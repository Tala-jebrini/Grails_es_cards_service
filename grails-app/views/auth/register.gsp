<%@ page contentType="text/html;charset=UTF-8" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="register.css"/>

<div class="auth-container">
  <h2>Sign Up</h2>

  <g:if test="${flash.error}">
    <div class="flash-error">${flash.error}</div>
  </g:if>

  <g:form controller="auth" action="doRegister">
    <div class="form-group">
      <label>Email</label>
      <input type="email" name="email" placeholder="Enter your email" required/>
    </div>

    <div class="form-group">
      <label>Username</label>
      <input type="text" name="username" placeholder="Enter your username" required/>
    </div>

    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" placeholder="Enter your password" required/>
    </div>

    <div class="form-group">
      <button type="submit" class="btn">Sign Up</button>
    </div>
  </g:form>

  <p class="auth-footer">
    Already have an account? <a href="${createLink(controller:'auth', action:'login')}">Login</a>
  </p>
</div>
