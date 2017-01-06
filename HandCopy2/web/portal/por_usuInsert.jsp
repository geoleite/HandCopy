<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="por_usuJB" class="br.com.easynet.portal.jb.Por_usuInsertJB" scope="request"/>                                         
<jsp:setProperty name="por_usuJB" property="*"/>                                         
<jsp:setProperty name="por_usuJB" property="page" value="${pageContext}"/>                                         
${por_usuJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Insert Generate By EasyNet</title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	<script>
          var className = "br.com.easynet.portal.jb.Por_usuInsertJB";
	  function insertAjax() {
	    var xml = getResponse(className, "insert");            
            /*	   
		|COMMANDS|
	    */
 	  }
	  function findByIdAjax(id) {
	    var xml = getResponseParam(className, "findbyid", id);            
            /*	   
		|COMMANDS|
	    */
 	  }
	  function updateAjax(id) {
	    var xml = getResponse(className, "update");  
            /*	   
		|COMMANDS|
	    */
 	  }
	  function deleteAjax() {
	    var xml = getResponse(className, "delete");            
            /*	   
		|COMMANDS|
	    */
 	  }

          // Limpa os campos do formulário
	  function clear() {
	    clearFields();
          }

	</script>                                         
    </head>                                         
    <body>                                         

    <h1>Generate Page Automatic for Insert br.com.easynet.portal.jb.Por_usuInsertJB</h1>                                         
	<label class="errorMessage" align="center">${por_usuJB.msg} </label>
<form action="por_usuInsert.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${por_usuJB.msg}</label><br/>

    <label>usu_nr_id:</label><input type="text" name="por_usuT.usu_nr_id" value="${por_usuJB.por_usuT.usu_nr_id}"/>  <br/>
<label>por_nr_id:</label><input type="text" name="por_usuT.por_nr_id" value="${por_usuJB.por_usuT.por_nr_id}"/>  <br/>

    
	<br/>
    <input type="button" value="Insert"  onClick="setOp('insert')" /> &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    </center>     
	
    
</form>
    </body>
</html>
