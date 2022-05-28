<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator Form</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="">
            <label>Enter your age:</label>
            <input type="text" name="age" value="${age}">
            <br><br>     
            <input type="Submit" value="Age next birthday">
            <br>
        </form>
            
        <p>${message}</p>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
