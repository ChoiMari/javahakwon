<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" 
    %>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1"><!--initial-scale=1는 브라우저 기본 비율 이용 -->
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
 crossorigin="anonymous">
 
 <!-- integrity 보안 -->
 
</head>

<body>
   <div class="container-fluid"> <%--jsp주석 사용해야 HTML에 포함 안됨. --%>
        <c:set var="pageTitle" value="Post Modify"/> <%--scope의 기본값이 page여서 생략 가능 --%>
         <%@ include file="../fragments/header.jspf" %>
        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>포스트 수정 페이지</h2>
                </div>
                <div class="card-body">
                    <form>
                        <div class="mt-2">
                            <label for="id" class="form-label">번호</label><!--for="id"는 다른 HTML의 id속성값 찾는것 -->
                            <input id="id" class="form-control" type="text" 
                                value="${post.id}" readonly/><!-- 여기에 쓴 id속성 label에서 찾음 -->
                                <!-- readonly는 편집 막음 --><!-- value="${post.id}"은 getter메서드 호출하는 것 EL로 작성 -->
                        </div>
                        <div class="mt-2">
                            <label for="title" class="form-label">제목</label><!--for="id"는 다른 HTML의 id속성값 찾는것 -->
                            <input id="title" class="form-control" type="text" 
                                value="${post.title}" /><!--readonly 빼버림. 여기에 쓴 id속성 label에서 찾음 -->
                                <!-- readonly는 편집 막음 --><!-- value="${post.id}"은 getter메서드 호출하는 것 EL로 작성 -->
                                <!--label for="title"는 id가 title인 input을 위한 라벨입니다 라는 뜻 -->
                        </div>
                         <div class="mt-2">
                            <label for="content" class="form-label">내용</label><!--for="id"는 다른 HTML의 id속성값 찾는것 -->
                            <textarea id="contect" class="form-control" 
                            rows="5" >${post.content}</textarea> <%--readonly : 편집 막음 --%><%--readonly빼버림. 편집가능하도록 --%>
                        </div>
                        <div class="mt-2">
                            <label for="author" class="form-label">작성자</label><!--for="id"는 다른 HTML의 id속성값 찾는것 -->
                            <input id="author" class="form-control" type="text" 
                                value="${post.author}" readonly/><!-- 여기에 쓴 id속성 label에서 찾음 -->
                                <!-- readonly는 편집 막음 --><!-- value="${post.id}"은 getter메서드 호출하는 것 EL로 작성 -->
                                <!--label for="title"는 id가 title인 input을 위한 라벨입니다 라는 뜻 -->
                        </div><!-- 작성자와 id 같으면 수정가능하도록 하려고 둠. -->
                       <!-- 작성시간, 최종수정시간 코드 삭제-->
                    </form>
                </div>
                <div class="card-footer">
                   <button id="btnDelete" class= "btn btn-outline-danger">삭제</button>
                   <button id="btnUpdate" class= "btn btn-outline-success">업데이트</button>
                </div>
            </div>
        </main>
   </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous">
    </script>
</body>
</html>