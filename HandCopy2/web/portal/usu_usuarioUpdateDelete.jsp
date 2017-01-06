<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="usu_usuarioJB" class="br.com.easynet.easyportal.jb.Usu_usuarioUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="*"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="page" value="${pageContext}"/>                                         
${usu_usuarioJB.execute}                                    

                                    
<form name="usu_usuario" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="usu_usuarioUpdateDelete.jsp"/>
    <input type="hidden" name="usu_usuarioT.usu_nr_id" value="${usu_usuarioJB.usu_usuarioT.usu_nr_id}"/>  <br/>
    
    <center>     
        <h3 align="center">Alterar Usuário</h3>
        <label class="errorMessage">${usu_usuarioJB.msg}</label><br/>
        
        <table align="center" border="0" >
            <tr>
                <td align="left">
                    <label>Nome:</label>
                </td>
                <td align="left">
                    <input type="text" name="usu_usuarioT.usu_tx_nome" value="${usu_usuarioJB.usu_usuarioT.usu_tx_nome}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Login:</label>
                </td>
                <td align="left">
                    <input type="text" name="usu_usuarioT.usu_tx_login" value="${usu_usuarioJB.usu_usuarioT.usu_tx_login}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Email:</label>
                </td>
                <td align="left">
                    <input type="text" name="usu_usuarioT.usu_tx_email" value="${usu_usuarioJB.usu_usuarioT.usu_tx_email}"/>
                </td>
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>
                </td>
                <td align="left">
                    <select name="usu_usuarioT.usu_tx_status">
                        <option value="A" ${usu_usuarioJB.usu_usuarioT.usu_tx_status=='A'?'selected':'' }>Ativo</option>
                        <option value="I" ${usu_usuarioJB.usu_usuarioT.usu_tx_status=='I'?'selected':'' }>Inativo</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="left" colspan="2">
                    <input type="button" value="Update"  onClick="setOpPortal('usu_usuario','update', 'usu_usuarioUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('usu_usuario','delete', 'usu_usuarioUpdateDelete.jsp')""/>&nbsp;&nbsp;&nbsp;
                           <input type="button" value="Consult" onClick="setOpPortal('usu_usuario','', 'usu_usuarioConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </center>     
    
</form>
