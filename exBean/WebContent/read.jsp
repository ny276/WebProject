<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "exBean.studentVO" %>
<%@ page import = "exBean.studentDAO" %>

<%-- DAO 객체 생성 --%>
<% 
  studentDAO dao = new studentDAO();
  List<studentVO> items = new ArrayList<studentVO>();
  items = dao.selectStudent(); //selectStudent()메서드를 수행하여 List로 record set을 넘겨 받는다
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
 for(int i=0;i<items.size();i++) {
  studentVO item = (studentVO)items.get(i); //List에서 record를 하나씩 가져온다
%>

<%=item.getNo()%>
<%=item.getName()%><br>
<%}%>
</body>
</html>

