<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="category-show.css"/>

<!-- =========================
     CATEGORY HEADER
========================= -->
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

<!-- =========================
     SUBCATEGORIES
========================= -->
<g:if test="${subCategories}">
  <section class="subcategories-wrapper">
    <g:each in="${subCategories}" var="sub">
      <a href="${createLink(controller:'category', action:'show', id: sub.id)}"
         class="subcategory-item">
        <img class="subcategory-icon" src="${assetPath(src: sub.iconPath ?: category.iconPath)}"/>
        <div class="subcategory-name">${sub.name}</div>
      </a>
    </g:each>
  </section>
</g:if>

<!-- =========================
     PRODUCTS + ORDER PANEL
========================= -->
<g:if test="${products}">
  <div class="products-order-container">

    <!-- LEFT: PRODUCTS -->
    <section class="products-wrapper">
      <g:each in="${products}" var="p">
        <div class="product-card"
             data-product-id="${p.id}"
             data-price="${p.price}">
          <h4>${p.name}</h4>
          <p>$${p.price}</p>
        </div>
      </g:each>
    </section>

    <!-- RIGHT: ORDER PANEL -->
    <section class="order-panel">

      <g:form controller="customerOrder" action="placeOrder">

        <!-- hidden selected product -->
        <input type="hidden" name="productId" id="productId"/>

        <!-- Selected product -->
        <div class="order-info-box">
          <h3>Selected Product</h3>
          <p id="selected-product">None</p>
        </div>

        <!-- Quantity -->
        <div class="quantity-box">
          <h3>Quantity</h3>
          <div class="quantity-controls">
            <button type="button" id="decrease">-</button>
            <input type="number" name="quantity" id="quantity" value="1" min="1"/>
            <button type="button" id="increase">+</button>
          </div>
        </div>

        <!-- Order Options (HYBRID) -->
        <div class="order-options">
          <h3>Order Information</h3>

          <g:each in="${orderOptions}" var="opt">
            <div class="order-option">

              <label>
                ${opt.label}
                <g:if test="${opt.required}">
                  <span class="required">*</span>
                </g:if>
              </label>

              <input
                      type="${opt.type}"
                      name="order_${opt.optionKey}"
                      placeholder="${opt.placeholder}"
                      <g:if test="${opt.required}">required</g:if>
              />
            </div>
          </g:each>
        </div>

        <!-- Final -->
        <div class="final-order-box">
          <p id="order-total">Total: $0.00</p>

          <g:if test="${session.user}">
            <button type="submit">Place Order</button>
          </g:if>
          <g:else>
            <a href="${createLink(controller:'auth', action:'login')}" class="btn">
              Login to Order
            </a>
          </g:else>


        </div>

      </g:form>

    </section>

  </div>
</g:if>

<!-- =========================
     JS
========================= -->
<script>
  let selectedProduct = null

  const productCards = document.querySelectorAll('.product-card')
  const selectedProductElem = document.getElementById('selected-product')
  const quantityInput = document.getElementById('quantity')
  const orderTotal = document.getElementById('order-total')
  const hiddenProductId = document.getElementById('productId')

  function updateTotal() {
    if (selectedProduct) {
      const price = parseFloat(selectedProduct.dataset.price)
      const qty = parseInt(quantityInput.value)
      orderTotal.textContent = "Total: $" + (price * qty).toFixed(2)
    }
  }

  // Product selection
  productCards.forEach(card => {
    card.addEventListener('click', () => {

      productCards.forEach(c => c.classList.remove('selected'))
      card.classList.add('selected')

      selectedProduct = card
      selectedProductElem.textContent = card.querySelector('h4').textContent
      hiddenProductId.value = card.dataset.productId

      updateTotal()
    })
  })

  // Quantity controls
  document.getElementById('increase').addEventListener('click', () => {
    quantityInput.value = parseInt(quantityInput.value) + 1
    updateTotal()
  })

  document.getElementById('decrease').addEventListener('click', () => {
    if (quantityInput.value > 1) {
      quantityInput.value = parseInt(quantityInput.value) - 1
      updateTotal()
    }
  })

  quantityInput.addEventListener('input', updateTotal)
</script>
