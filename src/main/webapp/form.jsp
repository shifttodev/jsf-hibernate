<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<jsp:include page="header.jsp" />

  <f:view>
    <h:form id="inserir">
      <div class="form-group">
      <h:outputLabel for="isbn" value="ISBN"/>
        <h:inputText id="isbn" value="#{livros.livro.isbn}" styleClass="form-control" required="true">
        <f:validator validatorId="validadorISBN"/>
        <f:validateLength minimum="13" maximum="13"/>
      </h:inputText>
      <h:message for="isbn"  styleClass="form-text text-muted alert alert-warning"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="titulo" value="TÍTULO"/>
      <h:inputText id="titulo" value="#{livros.livro.titulo}" styleClass="form-control" required="true"/>
      <h:message for="titulo"  styleClass="form-text text-muted alert alert-warning"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="autor" value="AUTOR"/>
      <h:inputText id="autor" value="#{livros.livro.autor}" styleClass="form-control" required="true"/>
      <h:message for="autor"  styleClass="form-text text-muted alert alert-warning"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="ano" value="ANO"/>
        <h:inputText id="ano" value="#{livros.livro.ano}" styleClass="form-control"
                     required="true"
                     validator="#{livros.validarAno}">
          <f:validateLength minimum="4" maximum="4"/>
        </h:inputText>
        <h:message for="ano"  styleClass="form-text text-muted alert alert-warning"/>
      </div>
      <h:commandLink value="Inserir" action="#{livros.inserir}" styleClass="btn btn-primary mb-2 mr-3" />
      <h:commandLink value="Limpar" type="reset" styleClass="btn btn-primary mb-2"/>
    </h:form>
  </f:view>

<jsp:include page="footer.jsp" />