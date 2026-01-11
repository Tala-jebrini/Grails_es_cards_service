<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>

<style>
.orders-wrapper {
  max-width: 1000px;
  margin: 40px auto;
  padding: 30px;
  color: #333; /* Make sure text is visible */
}

.order-card {
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 10px 40px rgba(0,0,0,0.08);
  padding: 25px;
  margin-bottom: 30px;
  color: #333; /* Force black text */
}

.order-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.order-header h1 {
  margin: 0;
  font-size: 1.6em;
  color: #2c3e50;
}

.order-header small {
  color: #555;
}

.order-items table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 15px;
  color: #333; /* Ensure table text is visible */
}

.order-items th, .order-items td {
  padding: 12px;
  border-bottom: 1px solid #eee;
  text-align: left;
  color: #333; /* Force table text black */
}

.order-items th {
  background: #f8f8f8;
  font-weight: 600;
}

.total-row td {
  font-weight: bold;
  font-size: 1.1em;
}

.actions {
  text-align: center;
  margin-top: 25px;
}

.btn-home {
  display: inline-block;
  margin: 5px;
  padding: 10px 24px;
  border-radius: 6px;
  text-decoration: none;
  color: white;
  background-color: #27ae60;
  transition: 0.2s;
}

.btn-home:hover {
  background-color: #1e8449;
}

.btn-orders {
  background-color: #2980b9;
}

.btn-orders:hover {
  background-color: #1c5980;
}
</style>

<div class="orders-wrapper">
  <div class="order-card">

    <div class="order-header">
      <div>
        <h1>Order Placed Successfully 🎉</h1>
        <small>
          Order #${order.id} &nbsp;|&nbsp;
          <g:formatDate date="${order.createdAt}" format="yyyy-MM-dd HH:mm"/>
        </small>
      </div>
      <div>
        Total: <strong>$${order.totalAmount}</strong>
      </div>
    </div>

    <div class="order-items">
      <table>
        <thead>
        <tr>
          <th>Product</th>
          <th>Qty</th>
          <th>Price</th>
          <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${order.items}" var="item">
          <tr>
            <td>${item.product.name}</td>
            <td>${item.quantity}</td>
            <td>$${item.priceAtPurchase}</td>
            <td>$${item.priceAtPurchase * item.quantity}</td>
          </tr>
        </g:each>
        <tr class="total-row">
          <td colspan="3">Total</td>
          <td>$${order.totalAmount}</td>
        </tr>
        </tbody>
      </table>
    </div>

    <div class="actions">
      <a href="${createLink(controller:'category', action:'show', id:1)}" class="btn-home">
        Continue Shopping
      </a>
      <a href="${createLink(controller:'customerOrder', action:'history')}" class="btn-home btn-orders">
        View My Orders
      </a>
    </div>

  </div>
</div>
