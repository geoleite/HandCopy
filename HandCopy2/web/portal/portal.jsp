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
        <meta http-equiv="Content-Type" content="text/html; charset=latin1" />
        <script src="../script/eventos.js"></script>
        <script src="../script/calendario.js"></script>
        <script type="text/javascript">var dmWorkPath="menu.files/";</script>
        <script type="text/javascript" src="menu.files/dmenu.js"></script>
        <title>...::EasyPortal::...</title>
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <link href="../css/model.css" rel="stylesheet" type="text/css" />

    </head>
    <body bgcolor="#ffffff" style="margin-left:0;margin-top:0">
        <div id="layer_calendar" style="position:absolute;top:0;left:0;z-index:100"></div>

        <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center">
            <!-- fwtable fwsrc="EASYFCLIN2.png" fwpage="Page 1" fwbase="EASYCLIN2.jpg" fwstyle="Dreamweaver" fwdocid = "1791252200" fwnested="0" -->
            <tr>
                <td><img src="../images/spacer.gif" width="159" height="1" border="0" alt="" /></td>
                <td><img src="../images/spacer.gif" width="865" height="1" border="0" alt="" /></td>
                <td><img src="../images/spacer.gif" width="1" height="1" border="0" alt="" /></td>
            </tr>

            <tr>
                <td><img name="EASYCLIN2_r1_c1" src="../images/EASYCLIN2_r1_c1.jpg" width="159" height="45" border="0" id="EASYCLIN2_r1_c1" alt="" /></td>
                <td style="background-image:url(../images/EASYCLIN2_r1_c2.jpg)">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="color:white">Bem Vindo ${portal.usuarioLogado.usu_tx_nome}&nbsp;&nbsp;
                        <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=alterarSenha.jsp" style="color:yellow">Alterar Senha</a>
                    </label>

                </td>
                <td>
                </td>
            </tr>

            <tr>
                <td colspan="2" style="background-image:url(../images/EASYCLIN2_r2_c1.jpg)" nowrap>
                    <script type="text/javascript" src="menu/montaMenu2.jsp"></script>

                </td>
                <td><img src="../images/spacer.gif" width="1" height="30" border="0" alt="" /></td>
            </tr>

            <tr>
                <td colspan="3">
                    <label class="warnMessage">${autentication.msg}</label>
                    <table align="center" width="100%" height="100%">
                        <tr>
                            <td align="center" valign="top">
                                ${portal.msg}
                            </td>
                        </tr>
                        <tr>
                            <td align="center" valign="top">
                                
                                <!-- Se for redirecionar nao exibe a tela -->
                                
                                ${portal.montaCanal}
                                
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="3" align="center" style="background-image:url(../images/EASYCLIN2_r4_c1.jpg)"><br/><label>Contatos: contato@web10.eti.br <br/><br/></label></td>
            </tr>
        </table>
    </body>
</html>
<c:if test="${!empty redirect }">
    <script>

        setTimeout("redirect()",1000)
        function redirect() {
            document.location="${redirect}";
        }                        
    </script>
</c:if>


