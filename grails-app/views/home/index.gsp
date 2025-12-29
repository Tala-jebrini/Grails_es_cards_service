
<meta name="layout" content="main"/>

<asset:stylesheet src="home.css"/>


<section class="hero-banner swiper">
    <div class="swiper-wrapper">
        <g:each in="${banners}" var="b">
            <div class="swiper-slide">
                <asset:image src="${b.imagePath}" alt="${b.title}"/>
            </div>
        </g:each>
    </div>
    <div class="swiper-pagination"></div>
</section>

<section class="categories-banner">
    <div class="categories-wrapper">

        <g:each in="${categories}" var="c">
            <a href="${createLink(controller:'category', action:'show', id: c.id)}"
               class="category-slide">

                <img class="category-icon-img"
                     src="${assetPath(src: c.iconPath)}"
                     alt="${c.name}"/>

                <!-- TOOLTIP -->
                <div class="category-tooltip">
                    ${c.name}
                </div>

            </a>
        </g:each>

    </div>
</section>




<section class="special-offers">
    <g:each in="${offers}" var="o">
        <div class="offer-card">
            <img src="${resource(dir:'images', file:o.imagePath)}"/>
            <h4>${o.title}</h4>
            <p>${o.description}</p>
        </div>
    </g:each>
</section>

<script>
    // Hero banner
    new Swiper('.hero-banner', {
        loop: true,
        autoplay: { delay: 5000 },
        pagination: { el: '.swiper-pagination', clickable: true }
    });

    // Categories slider
    new Swiper('.categories-swiper', {
        slidesPerView: 5,
        spaceBetween: 20,
        centeredSlides: true,
        loop: true,
        autoplay: { delay: 3000 }
    });
</script>


