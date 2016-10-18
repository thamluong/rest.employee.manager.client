<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" charset="UTF-8"
	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link rel="shortcut icon" href="">
<script type="text/javascript"
	src="<c:url value="/resources/js/add-service.js" />"></script>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<div>
	<br> <br>
	<article
		style="text-align: center; color: green; font-size: 4em; font-weight: bold; font-family: Monospace">
		Added staffs</article>
	<br> <br>
</div>
<div class='as-table-div' style="width: 80%; margin: auto;">
	<table id="as-table" class='table' style="border: 1px">
		<thead>
			<tr style='text-weight: bold;'>
				<th></th>
				<th></th>
				<th style="display: none;">ID</th>
				<th>Department</th>
				<th>Staff</th>
				<th>Position</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var='staff' items='${staffs}' varStatus='status'>
				<tr>
					<td><input class="check" type="checkbox" name="checkbox2"
						value="check"></td>
					<td>${status.index +1}</td>
					<td class='id' style="display: none;">${staff.id}</td>
					<td>${staff.department}</td>
					<td data-toggle="modal" data-target="#myModal_1" class="detail"
						style='cursor: pointer;'
						title="click name here to view info staff">${staff.name}</td>
					<td>${staff.position}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br> <br>
	<div style="display: inline;">
		<a href="http://localhost:8080/rest.employee.manager.client/"
			style="color: #cc0066; pointer: cursor; font-weight: bold; text-decoration: underline;">Home</a>
		<div style="float: right; width: 40%;">
			<button class="add-and-update btn btn-success" type="button">Add
				to DB</button>
			<!-- <button class="add btn btn-success" type="button">Back</button> -->
		</div>
	</div>
</div>

<div class="add-div"></div>