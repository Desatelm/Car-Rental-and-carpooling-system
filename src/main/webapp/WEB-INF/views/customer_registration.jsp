<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<title>sign up</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
 
    <div class='container'>
    <h3>Customer Registration:</h3>
    <div class='container well col-md-8'>
	<form action="../signUp" method="post" class="form-horizontal">
		
		   <div class="form-group">
            <label class="col-lg-3 control-label">User Name:</label>
            <div class="col-lg-6">
              <input class="form-control" name = "name" type="text" >
            </div></div>
            
          <div class="form-group">
            <label class="col-lg-3 control-label">First name:</label>
            <div class="col-lg-6">
              <input class="form-control" name = "firstName" type="text" >
            </div>
	        </div>
	        
	        <div class="form-group">
            <label class="col-lg-3 control-label">Last name:</label>
            <div class="col-lg-6">
              <input class="form-control" name = "lastName" type="text" >
            </div>
	        </div>
	        
		    <div class="form-group">  
		    <label class="col-lg-3 control-label">Email Address:</label>          
            <div class="col-lg-6">
              <input class="form-control" type="text" name="emailAddress">
            </div>
            <div class="form-group">
								<select name="role">
									<option value="RIDER">RIDER</option>
									<option value="DRIVER">DRIVER</option>									
								</select>
							</div>
	        </div>	
	        <div class="form-group">  
		    <label class="col-lg-3 control-label">Password:</label>          
            <div class="col-lg-6">
              <input class="form-control" type="password" name="password">
            </div>
	        </div>			
           
           <div class="form-group">
            <label class="col-lg-3 control-label">Phone:</label>
            <div class="col-lg-6">
              <input class="form-control" type="text" name="phone" >
            </div>
	        </div>
			<div class="form-group">
            <label class="col-lg-3 control-label">City:</label>
            <div class="col-lg-6">
              <input class="form-control" type="text" name="city" >
            </div>
	        </div>
			
			<div class="form-group">
            <label class="col-lg-3 control-label">State:</label>
            <div class="col-lg-6">
              <input class="form-control" type="text" name="state" >
            </div>
	        </div>
			
			<div class="form-group">
            <label class="col-lg-3 control-label">Country:</label>
            <div class="col-lg-6">
              <input class="form-control" type="text" name="country" >
            </div>
	        </div>
	        
			<div class="form-group">
            <label class="col-lg-3 control-label">Zip Code:</label>
            <div class="col-lg-6">
              <input class="form-control" type="text" name="zipcode" >
            </div>
	        </div>
			<div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Create Account">
              </div>
            </div>
	</form>
	</div>
</div>




<%@include file="/WEB-INF/views/template/footer.jsp"%>