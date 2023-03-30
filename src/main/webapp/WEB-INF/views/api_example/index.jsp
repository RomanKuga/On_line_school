<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Servlet API Tutorial - API Examples</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
  <script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</head>
<body class = "container">
<h1>Servlet API Tutorial - API Examples</h1>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Code Snippet</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="apiExample" items="${apiExamples}">
    <tr>
      <td>${apiExample.id}</td>
      <td>${apiExample.title}</td>
      <td><pre>${apiExample.codeSnippet}</pre></td>
    </tr>
  </c:forEach>
  </tbody>

  <form action="${pageContext.request.contextPath}/logout" method="post" style="float: right;">
    <input type="submit" value="Logout">
  </form>

</table>
<a href="${pageContext.request.contextPath}/api-sections">Back to API Sections</a>

<c:if test="${not empty sessionScope.user}">
  <a href="${pageContext.request.contextPath}/secure/add-api-example">Add API Example</a>
</c:if>
</body>
</html>
