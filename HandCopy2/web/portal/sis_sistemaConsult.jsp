<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="sis_sistemaJB" class="br.com.easynet.easyportal.jb.Sis_sistemaConsultJB" scope="request"/>                                         
<jsp:setProperty name="sis_sistemaJB" property="*"/>                                         
<jsp:setProperty name="sis_sistemaJB" property="page" value="${pageContext}"/>                                         
${sis_sistemaJB.execute}                                         


<form name="sis_sistema" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="sis_sistemaConsult.jsp"/>
    
    <center>     
        <h3>Sistemas</h3>
        <label class="errorMessage" align="center">${sis_sistemaJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('sis_sistema','', 'sis_sistemaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('sis_sistema','consult', 'sis_sistemaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <center>	
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${sis_sistemaJB.list}"  pagesize="10" >
         <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=sis_sistemaUpdateDelete.jsp&op=findbyid&sis_sistemaT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.sis_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=sis_sistemaUpdateDelete.jsp&op=findbyid&sis_sistemaT.sis_nr_id=${item.sis_nr_id}&">
                    <c:out value="${item.sis_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Operações" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=ope_operacaoConsult.jsp&ope_operacaoT.sis_nr_id=${item.sis_nr_id}&">
                    Operações
                </a>
            </display:column>
            
            <display:column title="">
                    <a onclick="setOpPortal('sis_sistema','delete', 'sis_sistemaConsult.jsp?sis_sistemaT.sis_nr_id=${item.sis_nr_id}')" href="#">
                        <img border="0" src="../images/delete.png">
                    </a>
            </display:column>	
        </display:table>
    </center>	
    
</form>                        