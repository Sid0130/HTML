<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP1</title>
    </head>
    <body>
        <header>
            <h1>Servlet/JSP 소개</h1>
            <!-- 자바 코드 . 겉은 HTML이지만 자바 실행 환경 
                 요청이 올때마다 자바 프로그램에서 자동으로 시간을 최신화 해줌. -->
            <div> <%= LocalDateTime.now() %> </div>
        </header>
        <nav>
            <h2>목차</h2>
        </nav>
        <main>
        </main>
    </body>
</html>