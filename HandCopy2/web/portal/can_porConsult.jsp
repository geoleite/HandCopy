<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="can_porJB" class="br.com.easynet.portal.jb.Can_porConsultJB" scope="request"/>                                         
<jsp:setProperty name="can_porJB" property="*"/>                                         
<jsp:setProperty name="can_porJB" property="page" value="${pageContext}"/>                                         
${can_porJB.execute}                                         
                                          

<form name="can_por" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="can_porConsult.jsp"/>
    <input type="hidden" name="por_portalT.por_nr_id" value="${can_porJB.por_portalT.por_nr_id}"/>
    
    <div align="center">    
        <h3>Insere ou Remove um Canal do Portal</h3>
        <label class="errorMessage" align="center">${can_porJB.msg} </label>
        <h3>Dados do Portal</h3>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>                    
                </td>
                <td align="left">
                    ${can_porJB.por_portalT.por_tx_nome}
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>            
                </td>
                <td align="left">
                    ${can_porJB.por_portalT.por_tx_status=='A'?'Ativo':'Inativo'}
                </td>
            </tr>
        </table>             
        <h3>Canais</h3>
        <table>
            <tr>
                <td align="left">
                    Não selecionado:<br/>
                    <select name="can_porT.can_nr_id" size="10">
                        <c:forEach var="item" items="${can_porJB.listNoCanal}">
                            <option value="${item.can_nr_id}">${item.can_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
                <td width="20px" align="center" valign="middle">
                    <input type="button" value="  >  " onClick="setOpPortal('can_por', 'add', 'can_porConsult.jsp')"/><br/><br/>
                    <input type="button" value="  <  " onClick="setOpPortal('can_por', 'rem', 'can_porConsult.jsp')"/><br/><br/>
                </td>
                <td align="right">
                    Selecionado:<br/>
                    <select name="can_porT.can_nr_id" size="10">
                        <c:forEach var="item" items="${can_porJB.listCanal}">
                            <option value="${item.can_nr_id}">${item.can_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="button" value="Voltar" onclick="setOpPortal('can_por', '','por_portalConsult.jsp')"/>
                </td>
            </tr>
            
        </table>
    </div>	
    
</form>
