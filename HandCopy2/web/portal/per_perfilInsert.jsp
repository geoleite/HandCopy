<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<jsp:useBean id="per_perfilJB" class="br.com.easynet.easyportal.jb.Per_perfilInsertJB" scope="request"/>                                         
<jsp:setProperty name="per_perfilJB" property="*"/>                                         
<jsp:setProperty name="per_perfilJB" property="page" value="${pageContext}"/>                                         
${per_perfilJB.execute}                                         
  
<form name="per_perfil" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="per_perfilInsert.jsp"/>
    <center>     
        <h3 align="center">Cadastro de Perfil</h3>
        <label class="errorMessage">${per_perfilJB.msg}</label><br/>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>
                </td>
                <td  align="left">
                    <input type="text" name="per_perfilT.per_tx_nome" value="${per_perfilJB.per_perfilT.per_tx_nome}"/>
                </td>    
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>            
                </td>
                <td align="left">
                    <select name="per_perfilT.per_tx_status">
                        <option value="A">Ativo</option>
                        <option value="I">Inativo</option>
                    </select>
                    
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="button" value="Insert"  onclick="setOpPortal('per_perfil','insert', 'per_perfilInsert.jsp')" /> &nbsp;&nbsp;&nbsp;
                    <input type="reset"  value="Clear" onclick="setOpPortal('per_perfil','clear', 'per_perfilInsert.jsp')"/>
                    <input type="button" value="Consult"  onclick="setOpPortal('per_perfil','', 'per_perfilConsult.jsp')" />
                    
                </td>
            </tr>
            
        </table>
        
        
    </center>     
</form>                                               
