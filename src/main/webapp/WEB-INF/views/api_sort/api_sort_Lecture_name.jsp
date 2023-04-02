<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Lecture</title>
</head>
<body class = "container">
<h3>
  <a href="${pageContext.request.contextPath}/api-sections">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Lecture</h1>
<table border="1">
  <thead>
  <tr>
    <th>ID lecture</th>
    <th>name lecture</th>
    <th>Date and time</th>
    <th>Number add material or homework</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="apiSortLecture" items="${apiSortLecture}">
    <tr>
      <td>${apiSortLecture.ID}</td>
       <td>${apiSortLecture.name}</td>
      <td>${apiSortLecture.holdingTimeString}</td>
      <td>${apiSortLecture.number}</td>

    </tr>
  </c:forEach>
  </tbody>
</table>
<h4><a href="${pageContext.request.contextPath}/index.jsp">Back to menu</a></h4>
</body>
</html>
