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
  </tr>

  </thead> </h2>
  <tbody>


  <c:forEach var="apiExPerson" items="${apiExPerson}">
    <h4> <tr>
      <td>${apiExPerson.ID}</td>
      <td>${apiExPerson.courseId}</td>
      <td>${apiExPerson.roleString}</td>
      <td>${apiExPerson.firstName}</td>
      <td>${apiExPerson.secondName}</td>
      <td>${apiExPerson.phone}</td>
      <td>${apiExPerson.email}</td>
    </tr></h4>
  </c:forEach>
  </tbody>
</table>
<h4><a href="${pageContext.request.contextPath}/index.jsp">Back to menu</a></h4>
</body>
</html>