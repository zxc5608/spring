<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="/WEB-INF/views/common/common_lib.jsp" %>


	<%@include file="/WEB-INF/views/common/header.jsp" %>


<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/WEB-INF/views/common/left.jsp" %>
	
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">

	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				
<%-- 	<%	
		for(int i = 0;i<userlist.size();i++){
				UserVo uservo = userlist.get(i);
	
			
				out.write("<tr>");
				out.write("<td>"+uservo.getUserid()+"</td>");
				out.write("<td>"+uservo.getUsernm()+"</td>");
				out.write("<td>"+uservo.getAlias()+"</td>");
				out.write("<td> "+uservo.getReg_dt_fmt()+"</td>");
				
				
				out.write("</tr>");
			}
		%>  --%>
	
		<c:forEach items="${userlist}" var="user">
			<tr>
				<td> ${user.userid }</td>
				<td>${user.usernm }</td>
				<td>${user.alias }</td>
				
				<td><fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd" /></td>
				
			
			</tr>
		
		</c:forEach>
		
			</table>
		</div>


		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
