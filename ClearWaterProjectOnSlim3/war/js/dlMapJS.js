/*　検討中　*/
J(function(){

//    //位置情報取得js。 jquery
//    var elm1 = document.createElement('script');
//    elm1.type='text/javascript';
//    elm1.src = 'https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js';
//  	document.getElementById('dljs-root').appendChild(elm1);
//  	
//  	// jQueryとGreyBoxの衝突回避 
//  	var elm_o1 = document.createElement('script');
//  	elm_o1.type='text/javascript';
//  	document.getElementById('dljs-root').appendChild('<script type="text/javascript">J = jQuery.noConflict();</script>');
//  	
//    // map取得js
//  	var elm6 = document.createElement('script');
//  	elm6.type= 'text/javascript';
//  	elm6.src = 'http://maps.google.com/maps/api/js?sensor=true';
//  	document.getElementById('dljs-root').appendChild(elm6);
  	
  	//GreyBox追加
  	var elm2 = document.createElement('script');
  	elm2.type= 'text/javascript';
  	elm2.src = '/js/greybox/AJS.js';
  	document.getElementById('dljs-root').appendChild(elm2);
  	
  	var elm3 = document.createElement('script');
  	elm3.type= 'text/javascript';
  	elm3.src = '/js/greybox/AJS_fx.js';
  	document.getElementById('dljs-root').appendChild(elm3);
  	
	var elm4 = document.createElement('script');
  	elm4.type= 'text/javascript';
  	elm4.src = '/js/greybox/gb_scripts.js';
  	document.getElementById('dljs-root').appendChild(elm4);

  	
    // map関連js
  	var elm7 = document.createElement('script');
  	elm7.type= 'text/javascript';
  	elm7.src = '/js/mapContextMenu.js';
  	document.getElementById('dljs-root').appendChild(elm7);
  	
  	var elm8 = document.createElement('script');
  	elm8.type= 'text/javascript';
  	elm8.src = '/js/createInfoContents.js';
  	document.getElementById('dljs-root').appendChild(elm8);
  	
  	var elm9 = document.createElement('script');
  	elm9.type= 'text/javascript';
  	elm9.src = '/js/map.js';
  	document.getElementById('dljs-root').appendChild(elm9);
  	
  	//広告情報取得js
  	var elm10 = document.createElement('script');
  	elm10.type= 'text/javascript';
  	elm10.src = '/js/ad.js';
  	document.getElementById('dljs-root').appendChild(elm10);
  	

		
});