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
<h1>Добавить персону</h1>
<form action="/person" method="post" enctype="multipart/form-data">
    <label for="">
        surname
        <input type="text" name="surname" value="test">
    </label>
    <label for="">name
        <input type="text" name="name" value="test">
    </label>
    <label for="">middleName
        <input type="text" name="middleName" value="test">
    </label>
    <label for="">birthday
        <input type="date" name="birthday">
    </label>
    <label for="">iin
        <input type="text" name="iin" value="980908405689">
    </label>
    <label for="">gender
        <input type="text" name="gender"  value="test">
    </label>
    <label for="">city
        <input type="text" name="city"  value="test">
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
    <label for="">education
        <input type="text" name="education" value="testtesttesttest">
    </label>
    <label for="">comment
        <input type="text" name="comment" value="testtesttesttest">
    </label>
    <label for="">
        <input type="file" name="file">
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