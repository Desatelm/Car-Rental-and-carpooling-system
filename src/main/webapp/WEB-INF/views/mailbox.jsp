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
	<table
				class="table table-striped, table table-hover table table-condensed table-bordered">
				<tr>

					<th>Id</th>
					<th>From</th>
					<th>Message</th>					

				</tr>
				<c:forEach var="message" items="${messages}">

					<tr>
						<td>${message.messageId}</td>						
						<td>${message.senderEmail}</td>
						<td>${message.message}</td> 						
						
				</c:forEach>
			</table>
	</div>
</div>




<%@include file="/WEB-INF/views/template/footer.jsp"%>