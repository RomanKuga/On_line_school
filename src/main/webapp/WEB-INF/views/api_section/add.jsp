<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add API Section</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Add API Section</h1>
  <form action="${pageContext.request.contextPath}/secure/add-api-example" method="post">
    <div>
      <label for="title">Title:</label>
      <input type="text" name="title" id="title" required>
    </div>
    <div>
      <label for="description">Description:</label>
      <textarea name="description" id="description" required></textarea>
    </div>
    <div>
      <input type="submit" value="Add Section">
    </div>
  </form>
  <a href="${pageContext.request.contextPath}/api-sections">Back to API Sections</a>
</div>
</body>
</html>
