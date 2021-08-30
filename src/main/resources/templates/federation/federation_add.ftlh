<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/federation" method="post">
    <label for="">name
        <input type="text" name="name" value="test">
    </label>
    <label for="">director
        <input type="text" name="director" value="test">
    </label>
    <label for="">address
        <input type="text" name="address" value="testtesttesttest">
    </label>
    <label for="">phone
        <input type="text" name="phone"value="testtesttesttest">
    </label>
    <label for="">email
        <input type="text" name="email" value="jane@mail.ru">
    </label>
    <label for="">password
        <input type="text" name="password" value="testtesttesttest">
    </label>
    <button type="submit">Добавить</button>
</form>
<#if errors??>
    <#list errors as e>
        <h2>${e}</h2>
    </#list>
    <h2></h2>
</#if>
</body>
</html>