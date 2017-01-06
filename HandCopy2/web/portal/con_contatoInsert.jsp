<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_contatoJB" class="br.com.agenda.jb.Con_contatoInsertJB" scope="request"/>                                         
<jsp:setProperty name="con_contatoJB" property="*"/>                                         
<jsp:setProperty name="con_contatoJB" property="page" value="${pageContext}"/>                                         
${con_contatoJB.execute}                                         
                                                                               
	
<form name="con_contato" action="portal.jsp" method="post"  > enctype="multipart/form-data"
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="con_contatoConsult.jsp"/>
    <input type="hidden" name="urlCanal" value="con_contatoInsert.jsp"/>
    <center>     
     	<label class="errorMessage">${con_contatoJB.msg}</label><br/>

    <label>con_nr_id:</label><input type="text" name="con_contatoT.con_nr_id" value="${con_contatoJB.con_contatoT.con_nr_id}"/>  <br/>
<label>cat_nr_id:</label><input type="text" name="con_contatoT.cat_nr_id" value="${con_contatoJB.con_contatoT.cat_nr_id}"/>  <br/>
<label>con_tx_nome:</label><input type="text" name="con_contatoT.con_tx_nome" value="${con_contatoJB.con_contatoT.con_tx_nome}"/>  <br/>
<label>con_tx_fone:</label><input type="text" name="con_contatoT.con_tx_fone" value="${con_contatoJB.con_contatoT.con_tx_fone}"/>  <br/>
<label>con_tx_endereco:</label><input type="text" name="con_contatoT.con_tx_endereco" value="${con_contatoJB.con_contatoT.con_tx_endereco}"/>  <br/>
<label>con_tx_email:</label><input type="text" name="con_contatoT.con_tx_email" value="${con_contatoJB.con_contatoT.con_tx_email}"/>  <br/>

    
	<br/>
    <input type="button" value="Insert"  onClick="setOpPortal('con_contato','insert', 'con_contatoInsert.jsp')" /> &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="Clear" onclick="setOpPortal('con_contato','clear', 'con_contatoInsert.jsp')"/>
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    </center>     
	
    
</form>
  
