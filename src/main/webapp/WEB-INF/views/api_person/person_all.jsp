
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Person</title>
</head>
<body>
<h3>
  <a href="${pageContext.request.contextPath}/api-sections">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Person</h1>
<table border="1">
  <h2><thead>

  <tr>
    <th>idPerson</th>
    <th>idCourse</th>
    <th>Role</th>
    <th>firstname</th>
    <th>secondName</th>
    <th>phone</th>
    <th>email</th>
    <th>Examples</th>
  </tr>

  </thead> </h2>
  <tbody>


  <c:forEach var="apiPerson" items="${personList}">
    <h4> <tr>
      <td>${apiPerson.ID}</td>
      <td>${apiPerson.courseId}</td>
      <td>${apiPerson.roleString}</td>
      <td>${apiPerson.firstName}</td>
      <td>${apiPerson.secondName}</td>
      <td>${apiPerson.phone}</td>
      <td>${apiPerson.email}</td>
      <td><a href="${pageContext.request.contextPath}/api-exCourse?sectionId=${apiPerson.courseId}">View Examples</a></td>
    </tr></h4>
  </c:forEach>
  </tbody>
</table>
<p>
  <a href="${pageContext.request.contextPath}/api-sortPerson?sectionId=1">Дані про студентів відсортовні за прізвищем</a>
</p>
<p>
  <a href="${pageContext.request.contextPath}/api-sortPerson?sectionId=2">Список вчителів, пізвища яких починаються з літер,
   які стоять до літери "N"</a>
</p>
<p>
<form action="${pageContext.request.contextPath}/index.jsp">
  <button type="submit">Back to menu</button>
</form>
</p>

</body>
</html>