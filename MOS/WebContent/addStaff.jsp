<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
                        <a class="dropdown-item" href="StaffMgmtUI.jsp">Staff Summary</a>
                        <a class="dropdwon-item active" href="addStaff.jsp">Add Staff</a><br>
           				<a class="dropdwon-item  " href="removeStaff.jsp">Remove Staff</a><br>
                    </div>
                </div>

            </div>

        </div>

    </div>

</header>

<div class="container">
    <ol class="breadcrumb">
        <li class="active">Add a new Staff Member</li>

    </ol>
</div>

<section id="main">
    <div class="container">
        <div class="row">
            
            <div class="col-md-9">
                <div class="list-group">
                    <a href="#" class="list-group-item active">Input Staff Information</a>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>ID</label>
                            <input class="form-control" type="text">

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>Password</label>
                            <input class="form-control" type="text" name="pin">

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>Password-Confirm</label>
                            <input class="form-control" type="text">

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>Gender</label>
                            <select class="form-control">
                                <option selected>Male</option>
                                <option>Female</option>
                            </select>

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>Phone</label>
                            <input class="form-control" type="tel" value="1-(555)-555-5555" id="example-tel-input">

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-group">
                            <label>Email</label>
                            <input class="form-control" type="email">

                        </form>
                    </div>
                    <div class="list-group-item">
                        <form class="form-row">
                            <div class="form-group col-md-7">
                                <label>Address</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-3">
                                <label>City</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="form-group col-md-2">
                                <label>Province</label>
                                <input class="form-control" type="text">
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
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