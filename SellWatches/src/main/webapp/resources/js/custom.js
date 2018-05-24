$(document).ready(function(){
	
	$('.btn-addtocart').click(function() {
		var productname = $("#data-productname").text();
		var imgproduct = $("#img-product").attr("data-img");
		var id = $("#data-productname").attr("data-id");
		var price = $(this).closest("div").find("h5").attr("data-price");
		var quantity = 1;
		$.ajax({
			url : "/SellWatches/Api/AddCart",
			type : "GET",
			data : {
				id: id,
				productName: productname,
				price: price,
				quantity: quantity,
				imgProduct: imgproduct
			},
			success:function(data){
				$('.quantityCart').text(data);
			}
		})
//		.done(function(){
//			$.ajax({
//				url : "/SellWatches/Api/TakeQuantityCart",
//				type : "GET",
//				success:function(data){
//					$('.quantityCart').text(data);
//				}
//			})
//		})
	});
	
	setTotalCart();
	
	function setTotalCart() {
		var totalcart = 0;
		$(".cart_Price").each(function(){
			var price = $(this).attr("data-price");
			var quantity = $(this).closest("ul").find(".idQuantity").val();
			
			totalcart = totalcart + price * quantity;
			
			var temp = addPeriod(totalcart);
			$(this).closest(".col-md-6").find(".txtPrice").text(temp +'₫');
		})
	}
	
	$(".idQuantity").change(function() {
		var quantity = $(this).val();
		var price = $(this).closest("ul").find(".cart_Price").attr("data-price");
		var totalMoney = price * quantity;
		var format = addPeriod(totalMoney);
		var id = $(this).closest("ul").find(".cart_Img").attr("data-id");
		
		$(this).closest("ul").find(".cart_Price").html('<span class="cost">' + format + ' VNĐ' + '</span>');
		setTotalCart();
		
		$.ajax({
			url : "/SellWatches/Api/UpdateCart",
			type : "GET",
			data : {
				id: id,
				quantity: quantity
			},
			success:function(data){
			}
		})
	})
	
	$(".delete_cart").click(function() {
		var self = $(this);
		var id = $(this).closest("ul").find(".cart_Img").attr("data-id");
		
		$.ajax({
			url : "/SellWatches/Api/DeleteCart",
			type : "GET",
			data : {
				id: id
			},
			success:function(data){
				self.closest("ul").remove();
				setTotalCart();
			}
		})
	})
});

function addPeriod(nStr)
{
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}