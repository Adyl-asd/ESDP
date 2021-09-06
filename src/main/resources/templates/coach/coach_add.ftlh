<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить тренера">
    <div class="container">

    <h1>Добавить тренера</h1>

    <form action="/coach" method="post" enctype="multipart/form-data">

        <#--Выбор человека и школы-->
        <div class="row">
            <div class="col">
                <label for="person" class="form-label fs-4">Персона</label>
                <select name="personId" class="form-select" id="person">
                    <option selected>Выберите человека</option>
                    <#list persons as p>
                        <option value="${p.id}">${p.surname} ${p.name} ${p.iin}</option>
                    </#list>
                </select>
            </div>
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

        <#--Выбор дициплины и категории-->
        <div class="row">
            <div class="col">
                <label for="discipline" class="form-label fs-4">Дисциплина</label>
                <select name="disciplineId" class="form-select" id="discipline">
                    <option selected>Выберите дисциплину</option>
                    <#list disciplines as d>
                        <option value="${d.id}">${d.name}</option>
                    </#list>
                </select>
            </div>
            <div class="col">
                <label for="category" class="form-label fs-4">Категория</label>
                <select name="categoryId" class="form-select" id="category">
                    <option selected>Выберите категорию</option>
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

        <button type="submit" class="btn btn-primary mt-1">Добавить</button>
    </form>
    </div>

    <#if errors??>
        <#list errors as e>
            <h2>${e}</h2>
        </#list>
    <#elseif fileError??>
        <h2>${fileError}</h2>
    </#if>
</@main.renderWith>