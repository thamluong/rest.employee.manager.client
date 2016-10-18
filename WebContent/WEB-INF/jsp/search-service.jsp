<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" charset="UTF-8"
	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<!-- <script type="text/javascript" charset="UTF-8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"> -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">

<!-- Modal -->
<div class="modal fade" id="ss-table-div" role="dialog">
	<div class="modal-dialog">
		Search modal
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">List staffs in server-side</h4>
			</div>
			<div class="modal-body" id='header_bar' align='center'>

				<br> <br>
				<form method="get" id="form_select">
					Department <select class="department">
						<option value="" selected>All</option>
						<c:forEach var="department" items="${departments}"
							varStatus="status">
							<option>${department}</option>
						</c:forEach>
						
					</select> Position <select class="position">
					<option value="" selected>All</option>
						<c:forEach var="position" items="${positions}" varStatus="status">
							<option>${position}</option>
						</c:forEach>

					</select> <input type="submit" value="Search" style="font-weight: bold;" />
				</form>

				<div id='table-div' class="table-div">
					<table id='ss-table' class='table'>
						<thead>
							<tr>
								<th></th>
								<th></th>
								<th style="display: none;">ID</th>
								<th>Department</th>
								<th>Staff</th>
								<th>Position</th>
							</tr>
						</thead>
						<tbody >
							<c:forEach var='staff' items='${staffs}' varStatus='status'>
								<tr>
									<td><input class="check" type="checkbox" name="checkbox"
										value="check"></td>
									<td>${status.index +1}</td>
									<td style="display: none;">${staff.id}</td>
									<td >${staff.department}</td>
									<td >${staff.name}</td>
									<td>${staff.position}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div class="modal-footer">
				<div style="float: right; width: 25%">
					<button class="ss-add btn btn-warning" type="submit" style="float: left;">Add</button>
				</div>
			</div>
		</div>
	</div>
</div>
