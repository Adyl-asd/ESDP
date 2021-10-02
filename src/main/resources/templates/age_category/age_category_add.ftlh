<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить возрастную категорию" scripts=["js/add_program.js"]>

    <div class="container">
        <div class="card my-3">
            <div class="main">
                <div class="row">
                    <div class="col">
                        <label for="discipline" class="form-label fs-5">Вид спорта</label>
                        <select name="disciplineId" id="discipline" class="form-select">
                            <option selected>Выберите вид спорта</option>
                            <#list disciplines as d>
                                <option value="${d.id}">${d.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
                <form id="second-form" method="post">
                    <div class="row">
                        <div class="col">
                            <label for="disciplineType" class="form-label">Дисциплина</label>
                            <select name="disciplineId" id="disciplineType" class="form-select">
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="minYear" class="form-label">Минимальный год</label>
                            <input type="number" name="minYear" class="form-control" id="minYear"
                            <#if dto?? && dto.minYear??> value="${dto.minYear}"</#if>>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="maxYear" class="form-label">Максимальный год</label>
                            <input type="number" name="maxYear" class="form-control" id="maxYear"
                                    <#if dto?? && dto.maxYear??> value="${dto.maxYear}"</#if>>
                        </div>
                    </div>
                    <div class="col">
                        <label for="rank" class="form-label fs-4">Разряд</label>
                        <select name="rankId" class="form-select" id="rank">
                            <option selected value="0">Выберите разряд участников</option>
                            <#list ranks as r>
                                <option value="${r.id}">${r.name}</option>
                            </#list>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Создать</button>
                </form>
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