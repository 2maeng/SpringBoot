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
            margin: 0;
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

        hr {
            margin: 20px 0;
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
    <b><a href="/main">메인으로 돌아가기</a></b>
    <h1>회원가입</h1>
    <div class="box">
        <form action="signup" method="post" onsubmit="return validateSignupForm()">
            ID <input type="text" name="id" required>
            PASSWORD <input type="password" name="pw" id="signup_pw" required>
            <input type="submit" value="회원가입">
        </form>
    </div>
    <hr>

    <script>
        function validateSignupForm() {
            var signupPw = document.getElementById("signup_pw").value;

            var id = document.querySelector("input[name='id']").value;

            // 비밀번호 길이 검사
            if (signupPw.length < 6 || signupPw.trim() === "") {
                alert("비밀번호는 최소 6자 이상이어야 합니다.");
                return false;
            }
            
            // 아이디가 비어 있는지 검사
            if (id.trim() === "") {
                alert("아이디를 입력하세요!");
                return false; // 폼 제출을 중단합니다.
            }
            
            // 추가적인 유효성 검사를 여기에 추가할 수 있습니다.
            alert("회원가입에 성공했습니다.");
            return true;
        }
    </script>
</body>
</html>