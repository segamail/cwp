<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>地図表示</title>
<meta name="keywords" content="ClearWaterProject,きれい,水,水質検査,水質チェック,水質浄化" />
<meta name="description" content="近くの水辺の水質をチェックし、水質を評価し、水質を改善しよう。あなたの近場に水遊びが出来る川を！沖縄レベルのきれいな海を！" />
<!-- FaceBookOGP設定 -->
<meta property="og:title" content="ClearWaterProject"/>　
<meta property="og:type" content="website" />
<meta property="og:url" content="https://clear-water-project.appspot.com/map" />　
<meta property="og:image" content="表示される画像のパス" />　
<meta property="og:description" content="概要を説明する文章" />　
<meta property="og:site_name" content="ClearWaterProject" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width">
<!-- スタイルシート追加 -->
<link href="/js/greybox/gb_styles.css" rel="stylesheet" type="text/css" media="all"/>
<link href="/css/map.css" rel="stylesheet" type="text/css"/>
<link href="/css/infoWindow.css" rel="stylesheet" type="text/css"/>
<link href="/js/jquery-ui-1.9.1.custom/css/ui-lightness/jquery-ui-1.9.1.custom.min.css" rel="stylesheet" type="text/css"/>
<!-- 位置情報取得js　追加-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/js/jquery-ui-1.9.1.custom/js/jquery-ui-1.9.1.custom.min.js"></script>
<script type="text/javascript">var J = jQuery.noConflict();</script>

<!-- 非同期dljs　検討中
<script type="text/javascript" src="/js/dlMapJS.js"></script>　
-->

<!--  Responsly.js -->
<link rel="stylesheet" href="/css/slidy.css" />
<script src="/js/slidy.js"></script>

<!--  GreyBox追加 -->
<script type="text/javascript">
    var GB_ROOT_DIR = "/js/greybox/";
</script>
<script type="text/javascript" src="/js/greybox/AJS.js"></script>
<script type="text/javascript" src="/js/greybox/AJS_fx.js"></script>
<script type="text/javascript" src="/js/greybox/gb_scripts.js"></script>


<!-- map取得js　追加-->
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="/js/mapMethod.js"></script>
<script type="text/javascript" src="/js/mapContextMenu.js"></script>
<script type="text/javascript" src="/js/createInfoContents.js"></script>
<script type="text/javascript" src="/js/map.js"></script>
<script type="text/javascript" src="/js/infoWindow.js"></script>
<script type="text/javascript" src="/js/loginUser.js"></script>
<script type="text/javascript" src="/js/mapTest.js"></script>

<!-- glowのパネル用追加 -->
<link href="/js/glow/1.7.7/widgets/widgets.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/js/glow/1.7.7/core/core.js"></script>
<script type="text/javascript" src="/js/glow/1.7.7/widgets/widgets.js"></script>
<!-- facebookからの認証時の不正URLを調整-->
<script type="text/javascript">if (window.location.hash == '#_=_')window.location.hash = '';</script>

<!-- Google analystic-->
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
    <!-- 各JSファイル非同期読み込み用div 検討中  <div id="dljs-root"></div>　　-->
	<%--　TOP画面の表示 --%>
	<div id="m_header">
	<table class="header_td"><tr>
		<th class="header_left"><div class="logo">
			<a href="/map"><img src="/img/top_icon.jpg" alt="ClearWaterProject"/></a>
		</div></th>
		<th class="header_center"><span id="count" style=" top:5px; width:140px;text-align:center; color:#000000; font-size:12px; 
		  font-family:Arial;">Water Analysis Point</span> 
        <span id="count" style=" top:20px; width:3%; 
          text-align:center; color:#000000; font-size:30px; 
          font-family:Arial;"><b>777</b></span>
        </th>
        <th class="header_right"><div id="userinfo"></div></th>
    </tr></table>
	</div>
	<div id="m_body">
		<%--　画面真ん中左。色々な情報表示 --%>
		<div id="info"></div>
		<%--　画面真ん中右。地図を表示 --%>
		<div id="map"></div>
	</div>
	<div id="m_footer">
		<%--　広告部分の表示 --%>
		<div id="ad" style="float:left;padding:10px 3px;"></div>
		<span style="bottom:1%;"><a href="http://clearwaterproject.jimdo.com/clearwaterproject%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6/%E5%BA%83%E5%91%8A%E3%83%9D%E3%83%AA%E3%82%B7%E3%83%BC/" target="_blank">広告ポリシーについて</a></span>
		<%-- テスト --%>
		<a href="http://job.mycom.co.jp/" title="job" rel="gb_page[480,360]"> 毎日就職ナビのページ表示 </a>
    </div>
    <!-- 広告情報取得js 追加-->
    <script type="text/javascript" src="/js/ad.js"></script>
</body>
</html>