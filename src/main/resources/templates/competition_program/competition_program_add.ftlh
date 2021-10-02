<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить соревнование" scripts=["js/add_program.js"]>

    <div class="container">
        <div class="card my-3">
            <div class="main">
                <div class="row">
                    <div class="col">
                        <label for="discipline" class="form-label fs-5">Вид спорта</label>
                        <select name="disciplineId" id="discipline" class="form-select">
                            <option selected value="">Выберите вид спорта</option>
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
                            <select name="disciplineTypeId" id="disciplineType" class="form-select">
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="name" class="form-label">Наименование</label>
                            <input type="text" name="name" class="form-control" id="name">
                        </div>
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
    </#if>

</@main.renderWith>