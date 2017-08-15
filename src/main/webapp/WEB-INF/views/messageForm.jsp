<%@include file="/WEB-INF/views/template/secureheader.jsp"%>

<title>Mailbox</title>
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
		<h3>Message MailBox:</h3>
		<div class='container well col-md-8'>
           <form action="../addMessage" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-lg-3 control-label">Text:</label>
				<textarea class='form-control' name='message'
					 style="margin-bottom: 25px;" rows="6">	
			  </textarea>
			  
			  <input class="form-control" name = "recieverId" type="hidden" value = ${recieverId}>			
			  <input class="form-control" name = "email" type="hidden" value = ${email}>
			</div>			
			<label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <input type="submit" class="btn btn-primary" value="Send Message">
            </div>
          </form>
		</div>
	</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>