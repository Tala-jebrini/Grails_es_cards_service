<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>

<h2>Your Cart</h2>

<table>
  <tr>
    <th>Product</th>
    <th>Qty</th>
    <th>Price</th>
    <th></th>
  </tr>

  <g:each in="${cart.items}" var="i">
    <tr>
      <td>${i.product.name}</td>
      <td>${i.quantity}</td>
      <td>$${i.product.price * i.quantity}</td>
      <td>
        <g:link action="remove" id="${i.id}">Remove</g:link>
      </td>
    </tr>
  </g:each>
</table>

<h3>Total: $${total}</h3>

<g:link controller="customerOrder" action="checkoutFromCart" class="btn">
  Checkout
</g:link>
