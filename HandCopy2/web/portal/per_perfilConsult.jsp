<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="per_perfilJB" class="br.com.easynet.easyportal.jb.Per_perfilConsultJB" scope="request"/>                                         
<jsp:setProperty name="per_perfilJB" property="*"/>                                         
<jsp:setProperty name="per_perfilJB" property="page" value="${pageContext}"/>                                         
${per_perfilJB.execute}                                         
                                     

<form name="per_perfil" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="per_perfilConsult.jsp"/>
    
    <center>     
        <h3 align="center">Perfis</h3>
        <label class="errorMessage" align="center">${per_perfilJB.msg} </label>
        <br/>
        <input type="button" value="New" onClick="setOpPortal('per_perfil','', 'per_perfilInsert.jsp')"/>&nbsp;&nbsp;&nbsp;
        <input type="button" value="List" onClick="setOpPortal('per_perfil','consult', 'per_perfilConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
    
    <hr/> 
    <h2 align="center">List</h2>
    <center>	
        <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${per_perfilJB.list}"  pagesize="15" >
            <display:column sortable="false" title="Nome" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=per_perfilUpdateDelete.jsp&op=findbyid&per_perfilT.per_nr_id=${item.per_nr_id}&">
                    <c:out value="${item.per_tx_nome}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Status" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=per_perfilUpdateDelete.jsp&op=findbyid&per_perfilT.per_nr_id=${item.per_nr_id}&">
                    <c:out value="${item.per_tx_status=='A'?'Ativo':'Inativo'}"/>
                </a>
            </display:column>
            <display:column sortable="false" title="Operações" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=operacoesPerfil2.jsp&per_perfilT.per_nr_id=${item.per_nr_id}&">
                    Operações
                </a>
            </display:column>
            <display:column sortable="false" title="Usuários" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=usuariosPerfil.jsp&per_perfilT.per_nr_id=${item.per_nr_id}&">
                    Usuários
                </a>
            </display:column>
            <display:column sortable="false" title="Menu" >
                <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=mep_men_perConsult.jsp&per_perfilT.per_nr_id=${item.per_nr_id}&">
                    Menu
                </a>
            </display:column>
            
            <display:column title="Apagar" class="th.apagar">
                    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=per_perfilConsult.jsp&op=delete&per_perfilT.per_nr_id=${item.per_nr_id}&">
                        <img border="0" src="../images/delete.png">
                    </a>
            </display:column>	
        </display:table>
    </center>	
    
</form>           
