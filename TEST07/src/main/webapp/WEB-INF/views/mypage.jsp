<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>마이페이지</title>
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
        max-width: 400px;
        margin: 0 auto;
      }

      label {
        display: block;
        margin-bottom: 5px;
      }

      input[type='text'],
      input[type='password'] {
        width: -webkit-fill-available;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
      }

      input[type='submit'],
      input[type='button'] {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        border-radius: 5px;
      }

      input[type='submit'] {
        margin-right: 10px;
      }

      input[type='button'] {
        background-color: #cc0000;
      }

      input[type='button']:hover {
        background-color: #ff0000;
      }

      script {
        margin-top: 20px;
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
    <script type="text/javascript">
      function del() {
        var ans = confirm('정말 회원탈퇴를 진행하시겠습니까?');
        if (ans) {
          location.href = '/deleteMember/${id}';
        }
      }

      function validateForm() {
        var password = document.forms['updateForm']['pw'].value;
        // 여기에 비밀번호 유효성 검사 조건을 추가하세요
        if (password.length < 6 || password.trim() === '') {
          alert('비밀번호는 최소 6자 이상이어야 합니다...');
          return false;
        }
        alert('비밀번호 변경성공!');
        // 추가적인 유효성 검사를 여기에 추가할 수 있습니다.
      }
    </script>

    <b><a href="/main">메인으로 돌아가기</a></b>
    <div class="box">
      <form name="updateForm" action="/updateMember" method="post" onsubmit="return validateForm()">
        아이디 <input type="text" name="id" value="${id}" readonly /> <br />
        비밀번호 <input type="password" name="pw" value="${mdata.pw}" required /> <br />
        <input type="submit" value="회원정보변경" />&nbsp;&nbsp;&nbsp;<input
          type="button"
          onclick="del()"
          value="회원탈퇴"
        />
      </form>
    </div>
  </body>
</html>
