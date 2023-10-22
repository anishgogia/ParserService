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
                    <a href="parse${competetion.id}">
                      <button type="button" class="btn btn-outline-warning">One Click Register</button>
                    </a>

                  </div> 
        </c:forEach>
</body>
</html>