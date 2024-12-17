<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset="UTF-8">
       <title>JSP</title>
       <style>
            <% 
            // 요청 파라미터 color의 값을 찾음
            String color = request.getParameter("color");
            String textColor = null;
            switch(color) {
            case "r":
                textColor = "Crimson";
                break;
            case "g":
                textColor = "MediumSeaGreen";
                break;
            case "b":
                textColor = "Dodgerblue";
                break;
                
            default :
                textColor = "black";
            }
            %>
            span#username {
                color: <%= textColor %>;
            }
       </style>
	</head>
	<body>
 	 	<%@ include file="header.jspf" %>
        
        <main>
            <h1>폼 양식 제출 결과</h1>
            
            <%
            // 클라이언트에서 전송한 요청 파라미터의 값을 찾는 방법:
            String username = request.getParameter("username"); // 요청 파라미터의 이름과 같아야함. input에 있는 name
            // pageContext, out, request 는 지역변수로 사용할 수 없음 이미 지역변수로 만들어져 있기 때문에.
            // 요청이 보낼때 마다 파라미터의 값이 달라지는 것 서버에서 이 일이 이루어져 있다는게 중요
            %>
            <h2>안녕하세요, <span id ="username"><%= username %></span>!</h2>
            
            <% if (username.equals("admin")) { %>
                <h3>관리자 페이지</h3>
            <% } else { %>
                <h3>일반 사용자 페이지</h3>
            <% } %>
        </main>
	</body>
</html>