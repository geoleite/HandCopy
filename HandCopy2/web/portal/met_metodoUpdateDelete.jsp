<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="met_metodoJB" class="br.com.easynet.easyportal.jb.Met_metodoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="met_metodoJB" property="*"/>                                         
<jsp:setProperty name="met_metodoJB" property="page" value="${pageContext}"/>                                         
${met_metodoJB.execute}                                    
                                   
<form name="met_metodo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="met_metodoConsult.jsp"/>
    
    <center>     
        <h3 align="center">Altera Método</h3>
        <label class="errorMessage">${met_metodoJB.msg}</label>
        
        <input type="hidden" name="met_metodoT.sis_nr_id" value="${met_metodoJB.met_metodoT.sis_nr_id}"/> 
        <input type="hidden" name="met_metodoT.ope_nr_id" value="${met_metodoJB.met_metodoT.ope_nr_id}"/>  
        <input type="hidden" name="met_metodoT.met_nr_id" value="${met_metodoJB.met_metodoT.met_nr_id}"/>  
        <input type="hidden" name="ope_operacaoT.sis_nr_id" value="${met_metodoJB.sis_sistemaT.sis_nr_id}"/>
        <input type="hidden" name="ope_operacaoT.ope_nr_id" value="${met_metodoJB.ope_operacaoT.ope_nr_id}"/>
        
        <table align="center" cellpadding="10">
            <tr>
                <td align="left">
                    <label>Sistema:</label>
                </td>
                <td align="left">
                    <label>${met_metodoJB.sis_sistemaT.sis_tx_nome}</label>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Operação:</label>         
                    
                </td>
                <td align="left">
                    <label>${met_metodoJB.ope_operacaoT.ope_tx_nome}</label>
                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Classe:    </label>                           
                    
                </td>
                <td align="left">
                    <label>${met_metodoJB.ope_operacaoT.ope_tx_classe}</label>
                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Método:</label>
                </td>
                <td align="left">
                    <input type="text" name="met_metodoT.met_tx_metodo" value="${met_metodoJB.met_metodoT.met_tx_metodo}"/> 
                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>
                    
                </td>
                <td align="left">
                    <select name="met_metodoT.met_tx_status">
                        <option value="A" ${met_metodoJB.met_metodoT.met_tx_status=='A'?'selected':'' }>Ativo</option>
                        <option value="I" ${met_metodoJB.met_metodoT.met_tx_status=='I'?'selected':'' }>Inativo</option>
                    </select>                 
                    
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="button" value="Update"  onClick="setOpPortal('met_metodo','update', 'met_metodoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('met_metodo','delete', 'met_metodoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Consult" onClick="setOpPortal('met_metodo','', 'met_metodoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                    
                </td>
            </tr>
        </table>
        
    </center>     
    
</form>

