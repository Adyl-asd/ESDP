<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить спортсмена">
    <div class="container">

    <h1>Продлить регистрацию спортсмена ${athlete.person.surname} ${athlete.person.name} ${athlete.person.iin}</h1>

    <form action="/athlete/${athlete.id}/register" method="post" enctype="multipart/form-data">

        <#--Выбор человека и школы-->
        <div class="row">
            <div class="col">
                <label for="school" class="form-label fs-4">Школа</label>
                <select name="schoolId" class="form-select" id="school">
                    <option selected>Выберите школу</option>
                    <#list schools as s>
                        <option value="${s.id}">${s.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <#--Выбор дициплины и разряда-->
        <div class="row">
            <p>Дисциплина ${athlete.discipline}</p>
            <div class="col">
                <label for="rank" class="form-label fs-4">Разряд</label>
                <select name="rankId" class="form-select" id="rank">
                    <option selected>Выберите разряд</option>
                    <#list ranks as r>
                        <option value="${r.id}">${r.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <#--Файл допинга, файл разряда, файл медосмотра-->
        <div class="row">
            <div class="col">
                <label for="dopingFile" class="form-label fs-4">Файл о прохождении допинга</label>
                <input type="file" name="dopingFile" class="form-control" id="dopingFile">
            </div>
            <div class="col">
                <label for="rankFile" class="form-label fs-4">Файл подтверждения разряда</label>
                <input type="file" name="rankFile" class="form-control" id="rankFile">
            </div>
            <div class="col">
                <label for="medicalFile" class="form-label fs-4">Файл медосмотра</label>
                <input type="file" name="medicalFile" class="form-control" id="medicalFile">
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-1">Добавить</button>
    </form>

    <#if errors??>
        <#list errors as fieldError>
            <h2>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</h2>
        </#list>
    <#elseif filesError??>
        <h2>${filesError}</h2>
    </#if>
</@main.renderWith>