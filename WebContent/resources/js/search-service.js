$(function(){
	
	$("#form_select")/*.unbind('submit')*/.bind('submit',function(event){
		//$("#form_select").submit(function(event){
		//event.preventDefault();
		
		$('.table_div').load('search-service-search?department='+$('.department option:selected').text()
				+ "&position="+$('.position option:selected').text() + " .table", function(){
			//window.open("google.com.vn", "_self");
		}); });
		
})