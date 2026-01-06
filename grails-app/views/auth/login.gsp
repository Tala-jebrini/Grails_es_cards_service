<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="login.css"/>

<div class="auth-container">
  <h2>Login</h2>

  <g:if test="${flash.error}">
    <div class="flash-error">${flash.error}</div>
  </g:if>

  <g:form controller="auth" action="doLogin">
    <div class="form-group">
      <label>Email</label>
      <input type="email" name="email" placeholder="Enter your email" required/>
    </div>

    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" placeholder="Enter your password" required/>
    </div>

    <div class="form-group">
      <button type="submit" class="btn">Login</button>
    </div>
  </g:form>

  <p class="auth-footer">
    Don't have an account? <a href="${createLink(controller:'auth', action:'register')}">Sign Up</a>
  </p>
</div>
