<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="layout" content="main"/>
  <title>Order Placed</title>
  <link rel="stylesheet" href="${request.contextPath}/assets/style.css">

  <style>
  /* Center the box in the middle of the page */
  .success-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 70vh;
  }

  .success-box {
    background-color: #fff;
    border-radius: 10px;
    padding: 40px;
    max-width: 500px;
    text-align: center;
    box-shadow: 0 4px 12px rgba(0,0,0,0.2);
    font-family: Arial, sans-serif;
  }

  .success-box h1 {
    color: #4CAF50;
    margin-bottom: 20px;
  }

  .success-box p {
    margin-bottom: 30px;
    font-size: 18px;
  }

  .success-box a {
    text-decoration: none;
    background-color: #4CAF50;
    color: #fff;
    padding: 12px 25px;
    border-radius: 5px;
    transition: background-color 0.3s ease;
  }

  .success-box a:hover {
    background-color: #45a049;
  }
  </style>
</head>
<body>
<div class="success-container">
  <div class="success-box">
    <h1>Thank you!</h1>
    <p>Your order has been successfully placed.</p>
    <a href="/">Go back to home</a>
  </div>
</div>
</body>
</html>
