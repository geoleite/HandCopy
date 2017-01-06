<!-- Gerado pelo EasyNet Generate JDragon -->
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<jsp:useBean id="principalPageJB" class="br.com.easynet.easyportal.jb.PrincipalPageJB" scope="request"/>                                         
<jsp:setProperty name="principalPageJB" property="*"/>                                         
<jsp:setProperty name="principalPageJB" property="page" value="${pageContext}"/>                                         
${principalPageJB.execute}                                         




    <center>
        <label class="errorMessage">${principalPageJB.msg}</label><br/>
            <c:set var="continuar" value="true"/>
        <c:forEach var="item" items="${principalPageJB.perfilUser}">
            <c:choose>
                <c:when test="${item.per_tx_nome=='Funcionarios EasyClin'}">
                    <jsp:include page="/easyclin/easyclin/ses_sessao/meucalendarioGeral.jsp" flush="true"/>
                </c:when>
                <c:when test="${item.per_tx_nome=='Secretaria EasyClin'}">
                    <jsp:include page="/easyclin/easyclin/ses_sessao/calendarioGeral.jsp" flush="true"/>
                </c:when>

                <c:otherwise>
                    <c:if test="${continuar}">
                        <h3>Bem vindo ao Portal</h3>
                     </c:if>
                     <c:set var="continuar" value="false"/>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </center>
           
