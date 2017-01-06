<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="opm_met_ope_perJB" class="br.com.i9.portal.jb.Opm_met_ope_perConsultJB" scope="request"/>                                         
<jsp:setProperty name="opm_met_ope_perJB" property="*"/>                                         
<jsp:setProperty name="opm_met_ope_perJB" property="page" value="${pageContext}"/>                                         
${opm_met_ope_perJB.execute}                                         
                                                                                

<form name="opm_met_ope_per" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${opm_met_ope_perJB.tipoMsg}">${opm_met_ope_perJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('opm_met_ope_per','', '/portal/portal/opm_met_ope_per/opm_met_ope_perInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('opm_met_ope_per','consult', '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${opm_met_ope_perJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Per_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp&op=findbyid&opm_met_ope_perT.per_nr_id=${item.per_nr_id}&opm_met_ope_perT.ope_nr_id=${item.ope_nr_id}&opm_met_ope_perT.sis_nr_id=${item.sis_nr_id}&opm_met_ope_perT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.per_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ope_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp&op=findbyid&opm_met_ope_perT.per_nr_id=${item.per_nr_id}&opm_met_ope_perT.ope_nr_id=${item.ope_nr_id}&opm_met_ope_perT.sis_nr_id=${item.sis_nr_id}&opm_met_ope_perT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.ope_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Sis_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp&op=findbyid&opm_met_ope_perT.per_nr_id=${item.per_nr_id}&opm_met_ope_perT.ope_nr_id=${item.ope_nr_id}&opm_met_ope_perT.sis_nr_id=${item.sis_nr_id}&opm_met_ope_perT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.sis_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Met_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/portal/portal/opm_met_ope_per/opm_met_ope_perUpdateDelete.jsp&op=findbyid&opm_met_ope_perT.per_nr_id=${item.per_nr_id}&opm_met_ope_perT.ope_nr_id=${item.ope_nr_id}&opm_met_ope_perT.sis_nr_id=${item.sis_nr_id}&opm_met_ope_perT.met_nr_id=${item.met_nr_id}&">
      		<c:out value="${item.met_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('opm_met_ope_per','delete', '/portal/portal/opm_met_ope_per/opm_met_ope_perConsult.jsp?opm_met_ope_perT.per_nr_id=${item.per_nr_id}&opm_met_ope_perT.ope_nr_id=${item.ope_nr_id}&opm_met_ope_perT.sis_nr_id=${item.sis_nr_id}&opm_met_ope_perT.met_nr_id=${item.met_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
