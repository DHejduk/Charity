<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="head.jsp" %>
  <body>
    <header>
      <nav class="container container--70">
        <ul class="nav--actions">
          <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
          <li><a href="/signup" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
          <li><a href="/donate" class="btn btn--without-border active">Start</a></li>
          <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
          <li><a href="#" class="btn btn--without-border">O nas</a></li>
          <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
          <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
      </nav>

    </header>

    <section class="login-page">
      <h2>Zaloguj się</h2>
      <form:form modelAttribute="userLogin" action="/login" method="post">
        <div class="form-group">
          <form:input path="email" type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
          <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
          <a href="#" class="btn btn--without-border">Załóż konto</a>      
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form:form>
    </section>


    <%@include file="footer.jsp" %>

    <script src="<c:url value="resources/js/app.js"/>"></script>
  </body>
</html>
