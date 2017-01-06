<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="can_porJB" class="br.com.easynet.portal.jb.Can_porInsertJB" scope="request"/>                                         
<jsp:setProperty name="can_porJB" property="*"/>                                         
<jsp:setProperty name="can_porJB" property="page" value="${pageContext}"/>                                         
${can_porJB.execute}                                         
                                          
<html>                                         
    <head>                                         
        <meta http-equiv="Content-Type" content="text/html; charset=latin1">                                         
        <title>Page Insert Generate By EasyNet</title>
	<link href="model.css" rel="stylesheet" type="text/css" />                                         
        <script src="eventos.js"></script>                                         
        <script src="easyajax.js"></script>

	<script>
          var className = "br.com.easynet.portal.jb.Can_porInsertJB";
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

    <h1>Generate Page Automatic for Insert br.com.easynet.portal.jb.Can_porInsertJB</h1>                                         
	<label class="errorMessage" align="center">${can_porJB.msg} </label>
<form action="can_porInsert.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <center>     
     	<label class="errorMessage">${can_porJB.msg}</label><br/>

    <label>por_nr_id:</label><input type="text" name="can_porT.por_nr_id" value="${can_porJB.can_porT.por_nr_id}"/>  <br/>
<label>can_nr_id:</label><input type="text" name="can_porT.can_nr_id" value="${can_porJB.can_porT.can_nr_id}"/>  <br/>
<label>cp_nr_ordem:</label><input type="text" name="can_porT.cp_nr_ordem" value="${can_porJB.can_porT.cp_nr_ordem}"/>  <br/>

    
	<br/>
    <input type="button" value="Insert"  onClick="setOp('insert')" /> &nbsp;&nbsp;&nbsp;
    <input type="reset"  value="Clear" onclick="setOp('clear')"/>
    <input type="button" value="Cancel"  onClick="history.go(-1)" />
    </center>     
	
    
</form>
    </body>
</html>
