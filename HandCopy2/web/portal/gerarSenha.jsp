<%-- 
    Document   : autentication
    Created on : 08/06/2008, 19:48:34
    Author     : geoleite
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="gerarsenha" class="br.com.easynet.easyportal.jb.GerarSenhaJB" scope="request"/>
<jsp:setProperty name="gerarsenha" property="*"/>
<jsp:setProperty name="gerarsenha" property="page" value="${pageContext}"/>
${gerarsenha.execute}

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <!-- DW6 -->
    <head>
        <!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
        <title>EasyPortal Authentication</title>
        <link rel="stylesheet" href="/recursos/mm_health_nutr.css" type="text/css" />
        <script language="JavaScript" type="text/javascript">
            <!--
            //--------------- LOCALIZEABLE GLOBALS ---------------
            var d=new Date();
            var monthname=new Array("Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro");
            //Ensure correct for language. English is "January 1, 2004"
            var TODAY = d.getDate() + " " + monthname[d.getMonth()] + ", " + d.getFullYear();
            //---------------   END LOCALIZEABLE   ---------------
            
            //-->
        </script>
        <link href="model.css" rel="stylesheet" type="text/css" />          
        <link href="/model.css" rel="stylesheet" type="text/css" />          
        <script src="eventos.js"></script>  
        <script src="/eventos.js"></script>                                         
        
    </head>
    <body bgcolor="#F4FFE4" onload="setfocus()">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D5EDB3">
                <td colspan="3">
                <jsp:include page="/cabecalho.jsp" flush="true" />				</td>
            </tr>
            <tr>
                <td colspan="3" bgcolor="#5C743D"><img src="/recursos/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
            </tr>
            
            <tr>
                <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif">
                <img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="3" border="0" />                </td>
            </tr>
            
            <tr bgcolor="#99CC66">
                <td colspan="1"  height="0" valign="top">
                </td>
                <td id="dateformat" width="30%" align="left" valign="middle">
                    <script language="JavaScript" type="text/javascript">
                        document.write(TODAY);	</script>
                </td>
                <td width="30%" align="right" valign="middle">
                    
                </td>
            </tr>
            <tr>
                <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif">
                    <img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="1" border="0" />
                </td>
            </tr>
            
            <tr>
                <td colspan="3" bgcolor="#5C743D">
                    <img src="/recursos/mm_spacer.gif" alt="" width="1" height="2" border="0" />
                </td>
            </tr>
            
            <tr>
                
                <td colspan="3" align="center" valign="top">
                    
                    <div align="center">
                        <h2> Form Password Generate </h2>
                        <form action="gerarSenha.jsp" method="post">
                            <input type="hidden" name="op" value="gerarNovaSenha"/>
                            ${gerarsenha.msg}
                            <table width="200px">
                                <tr>
                                    <td>Username:</td>
                                    <td><input type="text" name="usu_usuarioT.usu_tx_login" onkeypress="enter(event)"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="2"><input type="button" value="Generate" onclick="setOp('gerarNovaSenha')"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td rowspan="2">
                                        Volta ao Login <a href="autentication.jsp">Voltar</a>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

