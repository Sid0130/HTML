<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <!-- Bootstrap을 사용하기 위한 meta name="viewport" 설정. -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Spring2</title>
        
        
        <!-- Bootstrap CSS 링크. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
        crossorigin="anonymous">
	</head>
	<body>
		<div class="container-fluid">
            <c:set value="포스트 상세보기" var="pageTitle"/>
            <%@ include file="../fragments/header.jspf" %>
            
            <main>
                <div class="card mt-2">
                    <div class="card-header">
                        <h1>${post.id} ${post.title}</h1>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="mt-2">
                                <label class="form-label" for="id">번호</label>
                                <input class="form-control" id="id" name="id" 
                                   value="${post.id}" type="text" readonly/>
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="title">제목</label>
                                <input class="form-control" id="title" name="title" 
                                   value="${post.title}" type="text" readonly/>
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="content">내용</label>
                                <textarea rows="5" class="form-control" id="content" 
                                     name="content" readonly>${post.content}"</textarea>
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="author">작성자</label>
                                <input class="form-control" type="text" id="author" 
                                   value="${post.author}" name="author" readonly/>
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="createTime">작성시간</label>
                                <input class="form-control" type="text" id="createdTime" name="createdTime" 
                                   value="${post.createdTime}" readonly/>
                            </div>
                            <div class="mt-2">
                                <label class="form-label" for="modifiedTime">최종수정시간</label>
                                <input class="form-control" type="text" id="modifiedTime" name="modifiedTime" 
                                   value="${post.modifiedTime}" readonly/>
                            </div>
                        </form>
                        <div class="card-footer">
                            <div class="d-flex justify-content-center">
                                <c:url var="postModifyPage" value="/post/modify">
                                    <c:param name="id" value="${post.id}"/>
                                </c:url>
                                <a class="btn btn-outline-success"
                                    href="${postModifyPage}">수정하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

        <section>
            <div class="mt-2 d-inline-flex gap-1">
                <button class="btn btn-outline-secondary"
                    id="btnToggleComment">댓글 보기</button>
            </div>
            
            <!-- 댓글 보기/감추기 토글 버튼에 의해서 접기/펼치기를 할 영역 -->
            <div class="mt-2 collapse" id="collapseComments">
                <!-- 댓글 등록 UI -->
                <div class="mt-2 card card-body">
                    <div class="row">
                        <div class="col-10">
                            <textarea class="form-control" rows="3" 
                                 id="ctext" placeholder="댓글 입력"></textarea>
                            <input class="d-none" id="username" value="guest" readonly>
                        </div>
                        <div class="col-2">
                            <button class="btn btn-outline-success"
                                id="btnRegisterComment">등록</button>
                            
                        </div>
                    </div>
                </div>
                <!-- 댓글 목록 UI -->
                <div class="my-2" id="divComments">
                    댓글 목록
                </div>
            </div>
        </section>
    </div>
        
        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
        
        <!-- Axios Http JS -->
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        
        <c:url var="commentJS" value="/js/comments.js"/>
        <script src="${commentJS}"></script>
	</body>
</html>