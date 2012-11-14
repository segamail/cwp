<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<!-- スタイルシート追加 -->
<link href="./css/inputCheckWaterInfo.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css" rel="stylesheet" />
<!-- 位置情報取得js　追加-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">var J = jQuery.noConflict();</script>
<!-- jQuery UI　を追加。※将来的にはこれらのライブラリーもダウンロードして管理した方がよいのだろう。勝手にURL変わる可能性あるため-->	
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<script type="text/javascript" src="/js/mapMethod.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.upload-1.0.2.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<!-- map取得js　追加-->
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="text/javascript" src="/js/inputCheckWaterInfo.js"></script>
<script type="text/javascript" src="/js/loginUser.js"></script>
<!-- 使えない？？<script type="text/javascript"
	src="http://code.google.com/apis/gears/gears_init.js"></script>-->
<title>水質状況登録</title>
</head>
<body>
	<div id="container">
<!-- 		<form name="inputCheckWaterInfo" action="<%= blobstoreService.createUploadUrl("/inputCheckWaterInfo") %>" method="post" enctype="multipart/form-data">  -->
            <form id="inputCheckWaterInfo" name="inputCheckWaterInfo" action="#" method="post">
            </form>
			<h1 class="input_layout_hd"><strong>水質状況登録</strong></h1>
			<div id="water_info">
			<div class="tbl_box">
			  <div class="tbl_pic">
			    <input type="file" id="file" name="waterInfoPic" value="写真を選択して下さい" multiple />
			  </div>
			  <div class="tbl_map"></div>
			</div>
			<table border="0" cellpadding="0" cellspacing="0">
			<tbody>
			   <tr>
			     <th>コメント</th>
			     <td><p><textarea id="comment" name="comment" class="commentarea"></textarea></p></td>
			   </tr>
			</tbody>
			</table>
			<table border="0" cellpadding="0" cellspacing="0">			
			<tbody>		
			　　<tr>
			     <th>登録日</th>
			     <td><p><input type="text" name="date" id="datepicker"></p></td>
			   </tr>
			　　<tr>
			     <th>場所</th>
			     <td id="address"></td>
			   </tr>
			　　<tr>
			     <th>天気</th>
			     <td><input type="text" name="weatherId" id="weatherId" value="1"></td>
			   </tr>
			　　<tr>
			     <th>色度</th>
			     <td><input type="text" name="colour"></td>
			   </tr>
			　　<tr>
			     <th>透視度</th>
			     <td><input type="text" name="clarity"></td>
			   </tr>	
			   <tr>
			     <th>透明度</th>
			     <td><input type="text" name="transparency"></td>
			   </tr>		
			   <tr>
			     <th>濁度</th>
			     <td><input type="text" name="turbidity"></td>
			   </tr>	
			   　<tr>
			     <th>pH</th>
			     <td><input type="text" name="pH"></td>
			   </tr>	
			   <tr>
			     <th>臭気</th>
			     <td><input type="text" name="odour"></td>
			   </tr>	
			   <tr>
			     <th>BOD</th>
			     <td><input type="text" name="bod"></td>
			   </tr>	
			   <tr>
			     <th>COD</th>
			     <td><input type="text" name="cod"></td>
			   </tr>	
			   <tr>
			     <th>硝酸態窒素</th>
			     <td><input type="text" name="nitrate"></td>
			   </tr>			
			   <tr>
			     <th>鉄</th>
			     <td><input type="text" name="iron"></td>
			   </tr>	
			   <tr>
			     <th>マンガン</th>
			     <td><input type="text" name="manganese"></td>
			   </tr>	   				   	   
			</tbody>
			</table>
			<d1>
			<dt>
			  <c:if test="${error_comment}">
				<font color="red">コメントは必須です</font>
			  </c:if>
			</dt>
<!-- 			<dd>コメント：
				<input type="text" name="comment" />
 		            value='<c:out value="${comment}" />' />

			</dd>
-->			</d1>
            </div>
			<p><input type="button" id="regist" value="登録する" /></p>
			<p><input type="button" id="map" value="地図を表示する" /></p>
			<input type="hidden" id="lat" name="lat" value='<c:out value="${lat}" />'/>
			<%--緯度 --%>
			<input type="hidden" id="lng" name="lng" value='<c:out value="${lng}" />'/>
			<%--経度 --%>
<!--  		</form> -->
	</div>

</body>
</html>