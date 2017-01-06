<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="operacoesPerfilJB" class="br.com.easynet.easyportal.jb.OperacoesPerfil2JB" scope="request"/>                                         
<jsp:setProperty name="operacoesPerfilJB" property="*"/>                                         
<jsp:setProperty name="operacoesPerfilJB" property="page" value="${pageContext}"/>                                         
${operacoesPerfilJB.execute}                                         
                                     

<form name="operacoesPerfil" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="operacoesPerfil2.jsp"/>       
    <center>     
        <label class="errorMessage" align="center">${operacoesPerfilJB.msg} </label>
        <br/>
    </center>     
    
    <center>
        <input type="hidden" name="per_perfilT.per_nr_id" value="${operacoesPerfilJB.per_perfilT.per_nr_id}"/>
        <label>Perfil:</label>${operacoesPerfilJB.per_perfilT.per_tx_nome}<br/>
        <table align="60%">
            <tr>
                <td align="center" valign="top">
                    Sistemas:<br/>
                    <select name="sis_sistemaT.sis_nr_id" size="4" onchange="setOpPortal('operacoesPerfil','consultOperacoes', 'operacoesPerfil2.jsp')">
                        <c:forEach items="${operacoesPerfilJB.listSistema}" var="item">
                            <option value="${item.sis_nr_id}" title="${item.sis_tx_descricao}" ${item.sis_nr_id==operacoesPerfilJB.sis_sistemaT.sis_nr_id?'selected':''}>${item.sis_tx_nome}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <c:if test="${operacoesPerfilJB.existOperacoes}">
                        Classes<br/>
                        <select name="ope_operacaoT.ope_nr_id" size="8" onchange="setOpPortal('operacoesPerfil','consultMetodos', 'operacoesPerfil2.jsp')">
                            <c:forEach items="${operacoesPerfilJB.listOperacao}" var="item">
                                <option value="${item.ope_nr_id}" title="${item.ope_tx_classe}" ${item.ope_nr_id==operacoesPerfilJB.ope_operacaoT.ope_nr_id?'selected':''}>${item.ope_tx_nome}</option>
                            </c:forEach>
                        </select>
                        <br/>
                        <c:if test="${operacoesPerfilJB.existMetodos}">
                            <table>
                                <tr>
                                    <td align="center" valign="top">
                                        Métodos não adicionados:<br/>
                                        
                                        <select name="metodosRem" size="7" multiple >
                                        <c:forEach items="${operacoesPerfilJB.listMetodoNaoAdicionados}" var="item">
                                            <option value="${item.met_nr_id}" title="${item.met_tx_metodo} da classe ${ope_operacaoT.ope_tx_classe}.">${item.met_tx_metodo}</option>
                                        </c:forEach>
                                    </td>
                                    <td align="center" valign="middle">
                                        <input type="button" value="    >    " onclick="setOpPortal('operacoesPerfil','adicionar', 'operacoesPerfil2.jsp')"/><br/><br/>
                                        <input type="button" value="    <    " onclick="setOpPortal('operacoesPerfil','remover', 'operacoesPerfil2.jsp')"/>
                                    </td>
                                    <td align="center" valign="top">
                                        Métodos Adicionados<br/>
                                        <select name="metodosAdd" size="5"  multiple>
                                            <c:forEach items="${operacoesPerfilJB.listMetodoAdicionados}" var="item">
                                                <option value="${item.met_nr_id}" title="${item.met_tx_metodo} da classe ${ope_operacaoT.ope_tx_classe}.">${item.met_tx_metodo}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </c:if>
                    </c:if>
                    
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="button" value="Voltar" onclick="setOpPortal('operacoesPerfil', '', 'per_perfilConsult.jsp')"/>           
                </td>
            </tr>
            
        </table>
    </center>	
</form>           
