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
<form action="/school/${school.id}/update" method="post">
    <label for="">name
        <input type="text" name="name" value="${school.name}">
    </label>
    <label for="">director
        <input type="text" name="director" value="${school.director}">
    </label>
    <label for="">address
        <input type="text" name="address" value="${school.address}">
    </label>
    <label for="">phone
        <input type="text" name="phone"value="${school.phone}">
    </label>
    <label for="">email
        <input type="text" name="email" value="${school.email}" disabled>
    </label>
    <label for="">
        <input type="text" name="password" value="${school.password}" style="display: none">
    </label>
    <label for="">
        Федерация ${school.federation.name}
    </label>
    <button type="submit">Изменить</button>
</form>
<a href="/school/${school.id}/update" class="btn btn-secondary mt-1">Отменить</a>
<#if errors??>
    <#list errors as e>
        <h2>${e}</h2>
    </#list>
</#if>
</body>
</html>