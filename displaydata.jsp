<%@ taglib uri="WEB-INF/MyCustomTags.tld" prefix="mytags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
	<title>
		Display Data JSP
	</title>
	<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<style type="text/css">
	.progress-label {
		position: absolute;
		left: 50%;
		top: 4px;
		font-weight: bold;
		text-shadow: 1px 1px 0 #fff;
	}
	.paging-nav {
		text-align: center;
		padding-top: 2px;
	}

	.paging-nav a {
		margin: auto 1px;
		text-decoration: none;
		display: inline-block;
		padding: 1px 7px;
		background: #91b9e6;
		color: white;
		border-radius: 3px;
	}

	.paging-nav .selected-page {
		background: #187ed5;
		font-weight: bold;
	}

	.paging-nav,
	#tableData {
		width: auto;
		margin: 0 auto;
		font-family: Arial, sans-serif;
	}

	</style>

	<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="js/paging.js"></script> 
	<script type="text/javascript">
	$(document).ready(function() {
		$('#tableData').paging({limit:300});
	});
	</script>
	<script type="text/javascript">

	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-36251023-1']);
	_gaq.push(['_setDomainName', 'jqueryscript.net']);
	_gaq.push(['_trackPageview']);

	(function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	})();

	</script>
</head>
<body>
	<div align="center">
		<h1>Welcome to Reports.com</h1>
		<br>
	</div>
</div>
<div align="center">
Data for Location <h3><c:out value="${param.location}"/></h3>
Displyaing Top <c:out value="${param.count}"/> records
</div>
<div align="right">
<a href="home.jsp">Home</a>
</div>
<div name="table" id="tableDiv">
	<table id="tableData" class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Sr.No</th>
				<th>Id</th>
				<th>Division Name</th>
				<th>Location Code</th>
				<th>Location Name</th>
				<th>Connection Name</th>
				<th>Connection Address</th>
				<th>Arrears</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${connections}" varStatus="count">
			<tr>
				<td><c:out value="${count.index+1}"/></td>
				<td><c:out value="${c.id}"/></td>
				<td><c:out value="${c.divisionName}"/></td>
				<td><c:out value="${c.locationCode}"/></td>
				<td><c:out value="${c.locationName}"/></td>
				<td><c:out value="${c.connectionName}"/></td>
				<td><c:out value="${c.firstAddress}"/></td>
				<td><c:out value="${c.arrears}"/></td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</html>