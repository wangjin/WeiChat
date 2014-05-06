$(function() {
	$(".foot_menu").click(function() {
		$(".foot_menu").removeClass("btn btn-primary");
		$(".foot_menu").addClass("btn btn-default");
		$(this).addClass("btn btn-primary");
	});
});