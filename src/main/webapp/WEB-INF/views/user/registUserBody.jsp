<%@page import="kr.or.ddit.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

		<form class="form-horizontal" role="form" enctype="multipart/form-data"
									action="${cp}/user
									/registUser" method="post">
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="USERID"/></label>
						<div class="col-sm-10">
						<%-- <label class="control-label"><%=vo.getUserid() %></label> --%>
					
						 	<input type="text" class="form-control" id="userid" name="userid"
								placeholder="사용자 아이디" value="${param.userid}"/> 
							<span style="color:red"><form:errors path="userVo.userid"/></span>
						<input type="file" class="form-control" name ="profile"/>
						
						</div>
					</div>
					SPRING
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="USERNM"/></label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control" id="usernm" name="usernm"
								placeholder="사용자 이름" value="${param.usernm}" />
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="PASS"/></label>
						<div class="col-sm-10">
							
							<input type="password" class="form-control"id="pass" name="pass"
									placeholder="password"  value="${param.pass}"/>		
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="REG_DT"/></label>
						<div class="col-sm-10">

							<input type="text" class="form-control"id="reg_dt" name="reg_dt"
								placeholder="yyyy.MM.dd"  value="${param.reg_dt}">
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="ALIAS"/></label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control"id="alias" name="alias"
								placeholder="alias" value="${param.alias}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="ADDR1"/></label>
						<div class="col-sm-8">
						
							<input type="text" class="form-control"id="addr1" name="addr1"
								placeholder="도로주소" value="${param.addr1}" readonly/>
						</div>
						<div class="col-sm-2">
							<button type="button" id="addrbtn" class="btn btn-default">주소 검색</button>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="ADDR2"/></label>
						<div class="col-sm-10">
							
							<input type="text" class="form-control"id="addr2" name="addr2"
								placeholder="상세주소"  value="${param.addr2}"/>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label"><spring:message code="ZIPCODE"/></label>
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
<select name="lang">
	<option value="">언어설정</option>
	<option value="ko">한국어</option>
	<option value="en">영어</option>
</select>
<script>
$(function(){
	$("select[name=lang]").val("${param.lang}");
	$("select[name=lang]").on("change",function(){
		
		document.location="/user/registUser?lang="+$(this).val();
	});
})
</script>