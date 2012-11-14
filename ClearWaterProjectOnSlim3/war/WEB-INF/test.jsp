<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<!-- スタイルシート追加 -->
<link href="/js/greybox/gb_styles.css" rel="stylesheet" type="text/css" media="all"/>

<!-- 位置情報取得js　追加-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">var J = jQuery.noConflict();</script>
<script type="text/javascript" src="/js/test.js"></script>
<script type="text/javascript" src="/js/jcarousellite.js"></script>

<link href="/css/slider.css" media="screen, projection" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="/css/slidy.css" />
<script src="/js/slidy.js"></script>

<title>水質状況登録</title>
</head>
<body>
    <p>localhosへのアップロードテスト。</p>
　　　<h2>Form Version</h2>
　　　<input id="form" type="file" multiple="multiple" />

　　　<br />
    <table>
    <tr id="addCommentTr"><input id="addComment" type="textarea"></tr>
    </table>

　　　<form id="fromtest" name="fromtest" action="/fromtest" method="post">
   <input id="submit" type="submit" value="User以外のデータを削除submit" />
   </form>

　　　<h2>Drag and Drop Version</h2>
　　　<div id="target" draggable="true">
　　　    <br />
   　　　 <br />
  　　　  <span>Drop File(s)</span>
  　　　  <br />
  　　　  <br />
  　　　  <br />
　　　</div></br>


	    <div id="slidyBanner" class="slidyContainer" title="Your tooltip text">
        <div class="slidySlides">

            <!-- Each slide is wrapped in figure section -->

            <!-- Slide 1 -->
            <!-- add the 'slidyCurrent' class to which slide you want as default -->
            <figure class="slidyCurrent">
                <!-- Your context goes here -->
                <img  alt="Uyuni, Bolivia" src="http://127.0.0.1:8888/_ah/img/y3o2tiK0-RW98A2i9MmRDw=s150-c">
                <!-- Use the figcaption element to add captions -->
                <figcaption>An Image</figcaption>
            </figure>

            <!-- Slide 2 -->
            <figure>
                <img  alt="Shanghai, China"  src="http://127.0.0.1:8888/_ah/img/cfLeSaAzfYZww83QfHx5NQ=s150-c">
                <figcaption>Another image</figcaption>
            </figure>

            <!-- Add more slides as necessary -->

        </div>
    </div>


</body>
</html>