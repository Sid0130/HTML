<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>JSP2</title>
        
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
	</head>
	<body>
        <div>
            <c:set value="홈 페이지" var="pageTitle" />
            <%@ include file="./fragments/header.jspf" %>
            
        </div>

    <div class="text-left">
        <h2 class="ms-5"> 메뉴 </h2>
        <div class="row">
            <div class="col-4">
                <ul class="m-20 fs-5"  style="list-style:none;">
                    <li >
                        <a>테스트</a>
                    </li>            
                    <li>
                        <a>테스트</a>
                    </li>            
                </ul>
            </div>
            <div class="col-8">2 of 2</div>
        </div>
        <div class="row">
            <div class="col">2 of 3</div>
            <div class="col">3 of 3</div>
        </div>
    </div>



    <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
	</body>
</html>