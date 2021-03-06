<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- login-register31:27-->
<head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Login Register || limupa - Digital Products Store eCommerce Bootstrap 4 Template</title>
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
                <%@include file='partials/header-top.jsp' %>
                <!-- Header Top Area End Here -->
                <!-- Begin Header Middle Area -->
                <%@include file='partials/header-middle.jsp' %>
                <!-- Header Middle Area End Here -->
                <!-- Begin Header Bottom Area -->
                <%@include file='partials/header-bottom.jsp' %>
                <!-- Header Bottom Area End Here -->
                <!-- Begin Mobile Menu Area -->
                <div class="mobile-menu-area d-lg-none d-xl-none col-12">
                    <div class="container"> 
                        <div class="row">
                            <div class="mobile-menu">
                            </div>
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
                            <li class="active">Login Register</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!-- Begin Login Content Area -->
            <div class="page-section mb-60">
                <div class="container">
                    <div class="row">
                        
                        <div class="col-sm-12 col-md-6 col-lg-6 col-xs-12">
                            <form method="post" action="login">
                                <div class="login-form">
                                    <h4 class="login-title">Register</h4>
                                    <div class="row">
                                        <div class="col-md-12 mb-20">
                                            <label>Email*</label>
                                            <input class="mb-0" type="email" name="email" value="<c:out value="${User.email}"/>" placeholder="Votre Email">
                                            <span class="erreur">${form.erreurs['email']}</span>
                                        </div>
                                        <div class="col-md-12 mb-20">
                                            <label>Mot de Passe*</label>
                                            <input class="mb-0" type="password" name="password" placeholder="votre mot de passe">
                                            <span class="erreur">${form.erreurs['password']}</span>
                                        </div>
                                        <div class="col-md-12">
                                            <button class="register-button mt-0">Login</button>
                                        </div>
                                        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Login Content Area End Here -->
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

<!-- login-register31:27-->
</html>
