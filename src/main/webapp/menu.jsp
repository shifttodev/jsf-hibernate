<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<jsp:include page="header.jsp" />

  <f:view>
    <h:form>
      <h:commandLink action="#{livros.novo}" value="Adicionar" styleClass="list-group-item list-group-item-action"/>
      <h:commandLink action="listar" value="Listar" styleClass="list-group-item list-group-item-action"/>
    </h:form>
  </f:view>

<jsp:include page="footer.jsp" />