<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Lecture</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Add Lecture</h1>
  <form action="${pageContext.request.contextPath}/add_api_lecture" method="post">
    <div>
      <h3><label for="id">Lecture number:</label></h3>
      <input type="number" name="id" id="id" required>
    </div>
    <div>
      <h3><label for="idCourse">Course number:</label></h3>
      <input type="number" name="idCourse" id="idCourse" required>
    </div>
    <div>
      <h3><label for="title">Name of Lecture:</label></h3>
      <input type="text" name="title" id="title" required>
    </div>
    <div>
      <h3><label for="idPerson">Person number:</label></h3>
      <input type="number" name="idPerson" id="idPerson" required>
    </div>
    <div>
      <h3><label for="description">Description:</label></h3>
      <input type="text" name="description" id="description" required>
    </div>
    <div>
      <h3><label for="dateTime">Date and time:</label></h3>
      <input type="datetime-local" name="dateTime" id="dateTime" required>
    </div>
    <div>
      <input type="submit" value="Add Section">
    </div>
  </form>
  <a href="${pageContext.request.contextPath}/api_lecture">Back to API Lecture</a>
</div>
</body>
</html>
