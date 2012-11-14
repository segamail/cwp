// ***************************************************************
//  MapContextMenu(右クリック時に表示させるメニュー)
//
// *************************************************************** 
 
var nowMainURL = location.protocol + '//' + location.host;
//右クリックの登録リスト
var rightClickList = [
      ['この地点の水質情報を登録','input_waterinfo',true,'/inputCheckWaterInfo'],
      ['この地点の改善アクションを登録','input_actioninfo',true,'/test']
     ];
      
 
  function MapContextMenu(gmap, lat, lng, opt, callback) {
 
     this.gmap_ = gmap;
     //マップの中にこのインスタンスを追加
     this.setMap(gmap);
     this.lat = lat;
     this.lng    = lng;
     this.opt = opt;
     this.callback = callback;
     

     //optionのプロパティをつくり初期化　menu, inSpeed,outSpeed
     if( this.opt.div == undefined) return false;
     if( this.opt.inSpeed == undefined) this.opt.inSpeed = 150;
     if( this.opt.outSpeed == undefined) this.opt.outSpeed = 75;
     // 0 needs to be -1 for expected results (no fade)
     if( this.opt.inSpeed == 0) this.opt.inSpeed = -1;
     if( this.opt.outSpeed == 0) this.opt.outSpeed = -1;
     
     J('#' + opt.div).addClass('contextMenu');
 
  }
 
  /* google.maps.OverLayViewを継承 コンストラクタ作成時　onAdd()→onDraw()　の順で起動*/
  MapContextMenu.prototype = new google.maps.OverlayView();
 
  MapContextMenu.prototype.onAdd = function(){
 
     //メニューを作成する
     this.createmenu_();
     //現在処理しているイベントフローのキャンセル
     this.stopEvent();
 
     //メニューパネルのDOM取得
     var panes = this.getPanes();
     //メニューパネルにメニューを登録
     panes.floatPane.appendChild( this.menu_ );
 
     //メニューを一旦オフにする
     this.MenuVisibleOff();
 
     var contextMenu = this;
 
     google.maps.event.addListener(gmap, 'click', function() {
        contextMenu.MenuVisibleOff();
     });
     google.maps.event.addListener(gmap, 'rightclick', function(event) {
        if(contextMenu == undefined){
        	contextMenu = new MapContextMenu(gmap, event.latLng.lat(),event.latLng.lng(), {menu: 'mapMenu'}, onMenuClick);
        }
        contextMenu.lat = event.latLng.lat();
        contextMenu.lng = event.latLng.lng();
        //リンクに位置情報付加
        var elems = document.getElementsByName('rightClickElems');
        for (var i=0; i< elems.length; i++){
        	var elem = elems[i];
          	var myLinkPlus =  nowMainURL + rightClickList[i][3] + '?lat=' + contextMenu.lat + '&lng=' + contextMenu.lng;
            elem.setAttribute('href',myLinkPlus);
        }
        contextMenu.MenuVisibleOn(event.latLng,0);
        //※重要。右クリックの処理後にgreyboxをリフレッシュ
        gb_refresh();
     });
     google.maps.event.addListener(gmap, 'mouseout', function() {
        contextMenu.MenuVisibleOff();
     });

     gb_refresh();
  }
  
  //greyboxを最後に再度読み込ませるため。
  function gb_refresh(){
     //greyboxセットを空にする(greyboxのセット機能を使う場合必須。greyboxの使い方によるが、これが無いとセットが増え続ける場合がある)
     GB_SETS={};
     //表示中のリンクを強制的に読み込み、クリックでgreyboxが実行できるようにする。
     decoGreyboxLinks(); 	
  }
  
  function onMenuClick( hash, latlng){
  	alert('test1');
  }
 
  MapContextMenu.prototype.draw = function() {
  }
 
  MapContextMenu.prototype.createmenu_ = function() {
 
        this.menu_ = document.createElement	('ul');
        this.menu_.id = this.opt.div;
        this.menu_.style.listStyle = 'none';
        this.menu_.style.position = 'absolute';
        this.menu_.style.backgroundColor = '#ffffff';
        this.menu_.style.color = '#000000';
        this.menu_.style.width = '200px';
        this.menu_.style.fontSize = '12px'
        this.menu_.style.padding = '0px 0px';
        this.menu_.style.margin = '0px';
        this.menu_.style.border = '1px solid #cccccc';
 
        if (loginUser != null || loginPromoter != null){
        	this.addListItem_(this.menu_,rightClickList[0][0],rightClickList[0][1],rightClickList[0][2],nowMainURL+rightClickList[0][3]);
        }
        if (loginPromoter != null){
        	this.addSeparator_(this.menu_,'separator1');
        	this.addListItem_(this.menu_,rightClickList[1][0],rightClickList[1][1],rightClickList[1][2],nowMainURL+rightClickList[1][3]);
        }
  }
 
  MapContextMenu.prototype.addListItem_ = function(menu,myTxt,myAction,myVisible,myLink) {
 
     //メニュー内要素作成
     var elem = document.createElement('a');
     var  str = document.createTextNode(myTxt);
     elem.appendChild(str);
     //開くページにGET用にlatとlngを渡す
     elem.setAttribute('href',myLink);
     elem.setAttribute('name','rightClickElems');
     elem.setAttribute('rel','gb_page_center[600,600]')
     
     //メニューリスト作成
     var listitem = document.createElement('li');
       //一つのメニュー毎のパディングの大きさを決めている
     listitem.id = myAction;
     listitem.style.padding = '5px 10px 5px 10px';
     listitem.appendChild(elem);
 
     var that = this;
 
     google.maps.event.addDomListener(listitem, 'mouseover', function() {
        listitem.style.cursor = 'pointer';
        listitem.style.backgroundColor = '#ffff99';
     });
     google.maps.event.addDomListener(listitem, 'mouseout', function() {
        listitem.style.cursor = 'default';
        listitem.style.backgroundColor = '#ffffff';
     });
     menu.appendChild(listitem);
  }
 
  MapContextMenu.prototype.addSeparator_ = function(menu,myID,myVisible) {
 
     var line = document.createElement('li');
     line.style.margin = '3px';
     line.style.borderBottom = '1px solid #eeeeee';
     menu.appendChild(line);
 
  }
 
  MapContextMenu.prototype.setMenuPosition_ = function(myLocation) {
 
     // 緯度、経度の情報を、Pixelに変換
     var point = this.getProjection().fromLatLngToDivPixel(myLocation);
 
     if (point.x + this.menu_.offsetWidth > this.gmap_.getDiv().offsetWidth) {
        point.x = point.x - this.menu_.offsetWidth;
     }
     if (point.y + this.menu_.offsetHeight > this.gmap_.getDiv().offsetHeight) {
        point.y = point.y - this.menu_.offsetHeight;
     }
 
     this.menu_.style.left = point.x  + 'px';
     this.menu_.style.top = point.y  + 'px';
  }
 
  MapContextMenu.prototype.MenuVisibleOff = function () {
     this.menu_.style.visibility = 'hidden';
  }
 
  MapContextMenu.prototype.MenuVisibleOn = function (myLocation,markerFlg) {
    this.menu_.style.visibility = 'visible';
    this.setMenuPosition_(myLocation);
  }
 
  MapContextMenu.prototype.stopEvent = function() {
     var events = ['click', 'dblclick', 'rightclick', 'mousedown', 'mouseup',
         'mousemove', 'mouseover', 'mouseout', 'dragstart', 'dragend', 'contextmenu'];
     var menu = this.menu_;
 
     //すべてのイベントフローをfor文で回しキャンセルさせる
     for (var i = 0, event; event = events[i]; i++) {
        google.maps.event.addDomListener(menu, event, function(e) {
           e.cancelBubble = true;      //IE
           if (e.stopPropagation) {
              e.stopPropagation();     //Firefox
           }
        })
     }
  };
  
  
