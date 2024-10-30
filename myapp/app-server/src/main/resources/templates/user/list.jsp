<!DOCTYPE html>
<html>
<head data-th-replace="~{header :: head}"></head>
<body>

<header data-th-replace="~{header :: #page-header}"></header>

<h1>회원 목록</h1>
<p><a data-th-href="@{users/form}">새 회원</a></p>
<table>
  <thead>
      <tr><th>번호</th><th>이름</th><th>이메일</th></tr>
  </thead>
  <tbody>

<tr>
  <td>${user.no}</td>
  <td>
    <img src="https://p2zqyggq4939.edge.naverncp.com/UZxHbepmRn/user/${user.photo == null ? 'default.png' : user.photo}?type=f&w=20&h=20">
    <a href='users/${user.no}'>${user.name}</a></td>
  <td>${user.email}</td>
</tr>

  </tbody>
</table>


</body>
</html>