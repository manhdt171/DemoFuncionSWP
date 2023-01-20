<%-- 
    Document   : Register
    Created on : Oct 13, 2022, 4:24:47 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body>
        <form action ="register" method="post">
            Account:  <input type="text" name="acc">
            <br>Password:<input type="text" name="pass">
             <br>Role:<select name="role">
                                <option>Employees</option>
                            <option>Guest</option>
                        </select>
            <br><input type="submit" value="REGISTER">
            ${mess}
        </form>
    </body>
</html>
