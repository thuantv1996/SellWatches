function addDetail() {
	var nameProduct = $("#product").find(":selected").text();
	var idProduct = $("#product").find(":selected").val();
	var content = $("#content").val();
	var idPromotion = $("#idPromotion").val();
	var content_item = $("#content-table #"+idProduct +" #item-content");
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/SellWatches/admin/detail-promotion/add",
		data : {
			idPromotion : idPromotion,
			idProduct : idProduct,
			content:content,
		},
		success : function(data) {
			console.log("SUCCESS: ", data);
			if(data == "Add suscess")
			{
				var res = "<tr id ='"+idProduct+"'>" +
							"<td style='text-align:center'>"+
								idProduct+
							"</td>" +
							"<td style='text-align:center'>"+
								nameProduct+
							"</td>" +
							"<td style='text-align:center' id='item-content'>"+
								content+
							"</td>" +
							"<td style='text-align:center'>" +
								"<button type='button' style='background: red;' class='button-delete'>X</button>" +
							"</td>" +
						"</tr>";
				$("#content-table").html($("#content-table").html()+res);			
			}
			else
				if(data == "Upadte suscess")
				{
					console.log("Inner: ", content_item.html());
					content_item.html(content);
				}
			alert(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});	
}


$(".button-delete").click(function deleteDetail(obj) {
	var idPromotion = $("#idPromotion").val();
	var idProduct = $(this).closest("tr").attr("id");
	var tag = $(this).closest("tr");
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/SellWatches/admin/detail-promotion/delete",
		data : {
			idPromotion : idPromotion,
			idProduct : idProduct,
		},
		success : function(data) {
			tag.fadeOut('slow', function (c) {
				tag.remove();
            });
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	});	
})



