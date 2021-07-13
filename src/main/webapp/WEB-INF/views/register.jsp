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
      <h2>Załóż konto</h2>
      <form:form action="/signup" method="post" modelAttribute="userDto" >
        <div class="form-group">
          <form:input type="email" name="email" placeholder="Email" path="email"/>
        </div>
        <div class="form-group">
          <form:input type="password" name="password" placeholder="Hasło" path="password"/>
        </div>
        <div class="form-group">
          <form:input type="password" name="password2" placeholder="Powtórz hasło" path="matchingPassword"/>
        </div>

        <div class="form-group form-group--buttons">
          <a href="login.jsp" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>


    <%@include file="footer.jsp" %>

    <script src="<c:url value="resources/js/app.js"/>"></script>
  </body>
</html>

