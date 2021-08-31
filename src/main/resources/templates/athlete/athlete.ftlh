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
    <img src="/person/photo/${athlete.person.photo.filePath}" alt="">
    <h1>${athlete.person.name}</h1>
    <p>${athlete.discipline}</p>
    <p>${athlete.rank}</p>
    <form action="/athlete/${athlete.id}" method="post">
        <button type="submit">Удалить</button>
    </form>
</body>
</html>