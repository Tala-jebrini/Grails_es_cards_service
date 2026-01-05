<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="category-show.css"/>

<!-- CATEGORY HEADER -->
<section class="category-header">
  <g:if test="${category.parent}">
    <img class="category-main-icon" src="${assetPath(src: category.parent.iconPath)}"/>
    <h2>${category.parent.name} ${category.name}</h2>
    <p>${category.subDescription}</p>
  </g:if>
  <g:else>
    <img class="category-main-icon" src="${assetPath(src: category.iconPath)}"/>
    <h2>${category.name}</h2>
    <p>${category.subDescription}</p>
  </g:else>
</section>

<!-- SUBCATEGORIES -->
<g:if test="${subCategories}">
  <section class="subcategories-wrapper">
    <g:each in="${subCategories}" var="sub">
      <a href="${createLink(controller:'category', action:'show', id: sub.id)}"
         class="subcategory-item">
        <img class="subcategory-icon" src="${assetPath(src: category.iconPath)}"/>
        <div class="subcategory-name">${category.name} ${sub.name}</div>
      </a>
    </g:each>
  </section>
</g:if>

<!-- PRODUCTS + ORDER PANEL -->
<g:if test="${products}">
  <div class="products-order-container">

    <!-- LEFT: Products -->
    <section class="products-wrapper">
      <g:each in="${products}" var="p">
        <div class="product-card" data-product-id="${p.id}">
          <h4>${p.name}</h4>
          <p>$${p.price}</p>
        </div>
      </g:each>
    </section>

    <!-- RIGHT: Order Panel -->
    <section class="order-panel">
      <div class="order-info-box">
        <h3>Selected Product</h3>
        <p id="selected-product">None</p>
      </div>

      <div class="quantity-box">
        <h3>Quantity</h3>
        <div class="quantity-controls">
          <button type="button" id="decrease">-</button>
          <input type="number" id="quantity" value="1" min="1"/>
          <button type="button" id="increase">+</button>
        </div>
      </div>

      <div class="final-order-box">
        <h3>Order Info</h3>
        <p id="order-total">Total: $0.00</p>

        <g:if test="${session.user}">
          <button id="order-button">Place Order</button>
        </g:if>
        <g:else>
          <a href="/login" class="btn">Login to Order</a>
        </g:else>
      </div>
    </section>

  </div>
</g:if>

<!-- JS for selecting product and updating total -->
<script>
  let selectedProduct = null
  const productCards = document.querySelectorAll('.product-card')
  const selectedProductElem = document.getElementById('selected-product')
  const quantityInput = document.getElementById('quantity')
  const orderTotal = document.getElementById('order-total')

  function updateTotal() {
    if(selectedProduct){
      const price = parseFloat(selectedProduct.dataset.price)
      const qty = parseInt(quantityInput.value)
      orderTotal.textContent = "Total: $" + (price * qty).toFixed(2)
    }
  }

  productCards.forEach(card => {
    card.addEventListener('click', () => {
      // deselect all
      productCards.forEach(c => c.classList.remove('selected'))
      // select this one
      card.classList.add('selected')
      selectedProduct = card
      selectedProductElem.textContent = card.querySelector('h4').textContent
      updateTotal()
    })
    // store price as data attribute
    const price = parseFloat(card.querySelector('p').textContent.replace('$',''))
    card.dataset.price = price
  })

  document.getElementById('increase').addEventListener('click', () => {
    quantityInput.value = parseInt(quantityInput.value)+1
    updateTotal()
  })
  document.getElementById('decrease').addEventListener('click', () => {
    if(quantityInput.value > 1){
      quantityInput.value = parseInt(quantityInput.value)-1
      updateTotal()
    }
  })

  quantityInput.addEventListener('input', updateTotal)
</script>
