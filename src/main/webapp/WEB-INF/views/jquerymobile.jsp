<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.0/jquery.mobile-1.4.0.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.0/jquery.mobile-1.4.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(function() {
		/* $('#href2').click(function() {
			alert('adasdas');
		}); */
	});
</script>
<title>1</title>
</head>
<body>
	<div data-role="page" id="p1">
		<div data-role="header" data-position="fixed">
			<h3>jQuery mobile 测试</h3>
		</div>
		<div data-role="content">
			<p>欢迎！</p>
			<a href="#p5" data-rel="dialog">弹窗</a>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-grid="c">
				<ul>
					<li><a href="#p1" class="ui-btn-active">One</a></li>
					<li><a href="#p2">Two</a></li>
					<li><a href="#p3">Three</a></li>
					<li><a href="#p4">Four</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
	</div>

	<div data-role="page" id="p2">
		<div data-role="header">
			<h6>页面二</h6>
		</div>
		<div data-role="content">
			<a href="#p1" id="href2">转到页面一</a> <select name="select-choice-a"
				id="select-choice-a" data-native-menu="false">
				<option>Custom menu example</option>
				<option value="standard">Standard: 7 day</option>
				<option value="rush">Rush: 3 days</option>
				<option value="express">Express: next day</option>
				<option value="overnight">Overnight</option>
			</select>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-grid="c">
				<ul>
					<li><a href="#p1">One</a></li>
					<li><a href="#p2" class="ui-btn-active">Two</a></li>
					<li><a href="#p3">Three</a></li>
					<li><a href="#p4">Four</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>

	</div>

	<div data-role="page" id="p3">
		<div data-role="header">
			<h6>页面三</h6>
		</div>
		<div data-role="content">

			<h2>Use inset listview for tabs</h2>
			<div data-role="tabs">
				<ul data-role="listview" data-inset="true" class="tablist-left">
					<li><a href="#one" data-ajax="false">one</a></li>
					<li><a href="#two" data-ajax="false">two</a></li>
					<li><a href="ajax-content.html" data-ajax="false">three</a></li>
				</ul>
				<div id="one" class="ui-body-d tablist-content">
					<h1>First tab contents</h1>
				</div>
				<ul id="two" class="tablist-content" data-role="listview"
					data-inset="true">
					<li><a href="#">Acura</a></li>
					<li><a href="#">Audi</a></li>
					<li><a href="#">BMW</a></li>
					<li><a href="#">Cadillac</a></li>
					<li><a href="#">Ferrari</a></li>
				</ul>

				<button class="show-page-loading-msg" data-textonly="false"
					data-textvisible="false" data-msgtext="" data-inline="true">Icon
					(default)</button>
				<button class="show-page-loading-msg" data-textonly="false"
					data-textvisible="true" data-msgtext="" data-inline="true">Icon
					+ text</button>
				<button class="show-page-loading-msg" data-textonly="true"
					data-textvisible="true" data-msgtext="Text only loader"
					data-inline="true">Text only</button>
				<button class="hide-page-loading-msg" data-inline="true"
					data-icon="delete">Hide</button>
			</div>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-grid="c">
				<ul>
					<li><a href="#p1">One</a></li>
					<li><a href="#p2">Two</a></li>
					<li><a href="#p3" class="ui-btn-active">Three</a></li>
					<li><a href="#p4">Four</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
	</div>

	<div data-role="page" id="p4">
		<div data-role="header">
			<h6>页面四</h6>
		</div>
		<div data-role="content">

			<form>
				<label for="slider-2">Slider (default is "false"):</label> <input
					type="range" name="slider-2" id="slider-2" data-highlight="true"
					min="0" max="100" value="50">
			</form>

			<form>
				<label for="flip-3">Flip toggle switch:</label> <select
					name="flip-3" id="flip-3" data-role="slider" data-mini="true">
					<option value="off">Off</option>
					<option value="on">On</option>
				</select>
			</form>
			<form>
     <label for="search-1">Search:</label>
     <input type="search" name="search-1" id="search-1" value="">
</form>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" data-grid="c">
				<ul>
					<li><a href="#p1">One</a></li>
					<li><a href="#p2">Two</a></li>
					<li><a href="#p3">Three</a></li>
					<li><a href="#p4" class="ui-btn-active">Four</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
	</div>

	<div data-role="page" id="p5">
		<div data-role="header">
			<h6>页面二</h6>
		</div>
		<div data-role="content">
			<a href="#p1" id="href2">转到页面一</a> <select name="select-choice-a"
				id="select-choice-a" data-native-menu="false">
				<option>Custom menu example</option>
				<option value="standard">Standard: 7 day</option>
				<option value="rush">Rush: 3 days</option>
				<option value="express">Express: next day</option>
				<option value="overnight">Overnight</option>
			</select>
		</div>
	</div>


</body>
</html>