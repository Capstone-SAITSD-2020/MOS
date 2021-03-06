<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width-device-width, initial-scale-1, shrink-to-fit-no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="js/StaffListScreen.js" type="text/javascript"></script>
<script src="js/StaffAddScreen.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Migarock Management</title>
</head>
<body>
	
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="DashboardUI.jsp">Migarock Management System</a>
    <!--Allows NAv bar to adapt to any size screen-->
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbar" aria-controls="navbar" aria-expanded="false">
        <!--Icon for screens too small for full NAV bar-->
        <span class="navbar-toggler-icon"></span>
    </button>
    <!--Default NAV Bar-->
    <div class="collapse navbar-collapse justify-content-between" id="navbar">
        <div class="navbar-nav">
            <a class="nav-item nav-link " href="DashboardUI.jsp">Dashboard</a>
            <a class="nav-item nav-link " href="MenuUI.jsp">Menu</a>
            <a class="nav-item nav-link active" href="StaffMgmtUI.jsp">Staff</a>
            <a class="nav-item nav-link " href="DataBaseUI.jsp">Backup/ Restore</a>
        </div>
    </div>
</nav>
<!--Dark grey Large Header-->
<header id="header">
    <div class="container p-3 bg-dark text-white">
        <div class="row">
            <div class="col-sm-9 info">
                <h4><img src="img/user_small.svg"> Staff Management       
                </h4>
            </div>
            <div class="col-sm-3 info">
            </div>
        </div>
    </div>
</header>
<!--Light grey header-->
<div class="container">
<nav aria-label="breadcrumb">
    <ol class="breadcrumb blue-grey lighten-4">
      <li class="breadcrumb-item active"><a class="black-text">Staff Summary</a>
    </ol>
  </nav>
</div>
<!-- This screen contains Staff that are currently listed in the DB -->
<!-- Each Line is a Staff object, should include "edit" and "delete" buttons on each line -->
<section id="main">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="StaffMgmtUI.jsp" class="list-group-item active">Staff Summary</a>
                    <a href="AddStaffUI.jsp" class="list-group-item ">Add New Staff</a>
                </div>   
            </div>
            <div class="col-md-9">
                <div class="list-group">
                    <a href="#" class="list-group-item active">Current Staff</a>
                    <div class="list-group-item">
                        <div class="list-group">
                            <table class="table" id="staffListTable">
                                <tbody>
                                <tr>
                                    <th class="mobile" style="width: 100px; text-align: center">Job Title</th>
                                    <th>ID</th>
                                    <th class="mobile" style="width: 130px; text-align: center">Name</th>
                                    <th class="mobile" style="width: 150px; text-align: center">Phone</th>
                                    
                                    <!-- Commented out this data to test with data coming from database - Nathan -->
                                    <!-- <th class="mobile" style="width: 150px; text-align: center">Options</th>-->
                                    <!-- <tr>
                                    <td>PT Server</td>
                                    <td>9999</td>
                                    <td>Chris Lumsden</td>
                                    <td>4039992846</td>
                                    
                                    <td colspan="4">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editModal">
										  Edit
										</button>
                                    </td>
                                    <td colspan="4">
                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteModal">
										  Delete
										</button>
                                    </td>
                                    </tr>
                                    -->
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
<!-- Pop up Modals -->

<!-- Popup for the edit Staff screen, this modal has all editable areas filled in with selected staff object info -->
<div class="modal fade" id="editModal" tabindex="-1" aria-hidden="true" aria-labelledby="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Staff Info</h5>
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label>Job Title</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>PIN</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Contact Number</label>
                        <input type="text" class="form-control">
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" data-miss="modal">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- This is the delete popup this modal asks to confirm they want to remove the selected Staff object -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirm Staff Removal</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you Sure you would like to remove this person?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-dismiss="modal" data-target="#deleteConfirmModal">Yes</button>
      </div>
    </div>
  </div>
</div>
<!-- popup showing successful Staff removal -->
<div class="modal fade" id="deleteConfirmModal" tabindex="-1" aria-labelledby="deleteConfirmModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Staff Removed</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Wow they deleted. fo real!
      </div>
      <div class="modal-footers">
      	<div class="row">
        	<div class="col-sm-6 text-right">
        		<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
         	</div>
      	</div>
      </div>
    </div>
  </div>
</div>
<!--Popup for failure message, could pass through a few error messages to make this reactive and more clear on issue-->
<div class="modal fade" id="failModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">   
        <h4 class="modal-title" id="myModalLabel">Whoops!</h4>
      </div>
      <div class="modal-body">
        {Error} something has gone wrong!<br>
        Please try again!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- Footer -->
<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff;">
    Copyright &copy; 2020 Best Capstone Group
</footer>


<!-- Scripts -->
<script src="js/jquery.min.js"></script>

<script src="js/popper.min.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/mdb.min.js"></script>

</body>
</html>