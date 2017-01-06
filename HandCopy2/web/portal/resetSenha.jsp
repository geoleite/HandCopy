<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="resetSenhaJB" class="br.com.easynet.easyportal.jb.ResetSenhaJB" scope="request"/>                                         
<jsp:setProperty name="resetSenhaJB" property="*"/>                                         
<jsp:setProperty name="resetSenhaJB" property="page" value="${pageContext}"/>                                         
${resetSenhaJB.execute}                                    

<form name="resetSenha" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="resetSenha.jsp"/>
    
    <center>     
        <label class="errorMessage">${resetSenhaJB.msg}</label><br/>
        
        <input type="hidden" name="usu_usuarioT.usu_nr_id" value="${resetSenhaJB.usu_usuarioT.usu_nr_id}"/>  <br/>
        <label>Nome:</label>${resetSenhaJB.usu_usuarioT.usu_tx_nome}  <br/>
        <label>Login:</label>${resetSenhaJB.usu_usuarioT.usu_tx_login}  <br/>
        <label>Status:</label>${resetSenhaJB.usu_usuarioT.usu_tx_status=='A'?'Ativo':'Inativo' }
        <br/>
        <label>Nova Senha:</label><input type="password" name="usu_usuarioT.usu_tx_senha"/><br/>
        <label>Conf. Nova Senha:</label><input type="password" name="confsenha"/><br/>
        <input type="button"  value="Salvar" onclick="setOpPortal('resetSenha', 'resetar', 'resetSenha.jsp')"/>
    </center>     
    
</form>

