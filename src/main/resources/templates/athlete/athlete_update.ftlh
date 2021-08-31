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
    <form action="/athlete/${athlete.id}/update" method="post" enctype="multipart/form-data">
        <label for="">
            Школа
            <select name="schoolId" id="school">
                <#list schools as s>
                    <option value="${s.id}">${s.name}</option>
                </#list>
            </select>
        </label>
        <label for="">Дата регистрации спортсмена
            <input type="date" name="registryDate">
        </label>
        <label for="">Файл, подтверждающий регистрацию спортсмена
            <input type="file" name="registryFile">
        </label>
        <label for="">Файл медосмотра
            <input type="file" name="medicalFile">
        </label>
        <label for="">Файл о прохождении допинга
            <input type="file" name="dopingFile">
        </label>
        <label for="">
            Дисциплина
            <select name="disciplineId" id="discipline">
                <#list disciplines as d>
                    <option value="${d.id}">${d.name}</option>
                </#list>
            </select>
        </label>
        <label for="">
            Разряд
            <select name="rankId" id="rank">
                <#list ranks as r>
                    <option value="${r.id}">${r.name}</option>
                </#list>
            </select>
        </label>
        <label for="">Файл, подтверждающий разряд
            <input type="file" name="rankFile">
        </label>
        <button type="submit">Создать</button>
    </form>
    <#if errors??>
        <#list errors as e>
            <h2>${e}</h2>
        </#list>
    </#if>
</body>
</html>