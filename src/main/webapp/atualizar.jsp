<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<jsp:include page="header.jsp" />

  <f:view>
    <h:form id="inserir">
      <div class="form-group">
      <h:outputLabel for="isbn" value="ISBN"/>
      <h:inputText id="isbn" value="#{livros.livro.isbn}" styleClass="form-control" required="true"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="titulo" value="TÍTULO"/>
      <h:inputText id="titulo" value="#{livros.livro.titulo}" styleClass="form-control" required="true"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="autor" value="AUTOR"/>
      <h:inputText id="autor" value="#{livros.livro.autor}" styleClass="form-control" required="true"/>
      </div>
      <div class="form-group">
      <h:outputLabel for="ano" value="ANO"/>
      <h:inputText id="ano" value="#{livros.livro.ano}" styleClass="form-control" converterMessage="Insira somente números" required="true"/>
      </div>
      <h:commandLink value="Atualizar" action="#{livros.atualizar}" styleClass="btn btn-primary mb-2 mr-3" />
      <h:commandLink value="Limpar" type="reset" styleClass="btn btn-primary mb-2"/>
    </h:form>
  </f:view>

<jsp:include page="footer.jsp" />