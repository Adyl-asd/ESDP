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
    <h1>${federation.name}</h1>
<p>${federation.address}</p>
<p>${federation.email}</p>
    <form action="/federation/${federation.id}" method="post">
        <button type="submit">Удалить</button>
    </form>
<h2>Школы</h2>
    <#list schools as s>
        ${s.name}
    </#list>
</body>
</html>