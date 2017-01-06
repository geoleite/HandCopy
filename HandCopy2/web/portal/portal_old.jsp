<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBaseJB" scope="request"/>                                         
<jsp:setProperty name="portal" property="*"/>                                         
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>   
${portal.execute}
<%@page contentType="text/html" pageEncoding="latin1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <script src="Scripts/AC_RunActiveContent.js" type="text/javascript"></script>
        <script src="../script/eventos.js"></script>
        <script src="../script/calendario.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>...::EasyPortal::...</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <link href="../css/model.css" rel="stylesheet" type="text/css" />  
    </head>

    <body> 
        <div id="layer_calendar" style="position:absolute;top:0;left:0;z-index:100"></div>
        <div id="container">
            <table align="center" width="100%" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td id="topo" align="center">
                        <!--div id="topo" align="center" -->
                        <img src="../recursos/mm_health_photo.png" alt="Header image"  border="0" /><br/>
                        <label>Bem Vindo ${portal.usuarioLogado.usu_tx_nome}
                            <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=alterarSenha.jsp">Alterar Senha</a>
                        </label> 			
                        <!--/div-->
                    </td>
                </tr>
                <tr>
                    <td id="subtopo_menu">
                        <!--div id="subtopo_menu"-->
                        <table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
                            <tr>
                                <td>
                                    &nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td align="center" valign="middle">
                                    <jsp:include page="menu/montaMenu.jsp" flush="true">
                                        <jsp:param name="clearop" value="true"/>
                                    </jsp:include>
                                </td>
                            </tr>
                        </table>

                        <!--/div-->
                    </td>
                </tr>
                <tr>
                    <td align="center" valign="top">
                        <div id="conteudo">
                            <table align="center" width="100%" height="100%">
                                <tr>
                                    <td align="center" valign="top">
                                        <label class="${portal.tipoMsg}">${portal.msg}</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center" valign="top">
                                        ${portal.montaCanal} 
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td id="rodape">
                        <!--div id="rodape" -->
                        <table width="100%" height="100%" border="0">
                            <tr>
                                <td align="center" valign="middle">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" valign="middle">
                                    <label>Contato: contato@geoleite.com.br</label>
                                </td>
                            </tr>
                        </table>
                        <!--/div-->

                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
<script>
    // Redirecionador de Páginas
    <%
            String redirect = (String) session.getAttribute(br.com.easynet.easyportal.jb.SystemBase.REDIRECT_SESSION);
            session.removeAttribute(br.com.easynet.easyportal.jb.SystemBase.REDIRECT_SESSION);
            redirect = redirect == null ? "" : redirect;
    %>
        var redirect = '<%=redirect%>';
        if (redirect.length > 0) {
            document.location= redirect;
        }
</script>

