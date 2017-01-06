<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="men_menuJB" class="br.com.easynet.easyportal.menu.jb.Men_menuInsertJB" scope="request"/>
<jsp:setProperty name="men_menuJB" property="*"/>
<jsp:setProperty name="men_menuJB" property="page" value="${pageContext}"/>
${men_menuJB.execute}



<form name="men_menu" action="portal.jsp" method="post"   >
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="men_menuInsert.jsp"/>
    <div align="center">
        <label class="msg">${men_menuJB.msg}</label>
        <h3>Dados do Menu</h3>
        <table>
            <tr>
                <td>
                    <label>Nome:</label>

                </td>
                <td>
                    <input type="text" name="men_menuT.men_tx_nome" value="${men_menuJB.men_menuT.men_tx_nome}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Url:</label>
                </td>
                <td>
                    <input type="text" name="men_menuT.men_tx_url" value="${men_menuJB.men_menuT.men_tx_url}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Acao GWT:</label>
                </td>
                <td>
                    <input type="text" name="men_menuT.men_tx_acao" value="${men_menuJB.men_menuT.men_tx_acao}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Icone GWT:</label>
                </td>
                <td>
                    <input type="text" name="men_menuT.men_tx_icone" value="${men_menuJB.men_menuT.men_tx_icone}"/>
                </td>
            </tr>

            <tr>
                <td>
                    <label>Sistema:</label>
                </td>
                <td>
                    <select name="sis_sistemaT.sis_nr_id" >
                        <c:forEach items="${men_menuJB.listSistemas}" var="item">
                            <option value="${item.sis_nr_id}" ${men_menuJB.sis_sistemaT.sis_nr_id==item.sis_nr_id?'selected':''}>${item.sis_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Status:</label>
                </td>
                <td>
                    <label>Ativo: </label><input type="radio" name="men_menuT.men_tx_status" value="A" ${men_menuJB.men_menuT.men_tx_status=='A'?'checked':''} />
                    <label>Inativo: </label><input type="radio" name="men_menuT.men_tx_status" value="I" ${men_menuJB.men_menuT.men_tx_status=='I'?'checked':''} />
                </td>
            </tr>
            <tr>
                <td>
                    <label>Ordem do Menu:</label>
                </td>
                <td>
                    <select name="men_menuT.men_nr_ordem" >
                        <c:forEach begin="0" end="20" var="i">
                            <option value="${i}" ${men_menuJB.men_menuT.men_nr_ordem==i?'selected':''}>${i}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Filtrar por Sistema:</label>
                </td>
                <td>
                    <select name="sis_sistemaTFiltro.sis_nr_id" onchange="setOpPortal('men_menu','consult', 'men_menuInsert.jsp')">
                        <c:forEach items="${men_menuJB.listSistemas}" var="item">
                            <option value="${item.sis_nr_id}" ${men_menuJB.sis_sistemaTFiltro.sis_nr_id==item.sis_nr_id?'selected':''}>${item.sis_tx_nome}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td valign="top">
                    <label>Menu Superior:</label>
                </td>
                <td>
                    <select name="men_menuT.supermenu_nr_id" title="Define o menu superior, caso haja!" size="15">
                        <option value="0" ${men_menuJB.men_menuT.supermenu_nr_id==0?'selected':''}>Não há menu superior</option>
                        <c:forEach var="item" items="${men_menuJB.listMenus}">
                            <option value="${item.men_nr_id}" ${men_menuJB.men_menuT.supermenu_nr_id==item.men_nr_id?'selected':''}>${item.men_nr_id}-${item.men_tx_nome}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Insert"  onClick="setOpPortal('men_menu','insert', 'men_menuInsert.jsp')" /> &nbsp;&nbsp;&nbsp;
                    <input type="button" value="Voltar"  onClick="setOpPortal('men_menu','', 'men_menuConsult.jsp')" /> &nbsp;&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </div>


</form>

