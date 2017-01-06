<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="can_canalInsertJB" class="br.com.easynet.portal.jb.Can_canalInsertJB" scope="request"/>                                         
<jsp:setProperty name="can_canalInsertJB" property="*"/>                                         
<jsp:setProperty name="can_canalInsertJB" property="page" value="${pageContext}"/>                                         
${can_canalInsertJB.execute}                                         

<h3 align="center">Cadastra Novo Canal</h3>
<form name="can_canal" action="portal.jsp" method="get"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="can_canalInsert.jsp"/>
    <div align="center">     
        <label class="errorMessage">${can_canalInsertJB.msg}</label><br/>
        <table>
            <tr>
                <td  align="left">
                    <label>Nome:</label> 
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_nome" value="${can_canalInsertJB.can_canalT.can_tx_nome}"/>                    
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Descricao:</label>        
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_descricao" value="${can_canalInsertJB.can_canalT.can_tx_descricao}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Url:</label>        
                </td>
                <td align="left">
                    <input type="text" name="can_canalT.can_tx_url" value="${can_canalInsertJB.can_canalT.can_tx_url}"/>  
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>        
                </td>
                <td align="left">
                Ativo:<input type="radio" name="can_canalT.can_tx_status" value="A" ${can_canalInsertJB.can_canalT.can_tx_status=='A'?'checked':''} />
                             Inativo: <input type="radio" name="can_canalT.can_tx_status" value="I" ${can_canalInsertJB.can_canalT.can_tx_status=='I'?'checked':''} />
                             
                             </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Border:</label>        
                </td>
                <td align="left">
                Sim:<input type="radio" name="can_canalT.can_tx_border" value="S" ${can_canalInsertJB.can_canalT.can_tx_border=='S'?'checked':''} />        
                           Não:<input type="radio" name="can_canalT.can_tx_border" value="N" ${can_canalInsertJB.can_canalT.can_tx_border=='N'?'checked':''} />        
                           </td>
            </tr>
            
            <tr>
                <td align="left">
                    <label>Estado:</label>        
                </td>
                <td align="left">
                Normal:<input type="radio" name="can_canalT.can_tx_estado" value="NOR" ${can_canalInsertJB.can_canalT.can_tx_estado=='NOR'?'checked':''} /> 
                              Minimizado:<input type="radio" name="can_canalT.can_tx_estado" value="MIN" ${can_canalInsertJB.can_canalT.can_tx_estado=='MIN'?'checked':''} /> 
                              Maximizado:<input type="radio" name="can_canalT.can_tx_estado" value="MAX" ${can_canalInsertJB.can_canalT.can_tx_estado=='MAX'?'checked':''} /> 
                              Fechado:<input type="radio" name="can_canalT.can_tx_estado" value="CLO" ${can_canalInsertJB.can_canalT.can_tx_estado=='CLO'?'checked':''} /> 
                              </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Iframe:</label>        
                </td>
                <td align="left">Sim:
                <input type="radio" name="can_canalT.can_tx_iframe" value="S" ${can_canalInsertJB.can_canalT.can_tx_iframe=='S'?'checked':''} />
                       Não:
                       <input type="radio" name="can_canalT.can_tx_iframe" value="N" ${can_canalInsertJB.can_canalT.can_tx_iframe=='N'?'checked':''}/>
                       </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Insert"  onClick="setOpPortal('can_canal', 'insert','can_canalInsert.jsp')" /> &nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('can_canal','', 'can_canalConsult.jsp')" />
                </td>
            </tr>
            
        </table>
    </div>     
    
    
</form>
