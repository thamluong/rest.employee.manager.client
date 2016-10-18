<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table border="1" class="table" style="name: detail-table">
	<tr>

		<td colspan="2" id="i2"
			style="width: 200px; height: 250px; background-color: #ffcc99; text-align: center; vertical-align: middle">
			<img src="../ListStaffs/resources/img/${staff.avatar}"
			alt="Updating ..."
			style="max-height: 100%; max-width: 100%; align: center" />
	</tr>
	<tr>
		<td>Company</td>
		<td align="center">${staff.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td align="center">${staff.name}</td>
	</tr>

	<tr>
		<td>Reference</td>
		<td align="center"><textarea
				style="text-align: justify; width: 100%;" disabled>${staff.info}</textarea></td>
	</tr>

</table>

<div class="button-modal"
	style="width: -50%; resize: none; align: right;'">
	<button type="button" class="btn btn-default" data-dismiss="modal"
		id="close-button">Close</button>
</div>

