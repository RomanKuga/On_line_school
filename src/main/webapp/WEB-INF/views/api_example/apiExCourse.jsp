<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Course</title>
</head>
<body>
<h3>
  <a href="${pageContext.request.contextPath}/course_all">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Course</h1>
<table border="1">
  <h2><thead>

  <tr>
    <th>ID</th>
    <th>Title</th>
  </tr>

  </thead> </h2>
  <tbody>


    <h4> <tr>
      <td>${apiExCourse.idCourse}</td>
      <td>${apiExCourse.courseName}</td>
    </tr></h4>

  </tbody>
</table>
<h4><a href="${pageContext.request.contextPath}/index.jsp">Back to menu</a></h4>
</body>
</html>
