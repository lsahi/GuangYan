<%@page import="com.po.Student"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园召集</title>
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
          <!-- activity name here -->
          <a class="navbar-brand" href="index.jsp"><%=  %></a>
        </div>
      </div>
    </nav><br><br><br><br>
    
	<div class="center-block" style="width:400px">
	<form action="queryCustomerServlet.do" method = "post">
		<h2 class="form-signin-heading">用户信息</h2>
		<table>
			<tr>
				<td>身份证:</td>
				<td><input type = "text" name = "sno" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sno")%>"></td>
			</tr>
			
			<tr>
				
				<td>用户名:</td>
				<td><input type = "text" name = "sname" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("sname")%>"></td>
			</tr>
			
			<tr>
				<td>用户手机:</td>
				<td><input type = "text" name = "phone" class = "form-control" value = "<%=request.getParameter("sno") == null ? "" : request.getParameter("phone")%>"></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "查询" class="btn btn-info btn-block"></td>
			</tr>
		</table>
	</form>
	<br>
	</div>
	<div style="margin:0 auto;width:400px">
		<a href = "queryChangeInfo.do" type="button" class="btn btn-success btn-block" >按时间显示全部历史操作记录</a>
	</div>
	<br>
	<%
		List<Student> customers = (List<Student>) request.getAttribute("listCustomer");
		 	if (customers != null && customers.size() > 0) {
	%>
		
		<table class = "table table-bordered table-hover">
			<tr>
				<th class="col-md-2">身份证号</th>
				<th class="col-md-1">姓名</th>
				<th class="col-md-2">手机</th>
				<th class="col-md-1">剩余使用次数</th>
				<th class="col-md-2">备注</th>
				<!-- 如果身份证系统可用，删除此行 --><th class="col-md-1">消费</th>
				<th class="col-md-2">删除或修改</th>
			</tr>
			
			<%
							for (Student c : customers) {
						%>
			<!-- 现在获取不到TimesLeft和information -->
			<tr>
				<th><a href = "queryChangeInfo.do?UserID=<%=c.getSno()%>" style="color:#595959"><%=c.getSno() %></a></th>
				<th><%=c.getSname() %></th>
				<th><%=c.getPhone() %></th>
				<th><%=c.getTimesLeft() %></th>
				<th><%=c.getInformation() %></th>
				<!-- 如果身份证系统可用，删除此行 --><th><a href = "charge.do?sno=<%=c.getSno() %>" type="button" class="btn btn-info" data-toggle="tooltip" data-placement="middle" title="你确定要消费?">消费</a></th>
				<th>
					<a href = "delete.do?sno=<%=c.getSno() %>" type="button" class="btn btn-danger" data-toggle="tooltip" data-placement="left" title="你确定要删除?">删除</a>
					<a href = "edit.do?sno=<%=c.getSno() %>" type="button" class="btn btn-warning" data-toggle="tooltip" data-placement="right" title="你确定要修改?">修改</a>

				</th>
			</tr>
			
			<%} %>
		</table>
		
	<%} %>
	
  </body>
  
</html>
