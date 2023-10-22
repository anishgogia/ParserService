<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

                    <!DOCTYPE html>
                    <html lang="en">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Document</title>
                        <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
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
                          
                            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        <div class="row">
                        <div class="col-3">
                        </div>
                        <div class = "col-md-5">
                       <form:form action="competetiondetails" method="POST" modelAttribute="competetion">
                        <div class="card-body">
                            <div class="form-group">
                           <label for="URL">URL</label>
                           <form:input type="text" class="form-control" path="url"/>
                           <form:errors path="url" cssClass="error" />
                           <span class="text-danger">
                            <form:errors path="url" cssClass="error" />
                            ${message}
                           </span>
                            </div>

                            <div class="form-group">
                              <label for="URL">FINAL URL</label>
                              <form:input type="text" class="form-control" path="finalurl"/>
                              <form:errors path="finalurl" cssClass="error" />
                               </div>

                            <div class="form-group">
                            <label>Form No. </label>
                           <form:input type="number" class="form-control" path="formno"/>
                          </div>
                          <div class="form-group">
                            <label>No. Of Fields</label>
                           <form:input type="number" path="numberfields" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Start Date</label>
                           <form:input type="date" path="startDate" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>End Date</label>
                          <form:input type="date" path="endDate" name="endDate" class="form-control"/>
                           
                        </div>

                        <input type="submit" class="btn btn-primary" id="submit">
                        </div>
                       </form:form>
                       </div>
                    </div>
                    </body>

                    </html>