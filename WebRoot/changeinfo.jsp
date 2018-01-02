<%@page import="com.po.FixTime"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>光盐管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
	<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
	<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
	<script src="bootstrap/js/myjs.js"></script>
	<link href="bootstrap/css/mycss.css" rel="stylesheet">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
    <!-- 最上面的导航栏 -->
  	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          </button>
          <a class="navbar-brand" href="index.jsp">光盐用户管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="queryCustomerServlet.do">查询</a></li>
            <li><a href="add.jsp">添加</a></li>
          </ul> 
        </div>
      </div>
    </nav><br><br><br><br>
    
	<div class="center-block" style="width:400px;">
	<form action="queryChangeInfo.do" method = "post">
		<h2 class="form-signin-heading">Please Query</h2>
		<table>
			<tr>
				<td>用户ID(Sno):</td>
				<td><input type = "text" name = "UserID" class = "form-control" value = "<%=request.getParameter("UserID") == null ? "" : request.getParameter("UserID")%>"></td>
			</tr>
			
			<!-- addCustomerServlet.do -->
			<tr>
				<td><input type = "submit" value = "查询" class="btn btn-primary"></td>
			</tr>
			
		</table>
	</form>
	<form action="queryCustomerServlet.do" method = "post">
		<table>
			<!-- addCustomerServlet.do -->
			<tr>
				<td><input type = "submit" value = "返回" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	</div>
	<br><br>
	
	<!-- 在这里直接输出用户时间信息列表，下面添加返回按钮 -->
	<%
		List<FixTime> fixTime = (List<FixTime>) request.getAttribute("listFixTime");
	 	if (fixTime != null && fixTime.size() > 0) {
	 %>
		
		<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-md-3">身份证号</th>
				<th class="col-md-2">姓名</th>
				<th class="col-md-2">操作类型</th>
				<th class="col-md-2">本次操作后剩余使用次数</th>
				<th class="col-md-3">修改时间</th>
			</tr>
			
			<%
				for (FixTime f:fixTime){
			 %>
			<!-- 现在获取不到TimesLeft和information -->
			<tr>
				<th><%=f.getUserID() %></th>
				<th><%=f.getUserName() %></th>
				<th><%=f.getOperation() %></th>
				<th><%=f.getTimesLeft() %></th>
				<th><%=f.getCurrentTime() %></th>
			</tr>
			
			<%} %>
		</table>
		
	<%} %>
	<div class="center-block" style="width:400px;">
	</div>
  </body>
  
</html>
