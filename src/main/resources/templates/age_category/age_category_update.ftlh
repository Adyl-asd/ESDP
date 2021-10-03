<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменить возрастную категорию" scripts=["js/add_program.js"]>

    <div class="container">
        <div class="card my-3">
            <div class="main">
                <div class="row">
                    <div class="col">
                        <label for="discipline" class="form-label fs-5">Вид спорта</label>
                        <select name="disciplineId" id="discipline" class="form-select">
                            <option selected value="${category.discipline.discipline.id}">${category.discipline.discipline.name}</option>
                            <#list disciplines as d>
                                <option value="${d.id}">${d.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <form action="/age_category/${category.id}/update" method="post">
                    <div class="row">
                        <div class="col">
                            <label for="disciplineType" class="form-label">Дисциплина</label>
                            <select name="disciplineId" id="disciplineType" class="form-select">
                                <option selected value="${category.discipline.id}">${category.discipline.name}</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="minYear" class="form-label">Минимальный год</label>
                            <input type="number" name="minYear" class="form-control" id="minYear"
                                    <#if category.minYear??> value="#{category.minYear}"</#if>>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="maxYear" class="form-label">Максимальный год</label>
                            <input type="number" name="maxYear" class="form-control" id="maxYear"
                                    <#if category.maxYear??> value="#{category.maxYear}"</#if>>
                        </div>
                    </div>
                    <div class="col">
                        <label for="rank" class="form-label fs-4">Разряд</label>
                        <select name="rankId" class="form-select" id="rank">
                            <#if category.rank??>
                                <option selected value="${category.rank.id}">${category.rank.name}</option>
                            <#else>
                                <option selected value="0">Выберите разряд участников</option>
                            </#if>
                            <#list ranks as r>
                                <option value="${r.id}">${r.name}</option>
                            </#list>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Изменить</button>
                </form>
                <a href="/age_category/${category.id}/update" class="btn btn-secondary">Отменить</a>
            </div>
        </div>
    </div>

    <#if errors??>
        <#list errors as e>
            <h2>$${e.field} - ${e.defaultMessage!'__no message__'}</h2>
        </#list>
    <#elseif yearError??>
        <h2>${yearError}</h2>
    </#if>

</@main.renderWith>