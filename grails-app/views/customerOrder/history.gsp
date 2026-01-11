<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>

<style>
/* =========================
   Wrapper
========================= */
.orders-wrapper {
  max-width: 1000px;
  margin: 40px auto;
  padding: 20px;
  font-family: Arial, sans-serif;
  color: #333;
}

/* =========================
   Page Title
========================= */
.orders-wrapper h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #2c3e50;
  font-size: 28px;
}

/* =========================
   Individual Order Card
========================= */
.order-card {
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 20px;
  margin-bottom: 25px;
  background-color: #fff;
  box-shadow: 0 4px 15px rgba(0,0,0,0.05);
  transition: 0.2s;
}

.order-card:hover {
  box-shadow: 0 6px 20px rgba(0,0,0,0.08);
}

/* =========================
   Order Header
========================= */
.order-header {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  margin-bottom: 15px;
}

.order-header div {
  margin-bottom: 8px;
}

.order-header strong {
  font-size: 18px;
}

/* =========================
   Table Styles
========================= */
.order-items table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 10px;
}

.order-items th, .order-items td {
  padding: 12px;
  border-bottom: 1px solid #eee;
  text-align: left;
  color: #333;
}

.order-items th {
  background-color: #f5f5f5;
  font-weight: bold;
}

.order-items tbody tr:hover {
  background-color: #fafafa;
}

/* =========================
   Total Row
========================= */
.total {
  text-align: right;
  font-weight: bold;
  margin-top: 10px;
  font-size: 16px;
  color: #2c3e50;
}

/* =========================
   No Orders Message
========================= */
.no-orders {
  text-align: center;
  font-size: 18px;
  color: #666;
  margin-top: 40px;
}

/* =========================
   Buttons
========================= */
.btn-home {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 25px;
  background-color: #3498db;
  color: white;
  text-decoration: none;
  border-radius: 5px;
  transition: 0.2s;
}

.btn-home:hover {
  background-color: #2980b9;
}
</style>

<div class="orders-wrapper">
  <h2>My Orders</h2>

  <g:if test="${!orders}">
    <p class="no-orders">You have not placed any orders yet.</p>
  </g:if>

  <g:each in="${orders}" var="order">
    <div class="order-card">
      <div class="order-header">
        <div>
          <strong>Order #${order.id}</strong><br>
          <small>
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
            <th>Quantity</th>
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
          </tbody>
        </table>
        <div class="total">
          Order Total: $${order.totalAmount}
        </div>
      </div>
    </div>
  </g:each>

  <div style="text-align: center;">
    <a href="${createLink(controller: 'category', action: 'show', id: 1)}" class="btn-home">Go back to Home</a>
  </div>
</div>
