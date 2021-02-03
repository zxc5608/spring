<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="/WEB-INF/views/common/common_lib.jsp" %>


<script>
//문서로딩이 완료되고 나서 실행되는 영역
$(function(){
	$(".user").on("click",function(){
		//this: 클릭 이벤트가 발생한 element
		//data-속성명 data-userid, 속성명은 대소문자 무식하고 소문자로 인식
		//data-userID==> data-userid
		var userid = $(this).data("userid");
		//var userid = ($(this).data("userid"));
		$("#userid").val(userid);
		$("#frm").submit();
		
		
	});
});
</script>



	<form id ="frm" action="<%=request.getContextPath()%>/user/userTiles">
		<input type= "hidden" id= "userid" name= "userid" value=""/>
	</form>

	
	


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
				
				<c:forEach items="${userList }" var="user">
					<tr>
					<tr class='user' data-userid="${user.userid }">
						<td>${user.userid }</td>
						<td>${user.usernm }</td>
						<td>${user.alias }</td>
						<td>
						<fmt:formatDate value="${user.reg_dt }" pattern="yyyy.MM.dd"/>
						</td>
					
					</tr>
				
				</c:forEach>


							</table>
						</div>


						<a class="btn btn-default pull-right" href="${cp}/user/registUser">사용자등록</a>
						<a class="btn btn-default pull-right" href="${cp}/user/excelDownload">사용자엑셀다운로드</a>

						<div class="text-center">
							<!-- 페이지네이션 링크 활성 비활성  -->

							<ul class="pagination">
								<%--
										pagination 이 4이므로 3번 반복된다
										사용자수 16명
										페이지 사이즈5
										페이지 4페이지 
										
									 --%>
								<li class="prev"><a
									href="${cp}pagingUser?page=1&pageSize=${pageVo.getPageSize()}">«</a>
								</li>
								<c:forEach begin="1" end="${pagination }" var="i">
									<c:choose>
										<c:when test="${pageVo.getPage() ==i}">
											<li class="active"><span>${i }</span></li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${cp}pagingUser?page=${i }&pageSize=${pageVo.getPageSize()}">${i }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li class="next"><a
									href="${cp}pagingUser?page=${pagination}&pageSize=${pageVo.getPageSize() }">»</a>
								</li>






							</ul>
						</div>
					</div>
				</div>


