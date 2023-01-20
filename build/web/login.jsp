<%-- 
    Document   : login
    Created on : Oct 11, 2022, 4:57:24 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <form action ="login" method="post">
            Account :  <input type="text" name="acc" value="${account}">
            <br>Password:<input type="text" name="pass" value="${pass}">
            <br>Role:<select name="role">
                            <option>Admin</option>
                            <option>Employees</option>
                            <option>Guest</option>
                        </select>
            <br><input type="submit" name="LOGIN" value="LOGIN">
            <br><a href="register.jsp">Create an account</a>
            <br><a href="ForgotPass.jsp">Forgot password</a>
        </form>
    </body>
</html>
