<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="usu_usuarioJB" class="br.com.easynet.easyportal.jb.AlterarSenhaJB" scope="request"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="*"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="page" value="${pageContext}"/>                                         
${usu_usuarioJB.execute}                                    

                                    
<form name="alterarSenha" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="alterarSenha.jsp"/>
    
    <center>     
        <label class="errorMessage">${usu_usuarioJB.msg}</label><br/>
        
        <label>Senha Atual:</label><input type="password" name="senhaatual" />  <br/>
        <label>Nova Senha:</label><input type="password" name="novasenha" />  <br/>
        <label>Conf. Nova Senha:</label><input type="password" name="confnovasenha" />  <br/>
        <br/>
        <input type="button" value="Alterar" onClick="setOpPortal('alterarSenha','alterarSenha', 'alterarSenha.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="Cancel"  onClick="history.go(-1)" />
    </center>     
    
</form>
