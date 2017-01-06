<%out = new br.com.easynet.io.EasyJSPOut();%>
<jsp:useBean id="downloadJB" class="br.com.easynet.jb.EasyDownloadJB" scope="request"/>                                         
<jsp:setProperty name="downloadJB" property="*"/>                                         
<jsp:setProperty name="downloadJB" property="page" value="${pageContext}"/>                                         
${downloadJB.execute}
