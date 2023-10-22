<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <a href ="" class="btn btn-outline-danger" type="submit">Logout</a>
      </div>
  </nav>
    <div class = "row mt-3">
      <div class ="col-3"></div>
    <div class="col-5">
      <input class="form-control" type="text" placeholder="${url}" aria-label="Disabled input example" disabled>
     </div>
    </div>
    <div class ="ml-5"> 
    <form:form action="addedsuccessful" modelAttribute="entityWrapper">
        
        <div class="card-body">

            <div class="row">
                <div class="col-1">
                    <label for="">S. No. </label> 
                </div>
                <div class="col-3">
                    <label for="">FieldType </label> 
                </div>
              <div class="col-2">
                <label for="">FieldName </label> 
              </div>
              <div class="col-2">
                <label for="">FieldId </label> 
              </div>
              <div class="col-3">
                <label for="">UserMapping </label> 
              </div>
            </div>
        </div>
         
          


          <c:forEach items="${entityWrapper.entityList}" varStatus="i">
          <div class="card-body">
            <div class="row">
                <div class="col-1">
                    <label for=""> ${i.index+1} </label>
                  </div>
              <div class="col-3">
            <form:select path = "entityList[${i.index}].fieldtype" class="form-control">
            <form:option value="TextInput" label="TextInput"/>
             <form:option value="EmailInput" label="EmailInput"/>
             <form:option value="NumberInput" label="NumberInput"/>
             <form:option value="PasswordInput" label="PasswordInput"/>
             <form:option value="Button" label="Button"/>
             <form:option value="SubmitInput" label="SubmitInput"/>
             <form:option value="TextArea" label="TextArea"/>
             <form:option value="CheckBox" label="CheckBox"/>
             <form:option value="Select" label="Select"/>
             </form:select>
           
              </div>
              <div class="col-2">
                <form:input type="text" path ="entityList[${i.index}].fieldname" class="form-control"/>
              </div>
              <div class="col-2">
                <form:input type="text" path ="entityList[${i.index}].fieldid" class="form-control"/>
              </div>
              <div class="col-3">
                <form:select path ="entityList[${i.index}].userData" placeholder="Please Write Your Code Here" class="form-control">
        <form:option value="FirstName" label="FirstName"/>
        <form:option value="LastName" label="LastName"/>
        <form:option value="Email" label="Email"/>
        <form:option value="Phone No." label="Phone No."/>
        <form:option value="Address" label="Address"/>
        <form:option value="Postcode" label="Postcode"/>
        <form:option value="City" label="City"/>
        <form:option value="Suburb" label="Suburb"/>
        <form:option value="Country" label="Country"/>
        <form:option value="Password" label="Password"/>
        <form:option value="Button/Checkbox/SubmitInput" label="Button/Checkbox/SubmitInput"/>
       
                </form:select>
              </div>
            </div>
          </div>
        </c:forEach>
        <div class="text-center">
     <input type="submit" value="Submit" class="btn btn-primary col-md-3">
        </div>
    </form:form> 
  </div> 
</body>
</html>