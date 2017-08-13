<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

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
			
		    <div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">User Name:  ${user.name} </label>                         
            </div>
            
            <div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">First name: ${user.firstName}</label>           
	        </div>
	        
	        <div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">Last name:${user.lastName}</label>            
	        </div>
	        
		    <div class="form-group col-lg-6">  
		    <label class="col-lg-3 control-label">Email Address:${user.emailAddress}</label>
            </div>
            
            <div class="form-group col-lg-6">  
		    <label class="col-lg-3 control-label">CustomerType:${user.roles.role}</label>          
            </div> 
            
            <div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">Phone:${user.phone}</label>            
	        </div>
	        
			<div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">City:${user.address.city}</label>            
	        </div>
			
			<div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">State:${user.address.state}</label>            
	        </div>
			
			<div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">Country:${user.address.country}</label>
            </div>
	        
			<div class="form-group col-lg-6">
            <label class="col-lg-3 control-label">Zip Code:${user.address.zipcode}</label>
            </div>
	</div>
	</div>
   



<%@include file="/WEB-INF/views/template/footer.jsp"%>