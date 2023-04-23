<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>On line school - Lecture</title>
</head>
<body>
<h3>
  <a href="${pageContext.request.contextPath}/course_all">Course</a>      <a href="${pageContext.request.contextPath}/api_lecture">Lecture</a>     <a href="${pageContext.request.contextPath}/api_person">Person</a>
  <a href="${pageContext.request.contextPath}/api_add_material">Add material</a>  <a href="${pageContext.request.contextPath}/api_home_work">Home work</a>
</h3>
<h1>On line school - Lecture</h1>
<table border="1">
  <h2><thead>

  <tr>
    <th>idLecture</th>
    <th>idCourse</th>
    <th>name lecture</th>
    <th>id Teacher</th>
    <th>description</th>
    <th>Date and time</th>
    <th>Examples</th>
  </tr>

  </thead> </h2>
  <tbody>


  <c:forEach var="apiLecture" items="${lectureList}">
    <h4> <tr>
      <td>${apiLecture.ID}</td>
      <td>${apiLecture.courseID}</td>
      <td>${apiLecture.name}</td>
      <td><a href="${pageContext.request.contextPath}/api-exPerson?sectionId=${apiLecture.personId}">${apiLecture.personId}</a></td>
      <td>${apiLecture.description}</td>
      <td>${apiLecture.holdingTimeString}</td>
      <td><a href="${pageContext.request.contextPath}/requestCourse?sectionId=${apiLecture.courseID}">View Examples</a></td>
    </tr></h4>
  </c:forEach>
  </tbody>
</table>
<p>
  <a href="${pageContext.request.contextPath}/api-sortLecture?sectionId=1">Назва лекції, та кількість додаткових матеріалів, яківона містить, відсортовані за
  датою та які проходили до 2023</a>
</p>
<p>
  <a href="${pageContext.request.contextPath}/api-sortLecture?sectionId=2">Інформація про лекцію, яка створенна раніше за всіх та має найбульшу кількість домашніх завдань</a>
</p>
<p>
<form action="${pageContext.request.contextPath}/index.jsp">
  <button type="submit">Back to menu</button>
</form>
</p>
<p>
<form action="${pageContext.request.contextPath}/add_api_lecture">
  <button type="submit">Add Lecture</button>
</form>
</p>
</body>
</html>