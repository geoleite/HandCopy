<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<jsp:useBean id="mep_men_perJB" class="br.com.easynet.easyportal.menu.jb.Mep_men_perInsertJB" scope="request"/>                                         
<jsp:setProperty name="mep_men_perJB" property="*"/>                                         
<jsp:setProperty name="mep_men_perJB" property="page" value="${pageContext}"/>                                         
${mep_men_perJB.execute}                                         
                                          
                                     

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>mep_men_per</title>
<meta http-equiv="Content-Type" content="text/html; charset=latin1" />
<link rel="stylesheet" href="/recursos/mm_health_nutr.css" type="text/css" />
<script language="JavaScript" type="text/javascript">
<!--
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
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
	<jsp:include page="/cabecalho.jsp" flush="true" />
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
      document.write(TODAY);	</script>&nbsp;&nbsp;Bem Vindo ${principalPageJB.usuarioLogado.usu_tx_nome}	</td>
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
          <td class="pageName" align="center">mep_men_per </td>
		</tr>

		<tr>
          <td valign="top" class="bodyText"><p align="left">
                                          


<form action="mep_men_perInsert.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${mep_men_perJB.msg}</label><br/>

    <label>per_nr_id:</label><input type="text" name="mep_men_perT.per_nr_id" value="${mep_men_perJB.mep_men_perT.per_nr_id}"/>  <br/>
<label>men_nr_id:</label><input type="text" name="mep_men_perT.men_nr_id" value="${mep_men_perJB.mep_men_perT.men_nr_id}"/>  <br/>

    
	<br/>
    <input type="button" value="Insert"  onClick="setOp('insert')" /> &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
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
