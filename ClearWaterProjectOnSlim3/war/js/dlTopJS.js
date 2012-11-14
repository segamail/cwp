/*　facebook SDKをダウンロードしていないと他FB.のAPI群が利用できないため、先にSDKとそれを利用するJS群を非同期で取得*/
J(function(){

	//facebook JS SDK
	var element = document.createElement('script');
	element.src = document.location.protocol + '//connect.facebook.net/ja_JP/all.js';
	document.getElementById('fb-root').appendChild(element);
	
    window.fbAsyncInit = function() {
        FB.init({appId: '316956581733624', status: true, cookie: true,
                 xfbml: true});
        FB.Event.subscribe('auth.login', function () {
        });
      };

    //ローカルのJS
    var element = document.createElement('script');
  	element.src = '/js/fbLogin.js';
  	document.getElementById('fb-root').appendChild(element);


		
});