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
        <link rel="stylesheet" href="./static/css/home.css">
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
    </head>
    <body>
    <div>
        <%@ include file="./fragments/header.jspf"%>


        <main>
            <div id="header"></div>

            <!-- 메인 이미지 -->
            <div>
                <section>
                    <div id="headerimg">
                        <div class="ret"></div>
                        <img id="wallpaper" alt="test"
                            src="./static/image/main_wallpaper.jpg"> <span>test</span>
                    </div>
                </section>
            </div>
            


        
            <!-- 카드형 이미지 -->
            <div id="homebody">
                <section>
                    <div class="card-container">
                    <!-- 파란색 라인 & 텍스트 -->
                        <div class="lines">
                            <div class="lines-text">
                                <span>Our image</span>
                                <p>Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc1.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc2.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card" >
                            <img src="./static/image/hc3.jpg" class="card-img-top">
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc4.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc5.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc6.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc7.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc8.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc9.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                        <div class="card">
                            <img src="./static/image/hc10.jpg" class="card-img-top" >
                            <div class="card-body">
                                <p class="card-text">Some quick
                                    example text to build on the card
                                    title and make up the bulk of the
                                    card's content.</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div class="middle"></div>

            <div>
                <section id="carousel-section">
                <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                      <img src="./static/image/landscape01.jpg" class="d-block w-100 " alt="First slide">
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                      <img src="./static/image/trees01.jpg" class="d-block w-100" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                      <img src="./static/image/waves_gentl01.jpg" class="d-block w-100" alt="Third slide">
                    </div>
                  </div>

                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden"></span>
                  </button>

                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden"></span>
                  </button>
                </div>
                </section>
            </div>
        </main>
    </div>





    <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
    </body>
</html>