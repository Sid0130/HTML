<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Blog_Jsp</title>
        <style>
            
        </style>
        
        
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
        <div class="row">
            <h2 class="ms-5"> 최근 목록 </h2>
            <div class="col-4">
                <ul class="m-20 fs-5"  style="list-style:none;">
                    <li class="mt-3">
                        <a>테스트</a>
                    </li>            
                    <li class="mt-3">
                        <a>테스트</a>
                    </li>            
                </ul>
            </div>
<!--             <div class="col-8">2 of 2 -->
<!--                 <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel"> -->
<!--                   Carousel 내부 컨텐츠 -->
<!--                   <div class="carousel-inner"> -->
<!--                     첫 번째 슬라이드 -->
<!--                     <div class="carousel-item active" data-bs-interval="10000"> -->
<!--                       <img src="./static/image/landscape01.jpg" class="d-block w-100 " alt="First slide"> -->
<!--                     </div> -->
<!--                     두 번째 슬라이드 -->
<!--                     <div class="carousel-item" data-bs-interval="2000"> -->
<!--                       <img src="./static/image/trees01.jpg" class="d-block w-100" alt="Second slide"> -->
<!--                     </div> -->
<!--                     세 번째 슬라이드 -->
<!--                     <div class="carousel-item"> -->
<!--                       <img src="./static/image/waves_gentl01.jpg" class="d-block w-100" alt="Third slide"> -->
<!--                     </div> -->
<!--                   </div> -->
                
<!--                   이전 슬라이드 버튼 -->
<!--                   <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev"> -->
<!--                     <span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
<!--                     <span class="visually-hidden">Previous</span> -->
<!--                   </button> -->
                
<!--                   다음 슬라이드 버튼 -->
<!--                   <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next"> -->
<!--                     <span class="carousel-control-next-icon" aria-hidden="true"></span> -->
<!--                     <span class="visually-hidden">Next</span> -->
<!--                   </button> -->
<!--                 </div> -->
<!--             </div> -->
            
        </div>
<!--         <div class="row"> -->
<!--             <div class="col">2 of 3</div> -->
<!--             <div class="col">3 of 3</div> -->
<!--         </div> -->
    </div>



    <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
	</body>
</html>