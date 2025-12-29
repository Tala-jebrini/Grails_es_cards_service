<%@ page contentType="text/html;charset=UTF-8" %>

<meta name="layout" content="main"/>

<asset:stylesheet src="category-show.css"/>

<!-- CATEGORY HEADER -->
<section class="category-header">

<!-- ICON: parent icon if subcategory, otherwise own icon -->
  <g:if test="${category.parent}">
    <img class="category-main-icon"
         src="${assetPath(src: category.parent.iconPath)}"/>
    <h2>${category.parent.name} ${category.name}</h2>
  </g:if>

  <g:else>
    <img class="category-main-icon"
         src="${assetPath(src: category.iconPath)}"/>
    <h2>${category.name}</h2>
  </g:else>

</section>

<!-- SUBCATEGORIES -->
<g:if test="${subCategories}">
  <section class="subcategories-wrapper">
    <g:each in="${subCategories}" var="sub">

      <a href="${createLink(controller:'category', action:'show', id: sub.id)}"
         class="subcategory-item">

        <!-- SAME ICON AS PARENT -->
        <img class="subcategory-icon"
             src="${assetPath(src: category.iconPath)}"/>

        <!-- NAME FORMAT -->
        <div class="subcategory-name">
          ${category.name} ${sub.name}
        </div>

      </a>

    </g:each>
  </section>
</g:if>
