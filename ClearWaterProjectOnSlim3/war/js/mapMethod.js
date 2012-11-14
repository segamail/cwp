//緯度軽度から住所を取得する  20120807現在未完成。　そもそもjsでfunction呼び出されるタイミングって？

function getAddress(lat,lng) {   
	  var geocoder = new google.maps.Geocoder();
      var latlng = new google.maps.LatLng(lat,lng);
      // geocodeリクエストを実行。
      // 第１引数はGeocoderRequest。緯度経度⇒住所の変換時はlatLngプロパティを入れればOK。
      // 第２引数はコールバック関数。
      geocoder.geocode(
        {'latLng': latlng},
        function(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            if (results[0].geometry) {
              // 住所を取得(日本の場合だけ「日本, 」を削除)
              // 20120817js全て読み込んだ跡に処理をしにいっているため、このコールバック内でaddressの場所に住所書き込みで対応。
              J('#address').text(results[0].formatted_address.replace(/^日本, /, ''));
            }
          } else if (status == google.maps.GeocoderStatus.ERROR) {
//            alert('サーバとの通信時に何らかのエラーが発生！');
          } else if (status == google.maps.GeocoderStatus.INVALID_REQUEST) {
//            alert('リクエストに問題アリ！geocode()に渡すGeocoderRequestを確認せよ！！');
          } else if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
//            alert('短時間にクエリを送りすぎ！落ち着いて！！');
          } else if (status == google.maps.GeocoderStatus.REQUEST_DENIED) {
//            alert('このページではジオコーダの利用が許可されていない！・・・なぜ！？');
          } else if (status == google.maps.GeocoderStatus.UNKNOWN_ERROR) {
//            alert('サーバ側でなんらかのトラブルが発生した模様。再挑戦されたし。');
          } else if (status == google.maps.GeocoderStatus.ZERO_RESULTS) {
//            alert('見つかりません');
          } else {
//            alert('えぇ～っと・・、バージョンアップ？');
          }
       });
    };