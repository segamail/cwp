var gmap;
var currentInfoWindow = null;
var markersArray = [];
var infoWindow;
var browserSupportFlag =  new Boolean();
var loginUser = null;
var loginPromoter = null;

/*HTMLが読み込まれたら実行される関数を準備する*/
J(function(){
	//ログインユーザーの取得
	getLoginInfo();
	//GBが開いていたらまず閉じる
    if (parent.parent.GB_CURRENT != null){parent.parent.GB_hide()};
	/*名古屋駅を示す位置オブジェクトを作成する*/
	var latlng = new google.maps.LatLng(35.170914, 136.882052);
	/*倍率、中心位置、地図の種類（ROADMAP）をオプションとして用意する*/
	var myOptions = {
		zoom:16, center:latlng, mapTypeId:google.maps.MapTypeId.ROADMAP
	};
	
	/*地図オブジェクトを<div id='map'>の中に作成する*/
	gmap = new google.maps.Map(document.getElementById('map'), myOptions);
	
	//右クリックメニューの追加（mapContextMenu.js利用）
	myContextMenu = new MapContextMenu(gmap, google.maps.event.latLng, {div: 'mapMenu'}, onMenuClick);
	
//  20121107 infowindowの利用は要検討
//	google.maps.event.addListener(gmap, 'click', function(){
//		currentInfoWindow.close();
//	});
	
    // マップのタイル読み込みが完了した時のイベント
    google.maps.event.addListener(gmap, 'tilesloaded', function(){
    	refresh(); 
    });
	
	/*マーカー取得時、表示画面の端から端のlatlng必要。 ドラッグ終了時、サイズ変更時、bounds_changed時に取得  */
	/*20121107ただしgetBounds()問題は上記　tilesloaded　によってクリアしたため、bounds_changedは再考必要*/
	// event の種類を保持
	var event_type = 1; // 1 は初回
	
	google.maps.event.addListener(gmap, 'zoom_changed', function() {
		event_type = 2; // ズームが変われば 2
	});

	google.maps.event.addListener(gmap, 'dragend', function() {
		event_type = 3; // ドラッグが終われば 3 
	});
	google.maps.event.addListener(gmap, 'bounds_changed', function() {
		switch(event_type){
		case 1:
			//ここに MAP 初回ロードの処理
			refresh();
		    /*MAPを現在地に移動させる*/
			setNowCenter();
			break;
		case 2:
			//ここにズームが変わった時の処理
			refresh();
			break;
		case 3:
			//ここにドラッグが終わった時の処理
			refresh();
			break;
		}
		// 初期化
		event_type = 0;
	});
	
});

/*サーバーから位置情報を取得する*/
function refresh(){
	//JSONで検索文字列を送る。構造はマップの南西北東位置(bouns)、期間、件数等（bouns以外現状未定義20121001）。
//	var data = {bouns: {sw:{lat:0,lng:0}, ne:{lat:0,lng:0}} };
	var data = {swlat:0,swlng:0, nelat:0,nelng:0};
	var latlngBounds = gmap.getBounds();
	swLatlng = latlngBounds.getSouthWest();
	neLatlng = latlngBounds.getNorthEast();
	data.swlat = swLatlng.lat();
	data.swlng = swLatlng.lng();
	data.nelat = neLatlng.lat();
	data.nelng = neLatlng.lng();

	/*contentTypeはprocessDataのデフォルトtureにより"application/x-www-form-urlencoded"に設定されている*/
	J.ajax({
		type: 'GET', 
//		url : '/mmappinjson',
		url : '/mapinfojson',
		data: data,
		cache:false,
		dataType: 'json',
		success: function(json){
			/*通信に成功した jsonデータの一覧*/
			J.each(json.waterInfo.reverse(), function(i,waterInfo){
				addMarker(waterInfo);
				if (i == 0){
					dispWaterInfo(waterInfo);
				}
			});
		}
	});
}

/*画面左記の水辺情報の表示*/
function dispWaterInfo(waterInfo){
	J('#infoContainer').remove();
	J('#info').append(createInfoWindowContents(waterInfo));
	/*非同期で場所情報取得*/
	getAddress(waterInfo.lat, waterInfo.lng);
//	infowindow.setContent(infoContainer);
	/*コメント追加の処理セット*/
	setWaterInfoAddComment();
	/*注目の処理セット*/
	setWaterWatchUser();
	/*注目取消の処理セット*/
	setDelWaterWatchUser();
	/*コメント取消の表示処理セット*/
	setWaterInfoEditSubComment();
	/*コメント取消の確認パネルセット*/
	setDelWaterAddCommentConfirmPanel();
	/*最新ウィンドとしてグローバル保持*/
//	currentInfoWindow = infowindow;
	J('.slidyContainer').slidy({
	});
}

/*マーカーを追加する*/
function addMarker(waterInfo){
    var waterInfoLatLng = new google.maps.LatLng(waterInfo.lat, waterInfo.lng);
    /*ここでマーカーが水質指標によって色を変えるようにする*/
    var originicon = getWaterInfoIcon(waterInfo);
    var marker   = new google.maps.Marker({ map: gmap, position: waterInfoLatLng, icon: originicon});	

    var infowindow = new google.maps.InfoWindow({
        content: J('<p>',{id:'address'})[0]
    });
    
    google.maps.event.addListener(marker, 'click', function() {
//    	if (currentInfoWindow){
//    		currentInfoWindow.close;
//    	}
//    	infowindow.open(gmap,marker);
    	
    	dispWaterInfo(waterInfo);
    });
    /*マーカー情報を追加しておく。あまり必要ないか？*/
    markersArray.push(marker);
    
}

/*非同期通信のデフォルト設定 */
function getDefAjaxSettings(){
	return set = {
			xhr: function(){
				var xhr = new window.XMLHttpRequest();
				// アップロードの進捗状況を取得
				xhr.upload.addEventListener("progress", function(event) {
					if (event.lengthComputable) {
						J('#status').html(parseInt(parseInt((event.loaded / event.total) * 100)) + '%');
					}
				}, false);
				// 中止の際に何かしたい場合
				xhr.addEventListener("abort", function(event) {
				}, false);

				return xhr;
			},
			contentType: 'application/json; charset=UTF-8',
			cache: false,
			dataType: 'json',
			error: function(xhr, textStatus, errorThrown) {
				alert('エラー\n' + textStatus);
			
			}
	};
}

function setWaterInfoAddComment(){
	var waterInfoAddCommentAjax; // 途中で停止する場合に必要。
	var waterInfoAddCommentAjaxSettings =  getDefAjaxSettings();
	waterInfoAddCommentAjaxSettings.type = 'post';
	waterInfoAddCommentAjaxSettings.url  = '/wateraddcomment';
	waterInfoAddCommentAjaxSettings.success = function(data) {
		if (data && data.result == 'ok') {
			//コメント欄を表示のみテキストに書き換える
			var addSt = J('#inputWaterInfoAddComment').val();
			var sNo = J('#waterInfoAddCommentContainer').attr('water_add_comment_self_no');
			J('#waterInfoAddCommentContainer').remove();
			J('#textContainer').append(getSubCommentContainer(sNo,loginUser,addSt));
			//新しいコメント入力欄を追加
			sNo++;
			J('#textContainer').append(getAddCommentContainer(sNo));
			//改めてコメント追加ロジックのセット
			setWaterInfoAddComment();
			return false;
		} else {
			alert('アップロード失敗しました。しばらくたってから再度お試しください。');
		}
	};
	waterInfoAddCommentAjaxSettings.complete = function(xhr, textStatus){
		waterInfoAddCommentAjax = null;
		//registボタンのdisabledを削除する
		J('#submitWaterInfoAddComment').removeAttr('disabled');
	};
	
	J('#submitWaterInfoAddComment').click(function(){
		//submitボタンを押せないようにする
		J('#submitWaterInfoAddComment').attr('disabled','disabled');

		//コメント欄の水辺情報、送信データ及びユーザーNoをdataに格納。
		var submitData = {water_info_no:'', cwp_user_no:'', water_add_comment_self_no:'',  comment:''}
		submitData.water_info_no =  J('#infoContainer').attr('water_info_no');
		submitData.cwp_user_no    = loginUser.cwp_user_no;
		submitData.water_add_comment_self_no = J('#waterInfoAddCommentContainer').attr('water_add_comment_self_no');
		submitData.comment        = J('#inputWaterInfoAddComment').val();
		//サーブレットに送信
		waterInfoAddCommentAjaxSettings.data = JSON.stringify(submitData);
		waterInfoAddCommentAjax = J.ajax(waterInfoAddCommentAjaxSettings);
	});
};

function doDelWaterInfoAddComment(sNo){
	var delWaterInfoAddCommentAjax; 
	var delWaterInfoAddCommentAjaxSettings =  getDefAjaxSettings();
	delWaterInfoAddCommentAjaxSettings.type = 'post';
	delWaterInfoAddCommentAjaxSettings.url  = '/delwateraddcomment';
	delWaterInfoAddCommentAjaxSettings.success = function(data) {
		if (data && data.result == 'ok') {
			
			alert('OKDESU');
			return false;
		} else {
			alert('アップロード失敗しました。しばらくたってから再度お試しください。');
		}
	};
	delWaterInfoAddCommentAjaxSettings.complete = function(xhr, textStatus){
		delWaterInfoAddCommentAjax = null;
	};
	
	//対象コメントデータ及びユーザーNoをdataに格納。
	var submitData = {water_info_no:'', cwp_user_no:'', water_add_comment_self_no:''};
	submitData.water_info_no    =  J('#infoContainer').attr('water_info_no');
	submitData.cwp_user_no      = loginUser.cwp_user_no;
	submitData.water_add_comment_self_no    = sNo;
	//サーブレットに送信
	delWaterInfoAddCommentAjaxSettings.data = JSON.stringify(submitData);
	delWaterInfoAddCommentAjax = J.ajax(delWaterInfoAddCommentAjaxSettings);
}


function setWaterWatchUser(){
	var waterWatchUserAjax; // 途中で停止する場合に必要。
	var waterWatchUserAjaxSettings = getDefAjaxSettings();
	waterWatchUserAjaxSettings.type = 'post';
	waterWatchUserAjaxSettings.url  = '/waterwatchuser';
	waterWatchUserAjaxSettings.success 
	  = function(data) {
		if (data && data.result == 'ok') {
			return false;
		} else {
			alert('アップロード失敗しました。しばらくたってから再度お試しください。');
		}
	};
	waterWatchUserAjaxSettings.complete = function(xhr, textStatus){
		waterWatchUserAjax = null;
	};
	
	
	J('#waterWatchUser').click(function(){
		//まず切り替えるコメント欄を注目済みに切り替える
		J('#waterWatchUser').remove();
		J('#optionContainer').append(getDelWaterWatchUserElem());
    	setDelWaterWatchUser();

		//注目欄の送信データ及びユーザーNoをdataに格納。
		var submitData = {water_info_no:'', cwp_user_no:''}
		submitData.water_info_no =  J('#infoContainer').attr('water_info_no');
		submitData.cwp_user_no    = loginUser.cwp_user_no;
		//サーブレットに送信
		waterWatchUserAjaxSettings.data = JSON.stringify(submitData);
		waterWatchUserAjax = J.ajax(waterWatchUserAjaxSettings);
	});
}

function setDelWaterWatchUser(){
	var delWaterWatchUserAjax; // 途中で停止する場合に必要。
	var delWaterWatchUserAjaxSettings =  getDefAjaxSettings();
	delWaterWatchUserAjaxSettings.type = 'post';
	delWaterWatchUserAjaxSettings.url  = '/delwaterwatchuser';
	delWaterWatchUserAjaxSettings.success = function(data) {
		if (data && data.result == 'ok') {
			return false;
		} else {
			alert('アップロード失敗しました。しばらくたってから再度お試しください。');
		}
	};
	delWaterWatchUserAjaxSettings.complete = function(xhr, textStatus){
		delWaterWatchUserAjax = null;
	};
	
	
	J('#delWaterWatchUser').click(function(){
		//まず切り替えるコメント欄を注目済みに切り替える
		J('#delWaterWatchUser').remove();
		J('#optionContainer').append(getWaterWatchUserElem());
		setWaterWatchUser();

		//注目欄の送信データ及びユーザーNoをdataに格納。
		var submitData = {water_info_no:'', cwp_user_no:''}
		submitData.water_info_no =  J('#infoContainer').attr('water_info_no');
		submitData.cwp_user_no    = loginUser.cwp_user_no;
		//サーブレットに送信
		delWaterWatchUserAjaxSettings.data = JSON.stringify(submitData);
		delWaterWatchUserAjax = J.ajax(delWaterWatchUserAjaxSettings);
	});
}

/*コメント取消の表示処理*/
function setWaterInfoEditSubComment(){
	J('.waterInfoEditSubComment').each(function(){
		var sNo = J(this).attr('water_add_comment_self_no');
		J('#waterInfoEditSubComment' + sNo).click(function(){
	      J("#editSubCommentSlideBox"+sNo).slideToggle("fast");
	     });
	});

}

/*コメント取消の確認パネルセット*/
function setDelWaterAddCommentConfirmPanel(){	
	J('.editSubCommentSlideBox').each(function(){
		var sNo = J(this).attr('water_add_comment_self_no');
		J('#editSubCommentSlideBox' + sNo).click(function(){
			if(window.confirm('このコメントを削除します。\nよろしいですか？')){
				doDelWaterInfoAddComment(sNo);
			}else{
				//何もしない
			}
		});
	});
};


/*ajaxのuploadステータス状況表示*/
function getUploadStatus(){
	var xhr = new window.XMLHttpRequest();
	// アップロードの進捗状況を取得
	xhr.upload.addEventListener("progress", function(event) {
		if (event.lengthComputable) {
			J('#status').html(parseInt(parseInt((event.loaded / event.total) * 100)) + '%');
		}
	}, false);
	// 中止の際に何かしたい場合
	xhr.addEventListener("abort", function(event) {
	}, false);

	return xhr;

}



/*20121018GeoHex取得テスト用マーカーを追加する*/
function addGHMarker(water_geohex){
	var water_geohexLatLng = new google.maps.LatLng(water_geohex.lat, water_geohex.lng);
	/*ここでマーカーが水質指標によって色を変えるようにする*/
	var originicon = getWIGHIcon(water_geohex);
	var marker   = new google.maps.Marker({ map: gmap, position: water_geohexLatLng, icon: originicon});	
	/*空の情報ウィンド追加*/  
	var contentString = '<button type="button" id="ghinfo" onclick="getWaterInfo()">'+ water_geohex.zone + '</div>';
	var infowindow = new google.maps.InfoWindow({
		content: contentString,
		disableAutoPan: false,
		maxWidth: 500
	});
	google.maps.event.addListener(marker, 'click', function() {
		if (currentInfoWindow) {
			currentInfoWindow.close();
		}
		infowindow.open(gmap,marker);
		/*最新ウィンドとしてグローバル保持*/
		currentInfoWindow = infowindow;
		
	});
	/*マーカー情報を追加しておく。あまり必要ないか？*/
	markersArray.push(marker);
}

/*20121018GeoHexでの情報ウィンドの中のボタン処理。jQueryうまくいかずonclick動作で実行。*/
function getWaterInfo(){
	var data = {zone:''};
	data.zone = J('#ghinfo').text();
	J.ajax({
		type: 'GET', 
		url : '/mwaterinfojson',
		data: data,
		cache:false,
		dataType: 'json',
		success: function(json){
			/*通信に成功した jsonデータの一覧*/
			J.each(json.waterInfo, function(i,waterInfo){
				alert(waterInfo.comment);
			});
		}
	});	

}

/*水質指標に沿ってicon種類を返す*/
function getWaterInfoIcon(waterInfo){
	/*最初はCODで判断するか。しかしplaceには情報ないため、他で必要。。*/
	if (markersArray.length==0){
		return '/img/bule_flag.png';
	} else if (markersArray.length==1){
		return '/img/bule_flag.png';
	} else {
		return '/img/bule_flag.png';
	}	
}

/*GeoHex確認用Icon*/
function getWIGHIcon(waterInfo){
	/*最初はCODで判断するか。しかしplaceには情報ないため、他で必要。。*/
	return '/img/red_earthquake.png';
}



function clickEventFunc(event) {
      alert(event.latLng.toString());
}
    
/*地図の中心を移動する*/
//function setCenter(lat,lng){
function setNowCenter(){
//	gmap.setCenter(new google.maps.LatLng(lat,lng));
	/* Try W3C Geolocation (Preferred) */
	if(navigator.geolocation) {
		browserSupportFlag = true;
		navigator.geolocation.getCurrentPosition(function(position) {
			initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
			gmap.setCenter(initialLocation);
		}, function() {
			handleNoGeolocation(browserSupportFlag);
		});
    /* Try Google Gears Geolocation */
	} else if (google.gears) {
		browserSupportFlag = true;
		var geo = google.gears.factory.create('beta.geolocation');
		geo.getCurrentPosition(function(position) {
			initialLocation = new google.maps.LatLng(position.latitude,position.longitude);
			gmap.setCenter(initialLocation);
		}, function() {
			handleNoGeoLocation(browserSupportFlag);
		});
	/* Browser doesn't support Geolocation。よって現在は名古屋駅にスポット */
	} else {
		browserSupportFlag = false;
		var latlng = new google.maps.LatLng(35.170914, 136.882052);
		gmap.setCenter(latlng);
	}

}
