$(function() {
	$('select').click(function(){
		var cid = $(".company").val();

		$('#table-div').load('staffs-acompany .table', 'id=' +$('.company').val(), function(){
			var table1 = $('#index-table').DataTable({
				"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
				"bDestroy": true,
				"drawCallback": function(){

					$('.detail').on("click", function () {
						//alert("Detail ok");
						var id = $(this).parents('tr').children('td').eq(1).text().trim();

						$(".modal-title").text("Information: ");
						$(".modal-body").load("detail.html .table", "id=" + id);
						$(".modal-footer").load("detail.html .button-modal", "id=" + id, function () {
							$('#close-button').on('click', function () {
								table1.$('tr.selected').removeClass('selected');
							}); }); });

					$('.delete').on('click', function(){

						var id = $(this).parents('tr').children('td').eq(1).text().trim();
						$(this).parents('tr').addClass("deleted");

						$.get("delete.html", "id=" + id, function () {
							table1.row('.deleted').remove().draw(false);
						}); });

					$('.index-add').on('click', function(){
						$('.add-div').load('search-service', function(){

							$('#ss-table-div').modal('show');

							$('.ss-add').click(function () {
								var checks = [];
								$.when($('input[name=checkbox]:checked').each(function() {

									var id = $(this).parents('tr').children('td').eq(1).text();
									checks.push(id);

								})).then(/*$('#ss-table-div').modal('hide')*/);

								window.open('add-service?checks='+checks, '_self');
							});	});	});
				}}); }); 
	});


	var table = $('#index-table').DataTable({
		"lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
		"bDestroy": true,
		"drawCallback": function () {

			$('.detail').on("click", function () {
				//alert("Detail ok");
				var id = $(this).parents('tr').children('td').eq(1).text().trim();

				$(".modal-title").text("Information: ");
				$(".modal-body").load("detail.html .table", "id=" + id);
				$(".modal-footer").load("detail.html .button-modal", "id=" + id, function () {
					$('#close-button').on('click', function () {
						table.$('tr.selected').removeClass('selected');
					}); }); });

			$('.delete').on('click', function(){

				var id = $(this).parents('tr').children('td').eq(1).text().trim();
				$(this).parents('tr').addClass("deleted");

				$.get("delete.html", "id=" + id, function () {
					table.row('.deleted').remove().draw(false);
				}); });

			$('.index-add').on('click', function(){
				$('.add-div').load('search-service', function(){

					$('#ss-table-div').modal('show');

					$("#form_select")/*.unbind('submit').bind('submit',*/.submit(function(event){
						//$("#form_select").submit(function(event){
						event.preventDefault();
						
						$('.table-div').load('search-service-search?department='+$('.department option:selected').text()
								+ "&position="+$('.position option:selected').text() + " .table", function(){
							//window.open("google.com.vn", "_self");
						}); });
					
					$('.ss-add').click(function () {	
						
						var checks = [];
						$.when($('input[name=checkbox]:checked').each(function() {

							var id = $(this).parents('tr').children('td').eq(1).text();
							checks.push(id);

						})).then(/*$('#ss-table-div').modal('hide')*/);

						window.open('add-service?checks='+checks, '_self');
					});	});	});
		}});
});

