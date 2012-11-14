var loginUser = null;

J(function() {

	var ajax; // 途中で停止する場合に必要。
	var ajaxSettings = {
			xhr: function() {
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
			type: 'post',
			url: '/receivewaterinfo',
			processData: false,
			contentType: false, // 送信するデータをFormDataにする場合、こうしないといけない。
			cache: false,
			dataType: 'json',
			success: function(data) {
				if (data && data.result == 'ok') {
//					J('#ajaxStatus').html('アップロード完了');
					alert('アップロード完了');
					parent.parent.location.reload();
					//今開いているウインドウを閉じる
					parent.parent.GB_hide();
					return false;
				} else {
//					J('#ajaxStatus').html('アップロード失敗');
					alert('アップロード失敗');
				}
				ajax = null;
				//registボタンのdisabledを削除する
				J('#regist').removeAttr('disabled');
			},
			error: function(xhr, textStatus, errorThrown) {
				alert('エラー\n' + textStatus);
				ajax = null;
				J('#regist').removeAttr('disabled');
			}
	};

	/* 位置情報より住所を取得し画面に描写*/
    getAddress(J('#lat').val(), J('#lng').val());
    //ログインユーザーの取得
    getLoginInfo();

	J('#regist').click(function(){
		//registボタンを押せないようにする
		J('#regist').attr('disabled','disabled');

		//ブラウザがフォームデータに対応しているか確認
		if(window.FormData){
//			// ID が "inputCheckWaterInfo" であるエレメントを取得
//			var form = document.getElementById("inputCheckWaterInfo");
			//Formデータを作成する
			var formData = new FormData();
			// typeがfileであるデータをすべて取得し処理していく。多分ここでfileタイプが決まっている20121004
			J.each(J('#file')[0].files, function(i, file) {
				formData.append('file-'+i, file);
			});
			// file以外のデータをすべて取得しjsonDataに変換
			formData.append('jsonData', getInputJsonDataWithoutFile());

			ajaxSettings.data = formData;
			ajax = J.ajax(ajaxSettings);
		}else {
			//検討中。。
		}


	});

	/* 20120820 元々登録ボタン処理だったが、不要かもしれないことに気づく。testにして一旦利用回避。　*/
	J('#test').click(function(){
		/*　位置情報取得用のオブジェクトの取得 */
		try{
			/*  まず　Geolocation API の　navigator.geolocation　データ取得、
			  データが取得できない場合は続けてgoogle.gears.... にてデータ取得を行う。便利な||*/
			var geo = navigator.geolocation
			|| google.gears.factory.create('beta.geolocation');
		}catch(e){
			/* nop */
		}
		if (geo==null){
			alert('この端末では位置情報が取得できません');
			return;
		}

		/*　位置情報の取得　*/
		var count= 0;
		/*watchPositionはclearWatchメソッドが呼び出されるまでバックグラウンドで継続的に位置情報を取得します*/
		var watchId = geo.watchPosition(function(position){
			if (position.coords.accuracy < 300){
				/*�精度高く位置情報取得成功した場合、処理停止するためclearWatch*/
				geo.clearWatch(watchId);
//				J('#lat').val();
//				J('#lng').val();
				J('form').submit(); /* jsからjavaにリクエスト送信 */
				//親ウインドウをリロードする
//				parent.parent.location.reload();
				//今開いているウインドウを閉じる
//				parent.parent.GB_hide();
				return;
			}
			if (count++ >= 5){
				geo.clearWatch(watchId);
				alert('位置情報の精度が低いため失敗しました');
				return;
			}
			/*20120723現状テストで臨時*/
			J('#lat').val();
			J('#lng').val();
			J('form').submit(function(){
				//親ウインドウをリロードする
				parent.parent.location.reload();
				//今開いているウインドウを閉じる
				parent.parent.GB_hide();
			}); 
		}, function(e){ /*←ここは　watchPositionの２つめの引数。位置情報の失敗原因を引数*/
			/*位置情報取得失敗しても処理停止するためclearWatch*/
			geo.clearWatch(watchId);
			alert('位置情報の取得に失敗しました');
		}, {/*←ここは　watchPositionの３つめの引数。位置情報取得オプション。Android端末で精度高い位置情報取得指示のため*/
			enableHighAccuracy : true
		});

	});

	/* 地図表示ボタンがクリックされた　*/
	J('#map').click(function(){
		var href = '/map';
		var tag = J('#tag').val();
		/*タグに値が入っていればその値で絞込みを行う*/
		if (tag != ''){
			href += ('?tag=' + encodeURIComponent(tag));
		}
		location.href = href;
	});

	//jQery UI のDatePicker利用
	J('#datepicker').datepicker({
		appendText: '(yyyy/mm/dd)',
		dateFormat: 'yy/mm/dd',
		defaultDate: null
	});

});

function getInputJsonDataWithoutFile(){
	var inputData = {place:{lat:0,lng:0,country:0},
			waterInfo:{cwp_user_no:'', apply_user:0, apply_date:'', weather_id:0, comment:'', colour:0, clarity:0, transparency:0, turbidity:0, pH:0, odour:0, bod:0, cod:0, nitrate:0, iron:0, manganese:0}};
	//geohex情報は出来てからセット20121007
	//位置情報セット	
	inputData.place.lat = J('#lat').val();
	inputData.place.lng = J('#lng').val();
	inputData.place.country = 0;
	//水質情報セット
	inputData.waterInfo.comment = J('#comment').val();
	inputData.waterInfo.apply_date = J('#datepicker').val();
	inputData.waterInfo.weather_id = J('#weatherId').val();
	inputData.waterInfo.cod = J('#cod').val();
	inputData.waterInfo.cwp_user_no = loginUser.cwp_user_no;
	inputData.waterInfo.bod = 1.1;



	var inputJsonData = JSON.stringify(inputData);
	return inputJsonData;
}

