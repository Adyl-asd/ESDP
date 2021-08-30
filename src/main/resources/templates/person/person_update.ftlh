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
<h1>Изменить персону</h1>
<img src="/person/photo/${person.photo.filePath}" alt="image">
<form action="/person/${person.id}/update" method="post" enctype="multipart/form-data">
    <label for="">
        surname
        <input type="text" name="surname" value="${person.surname}">
    </label>
    <label for="">name
        <input type="text" name="name" value="${person.name}">
    </label>
    <label for="">middleName
        <input type="text" name="middleName" value="${person.middleName}">
    </label>
    <label for="">birthday
        <input type="date" name="birthday" value="${person.birthday}">
    </label>
    <label for="">iin
        <input type="text" name="iin" value="${person.iin}">
    </label>
    <label for="">gender
        <input type="text" name="gender"  value="${person.gender}">
    </label>
    <label for="">city
        <input type="text" name="city"  value="${person.city}">
    </label>
    <label for="">address
        <input type="text" name="address" value="${person.address}">
    </label>
    <label for="">phone
        <input type="text" name="phone"value="${person.phone}">
    </label>
    <label for="">email
        <input type="text" name="email" value="${person.email}">
    </label>
    <label for="">education
        <input type="text" name="education" value="${person.education}">
    </label>
    <label for="">comment
        <input type="text" name="comment" value="${person.comment}">
    </label>
    <label for="">
        <input type="file" name="file">
    </label>
    <button type="submit">Добавить</button>
    <#if errors??>
        <#list errors as e>
            <h2>${e}</h2>
        </#list>
        <h2></h2>
    </#if>
</form>
</body>
</html>