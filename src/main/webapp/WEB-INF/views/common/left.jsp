<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${cp}/user/AllUser">전체사용자</a></li>
		<li class="active"><a href="${cp}/user/pagingUser">사용자페이징 리스트</a></li>
		
		<%--
			localhost/pagingUser?page=1&pageSize=5로 요청시
			
			pasingUser.jsp에서 페이지에 해당하는 사용자 5명만 출력되도록 개발
			
			(kr.or.ddit.user.controller.PagingUser.java, webapp/user/pagingUser.jsp)
		 --%>
		
		
		<li class="active"><a href="${cp}/EmpAll">직원</a></li>
		
	</ul>
	<%--
		/allUser 요청을 처리할 servlet(controller)
		
		kr.or.ddit.user.controller.AllUser
			doGet(){
				1. service객체를 통해서 전체사용자 정보를 조회
				2. request객체에 userList라는 속성명으로 1번에서 조회한 데이터를 설정
				3. webapp/user/allUser.jsp로 응답을 생성하도록 forward
					allUser.jsp는 user.html참고하여 생성
					header.jsp , left.jsp를 재활용해서 생성
					
					user.html의 사용자 정보를 표현하는 테이블 태그의 tr 부분을 
					request에 저장된 userList속성 값으로 동적 생성하여
					화면에 출력
					
			}
	 --%>
			
