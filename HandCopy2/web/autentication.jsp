
<jsp:useBean id="autentication" class="br.com.easynet.easyportal.jb.AutenticationJB" scope="request"/>
<jsp:setProperty name="autentication" property="*"/>
<jsp:setProperty name="autentication" property="page" value="${pageContext}"/>
${autentication.execute}
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EasyPortal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1" />
        <script src="script/eventos.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="css/model.css" rel="stylesheet" type="text/css" />
    </head>
    <body bgcolor="#ffffff">
        <table border="0" cellpadding="0" cellspacing="0" width="1024"  align="center">
            <!-- fwtable fwsrc="EASYCLIN.png" fwpage="Page 1" fwbase="EASYCLIN.jpg" fwstyle="Dreamweaver" fwdocid = "1791252200" fwnested="0" -->

            <tr>
                <td colspan="4"><br/><br/><br/></td>
            </tr>
            <tr>
                <td rowspan="5"><img name="EASYCLIN_r2_c1" src="images/EASYCLIN_r2_c1.jpg" width="369" height="488" border="0" id="EASYCLIN_r2_c1" alt="" /></td>
                <td><img name="EASYCLIN_r2_c2" src="images/EASYCLIN_r2_c2.jpg" width="263" height="80" border="0" id="EASYCLIN_r2_c2" alt="" /></td>
                <td rowspan="4"><img name="EASYCLIN_r2_c3" src="images/EASYCLIN_r2_c3.jpg" width="7" height="337" border="0" id="EASYCLIN_r2_c3" alt="" /></td>
                <td rowspan="2"><!--img name="EASYCLIN_r2_c4" src="images/EASYCLIN_r2_c4.jpg" width="385" height="122" border="0" id="EASYCLIN_r2_c4" alt="" /--></td>
                <td><img src="images/spacer.gif" width="1" height="80" border="0" alt="" /></td>
            </tr>
            <tr>
                <td><img name="EASYCLIN_r3_c2" src="images/EASYCLIN_r3_c2.jpg" width="263" height="42" border="0" id="EASYCLIN_r3_c2" alt="" /></td>
                <td><img src="images/spacer.gif" width="1" height="42" border="0" alt="" /></td>
            </tr>
            <tr>
                
                <td>
                    <label class="warnMessage">${autentication.msg}</label>
                    <form action="autentication.jsp" method="post">
                        <input type="hidden" name="op" value="autenticar"/>
                        <table width="200px">
                            <tr>
                                <td rowspan="4"><img src="images/chave.gif" border="0"/></td>
                                <td><label>Username:</label></td>
                                <td><input type="text" size="13" name="usu_usuarioT.usu_tx_login" onKeyPress="enter(event)"/>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Password:</label></td>
                                <td><input type="password" size="13" name="usu_usuarioT.usu_tx_senha" onKeyPress="enter(event)"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="button" value="Enter" onClick="setOp('autenticar')"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <label>
                                        Esqueceu a senha? Clique <a href="gerarSenha.jsp">aqui
                                        </a>
                                    </label>
                                        <br/>
                                        <br/>
                                    <label>
                                        Cliente, deseja consultar seu horario? clique <a href="easyclin/easyclin/cli_cliente/agendaCliente.jsp">aqui.</a>
                                    </label>

                                </td>
                            </tr>


                        </table>
                    </form>

                </td>
                <td><img name="EASYCLIN_r4_c4" src="images/EASYCLIN_r4_c4.jpg" width="385" height="153" border="0" id="EASYCLIN_r4_c4" alt="" /></td>
                
            </tr>
            <tr>
                <td><img name="EASYCLIN_r5_c2" src="images/EASYCLIN_r5_c2.jpg" width="263" height="62" border="0" id="EASYCLIN_r5_c2" alt="" /></td>
                <td rowspan="2"></td>
                <td><img src="images/spacer.gif" width="1" height="62" border="0" alt="" /></td>
            </tr>
            <tr>
                <td colspan="2"></td>
                <td><img src="images/spacer.gif" width="1" height="151" border="0" alt="" /></td>
            </tr>
        </table>
    </body>
</html>
