<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<div class="container">
  <h1>Login</h1>
  <form action="${pageContext.request.contextPath}/login" method="post">
    <div>
      <label for="username">Username:</label>
      <input type="text" name="username" id="username" required>
    </div>
    <div>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" required>
    </div>
    <div>
      <input type="submit" value="Login">
    </div>
  </form>

</div>
</body>
</html>