<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<!-- js　追加-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">var J = jQuery.noConflict();</script>
<script type="text/javascript" src="/js/dlTopJS.js"></script>
<title>ClearWaterProjectTopページ</title>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36060071-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
<!-- fbSDKの読込。内容はJSファイル内 -->
<div id="fb-root"></div>

<!-- 以下、メイン -->
    <p><font size="4"><b>現在開発中です。2013年初春リリース予定。Under Construction</b></p></br>
	<p>ClearWaterProjecttopです</p>
	
      <form action="/top" method="POST">
       <!-- a href="javascript:void(0);" を入れることでマウスポインタがクリック可能場所であることを示す-->
      <a href="/login"><img src="/img/fb_login_icon.gif"></a></br>
      <input type="button" id="fb_login" value="FBログイン">
      </form>
     </br>
     </br>
     <p>事業者の方はこちらから登録お願いします</p>
     <a href="/registpromoter"><b>登録</b></a>
</body>
</html>