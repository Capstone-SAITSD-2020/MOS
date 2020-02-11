<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="StaffManagementScript.js"></script>
<meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale-1, shrink-to-fit-no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Migarock Management</title>
</head>
<body>
	
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="index.html">Migarock Management System</a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbar" aria-controls="navbar" aria-expanded="false">
        
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse justify-content-between" id="navbar">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="homeUI.jsp">Dashboard</a>
            <a class="nav-item nav-link " href="menuUI.jsp">Menu</a>
            <a class="nav-item nav-link " href="staffUI.jsp">Staff</a>
            <a class="nav-item nav-link " href="dataBaseUI.jsp">Backup/ Restore</a>
        </div>
    </div>
</nav>


<header id="header">
    <div class="container p-3 bg-dark text-white">
        <div class="row">
            <div class="col-sm-9 info">
                <h4><img src="img/user_small.svg"> Staff Management       
                </h4>
            </div>
            <div class="col-sm-3 info">
                <div class="btn-group float-right">
                    <button type="button" class="btn btn-primary dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                    >Options
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item active " href="StaffMgmtUI.jsp">Staff Summary</a>
                        <a class="dropdwon-item " href="addStaff.jsp">Add Staff</a><br>
           				<a class="dropdwon-item  " href="removeStaff.jsp">Remove Staff</a>	
                    </div>
                </div>

            </div>

        </div>

    </div>

</header>

<div class="container">
    <ol class="breadcrumb">
        <li class="active">Staff Summary</li>

    </ol>
</div>

<section id="main">
    <div class="container">
        <div class="row">
            
            <div class="col-md-9">
                <div class="list-group">
                
                    <a href="" class="list-group-item active">Current Staff</a>
                    <div class="list-group-item">
                        <div class="list-group">
                            <table class="table" id="staffTable">
                                <tbody>
                                
                                <!-- Changed some of the table headings and the table data for testing -->
                                <tr>
                                    <th class="mobile" style="width: 100px; text-align: center" >ID</th>
                                    <td class="mobile" style="width: 100px; text-align: center" >First Name</td>
                                    <th class="mobile" style="width: 130px; text-align: center" >��Last Name</th>
                                    <th class="mobile" style="width: 150px; text-align: center" >Contact Number</th>
                                </tr>
                                <tr>
                                    <td class="mobile" style="width: 100px; text-align: center" id="id"></td>
                                    <td class="mobile" style="width: 100px; text-align: center" id="fname"></td>
                                    <td class="mobile" style="width: 130px; text-align: center" id="lname"></td>
                                    <td class="mobile" style="width: 150px; text-align: center" id="contactnumber"></td>
                                </tr>
                               
                               
                                </tbody>

                            </table>

                        </div>
                    </div>
                </div>
                
            </div>

        </div>

    </div>
</section>

<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
    Copyright &copy; 2020 Best Capstone Group
</footer>


<!--제이쿼리 자바스크립트 추가하기-->
<script src="js/jquery.min.js"></script>
<!--popper 자바스크립트 추가하기-->
<script src="js/popper.min.js"></script>
<!--부트스트랩 자바스크립트 추가하기-->
<script src="js/bootstrap.min.js"></script>
<!--MDB 자바스크립트 추가하기 (맨 밑에 있어야 함)-->
<script src="js/mdb.min.js"></script>

</body>
</html>