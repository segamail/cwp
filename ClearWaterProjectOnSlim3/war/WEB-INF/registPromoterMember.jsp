<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>事業者メンバー登録画面</title>
<meta name="description" content="CWP事業者メンバー登録画面" />
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
            <form id="registPromoter" name="registPromoter" action="/registpromotermember" method="post">
			<h1 class="regist_promoter_hd"><strong>事業者メンバー情報登録</strong></h1>
			<div id="promoter_info">
			<table border="0" cellpadding="0" cellspacing="0">			
			<tbody>		
			　　<tr>
			     <th>組織名</th>
			     <td><p><input type="text" name="org_name" id="org_name" value="<%= request.getAttribute("org_name")%>" ></p>
			            <input type="hidden" name="org_email" id="org_email" value="<%= request.getAttribute("org_email")%>" ></td>
			   </tr>
			　　<tr>
			     <th>姓</th>
			     <td><p><input type="text" name="last_name" id="last_name" value="瀬川"></p></td>
			   </tr>
			   <tr>
			     <th>姓よみがな</th>
			     <td><p><input type="text" name="last_name_kn" id="last_name_kn" value="せがわ"></p></td>
			   </tr>
			　　<tr>
			     <th>名</th>
			     <td><p><input type="text" name="first_name" id="first_name" value="貴之"></p></td>
			   </tr>
			　　<tr>
			     <th>名よみがな</th>
			     <td><p><input type="text" name="first_name_kn" id="first_name_kn" value="たかし"></p></td>
			   </tr>
			　　<tr>
			     <th>性別</th>
			     <td><p><input type="text" name="gender" id="gender" value="男"></p></td>
			   </tr>
			　　<tr>
			     <th>部門</th>
			     <td><input type="text" name="department" id="department" value="経営企画"></td>
			   </tr>
			　　<tr>
			     <th>電話番号</th>
			     <td><input type="text" name="phone" id="phone" value="0000000000"></td>
			   </tr>	
			　　<tr>
			     <th>携帯電話番号</th>
			     <td><input type="text" name="mobile_phone" id="mobile_phone" value="08030986861"></td>
			   </tr>	
			　　<tr>
			     <th>EMail</th>
			     <td><input type="text" name="email" id="email" value="takashi.segawa@gmail.com"></td>
			   </tr>	
			　　<tr>
			     <th>携帯EMail</th>
			     <td><input type="text" name="mobile_email" id="mobile_email" value="aggressive_style1007@i.softbank.jp"></td>
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