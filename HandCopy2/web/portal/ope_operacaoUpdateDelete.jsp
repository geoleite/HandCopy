<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ope_operacaoJB" class="br.com.easynet.easyportal.jb.Ope_operacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="*"/>                                         
<jsp:setProperty name="ope_operacaoJB" property="page" value="${pageContext}"/>                                         
${ope_operacaoJB.execute}                                    
                                    
<form name="ope_operacao" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="ope_operacaoUpdateDelete.jsp"/>
    <input type="hidden" name="ope_operacaoT.ope_nr_id" value="${ope_operacaoJB.ope_operacaoT.ope_nr_id}"/>  <br/>
    <input type="hidden" name="ope_operacaoT.sis_nr_id" value="${ope_operacaoJB.ope_operacaoT.sis_nr_id}"/>  <br/>
    
    <center>     
        <h3 align="center">Altera Operacão</h3>
        <label class="errorMessage">${ope_operacaoJB.msg}</label><br/>
        <table>
            <tr>
                <td align="left">
                    <label>Sistema:</label>
                </td>
                <td align="left">
                    <label>${ope_operacaoJB.sis_sistemaT.sis_tx_nome}  </label>
                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Nome:</label>
                </td>
                <td align="left">
                    <input type="text" name="ope_operacaoT.ope_tx_nome" value="${ope_operacaoJB.ope_operacaoT.ope_tx_nome}"/> 
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>
                    
                    
                </td>
                <td align="left">
                    <select name="ope_operacaoT.ope_tx_status">
                        <option value="A" ${ope_operacaoJB.ope_operacaoT.ope_tx_status=='A'?'selected':'' }>Ativo</option>
                        <option value="I" ${ope_operacaoT.ope_tx_status.ope_operacaoT.ope_tx_status=='I'?'selected':'' }>Inativo</option>
                    </select>                                            
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Url:</label>
                    
                </td>
                <td align="left">
                    <input type="text" name="ope_operacaoT.ope_tx_url" value="${ope_operacaoJB.ope_operacaoT.ope_tx_url}"/> 
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Descrição:</label>       
                    
                </td>
                <td align="left">
                    <input type="text" name="ope_operacaoT.ope_tx_descricao" value="${ope_operacaoJB.ope_operacaoT.ope_tx_descricao}"/> 
                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Classe Método:</label>
                </td>
                <td align="left">
                    <input type="text" name="ope_operacaoT.ope_tx_classe" value="${ope_operacaoJB.ope_operacaoT.ope_tx_classe}"/>  <br/>
                    
                </td>
            </tr>
            <tr>
                <td align="left" colspan="2">
                    <input type="button" value="Update"  onClick="setOpPortal('ope_operacao','update', 'ope_operacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('ope_operacao','delete', 'ope_operacaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Consult" onClick="setOpPortal('ope_operacao','', 'ope_operacaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;                    
                </td>
            </tr>
        </table>
        
    </center>     
    
</form>                              