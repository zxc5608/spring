<%@page import="kr.or.ddit.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@include file="/WEB-INF/views/common/common_lib.jsp" %>

<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
$(function(){
	//주소 검색 버튼이 클릭되었을때 다음 주소 api팝업을 연다.
	$("#addrbtn").on("click",function(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);
	            
	            $("#addr1").val(data.roadAddress);	//도로주소
	            $("#zipcode").val(data.zonecode);	//우편번호 
	            
	            //사용자의 편의성을 위해 상세주소 입력 input태그로 focus 설정
	            $("#addr2").focus();
	        }
	    }).open();
			
	});
});
</script>
</head>

<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
 spring message:<spring:message code="GREETING" arguments="brown"></spring:message>
	<%@include file="/WEB-INF/views/common/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<% UserVo vo= (UserVo)request.getAttribute("user"); %>

				contextPath.el
				<form class="form-horizontal" role="form" enctype="multipart/form-data"
									action="${cp}/user
									/registUser" method="post">
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
						<%-- <label class="control-label"><%=vo.getUserid() %></label> --%>
					
						 	<input type="text" class="form-control" id="userid" name="userid"
								placeholder="사용자 아이디" value="${param.userid}"/> 
							<span style="color:red"><form:errors path="userVo.userid"/></span>
						<input type="file" class="form-control" name ="profile"/>
						
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control" id="usernm" name="usernm"
								placeholder="사용자 이름" value="${param.usernm}" />
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							
							<input type="password" class="form-control"id="pass" name="pass"
									placeholder="password"  value="${param.pass}"/>		
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">

							<input type="text" class="form-control"id="reg_dt" name="reg_dt"
								placeholder="yyyy.MM.dd"  value="${param.reg_dt}">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control"id="alias" name="alias"
								placeholder="alias" value="${param.alias}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-8">
						
							<input type="text" class="form-control"id="addr1" name="addr1"
								placeholder="도로주소" value="${param.addr1}" readonly/>
						</div>
						<div class="col-sm-2">
							<button type="button" id="addrbtn" class="btn btn-default">주소 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control"id="addr2" name="addr2"
								placeholder="상세주소"  value="${param.addr2}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호코드</label>
						<div class="col-sm-10">
						
							<input type="text" class="form-control"id="zipcode" name="zipcode"
								placeholder="우편번호" value="${param.zipcode}" readonly/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
					

				</form>
			</div>
		</div>
	</div>
</body>
</html>
