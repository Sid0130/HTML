<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>로그인</title>
        
        
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
                    <div class="card-body">
                        <form method="post">
                            <div class="mt-2">
                                <input class="form-control" type="text" 
                                    name="username" placeholder="아이디" required autofocus />
                            </div>
                            <div class="mt-2">
                                <input class="form-control" type="password"
                                    name="password" placeholder="비밀번호" required />
                            </div>
                            <div class="mt-2">
                                <input class="form-control btn btn-outline-primary" 
                                    type="submit" value="로그인"/>
                            </div>
                        </form>
                    </div>
                </div>
                <ul>
                    <li>
                        <a href="/user/signup">회원가입</a>
                    </li>
                </ul>
            </main>
        </div>
        
		
        
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
	</body>
</html>