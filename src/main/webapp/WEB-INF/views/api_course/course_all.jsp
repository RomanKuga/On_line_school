<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Course</title>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/api-sections">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
    <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Course</h1>
<table border="1">
  <h2><thead>

    <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Examples</th>
  </tr>

  </thead> </h2>
  <tbody>

  <c:forEach var="apiSection" items="${courseList}">
   <h4> <tr>
      <td>${apiSection.idCourse}</td>
      <td>${apiSection.courseName}</td>
      <td><a href="${pageContext.request.contextPath}/api-exLecturePerson?sectionId=${apiSection.idCourse}">View Examples</a></td>
    </tr></h4>
  </c:forEach>
  </tbody>
</table>
<p>
<form action="${pageContext.request.contextPath}/index.jsp">
    <button type="submit">Back to menu</button>
</form>
</p>
<p>
<form action="${pageContext.request.contextPath}/secure/add_api_section">
    <button type="submit">Add Course</button>
</form>
</p>
</body>
</html>
