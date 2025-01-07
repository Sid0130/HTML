<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Blog_jsp : 회원가입</title>
        
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
	</head>
	<body>
        <div>
            <%@ include file="../fragments/header.jspf" %>
            
            <main class="mt-2 container-fluid">
                <div class="card">
                    <div class="card-header">
                        <h2>회원가입</h2>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="mt-2">
                                <label class="form-label" for="username">아이디</label>
                                <input class="form-control" id="username" type="text" >
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="password">비밀번호</label>
                                <input class="form-control" id="password" type="password" >
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="email">이메일</label>
                                <input class="form-control" id="email" type="email" >
                            </div>
                        </form>
                    </div>
                </div>
            </main>
        </div>
		
        
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
	</body>
</html>