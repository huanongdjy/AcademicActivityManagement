<%@ page language="java" contentType="text/html; ISO-8859-1;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="/login" method="post">
        <table>
            <tr>
                <td><label>登陆名：</label></td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登陆"></td>
            </tr>
        </table>
    </form>

</body>
</html>