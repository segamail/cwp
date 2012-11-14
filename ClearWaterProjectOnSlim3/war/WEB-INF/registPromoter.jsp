<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>事業者登録画面</title>
<meta name="description" content="CWP事業者登録画面" />
<!-- スタイルシート追加 -->
<link href="/css/map.css" rel="stylesheet" type="text/css"/>
<!-- 位置情報取得js　追加-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">var J = jQuery.noConflict();</script>

</head>
<body>
	<%--　TOP画面の表示 --%>
	<div class="header">
		<div class="logo">
			<a href="/map"><img src="/img/top_icon.jpg" alt="ClearWaterProject"/></a>
		</div>
		<span><a href="http://clearwaterproject.info">ClearWaterPrjectについて</a></span>
		<span id="count" style="right:1%; top:5px; width:140px; 
		  text-align:right; position:absolute; color:#000000; font-size:12px; 
		  font-family:Arial;">Water Analysis Point</span>
        <span id="count" style="right:5%; top:20px; width:3%; 
          text-align:center; position:absolute; color:#000000; font-size:30px; 
          font-family:Arial;"><b>777</b></span>

	</div>
	<div id="container">
            <form id="registPromoter" name="registPromoter" action="/registpromoter" method="post">
			<h1 class="regist_promoter_hd"><strong>事業者情報登録</strong></h1>
			<div id="promoter_info">
			<table border="0" cellpadding="0" cellspacing="0">			
			<tbody>		
			　　<tr>
			     <th>組織名</th>
			     <td><p><input type="text" name="org_name" id="org_name" value="CWP"></p></td>
			   </tr>
			   <tr>
			     <th>組織名ヨミガナ</th>
			     <td><p><input type="text" name="org_name_kn" id="org_name_kn" value="シーダブルーピー"></p></td>
			   </tr>
			　　<tr>
			     <th>郵便番号</th>
			     <td><p><input type="text" name="post" id="post" value="0001010"></p></td>
			   </tr>
			　　<tr>
			     <th>住所</th>
			     <td><p><input type="text" name="address" id="address" value="愛知県名古屋市西区新道１－１－１"></p></td>
			   </tr>
			　　<tr>
			     <th>業種</th>
			     <td><input type="text" name="sector" id="sector" value="システム"></td>
			   </tr>
			   <tr>
			     <th>組織詳細</th>
			     <td><p><textarea id="org_detail" name="org_detail" class="commentarea" value="近くの水辺を沖縄レベルのきれいさに"></textarea></p></td>
			   </tr>
			　　<tr>
			　　<tr>
			     <th>IRナンバー</th>
			     <td><input type="text" name="ir_no" id="ir_no" value="3111"></td>
			   </tr>
			     <th>設立年月日</th>
			     <td><input type="text" name="founding_date" id="founding_date" value="2012/10/01"></td>
			   </tr>
			　　<tr>
			     <th>電話番号</th>
			     <td><input type="text" name="tel" id="tel" value="1234567890"></td>
			   </tr>	
			　　<tr>
			     <th>fax</th>
			     <td><input type="text" name="fax" id="fax" value="1234567890"></td>
			   </tr>	
			　　<tr>
			     <th>EMail</th>
			     <td><input type="text" name="org_email" id="org_email" value="takashi.segawa@gmail.com"></td>
			   </tr>	
			　　<tr>
			     <th>URL</th>
			     <td><input type="text" name="url" id="url" value="http://www.clearwaterproject.info/"></td>
			   </tr>	
			</tbody>
			</table>
            </div>
<!--    			<div class="tbl_box">
	    		  <div class="tbl_pic">
			      <input type="file" id="file" name="waterInfoPic" value="写真を選択して下さい" multiple />
			      </div>
		    	  <div class="tbl_map"></div>
			</div>    -->
            <p><input type="submit" id="regist_submit" value="登録" /></p>
			
            </form>
	</div>

</body>
</html>