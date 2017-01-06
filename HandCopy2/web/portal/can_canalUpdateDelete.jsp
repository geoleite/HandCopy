<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="can_canalUpdateDeleteJB" class="br.com.easynet.portal.jb.Can_canalUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="can_canalUpdateDeleteJB" property="*"/>                                         
<jsp:setProperty name="can_canalUpdateDeleteJB" property="page" value="${pageContext}"/>                                         
${can_canalUpdateDeleteJB.execute}                                         
                                                                                 

<h3 align="center">Alterar ou Excluir Canal</h3>                                         

<form name="can_canal" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="can_canalUpdateDelete.jsp"/>
   <input type="hidden" name="can_canalT.can_nr_id" value="${can_canalUpdateDeleteJB.can_canalT.can_nr_id}"/>
    <div align="center">     
        
        <div align="center">     
        <label class="errorMessage">${can_canalUpdateDeleteJB.msg}</label>
        <table>
            <tr>
                <td  align="left">
                    <label>Nome:</label> 
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_nome" value="${can_canalUpdateDeleteJB.can_canalT.can_tx_nome}"/>                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Descricao:</label>        
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_descricao" value="${can_canalUpdateDeleteJB.can_canalT.can_tx_descricao}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Url:</label>        
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_url" value="${can_canalUpdateDeleteJB.can_canalT.can_tx_url}"/>  
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>        
                </td>
                <td align="left">
                Ativo:<input type="radio" name="can_canalT.can_tx_status" value="A" ${can_canalUpdateDeleteJB.can_canalT.can_tx_status=='A'?'checked':''} />
                             Inativo: <input type="radio" name="can_canalT.can_tx_status" value="I" ${can_canalUpdateDeleteJB.can_canalT.can_tx_status=='I'?'checked':''} />
                             
                             </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Border:</label>        
                </td>
                <td align="left">
                Sim:<input type="radio" name="can_canalT.can_tx_border" value="S" ${can_canalUpdateDeleteJB.can_canalT.can_tx_border=='S'?'checked':''} />        
                           Não:<input type="radio" name="can_canalT.can_tx_border" value="N" ${can_canalUpdateDeleteJB.can_canalT.can_tx_border=='N'?'checked':''} />        
                           </td>
            </tr>
            
            <tr>
                <td align="left">
                    <label>Estado:</label>        
                </td>
                <td align="left">
                Normal:<input type="radio" name="can_canalT.can_tx_estado" value="NOR" ${can_canalUpdateDeleteJB.can_canalT.can_tx_estado=='NOR'?'checked':''} /> 
                              Minimizado:<input type="radio" name="can_canalT.can_tx_estado" value="MIN" ${can_canalUpdateDeleteJB.can_canalT.can_tx_estado=='MIN'?'checked':''} /> 
                              Maximizado:<input type="radio" name="can_canalT.can_tx_estado" value="MAX" ${can_canalUpdateDeleteJB.can_canalT.can_tx_estado=='MAX'?'checked':''} /> 
                              Fechado:<input type="radio" name="can_canalT.can_tx_estado" value="CLO" ${can_canalUpdateDeleteJB.can_canalT.can_tx_estado=='CLO'?'checked':''} /> 
                              </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Iframe:</label>        
                </td>
                <td align="left">Sim:
                <input type="radio" name="can_canalT.can_tx_iframe" value="S" ${can_canalUpdateDeleteJB.can_canalT.can_tx_iframe=='S'?'checked':''} />
                       Não:
                       <input type="radio" name="can_canalT.can_tx_iframe" value="N" ${can_canalUpdateDeleteJB.can_canalT.can_tx_iframe=='N'?'checked':''}/>
                       </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Update"  onClick="setOpPortal('can_canal', 'update','can_canalUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('can_canal', 'delete','can_canalUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar" onClick="setOpPortal('can_canal', '','can_canalConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            
        </table>
    </div>     
    
</form>
