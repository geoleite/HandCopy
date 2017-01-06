<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="usuariosPerfilJB" class="br.com.easynet.easyportal.jb.UsuariosPerfilJB" scope="request"/>                                         
<jsp:setProperty name="usuariosPerfilJB" property="*"/>                                         
<jsp:setProperty name="usuariosPerfilJB" property="page" value="${pageContext}"/>                                         
${usuariosPerfilJB.execute}                                         
                                     


                                    
<form name="usuariosPerfil" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="usuariosPerfil.jsp"/>
    
    <center>     
        <label class="errorMessage" align="center">${usuariosPerfilJB.msg} </label>
        <br/>
    </center>     
    
    <center>
        <input type="hidden" name="per_perfilT.per_nr_id" value="${usuariosPerfilJB.per_perfilT.per_nr_id}"/>
        <label>Perfil:</label>${usuariosPerfilJB.per_perfilT.per_tx_nome}<br/>
        <table align="60%">
            <tr>
                <td align="center">
                    <select name="naoUsuarios" size="10" multiple>
                        <c:forEach items="${usuariosPerfilJB.usuariosNaoPerfil}" var="item">
                            <option value="${item.usu_nr_id}">${item.usu_tx_nome}-${item.usu_tx_login}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="center">
                    <input type="button"  value=">" onclick="setOpPortal('usuariosPerfil','adicionar', 'usuariosPerfil.jsp')"/><br/>
                    <input type="button"  value="<" onclick="setOpPortal('usuariosPerfil','remover', 'usuariosPerfil.jsp')"/><br/>
                </td>
                <td align="center">
                    <select name="usuarios" size="10" multiple>
                        <c:forEach items="${usuariosPerfilJB.usuariosPerfil}" var="item">
                            <option value="${item.usu_nr_id}">${item.usu_tx_nome}-${item.usu_tx_login}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="button" value="Voltar" onclick="setOpPortal('usuariosPerfil', '', 'per_perfilConsult.jsp')"/>           
                </td>
            </tr>
            
        </table>
    </center>	
</form>           
