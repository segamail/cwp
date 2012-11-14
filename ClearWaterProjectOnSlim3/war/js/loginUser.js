/*サーバーからログイン情報を取得*/
function getLoginInfo(){
	J.ajax({
		type: 'POST', 
		url : '/userjson',
		cache:false,
		dataType: 'json',
		success: function(json){
			/*通信に成功した jsonデータの一覧*/
			if (json.loginUser != null){
				//日付型の場合
				//alert(new Date(parseInt(json.loginUser.regist_date,10)).toLocaleString());
				loginUser = json.loginUser;
				J('#userinfo').append('<div><img src="' + json.loginUser.userPicRef.thumbnail_serving_url +'" /></div>');
				J('#userinfo').append('<div>' + json.loginUser.last_name + ' ' + json.loginUser.first_name +'</div>');
			}
		}
	});
}
