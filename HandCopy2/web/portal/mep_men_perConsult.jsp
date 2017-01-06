<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="mmpJB" class="br.com.easynet.easyportal.menu.jb.Mep_men_perConsultJB" scope="request"/>                                         
<jsp:setProperty name="mmpJB" property="*"/>                                         
<jsp:setProperty name="mmpJB" property="page" value="${pageContext}"/>                                          
${mmpJB.execute}                                         
                                     

<form name="mep_men_per" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="mep_men_perConsult.jsp"/>
    <input type="hidden" name="per_perfilT.per_nr_id" value="${mmpJB.per_perfilT.per_nr_id}"/>
    
    <div align="center">     
        <label class="errorMessage" align="center">${mmpJB.msg} </label>
        <h3>Dados do Perfil</h3>
        <table>
            <tr>
                <td align="left">
                    <label>Nome:</label>
                </td>
                <td  align="left">
                    <label>${mmpJB.per_perfilT.per_tx_nome}</label>
                </td>    
            </tr>
            <tr>
                <td align="left">
                    <label>Status:</label>            
                </td>
                <td align="left">
                    <label>${mmpJB.per_perfilT.per_tx_status=='A'?'Ativo':'Inativo'}</label>
                </td>
            </tr>
        </table>  
        <table>
            <tr>
                <td align="left">
                    <label>Menu não selecionado:<br/></label>
                    <select name="mep_men_perAddT.men_nr_id" size="10">
                        <c:forEach var="item" items="${mmpJB.listNoMenu}">
                            <option value="${item.men_nr_id}" ${mmpJB.mep_men_perAddT.men_nr_id==item.men_nr_id?'selected':''}>${item.men_nr_id}-${item.men_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="center" width="20px">
                    <input type="button" value="  >  " onClick="setOpPortal('mep_men_per', 'add', 'mep_men_perConsult.jsp')"/><br/><br/>
                    <input type="button" value="  <  " onClick="setOpPortal('mep_men_per', 'rem', 'mep_men_perConsult.jsp')"/><br/><br/>
                    
                </td>
                <td  align="right">
                    <label>Menu selecionado:</label><br/>
                    <select name="mep_men_perRemT.men_nr_id" size="10">
                        <c:forEach var="item" items="${mmpJB.listMenu}">
                            <option value="${item.men_nr_id}" ${mmpJB.mep_men_perRemT.men_nr_id==item.men_nr_id?'selected':''}>${item.men_nr_id}-${item.men_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td align="center" colspan="3">
                    <input type="button" value="Voltar" onclick="setOpPortal('mep_men_per', '', 'per_perfilConsult.jsp')"/>           
                </td>
            </tr>
            
        </table>
    </div>     
    
</form>           
