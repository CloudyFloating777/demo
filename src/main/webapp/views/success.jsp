<%@ page language="java" import="com.alibaba.demo.entity.Student"%>
<body>
<c:forEach items="${result}" var = "Student">
    ${Student.name}
    ${Student.age}
    ${Student.telephone}
    ${Student.email}<br/>
</c:forEach>
<br>
<form >
    <h4 align="center">total <%=1%> pages
        <input type="text" name="pageNos" >
        <input id="name" name="name" value=<%=1%> type="hidden"/>
        <input type="text" name="pageMax" value=<%=1%>>
        <input type="submit" value="go">
    </h4>
</form>
</body>