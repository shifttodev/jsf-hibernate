<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         language="java" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<jsp:include page="header.jsp" />
  <f:view>
    <h:messages/>
    <h:form>
      <h:dataTable value="#{livros.livros}" var="item" styleClass="table table-striped table-bordered ">
        <h:column>
          <f:facet name="header">
            <h:outputText value="ISBN"/>
          </f:facet>
          <h:commandLink action="#{livros.editar}" value="#{item.isbn}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="TÍTULO"/>
          </f:facet>
          <h:outputText value="#{item.titulo}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="AUTOR"/>
          </f:facet>
          <h:outputText value="#{item.isbn}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="ANO"/>
          </f:facet>
          <h:outputText value="#{item.ano}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="EXCLUIR"/>
          </f:facet>
          <h:commandLink action="#{livros.deletar}" value="Excluir"/>
        </h:column>
      </h:dataTable>
      <h:commandLink action="#{livros.novo}" value="Adicionar" styleClass="btn btn-primary" />
    </h:form>
  </f:view>

<jsp:include page="footer.jsp" />