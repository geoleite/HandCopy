<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="mep_men_perJB" class="br.com.i9.portal.jb.Mep_men_perConsultJB" scope="request"/>                                         
<jsp:setProperty name="mep_men_perJB" property="*"/>                                         
<jsp:setProperty name="mep_men_perJB" property="page" value="${pageContext}"/>                                         
${mep_men_perJB.execute}                                         
                                                                                

<form name="mep_men_per" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/mep_men_per/mep_men_perConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${mep_men_perJB.tipoMsg}">${mep_men_perJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('mep_men_per','', '/portal/portal/mep_men_per/mep_men_perInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('mep_men_per','consult', '/portal/portal/mep_men_per/mep_men_perConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${mep_men_perJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Per_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp&op=findbyid&mep_men_perT.per_nr_id=${item.per_nr_id}&mep_men_perT.men_nr_id=${item.men_nr_id}&">
      		<c:out value="${item.per_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Men_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/mep_men_per/mep_men_perUpdateDelete.jsp&op=findbyid&mep_men_perT.per_nr_id=${item.per_nr_id}&mep_men_perT.men_nr_id=${item.men_nr_id}&">
      		<c:out value="${item.men_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('mep_men_per','delete', '/portal/portal/mep_men_per/mep_men_perConsult.jsp?mep_men_perT.per_nr_id=${item.per_nr_id}&mep_men_perT.men_nr_id=${item.men_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
