<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>On line school - Lecture and Person for Course</title>
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

<h1>On line school - Person</h1>
<table border="2">
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
