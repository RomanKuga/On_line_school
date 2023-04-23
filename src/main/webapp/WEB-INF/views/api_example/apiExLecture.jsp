<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Lecture</title>
</head>
<body class = "container">
<h3>
  <a href="${pageContext.request.contextPath}/course_all">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Lecture</h1>
<table border="1">
  <thead>
  <tr>
    <th>idLecture</th>
    <th>idCourse</th>
    <th>name lecture</th>
    <th>id Teacher</th>
    <th>description</th>
    <th>Date and time</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="apiExLecture" items="${apiExLecture}">
    <tr>
      <td>${apiExLecture.ID}</td>
      <td>${apiExLecture.courseID}</td>
      <td>${apiExLecture.name}</td>
      <td>${apiExLecture.personId}</td>
      <td>${apiExLecture.description}</td>
      <td>${apiExLecture.holdingTimeString}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<h4><a href="${pageContext.request.contextPath}/index.jsp">Back to menu</a></h4>
</body>
</html>