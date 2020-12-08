<!doctype html>
<html class="no-js" lang="zxx">

<!-- shopping-cart31:32-->
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Shopping Cart || limupa - Digital Products Store
	eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- head-include begin  -->
        <%@include file='partials/head-includes.jsp' %>
        <!-- head-include end  -->
</head>
<body>
	<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<!-- Begin Body Wrapper -->
	<div class="body-wrapper">
		<!-- Begin Header Area -->
		<header>
			<!-- Begin Header Top Area -->
			<%@include file='partials/header-top.jsp'%>
			<!-- Header Top Area End Here -->
			<!-- Begin Header Middle Area -->
			<%@include file='partials/header-middle.jsp'%>
			<!-- Header Middle Area End Here -->
			<!-- Begin Header Bottom Area -->
			<%@include file='partials/header-bottom.jsp'%>
			<!-- Header Bottom Area End Here -->
			<!-- Begin Mobile Menu Area -->
			<div class="mobile-menu-area d-lg-none d-xl-none col-12">
				<div class="container">
					<div class="row">
						<div class="mobile-menu"></div>
					</div>
				</div>
			</div>
			<!-- Mobile Menu Area End Here -->
		</header>
		<!-- Header Area End Here -->
		<!-- Begin Li's Breadcrumb Area -->
		<div class="breadcrumb-area">
			<div class="container">
				<div class="breadcrumb-content">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li class="active">Shopping Cart</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!--Shopping Cart Area Strat-->
		<div class="Shopping-cart-area pt-60 pb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<form action="#">
							<div class="table-content table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th class="li-product-remove">remove</th>
											<th class="li-product-thumbnail">images</th>
											<th class="cart-product-name">Product</th>
											<th class="li-product-price">Unit Price</th>
											<th class="li-product-quantity">Quantity</th>
											<th class="li-product-subtotal">Total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="li-product-remove"><a href="#"><i
													class="fa fa-times"></i></a></td>
											<td class="li-product-thumbnail"><a href="#"><img
													src="images/product/small-size/5.jpg"
													alt="Li's Product Image"></a></td>
											<td class="li-product-name"><a href="#">Accusantium
													dolorem1</a></td>
											<td class="li-product-price"><span class="amount">$46.80</span></td>
											<td class="quantity"><label>Quantity</label>
												<div class="cart-plus-minus">
													<input class="cart-plus-minus-box" value="1" type="text">
													<div class="dec qtybutton">
														<i class="fa fa-angle-down"></i>
													</div>
													<div class="inc qtybutton">
														<i class="fa fa-angle-up"></i>
													</div>
												</div></td>
											<td class="product-subtotal"><span class="amount">$70.00</span></td>
										</tr>
										<tr>
											<td class="li-product-remove"><a href="#"><i
													class="fa fa-times"></i></a></td>
											<td class="li-product-thumbnail"><a href="#"><img
													src="images/product/small-size/6.jpg"
													alt="Li's Product Image"></a></td>
											<td class="li-product-name"><a href="#">Mug Today is
													a good day</a></td>
											<td class="li-product-price"><span class="amount">$71.80</span></td>
											<td class="quantity"><label>Quantity</label>
												<div class="cart-plus-minus">
													<input class="cart-plus-minus-box" value="1" type="text">
													<div class="dec qtybutton">
														<i class="fa fa-angle-down"></i>
													</div>
													<div class="inc qtybutton">
														<i class="fa fa-angle-up"></i>
													</div>
												</div></td>
											<td class="product-subtotal"><span class="amount">$60.50</span></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="row">
								<div class="col-12">
									<div class="coupon-all">
										<div class="coupon">
											<input id="coupon_code" class="input-text" name="coupon_code"
												value="" placeholder="Coupon code" type="text"> <input
												class="button" name="apply_coupon" value="Apply coupon"
												type="submit">
										</div>
										<div class="coupon2">
											<input class="button" name="update_cart" value="Update cart"
												type="submit">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-5 ml-auto">
									<div class="cart-page-total">
										<h2>Cart totals</h2>
										<ul>
											<li>Subtotal <span>$130.00</span></li>
											<li>Total <span>$130.00</span></li>
										</ul>
										<a href="#">Proceed to checkout</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!--Shopping Cart Area End-->
		<!-- Begin Footer Area -->
            <div class="footer">
                <!-- Begin Footer Static Top Area -->
                <%@include file='partials/footer-top.jsp' %>
                <!-- Footer Static Top Area End Here -->
                <!-- Begin Footer Static Middle Area -->
                <%@include file='partials/footer-middle.jsp' %>
                <!-- Footer Static Middle Area End Here -->
                <!-- Begin Footer Static Bottom Area -->
                <%@include file='partials/footer-bottom.jsp' %>
                <!-- Footer Static Bottom Area End Here -->
            </div>
            <!-- Footer Area End Here -->
        </div>
        <!-- Body Wrapper End Here -->
        <!--script-dependence begin  -->
        <%@include file='partials/script-dependances.jsp' %>
        <!-- script-dependence end  -->
</body>

<!-- shopping-cart31:32-->
</html>