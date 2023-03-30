<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Servlet API Tutorial - API Sections</title>
</head>
<body>
<h1>Servlet API Tutorial - API Sections</h1>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Examples</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="apiSection" items="${apiCourse}">
    <tr>
      <td>${apiCourse.id}</td>
      <td>${apiCourse.title}</td>
      <td><a href="${pageContext.request.contextPath}/api-examples?sectionId=${apiCourse.id}">View Examples</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<c:if test="${not empty sessionScope.user}">
  <a href="${pageContext.request.contextPath}/secure/add-api-section">Add API Section</a>
</c:if>
</body>
</html>
