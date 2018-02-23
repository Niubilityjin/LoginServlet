<%@ page pageEncoding="utf-8" 
contentType="text/html; charset=utf-8" %>
<%@ page import="entity.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>用户管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" 
		type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								用户名
							</td>
							<td>
								密码
							</td>
							<td>
								电话
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
							List<User> users = (List<User>)request.getAttribute("users");
							for(int i = 0; i < users.size(); i ++){
								User user = users.get(i);
								%>
						<tr class="row<%=i % 2 + 1%>">
							<td>
								<%=user.getId()%>
							</td>
							<td>
								<%=user.getUname()%>
							</td>
							<td>
								<%=user.getPwd()%>
							</td>
							<td>
								<%=user.getPhone()%>
							</td>
							<td>
								<a href="del.do?id=<%=user.getId()%>" 
								onclick="return confirm('确定删除<%=user.getUname()%>吗?');">删除</a>&nbsp;
							</td>
						</tr>
								<%
							}
						%>
					</table>
					<p>
						<input type="button" 
						class="button" value="添加用户" 
						onclick="location='addUser.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
