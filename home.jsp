<%@ taglib uri="WEB-INF/MyCustomTags.tld" prefix="mytags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
	<title>
		Home JSP
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

	fieldset {
		border: 0;
	}
	label {
		display: block;
		margin: 30px 0 0 0;
	}
	select {
		width: 200px;
	}
	.overflow {
		height: 200px;
	}
	</style>

	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="js/dropdownchecklist.js"></script> 
	<script type="text/javascript">
	$(function() {
		$(function() {
			$( "#count" ).selectmenu();

			$( "#files" ).selectmenu();

			$( "#location" )
			.selectmenu()
			.selectmenu( "menuWidget" )
			.addClass( "overflow" );
			
		});
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
	</div>
	

	<mytags:locationsPrinter/>
	<div class="demo" align="center">

		<form action="getReport" method="POST">
			<fieldset>
				<label for="location">Select location</label>
				<select name="location" id="location">
					<option selected="selected">ALL</option>
					<c:forEach var="l" items="${locations}">
					<option><c:out value="${l}"/></option>
				</c:forEach>
			</select>

			<label for="count">Select no. of Rows</label>
			<select name="count" id="count">
				<option>ALL</option>
				<option selected="selected">10</option>
				<option>20</option>
				<option>50</option>
				<option>100</option>
				<option>500</option>
			</select>
			<br>
			<br/>
			<input name="filterButton" type="Submit" value="View Data"/>
		</fieldset>

	</form>

</div>
</div>
</html>
