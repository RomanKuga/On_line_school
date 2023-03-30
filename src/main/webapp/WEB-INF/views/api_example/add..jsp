<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add API Example</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Add API Example</h1>
  <form action="${pageContext.request.contextPath}/secure/add-api-section" method="post">
    <div>
      <label for="title">Title:</label>
      <input type="text" name="title" id="title" required>
    </div>
    <div>
      <label for="description">Description:</label>
      <textarea name="description" id="description" required></textarea>
    </div>
    <div>
      <label for="code">Code:</label>
      <textarea name="code" id="code" required></textarea>
    </div>
    <div>
      <input type="submit" value="Add Example">
    </div>
  </form>
  <a href="${pageContext.request.contextPath}/api-examples">Back to API Examples</a>
</div>
</body>
</html>