<% 
response.setContentType("text/xml");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cahce");
response.setDateHeader("Expires",0);
response.getWriter().write("<msg>invalid</msg>");
%>