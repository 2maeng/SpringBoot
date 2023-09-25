<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>능단평 메인</title>
    
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

        .box {
            margin: 20px;
            padding: 10px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: -webkit-fill-available;
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

        hr {
            margin: 20px;
            border: none;
            border-top: 1px solid #ccc;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
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
    <c:if test="${empty id}">
    <b><a href="/signupPage">회원가입</a></b>
    <h1>로그인</h1>
    <div class="box">
        <form action="/login" method="post" onsubmit="return validateLoginForm()">
            ID <input type="text" name="id" required>
            PASSWORD <input type="password" name="pw" id="login_pw" required>
            <input type="submit" value="로그인">
        </form>
    </div>
</c:if>

<c:if test="${not empty id}">
    <b><a href="mypage/${id}">마이페이지</a></b>
    <b><a href="logout">로그아웃</a></b>
    <hr>
    <div class="box">
        <form action="insertBoard" method="post" onsubmit="return validateBoardForm()">
            <input type="hidden" name="mid" value="${id}">
            <input type="text" name="content" required>
            <input type="submit" value="게시글 작성">
        </form>
    </div>
    <c:if test="${empty bdatas}">
        <h1>현재 게시글이 없습니다</h1>
    </c:if>
    <c:if test="${not empty bdatas}">
        <table>
            <thead>
                <tr>
                    <th><span>글 번호</span></th>
                    <th><span>작성자</span></th>
                    <th><span>게시글</span></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="data" items="${bdatas}">
                    <tr>
                        <td><a href="board/${data.num}">${data.num}</a></td>
                        <td>${data.mid}</td>
                        <td>${data.content}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</c:if>

<script>
    function validateLoginForm() {
        var loginPw = document.getElementById("login_pw").value;

        var id = document.querySelector("input[name='id']").value;

        // 비밀번호 길이 검사
        if (loginPw.length < 6 || loginPw.trim() === "") {
            alert("비밀번호는 최소 6자 이상이어야 합니다...");
            return false;
        }
        
        // 게시글 내용이 비어 있는지 검사
        if (id.trim() === "") {
            alert("아이디를 입력하세요...");
            return false;
        }

        // 추가적인 유효성 검사를 여기에 추가할 수 있습니다.
        return true;
    }

    function validateBoardForm() {
        var content = document.querySelector("input[name='content']").value;

        // 게시글 내용이 비어 있는지 검사
        if (content.trim() === "") {
            alert("게시글 내용을 입력하세요...");
            return false;
        }

        alert("게시글 작성 성공!")
        // 추가적인 유효성 검사를 여기에 추가할 수 있습니다.
        return true;
    }
</script>
</body>
</html>