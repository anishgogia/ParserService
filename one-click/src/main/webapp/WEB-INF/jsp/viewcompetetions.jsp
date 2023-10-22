<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
                    
    <title>Document</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">

        <div class="container-fluid">
          <a class="navbar-brand" href="#">Navbar</a>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="addcompetetion">Add Competetion</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="viewcompetetions">View Competetions</a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="oneclick">One Click</a>
              </li>
              </ul>
            </div>
          <a onclick="document.forms['logoutForm'].submit()" class="btn btn-outline-danger">Logout</a>
          </div>
      </nav> 
  <div class="row">
    <div class="col-1 ml-5">
        <label for="">S. No. </label> 
    </div>
    <div class="col-5">
        <label for=""> URL </label> 
    </div>
  </div>
    <c:forEach items="${competetionlist}" var="competetion">
                  <div class="row mt-3">
                    <div class="col-1 ml-5">
                        <label for="">${competetion.id}</label> 
                    </div>
                    <div class="col-5">
                      <input class="form-control" type="text" value= "${competetion.url}" aria-label="Disabled input example" disabled readonly>
                       
                    </div>
                    
                    <a href="edit${competetion.id}">
                      <button type="button" class="btn btn-outline-warning ml-3 mr-3">Edit</button>
                    </a>
                    <a href="delete${competetion.id}">
                        <button type="button" class="btn btn-outline-danger" onclick= "return confirm('Are you sure you want to delete this competetion?')">Delete</button>
                    </a>
                  </div> 
        </c:forEach>
</body>
</html>