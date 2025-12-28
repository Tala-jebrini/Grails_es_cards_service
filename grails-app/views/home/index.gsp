<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ES Cards Homepage</title>
    <link rel="stylesheet" href="${resource(dir:'stylesheets', file:'home.css')}"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
</head>

<body>

<!-- Top Header Row -->
<header class="header-top">
    <div class="header-left">
        <img src="${request.contextPath}/assets/logo/language.png" alt="Language" class="icon"/>
        <select>
            <option value="en">English</option>
            <option value="fr">Arabic</option>
        </select>
        <img src="${request.contextPath}/assets/logo/announcement.png" alt="Announcements" class="icon"/>
    </div>

    <div class="header-right">
        <a href="/contact" class="btn contact-btn">Contact Us</a>
    </div>


</header>

<!-- Second Row: Navbar -->
<nav class="navbar">
    <div class="navbar-left">
        <img src="${request.contextPath}/assets/logo/logo.png" alt="Web Logo" class="logo"/>
        <ul class="nav-links">
            <li><a href="/">Home</a></li>
            <li><a href="/categories">Categories</a></li>
            <li><a href="/faq">FAQ</a></li>
            <li><a href="/about">About Us</a></li>
            <li><a href="/services">Our Services</a></li>
            <li><a href="/blogs">Blogs</a></li>
        </ul>
    </div>
    <div class="navbar-right">
        <input type="text" placeholder="Search..." class="search-box"/>
        <a href="/login" class="btn login-btn">Login</a>
        <a href="/register" class="btn signup-btn">Sign Up</a>
    </div>
</nav>

<!-- Hero Banner Slider -->
<section class="hero-banner swiper">
    <div class="swiper-wrapper">
        <g:each in="${banners}" var="banner">
            <div class="swiper-slide">
                <asset:image src="${banner.imagePath}" alt="${banner.title}"/>

            </div>
        </g:each>
    </div>

    <div class="swiper-pagination"></div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
</section>

<!-- Categories Carousel -->
<section class="categories-banner">
    <div class="categories-wrapper">
        <g:each in="${categories}" var="cat">
            <div class="category-icon">
                <asset:image src="${cat.iconPath}" alt="${cat.name}"/>
            </div>
        </g:each>
    </div>
</section>

<!-- Special Offers Section -->
<section class="special-offers">
    <g:each in="${offers}" var="offer">
        <div class="offer-card">
            <img src="${resource(dir:'images', file: offer.imagePath)}" alt="${offer.title}"/>
            <h4>${offer.title}</h4>
            <p>${offer.description}</p>
        </div>
    </g:each>
</section>

<!-- Footer -->
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

<script>
    var swiper = new Swiper('.hero-banner', {
        loop: true,
        autoplay: { delay: 5000 },
        pagination: { el: '.swiper-pagination', clickable: true },
        navigation: { nextEl: '.swiper-button-next', prevEl: '.swiper-button-prev' },
    });
</script>

</body>
</html>
