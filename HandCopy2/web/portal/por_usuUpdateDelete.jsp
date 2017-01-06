<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="por_usuJB" class="br.com.easynet.portal.jb.Por_usuUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="por_usuJB" property="*"/>                                         
<jsp:setProperty name="por_usuJB" property="page" value="${pageContext}"/>                                         
${por_usuJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Update and Delete Generate By EasyNet </title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	                                  
    </head>                                         
    <body>                                         

    <h1>Generate Page Automatic for Update and Delete br.com.easynet.portal.jb.Por_usuUpdateDeleteJB</h1>                                         

<form action="por_usuUpdateDelete.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${por_usuJB.msg}</label><br/>

    <label>usu_nr_id:</label><input type="text" name="por_usuT.usu_nr_id" value="${por_usuJB.por_usuT.usu_nr_id}"/>  <br/>
<label>por_nr_id:</label><input type="text" name="por_usuT.por_nr_id" value="${por_usuJB.por_usuT.por_nr_id}"/>  <br/>

    
	<br/>
    <input type="button" value="Consult" onClick="setOp('consult')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Update"  onClick="setOp('update')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Delete"  onClick="setOp('delete')"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    </center>     
	
</form>
    </body>
</html>
