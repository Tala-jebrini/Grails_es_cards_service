<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>

<asset:stylesheet src="login.css"/>

<section class="login-wrapper">
  <h2>Login</h2>

  <g:if test="${flash.error}">
    <div class="flash-error">${flash.error}</div>
  </g:if>

  <g:form controller="auth" action="login" method="post" class="login-form">
    <label for="email">Email</label>
    <input type="email" name="email" id="email" placeholder="Enter your email" required/>

    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="Enter your password" required/>

    <button type="submit" class="btn login-btn">Login</button>
  </g:form>

  <div class="signup-link">
    <span>Don't have an account?</span>
    <a href="/register" class="btn signup-btn">Sign Up</a>
  </div>
</section>
