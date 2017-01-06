<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="con_contatoJB" class="br.com.agenda.jb.Con_contatoConsultJB" scope="request"/>                                         
<jsp:setProperty name="con_contatoJB" property="*"/>                                         
<jsp:setProperty name="con_contatoJB" property="page" value="${pageContext}"/>                                         
${con_contatoJB.execute}                                         
                                                                                

<form name="con_contato" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="con_contatoConsult.jsp"/>
    <input type="hidden" name="urlCanal" value="con_contatoConsult.jsp"/>
    <center>     
	<label class="errorMessage" align="center">${con_contatoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('con_contato','', 'con_contatoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('con_contato','consult', 'con_contatoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${con_contatoJB.list}"  pagesize="5" >

		<display:column sortable="false" title="Con_nr_id" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_nr_id}"/>
            </a>

	</display:column>
	<display:column sortable="false" title="Cat_nr_id" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.cat_nr_id}"/>
            </a>

	</display:column>
	<display:column sortable="false" title="Con_tx_nome" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_nome}"/>
            </a>

	</display:column>
	<display:column sortable="false" title="Con_tx_fone" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_fone}"/>
            </a>

	</display:column>
	<display:column sortable="false" title="Con_tx_endereco" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_endereco}"/>
            </a>

	</display:column>
	<display:column sortable="false" title="Con_bt_foto" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		sdf
            </a>

	</display:column>
	<display:column sortable="false" title="Con_tx_email" >
<!-- portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= -->
	    <a href="portal.jsp?urlCanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoUpdateDelete.jsp&op=findbyid&con_contatoT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_email}"/>
            </a>

	</display:column>
     
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id= 
portal.jsp?urlcanalAtual=con_contatoConsult.jsp&urlCanal=con_contatoConsult.jsp&op=delete&con_contatoT.con_nr_id=${item.con_nr_id}&
-->
       	   <center>
		<a onclick="setOpPortal('con_contato','delete', 'con_contatoConsult.jsp?con_contatoT.con_nr_id=${item.con_nr_id}')" href="#">
    	       		<img border="0" src="images/delete.png">
		</a>
	   </center>
       </display:column>	
    </display:table>
    </center>	
    
</form>
  