<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blog_jsp : 로그인</title>
        <link rel="stylesheet" href="../static/css/user_signin.css">
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
    </head>
    <body>
        <div>
<%--             <%@ include file="../fragments/header.jspf" %> --%>
            
                
            <main class="mt-2 container-fluid">
                <div class="form_header">
                    <c:url value="/" var="homePage"/>
                    <a href="${homePage}">
                        <img id="signInJspLogo" alt="LOGO_JSP" src="../static/image/sign2_jsp.png">
                    </a>
                </div>
                <div class="form_content">
                    <div class ="form_section">
                        <div class="card mt-3">
                            <div class="card-body">
                                <form method="post">
                                    <div class="form_list">
                                        <div class="form_username">
                                            <input class="form_itme" id="username" name="username" type="text" placeholder="아이디" autofocus />
                                        </div>
                                        <div class="form_password">
                                            <input class="form_itme" id="password" name="password" type="password" placeholder="비밀번호" />
                                        </div>
                                        <div class="d-none">
                                            <input name="target" value= "${param.target}" readonly/>
                                        </div>
                                    </div>
                                    <c:if test="${not empty param.result && param.result eq 'f'}">
                                        <div class="text-danger mt-2">아이디와 패스워드를 확인하세요.</div>
                                    </c:if>
                                        <div class="mt-2">
                                            <input class="form-control btn btn-outline-success" 
                                                type="submit" id="btnSignIn" value="로그인"/>
                                       </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="form_signup">
                            <c:url value="/user/signup" var="userSignUpPage"/>
                            <a href="${userSignUpPage}" id="signUpPage">회원가입</a>
                        </div>
                    </div>
                    </div>
                    <c:if test="${not empty message}">
                        <div class="alert alert-success mt-3" role="alert">
                            <p>${message}</p>
                            <p>현재 포인트: ${currentPoints}</p>
                            <p>지급된 포인트: ${pointAdded}</p>
                        </div>
                    </c:if>
        
                    <!-- 실패 메시지 -->
                    <c:if
                        test="${not empty param.result && param.result == 'failure'}">
                        <div class="alert alert-danger mt-3" role="alert">
                            로그인 실패: 아이디와 비밀번호를 확인하세요.</div>
                    </c:if>
            </main>
        </div>
        
        
        
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>  
        
    </body>
</html>