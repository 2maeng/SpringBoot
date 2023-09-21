<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title> 능단평 </title>
      <style>
         body {
             font-family: Arial, sans-serif;
             background-color: #f5f5f5;
             margin: 0;
             padding: 0;
         }
 
         h1 {
             background-color: #333;
             color: #fff;
             padding: 10px;
         }
 
         h1, h2 {
             margin: 10px;
         }
 
         form {
             margin: 20px;
             padding: 10px;
             background-color: #fff;
             border: 1px solid #ccc;
             border-radius: 5px;
         }
 
         input[type="text"] {
             width: 100%;
             padding: 10px;
             margin-bottom: 10px;
             border: 1px solid #ccc;
             border-radius: 5px;
         }
 
         input[type="submit"] {
             background-color: #333;
             color: #fff;
             padding: 10px 20px;
             border: none;
             cursor: pointer;
             border-radius: 5px;
         }
 
         b {
             margin: 10px;
         }
 
         a {
             text-decoration: none;
             color: #333;
         }
 
         a:hover {
             text-decoration: underline;
         }
     </style>
   </head>
   <body>
    <h1>작성자 : ${bdata.mid} </h1>
<h1>내용 : ${bdata.content}</h1>
<c:if test="${id eq bdata.mid}">
    <form action="/updateBoard/${bdata.num}" method="post" onsubmit="return validateUpdateForm()">
        <input type="text" name="content" required>
        <input type="submit" value="수정">
    </form>
    <br>
    <b><a href="/deleteBoard/${bdata.num}" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a></b> <br>
</c:if>
<b><a href="/main">메인으로 돌아가기</a></b>

<script>
    function validateUpdateForm() {
        var content = document.querySelector("input[name='content']").value;

        // 내용이 비어 있는지 검사
        if (content.trim() === "") {
            alert("내용을 입력하세요...");
            return false; // 폼 제출을 중단합니다.
        }
        
        // 추가적인 유효성 검사를 여기에 추가할 수 있습니다.
        alert("게시글 수정 완료!");
        return true; // 유효성 검사를 통과하면 폼을 제출합니다.
    }
</script>
</body>
</html>