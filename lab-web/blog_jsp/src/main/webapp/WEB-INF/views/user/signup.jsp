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
        <link rel="stylesheet" href="../static/css/user_signup.css">
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
	</head>
	<body>
        <div>
            <%@ include file="../fragments/header.jspf" %>
            
            <main class="mt-2 container-fluid">
                <div class="form_content">
                    <div class="form_section">
                        <form>
                            <div class="form_list">
                                <div class="form_user">
                                <input class="form_itme" id="username" name="username" type="text" placeholder="아이디">
                                </div>
                                <div class="form_password">
                                    <input class="form_itme" id="password" name="password" type="password" placeholder="비밀번호">
                                </div>
                                <div class="form_email">
                                    <input class="form_itme" id="email" name="email" type="email" placeholder="이메일">
                                </div>
                            </div>
                            <div class="form_list">
                                <div class="form_name">
                                <input class="form_itme" name="name" type="text" placeholder="이름">
                                </div>
                            </div>
                            
                            <div>
                                <div class="form-btn">
                                    <input class="form-control btn btn-outline-success" type="submit" value="저장">
                                </div>
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