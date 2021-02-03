
<%@page import="kr.or.ddit.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
>

<%@include file="/WEB-INF/views/common/common_lib.jsp" %>


<script>
//문서 로딩이 완료되었을때
$(function(){
	$("#modifyBtn").on("click",function(){
		$("#frm").attr("method","get");
		$("#frm").attr("action","${cp}/user/userModify");
		$("#frm").submit();
	});
	$("#deleteBtn").on("click",function(){
		$("#frm").attr("method","post");
		$("#frm").attr("action","${cp}/user/deleteUser");
		$("#frm").submit();
	});
});
</script>
</head>

<%@include file="/WEB-INF/views/common/header.jsp" %>


<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/WEB-INF/views/common/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<% UserVo vo= (UserVo)request.getAttribute("user"); %>

																				
				<form class="form-horizontal" id= "frm" role="form">
					<input type="hidden" name="userid" value="${user.userid }"/>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<%--  <img src ="${cp}/user/profile/${user.userid }.png"/>  --%>

						<a href="/user/profileDownload?userid=${user.userid }">
							<img src ="/user/profile?userid=${user.userid }"/>
						</a>
							
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label">${user.userid }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${user.usernm } </label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<label class="control-label">************</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd" /></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${user.alias }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-10">
							<label class="control-label">${user.addr1}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${user.addr2}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호코드</label>
						<div class="col-sm-10">
							<label class="control-label">${user.zipcode}</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
						 
							<button type="button" id = "modifyBtn" class="btn btn-default">사용자 수정</button>
							<button type="button" id = "deleteBtn" class="btn btn-default">사용자 삭제</button>
						</div>
					</div>
					

				</form>
			</div>
		</div>
	</div>
</body>
</html>
