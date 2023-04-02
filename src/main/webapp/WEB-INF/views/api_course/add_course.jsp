<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Course</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Add Course</h1>
  <form action="${pageContext.request.contextPath}/secure/add_api_section" method="post">
    <div>
      <h3><label for="id">Course number:</label></h3>
      <input type="number" name="id" id="id" required>
    </div>
    <div>
      <h3><label for="title">Name of course:</label></h3>
      <input type="text" name="title" id="title" required>
    </div>
    <div>
      <input type="submit" value="Add Section">
    </div>
  </form>
  <a href="${pageContext.request.contextPath}/api-sections">Back to API Sections</a>
</div>
</body>
</html>
