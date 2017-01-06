<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="operacoesPerfilJB" class="br.com.easynet.easyportal.jb.OperacoesPerfilJB" scope="request"/>                                         
<jsp:setProperty name="operacoesPerfilJB" property="*"/>                                         
<jsp:setProperty name="operacoesPerfilJB" property="page" value="${pageContext}"/>                                         
${operacoesPerfilJB.execute}                                         
                                     

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <!-- DW6 -->
    <head>
        <!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
        <title>per_perfil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=latin1" />
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
    <body bgcolor="#F4FFE4">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr bgcolor="#D5EDB3">
                <td colspan="3">
                    <jsp:include page="cabecalho.jsp" flush="true" />
                </td>
            </tr>
            <tr>
                <td colspan="3" bgcolor="#5C743D"><img src="/recursos/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
            </tr>
            
            <tr>
                <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif">
                    <img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="3" border="0" />
                </td>
            </tr>
            
            <tr bgcolor="#99CC66">
                <td colspan="3" id="dateformat" height="20">&nbsp;&nbsp;<script language="JavaScript" type="text/javascript">
                    document.write(TODAY);	</script>Bem Vindo ${operacoesPerfilJB.usuarioLogado.usu_tx_nome}	</td>
            </tr>
            <tr>
                <td colspan="3" bgcolor="#99CC66" background="/recursos/mm_dashed_line.gif"><img src="/recursos/mm_dashed_line.gif" alt="line decor" width="4" height="1" border="0" /></td>
            </tr>
            
            <tr>
                <td colspan="3" bgcolor="#5C743D"><img src="/recursos/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
            </tr>
            
            <tr>
                <td width="5%" valign="top" bgcolor="#5C743D">
                    <%@include file="menu.jsp"%>
                &nbsp; 	</td>
                <td width="16"></td>
                <td valign="top">&nbsp;<br />
                    <table border="0" cellspacing="0" cellpadding="0" width="90%">
                        <tr>
                            <td class="pageName" align="center">per_perfil</td>
                        </tr>
                        
                        <tr>
                            <td valign="top" class="bodyText"><p align="left">
                                    
                                    <form action="operacoesPerfil.jsp" method="post">                                         
                                        <input type="hidden" name="op"/>
                                        <center>     
                                            <label class="errorMessage" align="center">${operacoesPerfilJB.msg} </label>
                                            <br/>
                                        </center>     
                                        
                                        <center>
                                            <input type="hidden" name="per_perfilT.per_nr_id" value="${operacoesPerfilJB.per_perfilT.per_nr_id}"/>
                                            <label>Perfil:</label>${operacoesPerfilJB.per_perfilT.per_tx_nome}<br/>
                                            <table align="60%">
                                                <tr>
                                                    <td align="center" valign="top">
                                                        Operações:<br/>
                                                        <select name="operacaoSistema" size="10" onchange="setOp('selectMetodos')">
                                                            <c:forEach items="${operacoesPerfilJB.operacoesNaoPerfil}" var="item">
                                                                <option value="${item.sis_nr_id}_${item.ope_nr_id}">${item.ope_tx_nome}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <br/>
                                                        Métodos:<br/>
                                                        <select name="metodos" size="10" multiple >
                                                            <c:forEach items="${operacoesPerfilJB.metodosPerfil}" var="item">
                                                                <option value="${item.sis_nr_id}_${item.ope_nr_id}_${item.met_nr_id}">${item.met_tx_metodo}</option>                                                                
                                                            </c:forEach>
                                                        </select>

                                                    </td>
                                                    <td align="center">
                                                        <input type="button"  value=">" onclick="setOp('adicionar')"/><br/>
                                                        <input type="button"  value="<" onclick="setOp('remover')"/><br/>
                                                    </td>
                                                    <td align="center" valign="top">
                                                        <select name="operacoes" size="10" multiple>
                                                            <c:forEach items="${operacoesPerfilJB.operacoesPerfil}" var="item">
                                                                <option value="${item.sis_nr_id}_${item.ope_nr_id}">${item.ope_tx_nome}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </center>	
                                    </form>           
                                </p>
                                <p align="left"><br />
                            </p>            <div align="center"></div></td>
                        </tr>
                    </table>
                 </td>
            </tr>
            <tr>
                <td width="29">&nbsp;</td>
                <td width="16">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>
    </body>
</html>                                 
