<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <!-- <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> -->
      <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
    
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          </div>
      </nav>
      <div class ="row" width = "200px"></div>
      <div class="row top-buffer">
        <div class="col-4">
        </div>

    <div class="col-md-4">
    
      <form method="POST" action="${contextPath}/login" class="form-signin mt-3">
        <div class="text-center">
        <h2 class="form-heading">Log in</h2>
      </div>
        <div class="form-group ${error != null ? 'has-error' : ''}">

            <div class="form-outline mb-4">
              
            <span class="text-danger">
              ${message}
            </span>
            
            <input name="username" type="text" class="form-control" placeholder="Email"
                   autofocus="true"/>

            <label class="form-label" for="form2Example1">Email address</label>
            </div>
            <div class="form-outline mb-4">
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            
            <span class="text-danger" >${error}</span>
            <br>
            <label class="form-label" for="form2Example2">Password</label>
        </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-primary btn-block mb-4" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>


        </div>
      </form>
    </div>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  </body>
</html>