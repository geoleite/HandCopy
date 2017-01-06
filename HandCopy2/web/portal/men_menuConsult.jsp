<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="men_menuJB" class="br.com.easynet.easyportal.menu.jb.Men_menuConsultJB" scope="request"/>                                         
<jsp:setProperty name="men_menuJB" property="*"/>                                         
<jsp:setProperty name="men_menuJB" property="page" value="${pageContext}"/>                                         
${men_menuJB.execute}                                         
                                     

<form name="men_menu" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="men_menuConsult.jsp"/>
    
    <center>     
        <label class="errorMessage" align="center">${men_menuJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('men_menu', '', 'men_menuInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('men_menu', '', 'men_menuConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <h3>Menus Cadastrados</h3>
    <div align="center">	
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${men_menuJB.list}"  pagesize="20" >
            
            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuUpdateDelete.jsp&op=findbyid&men_menuT.men_nr_id=${item.men_nr_id}&">
                    <c:out value="${item.men_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="URL" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuUpdateDelete.jsp&op=findbyid&men_menuT.men_nr_id=${item.men_nr_id}&">
                    <c:out value="${item.men_tx_url}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Acao" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuUpdateDelete.jsp&op=findbyid&men_menuT.men_nr_id=${item.men_nr_id}&">
                    <c:out value="${item.men_tx_acao}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuUpdateDelete.jsp&op=findbyid&men_menuT.men_nr_id=${item.men_nr_id}&">
                    <c:out value="${item.men_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column style="text-align:right" sortable="false" title="Ordem"  >
                <div align="center">
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuUpdateDelete.jsp&op=findbyid&men_menuT.men_nr_id=${item.men_nr_id}&" >
                        <c:out value="${item.men_nr_ordem}"/>
                    </a>
                </div>
            </display:column>
            
            <display:column title="">
                <div align="center">
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=men_menuConsult.jsp&op=delete&men_menuT.men_nr_id=${item.men_nr_id}&">
                        <img border="0" src="../images/delete.png">
                    </a>
                </div>
            </display:column>	
        </display:table>
    </div>	
    
</form>           
