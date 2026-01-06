<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><g:layoutTitle default="ES Cards"/></title>

    <!-- Global CSS -->
    <asset:stylesheet src="layout.css"/>

    <!-- Page-specific CSS -->
    <g:layoutHead/>

    <!-- Swiper (shared dependency) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
</head>
<body>

<!-- HEADER -->
<header class="header-top">
    <div class="header-left">
        <img src="${request.contextPath}/assets/logo/language.png" class="icon"/>
        <select>
            <option>English</option>
            <option>Arabic</option>
        </select>
        <img src="${request.contextPath}/assets/logo/announcement.png" class="icon"/>
    </div>

    <div class="header-right">
        <a href="/contact" class="btn">Contact Us</a>
    </div>
</header>

<!-- NAVBAR -->
<nav class="navbar">
    <div class="navbar-left">
        <img src="${request.contextPath}/assets/logo/logo.png" class="logo"/>
        <ul class="nav-links">
            <li><a href="/">Home</a></li>
            <li><a href="/categories">Categories</a></li>
            <li><a href="/faq">FAQ</a></li>
            <li><a href="/about">About</a></li>
            <li><a href="/services">Services</a></li>
            <li><a href="/blogs">Blogs</a></li>
        </ul>
    </div>

    <div class="navbar-right">
        <input class="search-box" placeholder="Search..."/>
        <g:link controller="auth" action="login" class="btn">Login</g:link>
        <g:link controller="auth" action="register" class="btn">Sign Up</g:link>
    </div>

</nav>

<!-- PAGE CONTENT -->
<g:layoutBody/>

<!-- FOOTER -->
<footer class="footer">
    <div class="footer-content">
        <p>&copy; 2025 ES Cards Service</p>
        <ul>
            <li><a href="/privacy">Privacy Policy</a></li>
            <li><a href="/terms">Terms of Service</a></li>
            <li><a href="/contact">Contact</a></li>
        </ul>
    </div>
</footer>

</body>
</html>
