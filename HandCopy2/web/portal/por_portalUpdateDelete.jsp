<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="por_portalJB" class="br.com.easynet.portal.jb.Por_portalUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="por_portalJB" property="*"/>                                         
<jsp:setProperty name="por_portalJB" property="page" value="${pageContext}"/>                                         
${por_portalJB.execute}                                         
                                          

    <h3>Altera ou Excluir Portal</h3>

<form name="por_portal" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="por_portalUpdateDelete.jsp"/>
    <input type="hidden" name="por_portalT.por_nr_id" value="${por_portalJB.por_portalT.por_nr_id}"/>  <br/>    
    <center>     
     	<label class="errorMessage">${por_portalJB.msg}</label><br/>

    
    <div align="center">     
        <label class="errorMessage">${por_portalInsertJB.msg}</label>
        <table>
            <tr>
                <td>
                    <label>Nome:</label>
                    
                </td>
                <td>
                    <input type="text" name="por_portalT.por_tx_nome" value="${por_portalJB.por_portalT.por_tx_nome}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Status:</label>            
                </td>
                <td>
                Ativo:<input type="radio" name="por_portalT.por_tx_status" value="A" ${por_portalJB.por_portalT.por_tx_status=='A'?'checked':''} />
                             Inativo:<input type="radio" name="por_portalT.por_tx_status" value="I" ${por_portalJB.por_portalT.por_tx_status=='I'?'checked':''} />
                             </td>
            </tr>
            <tr>
                <td>
                    <label>Nr de Colunas:</label>             
                </td>
                <td>
                    <select name="por_portalT.por_nr_colunas">
                        <option value="1" ${por_portalJB.por_portalT.por_nr_colunas==1?'selected':''}>Uma</option>
                        <option value="2" ${por_portalJB.por_portalT.por_nr_colunas==2?'selected':''}>Duas</option>
                        <option value="3"  ${por_portalJB.por_portalT.por_nr_colunas==3?'selected':''}>Três</option>
                        <option value="4" ${por_portalJB.por_portalT.por_nr_colunas==4?'selected':''}>Quatro</option>
                        <option value="5"  ${por_portalJB.por_portalT.por_nr_colunas==5?'selected':''}>Cinco</option>
                        <option value="6"  ${por_portalJB.por_portalT.por_nr_colunas==6?'selected':''}>Seis</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="button" value="Update"  onClick="setOpPortal('por_portal','update', 'por_portalUpdateDelete.jsp')" /> &nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('por_portal','delete', 'por_portalUpdateDelete.jsp')" /> &nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('por_portal','', 'por_portalConsult.jsp')" />                    
                </td>
            </tr>
        </table>        
    </div>     
    
</form>
