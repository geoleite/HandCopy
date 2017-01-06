{"resultado":[
   {"name":"George", "symbol":"123", "open":"1", "last":"1", "date":"12/12/220","change":"1","industry":"universidade"}
<%
  for (int i=0;  i< 100; i++) {
%>
    ,{"name":"George<%=i%>", "symbol":"123<%=i%>", "open":"1<%=i%>", "last":"1<%=i%>", "date":"12/12/220<%=i%>","change":"1<%=i%>","industry":"universidade<%=i%>"}
<%}%>

]}

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:forEach items="" var="item">

</c:forEach>