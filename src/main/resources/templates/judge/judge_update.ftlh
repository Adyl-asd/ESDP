<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение данных судьи">
    <div class="container">

    <h1>Изменить тренера</h1>

    <form action="/judge/${judge.id}/update" method="post" enctype="multipart/form-data">

        <#--Выбор школы-->
        <div class="row">
            <div class="col">
                <label for="school" class="form-label fs-4">Школа</label>
                <select name="schoolId" class="form-select" id="school">
                    <option selected value="${judge.school.id}">${judge.school.name}</option>
                    <#list schools as s>
                        <option value="${s.id}">${s.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <#--Выбор дициплины и категории-->
        <div class="row">
            <div class="col">
                <label for="discipline" class="form-label fs-4">Дисциплина</label>
                <select name="disciplineId" class="form-select" id="discipline">
                    <option selected value="${judge.discipline.id}">${judge.discipline.name}</option>
                    <#list disciplines as d>
                        <option value="${d.id}">${d.name}</option>
                    </#list>
                </select>
            </div>
            <div class="col">
                <label for="category" class="form-label fs-4">Категория</label>
                <select name="categoryId" class="form-select" id="category">
                    <option selected value="${judge.category.id}">${judge.category.name}</option>
                    <#list categories as c>
                        <option value="${c.id}">${c.name}</option>
                    </#list>
                </select>
            </div>

        </div>


        <#--Файл категории-->
        <div class="row">
            <div class="col">
                <label for="categoryFile" class="form-label fs-4">Файл подтверждения категории</label>
                <input type="file" name="categoryFile" class="form-control" id="categoryFile">
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-1">Изменить</button>
    </form>
        <a href="/judge/${judge.id}/update" class="btn btn-secondary mt-1">Отменить</a>
    </div>

    <#if errors??>
        <#list errors as e>
            <h2>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</h2>
        </#list>
    <#elseif filesError??>
        <h2>${filesError}</h2>
    </#if>
</@main.renderWith>