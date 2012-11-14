/*画面左情報ウィンドの中身を作成し、そのDOM結果を返す*/  
function createInfoWindowContents(waterInfo){
	/*視認性が良く修正しやすいと思われるためjQueryで作成*/
	/*構造
	 * infoContainer
	 *   -infoHeader
	 *   -infoLine
	 *   -picContainer
	 *      -slidyElem
	 *   -textContainer
	 *      -mainCommentContainer
	 *      -optionContainer
	 *      -subCommentContainer[]　（配列で動的に複数作成）
	 *      -addCommentToWContainer
	 *各構造の作成後に一つ上位の構造に紐づけするようにしている。
	 */
	/*情報ウィンド全体コンテナ作成*/  
	var infoContainer = J('<div>',{
			id:'infoContainer',
			class:'infoContainer',
			water_info_no:waterInfo.no});
	
	/*ヘッダー部分作成*/  
	var infoHeader = J('<div>',{
		id:'infoHeader'}).append(J('<p>',{
			id:'address'}));	
	/*ヘッダー下の下線作成*/  
	var infoLine = J('<p>',{
		class:'line'});
	infoContainer.append(infoHeader,infoLine);
	
	/*情報ウィンドの上部写真部分。 Responsly.jsというライブラリ利用。利用対象jsは slidy.js*/  
	var picContainer = J('<div>',{
			id:'slidyBanner',
			class:'slidyContainer'});
	
	var slidyElem = J('<div>',{
			class:'slidySlides'});
	
	
	if (waterInfo.waterInfoPicListRef != null){
		J.each(waterInfo.waterInfoPicListRef, function(i,waterInfoPic){
			if (i==0){
				var figureElem = J('<figure>',{
						class:'slidyCurrent'});
			}else {
				var figureElem = J('<figure>');
			}    	

			var aElem = J('<a>',{
				href:waterInfoPic.normal_serving_url})
				.append(J('<img/>',{
					src:waterInfoPic.normal_serving_url})
				);

			slidyElem
			.append(figureElem
					.append(aElem));
		});
	};
	/*情報ウィンドの上部写真部分を情報ウィンドコンテナに追加*/
	infoContainer
	.append(picContainer
			.append(slidyElem));

	/*情報ウィンドの下部の色々情報部分。以下複数を含む*/  
	var textContainer = J('<table>',{
		id:'textContainer'
	});
	
	/*情報ウィンドの下部１、投稿者コメント*/
	var mainCommentContainer = J('<tr>',{
		id:'mainCommentContainer'});
	/*下部１の左、写真*/
	var mainCommentUserElem = J('<th>',{
		class:'waterInfoMainCommentLeft'});
	var mainCommentUserLinkElem = J('<a>',{
		href:'http://www.facebook.com/' + waterInfo.applyUser.facebook_id,
		target:'_blank'})
		.append(J('<img/>',{
			class:'waterInfoMainCommentUserPic',
			src:waterInfo.applyUser.userPicRef.thumbnail_serving_url}));
	/*下部１の左の写真をコンテナに追加*/
	mainCommentContainer.append(
			mainCommentUserElem.append(mainCommentUserLinkElem));
	/*下部１の右、コメント*/
	var mainCommentElem = J('<th>',{
		class:'waterInfoMainCommentRight'});
	var nameLinkElem    = J('<a>',{
		href:'http://www.facebook.com/' + waterInfo.applyUser.facebook_id,
		target:'_blank'})
		.text(waterInfo.applyUser.last_name + waterInfo.applyUser.first_name);
	var commentElem = J('<p>').text(waterInfo.comment);
	/*下部１の右のコメントをコンテナに追加*/
	mainCommentContainer.append(
			mainCommentElem.append(nameLinkElem,commentElem)
	);
	/*下部１を下部文字系コンテナにに追加*/
	textContainer.append(mainCommentContainer);


	/*情報ウィンドの下部２、注目やコメントボタン*/
	var optionContainerTr = J('<tr>',{
		id:'optionContainer'});
	var optionContainerTh = J('<th>',{id:'optionContainerTh', colspan:2});
	var isLoginNo = false;
	if (waterInfo.waterWatchUserListRef != null){
		J.each(waterInfo.waterWatchUserListRef, function(i,waterWatchUser){
			if (waterWatchUser.user.cwp_user_no = loginUser.cwp_user_no){
				isLoginNo = true;
			};
		});
	};
	if (isLoginNo == true){
		var waterWatchElem = getDelWaterWatchUserElem();
	}else{
		var waterWatchElem = getWaterWatchUserElem();
	}
	/*下部２を下部文字系コンテナにに追加*/
	textContainer.append(
			optionContainerTr.append(
					optionContainerTh.append(waterWatchElem)));
	

	/*情報ウィンドの下部３、他ユーザーコメント一覧*/
	var sNo = 0;
	if (waterInfo.waterAddCommentListRef != null){
		J.each(waterInfo.waterAddCommentListRef, function(i,waterAddComment){
			var subCommentContainer = getSubCommentContainer(sNo,waterAddComment.user,waterAddComment.comment);
			if (waterAddComment.user.cwp_user_no = loginUser.cwp_user_no){
				sNo++;
			}
//			var subCommentContainer = J('<tr>',{
//				class:'waterInfoSubCommentContainer',
//				water_add_sort:i});
//			if (i = waterInfo.waterAddCommentListRef.length-1){
//				J(subCommentContainer).attr('id','lastSubComment');
//			}
//			/*下部３の左、写真*/
//			var subCommentUserElem = J('<th>',{
//				class:'waterInfoSubCommentLeft'});
//			var subCommentUserLinkElem= J('<a>',{
//				href:'http://www.facebook.com/' + waterAddComment.user.facebook_id,
//				target:'_blank'})
//				.append(J('<img/>',{
//					class:'waterInfoSubCommentUserPic',
//					src:waterAddComment.user.userPicRef.thumbnail_serving_url}));
//			subCommentUserElem.append(subCommentUserLinkElem);
//			/*下部３の右、コメント*/
//			var subCommentTextElem = J('<th>',{
//				class:'waterInfoSubCommentRight'});
//			var replyNameLinkElem    = J('<a>',{
//				href:'http://www.facebook.com/' + waterAddComment.user.facebook_id,
//				target:'_blank'})
//				.text(waterAddComment.user.last_name + waterAddComment.user.first_name);
//			var commentElem    = J('<p>').text(waterAddComment.comment);
//			subCommentTextElem.append(replyNameLinkElem,commentElem);
//			var editElem    = J('<img>',{
//				class:'waterInfoEditSubComment',
//				id   :'waterInfoEditSubComment', 
//				src  :'/img/red_earthquake.png'});
//			var editPanelElem = J('<div>',{
//				class:'editSubCommentSlideBox',
//				id   :'editSubCommentSlideBox'}).text('削除');
//			/*下部３の部分をtextContainerに統合*/
//			subCommentContainer.append(subCommentUserElem,subCommentTextElem,editElem,editPanelElem);
			textContainer.append(subCommentContainer);

		});
	};

	
	/*情報ウィンドの下部４　コメントを入れる場所を表示*/
	textContainer.append(getAddCommentContainer(sNo));
	
	/*情報ウィンドの下部コメント系部分を情報ウィンドコンテナに追加*/
	infoContainer.append(textContainer);


	/*最後にinfoWindowのNoをhiddenで持たせる。グローバルよりいいが。。*/
	var waterInfoNo = J('<input>',{
		id:'waterInfoNo',
		type:'hidden',
		value:waterInfo.no});
	infoContainer.append(waterInfoNo);

//	/*情報ウィンドの下部５、詳細データ*/
//	var dtlInfoContainer = document.createElement('li');
//	dtlInfoContainer.nodeValue = '詳細';
//	textContainer.appendChild(dtlInfoContainer);
//
//	/*情報ウィンドコンテナにテキストコンテナー追加*/
//	infoContainer.appendChild(textContainer);
//	
	
	return J(infoContainer)[0];

}

/*情報ウィンドの下部１、注目ボタンのElement*/
function getWaterWatchUserElem(){
	return J('<a>',{
		 id:'waterWatchUser',
		 class:'waterWatchUser',
		 href:'#'})
		 .append(J('<span>').text('気になる！'));
}

/*情報ウィンドの下部１、注目取消ボタンのElement*/
function getDelWaterWatchUserElem(){
	return J('<a>',{
		 id:'delWaterWatchUser',
		 class:'delWaterWatchUser',
		 href:'#'})
		 .append(J('<span>').text('気になる！を取り消す'));
}

/*情報ウィンドの下部３　ユーザーコメント一覧。ユーザープロフィールオブジェクトとコメント内容*/
function getSubCommentContainer(sNo, user, comment){
	var subCommentContainer = J('<tr>',{
		class:'waterInfoSubCommentContainer',
		water_add_comment_self_no:sNo
	});
	/*下部３の左、写真*/
	var subCommentUserElem = J('<th>');
	var subCommentUserLinkElem= J('<a>',{
		href:'http://www.facebook.com/' + user.facebook_id,
		target:'_blank'})
		.append(J('<img/>',{
			class:'waterInfoSubCommentUserPic',
			src:user.userPicRef.thumbnail_serving_url}));
	subCommentUserElem.append(subCommentUserLinkElem);
	/*下部３の右、コメント*/
	var subCommentTextElem = J('<th>');
	var replyNameLinkElem    = J('<a>',{
		href:'http://www.facebook.com/' + user.facebook_id,
		target:'_blank'})
		.text(user.last_name + user.first_name);
	var commentElem    = J('<p>').text(comment);
	if (user.cwp_user_no = loginUser.cwp_user_no){
		var editElem    = J('<img>',{
			class:'waterInfoEditSubComment',
			id   :'waterInfoEditSubComment'+sNo, 
			water_add_comment_self_no:sNo,
			src  :'/img/red_earthquake.png'});
		var editPanelElem = J('<div>',{
			class:'editSubCommentSlideBox',
			id   :'editSubCommentSlideBox'+sNo,
			water_add_comment_self_no:sNo}).text('削除').hide();
		subCommentTextElem.append(replyNameLinkElem,commentElem,editElem,editPanelElem);
	}else{
		subCommentTextElem.append(replyNameLinkElem,commentElem);
	}
	/*下部３の部分をtextContainerに統合*/
	subCommentContainer.append(subCommentUserElem,subCommentTextElem);
	return subCommentContainer;
}


/*情報ウィンドの下部４　コメントを入れる場所のjQueryオブジェクトを取得*/
function getAddCommentContainer(sNo){
	/*情報ウィンドの下部４　コメントを入れる場所を表示*/
	var addCommentContainer = J('<tr>',{
		id:'waterInfoAddCommentContainer',
		class:'waterInfoAddCommentContainer',
		water_add_comment_self_no:sNo});
	/*写真枠は空白で。*/
	var addCommentUserElem = J('<th>');

	/*コメント部分に入力枠を。*/
	var addCommentTextElem = J('<th>',{
		id:'waterInfoAddComment'
	}).append(J('<input>',{
		id:'inputWaterInfoAddComment'}));
	addCommentTextElem.append(J('<input>',{
		type:'button',
		id:'submitWaterInfoAddComment',
		value:'投稿'}));

	/*下部４の部分をaddSubCommentContainerに統合*/
	addCommentContainer.append(addCommentUserElem,addCommentTextElem);
	return addCommentContainer;
}



///*キーイベントの参考用に残しているだけ*/
//J('#addComment').live('keypress',function (e) {
//	if (e.which == 13 && event.ctrlKey == false && event.altKey == false && event.shiftKey == false){
//		var addSt = J('#addComment').val();
//		J('#addComment').remove();
//		J('#addCommentTr').append('<div>' + addSt + '</div>');
//	};
//});



