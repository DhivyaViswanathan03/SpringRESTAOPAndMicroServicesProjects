<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Page</title>
</head>
<h1>GET TOTAL COST</h1>
<body>
${msg}
<form method="get" action="getTotalCost">
<table>
<tr>
<td>CompanyName
</td>
<td>
<input type="text" name="companyName"/>
</td>
</tr>
<tr>
<td>Quantity
</td>
<td>
<input type="text" name="quantity"/>
</td>
</tr>
<tr>
<td></td>
<td>
<input type="Submit" value="GetCost"> 
</td>
</tr>
</table>
</form>
</body>
</html>