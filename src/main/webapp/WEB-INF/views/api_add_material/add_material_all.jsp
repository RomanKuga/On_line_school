
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
        <th>id Add Material</th>
        <th>name Add Materials</th>
        <th>lecture Id</th>
        <th>Resource Typ</th>
        <th>Examples</th>
    </tr>

    </thead> </h2>
    <tbody>


    <c:forEach var="apiAddMaterial" items="${addMaterialList}">
        <h4> <tr>
            <td>${apiAddMaterial.ID}</td>
            <td>${apiAddMaterial.nameAddMaterials}</td>
            <td>${apiAddMaterial.lectureId}</td>
            <td>${apiAddMaterial.typeResource}</td>
            <td><a href="${pageContext.request.contextPath}/api-exLecture?sectionId=${apiAddMaterial.lectureId}">View Examples</a></td>
        </tr></h4>
    </c:forEach>
    </tbody>
</table>
<p>
    <a href="${pageContext.request.contextPath}/api-sortAddMaterial?sectionId=1">Виведіть кількість додаткових матріалів по кожній категорії</a>
</p>
<p>
<form action="${pageContext.request.contextPath}/index.jsp">
    <button type="submit">Back to menu</button>
</form>
</p>

</body>
</html>