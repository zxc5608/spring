<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<title>Jsp*</title>

<%@include file="/WEB-INF/views/common/common_lib.jsp" %>

<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">
</head>

<body>

	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				
				<%@include file="/WEB-INF/views/common/left.jsp" %>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header">
					<h1 class="blog-title">Main</h1>
					<p class="lead blog-description">Jsp / Spring.</p>
				</div>

				<div class="row">

					<div class="col-sm-8 blog-main">

						<div class="blog-post">
							<h2 class="blog-post-title">JSP</h2>
							<p class="blog-post-meta">2017.10.30, room 201</p>

							<p>jsp를 통한 웹 프로그래밍 학습</p>
							<hr>

							<h3>상세내역</h3>
							<p>JSP과정에서는 다음과 같은 내용을 학습한다.</p>
							<ul>
								<li>servlet 동작원리</li>
								<li>jsp와 servlet의 관계</li>
								<li>jsp 스크립틀릿 요소</li>
								<li>jsp action tag (standard)</li>
								<li>jstl</li>
								<li>db pooling</li>
								<li>페이지 모듈화</li>
							</ul>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
