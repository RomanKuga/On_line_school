
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Add Material</title>
</head>
<body>
<h3>
  <a href="${pageContext.request.contextPath}/course_all">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Add Material</h1>
<table border="1">
  <h2><thead>

  <tr>
    <th>Resource Typ</th>
    <th>Number</th>
  </tr>

  </thead> </h2>
  <tbody>


  <c:forEach var="apiSortAddMaterial" items="${apiSortAddMaterial}">
    <h4> <tr>
      <td>${apiSortAddMaterial.typeResource}</td>
      <td>${apiSortAddMaterial.numberResource}</td>
    </tr></h4>
  </c:forEach>
  </tbody>
</table>
<h4><a href="${pageContext.request.contextPath}/index.jsp">Back to menu</a></h4>
</body>
</html>