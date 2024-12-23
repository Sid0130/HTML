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
		<div class="container-fluid">
            <c:set value="새 글 작성" var="pageTitle" />
            <%@ include file="../fragments/header.jspf" %>
        </div>

    <main>
        <div class="mt-2 card">
            <div class="card-header">
                <h1>CREATE</h1>
            </div>
            <div class="mb-3 w-100 p-3">
                <label for="formGroupExampleInput" class="form-label fs-5">제목</label><br />
                <input type="text" class="form-control" placeholder="제목" /><br />
            </div>
            <div class="mb-3 w-100 p-3">
                <label for="contentTextarea" class="form-label fs-5">내용</label><br />
                <textarea id="contentTextarea" class="form-control"
                    placeholder="내용" style="width: 100%; height: 150px;"></textarea>
            </div>
            <div class="mb-3 w-100 p-3">
                <label for="authorInput" class="form-label fs-5">작성자</label><br /> <input
                    type="text" id="authorInput" class="form-control"
                    placeholder="작성자" />
                    
            </div>
            <div class="col-auto" align="right">
                <button type="button" class="btn btn-secondary">취소</button>
                <button type="submit" class="btn btn-primary">저장</button>
            </div>
        </div>
    </main>


    <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
        crossorigin="anonymous"></script>   
	</body>
</html>