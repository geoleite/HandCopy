<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="sis_sistemaJB" class="br.com.easynet.easyportal.jb.Sis_sistemaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="sis_sistemaJB" property="*"/>                                         
<jsp:setProperty name="sis_sistemaJB" property="page" value="${pageContext}"/>                                         
${sis_sistemaJB.execute}                                    

<form name="sis_sistema" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="sis_sistemaUpdateDelete.jsp"/>
    <input type="hidden" name="sis_sistemaT.sis_nr_id" value="${sis_sistemaJB.sis_sistemaT.sis_nr_id}"/>
    <center>     
        <h3>Alterar Sistema</h3>
        <label class="errorMessage">${sis_sistemaJB.msg}</label><br/>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>
                </td>
                <td align="left">
                    <input type="text" name="sis_sistemaT.sis_tx_nome" value="${sis_sistemaJB.sis_sistemaT.sis_tx_nome}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Descricao:</label>
                </td>
                <td align="left">
                    <input type="text" name="sis_sistemaT.sis_tx_descricao" value="${sis_sistemaJB.sis_sistemaT.sis_tx_descricao}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>
                </td>
                <td align="left">
                    <select name="sis_sistemaT.sis_tx_status">
                        <option value="A" ${sis_sistemaJB.sis_sistemaT.sis_tx_status=='A'?'selected':' '}>Ativo</option>
                        <option value="I" ${sis_sistemaJB.sis_sistemaT.sis_tx_status=='I'?'selected':' '}>Inativo</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="button" value="Update"   onClick="setOpPortal('sis_sistema','update', 'sis_sistemaUpdateDelete.jsp')" />&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"   onClick="setOpPortal('sis_sistema','delete', 'sis_sistemaUpdateDelete.jsp')" />&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Consult"  onClick="setOpPortal('sis_sistema','', 'sis_sistemaConsult.jsp')" />&nbsp;&nbsp;&nbsp;
                </td>
                
            </tr>
        </table>
        
        
        
        
        
    </center>     
    
</form>
