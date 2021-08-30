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
<form action="/federation/${federation.id}/update" method="post">
    <label for="">name
        <input type="text" name="name" value="${federation.name}">
    </label>
    <label for="">director
        <input type="text" name="director" value="${federation.director}">
    </label>
    <label for="">address
        <input type="text" name="address" value="${federation.address}">
    </label>
    <label for="">phone
        <input type="text" name="phone"value="${federation.phone}">
    </label>
    <label for="">email
        <input type="text" name="email" value="${federation.email}" disabled>
    </label>
    <button type="submit">Добавить</button>
</form>
</body>
</html>