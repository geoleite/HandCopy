<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="usu_por_canJB" class="br.com.easynet.portal.jb.Usu_por_canConsultJB" scope="request"/>                                         
<jsp:setProperty name="usu_por_canJB" property="*"/>                                         
<jsp:setProperty name="usu_por_canJB" property="page" value="${pageContext}"/>                                         
${usu_por_canJB.execute}                                         
                                          

<h3>Cadastra e/ou Excluir Usuários no Portal</h3>                                         

<form name="usu_por_can" action="usu_por_canConsult.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="usu_por_canConsult.jsp"/>
    <input type="hidden" name="por_portalT.por_nr_id" value="${usu_por_canJB.por_portalT.por_nr_id}"/>
    <div align="center">     
        <label class="errorMessage" align="center">${usu_por_canJB.msg} </label>
        <h3>Dados do Portal</h3>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>                    
                </td>
                <td align="left">
                    ${usu_por_canJB.por_portalT.por_tx_nome}
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>            
                </td>
                <td align="left">
                    ${usu_por_canJB.por_portalT.por_tx_status=='A'?'Ativo':'Inativo'}
                </td>
            </tr>
        </table>             
        <h3>Usuários do Portal</h3>
        <input type="button" value="New" onClick="setOp('insert')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOp('consult')"/>&nbsp;&nbsp;&nbsp;
        
    </div>	
    
</form>
