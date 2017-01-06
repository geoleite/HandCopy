<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="por_portalJBConsult" class="br.com.easynet.portal.jb.Por_portalConsultJB" scope="request"/>                                         
<jsp:setProperty name="por_portalJBConsult" property="*"/>                                         
<jsp:setProperty name="por_portalJBConsult" property="page" value="${pageContext}"/>                                         
${por_portalJBConsult.execute}                                         
                                          

    <h3 align="center">Portais Cadastrados</h3>

<form name="por_portal" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="por_portalConsult.jsp"/>
    <center>     
	<label class="errorMessage" align="center">${por_portalJBConsult.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('por_portal', '', 'por_portalInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('por_portal', '', 'por_portalConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h3 align="center">List</h3>
    <center>	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${por_portalJBConsult.list}"  pagesize="10" >
	<display:column sortable="false" title="Nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=por_portalUpdateDelete.jsp&op=findbyid&por_portalT.por_nr_id=${item.por_nr_id}&">
      		<c:out value="${item.por_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Status" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=por_portalUpdateDelete.jsp&op=findbyid&por_portalT.por_nr_id=${item.por_nr_id}&">
      		<c:out value="${item.por_tx_status=='A'?'Ativo':'Inativo'}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Nr de Colunas" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=por_portalUpdateDelete.jsp&op=findbyid&por_portalT.por_nr_id=${item.por_nr_id}&">
      		<c:out value="${item.por_nr_colunas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=por_usuConsult.jsp&por_portalT.por_nr_id=${item.por_nr_id}&">
      		Usuários
            </a>
	</display:column>
	<display:column sortable="false" title="" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=can_porConsult.jsp&por_portalT.por_nr_id=${item.por_nr_id}&">
      		Canais
            </a>
	</display:column>

        <display:column title="Apagar">
		<a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=por_portalConsult.jsp&op=delete&por_portalT.por_nr_id=${item.por_nr_id}&">
    	       		<img border="0" src="../images/delete.png">
		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
