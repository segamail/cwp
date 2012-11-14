
J(function(){
    //fb_loginをクリックしたときの動作
 	J('#fb_login').bind('click',function(){
	    //ユーザーの状況を確認
    	FB.getLoginStatus(function(response){
		    if (response.status == 'connected'){
	            //ログインしているため、別のページに飛ぶ
	    		var uid = response.authResponse.userID;
		        var accessToken = response.authResponse.accessToken;
		        window.location = location.protocol + '//' + location.host + '/map';
	     	} else if (response.status == 'not_authorized'){
	    		//ログインしているけどアプリに接続していない
		     	//よって情報提供認証してもらう
	     		login();
	    	} else {
		    	//ログインしていないため、ログインをしてもらう。
			    login();
	     	};
    	});
	});

	
	function login(){
		FB.login(function(response){
			if (response.authResponse){
				//ログインした時の処理
				//CWPへのログインが初回であるかの確認。初回であればCWPのユーザーへ登録
				//初回でなければグローバルに本人情報を取得し、そのままmapへ遷移
				//上記はjavaに任せる
				var accessToken = response.authResponse.accessToken;
				window.location = location.protocol + '//' + location.host + '/map';
			} else {
				//ログインしなかった時の処理
			}
		},{scope:'user_about_me'});//permissionの設定
	};
//	};

});
	
	
