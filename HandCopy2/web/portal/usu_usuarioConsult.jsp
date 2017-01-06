<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="usu_usuarioJB" class="br.com.easynet.easyportal.jb.Usu_usuarioConsultJB" scope="request"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="*"/>                                         
<jsp:setProperty name="usu_usuarioJB" property="page" value="${pageContext}"/>                                         
${usu_usuarioJB.execute}                                         
                                     

<form name="usu_usuario" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="usu_usuarioConsult.jsp"/>
     
    <center>     
        <h3 align="center">Usuários</h3>
        <label class="errorMessage" align="center">${usu_usuarioJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('usu_usuario','', 'usu_usuarioInsert.jsp')"/>&nbsp;&nbsp;&nbsp;<br/>
    </center>     
    
    <center>	
        <label>Usuário:</label>
        <input name="texto" type="text" value="${usu_usuarioJB.texto}" title="Informa parte do nome ou login a ser pesquisado!"/>
        <label>Pesquisar Por:</label>
        <select name="tipo">
            <option value="N" ${usu_usuarioJB.tipo=='N'?'selected':''}>Nome</option>
            <option value="L" ${usu_usuarioJB.tipo=='L'?'selected':''}>Login</option>
        </select>
        <input type="button" value="Pesquisar" onClick="setOpPortal('usu_usuario','consult', 'usu_usuarioConsult.jsp' )"  title="Realiza a consulta baseado no critério definido!"/>
        <br/>
        <br/>
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${usu_usuarioJB.list}"  pagesize="50" >
            <display:column sortable="false" title="Nome">
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=usu_usuarioUpdateDelete.jsp&op=findbyid&usu_usuarioT.usu_nr_id=${item.usu_nr_id}&">
                    <c:out value="${item.usu_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Login" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=usu_usuarioUpdateDelete.jsp&op=findbyid&usu_usuarioT.usu_nr_id=${item.usu_nr_id}&">
                    <c:out value="${item.usu_tx_login}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status">
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=usu_usuarioUpdateDelete.jsp&op=findbyid&usu_usuarioT.usu_nr_id=${item.usu_nr_id}&">
                    <c:out value="${item.usu_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="">
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=resetSenha.jsp&op=findbyid&usu_usuarioT.usu_nr_id=${item.usu_nr_id}&">
                    Trocar Senha
                </a>
            </display:column>
            
            <display:column title="Apagar">
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=usu_usuarioConsult.jsp&op=delete&usu_usuarioT.usu_nr_id=${item.usu_nr_id}&">
                        <img border="0" src="../images/delete.png">
                    </a>
            </display:column>	
        </display:table>
    </center>	
    
</form>           
