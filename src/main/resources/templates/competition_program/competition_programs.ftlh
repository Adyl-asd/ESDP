<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Соревновательные программы">
    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <form class="row g-3" id="filter">
                    <div class="col-md-5">
                        <label for="inputName" class="form-label"></label>
                        <input type="text" name="name" class="form-control" id="inputName" placeholder="Наименование">
                    </div>
                    <#--Нужно добавить список городов-->
                    <div class="col-md-4">
                        <label for="discipline" class="form-label fs-4"></label>
                        <select name="disciplineId" class="form-select" id="discipline">
                            <option selected>Выберите дисциплину</option>
                            <#list disciplines as d>
                                <option value="${d.id}">${d.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary mb-2">Поиск</button>
                    </div>
                </form>
            </div>
        </div>

        <h1>Соревновательные программы</h1>
        <a href="/competition_program" class="btn btn-primary">Добавить соревновательную программу</a>
        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Наименование программы</th>
                        <th scope="col">Вид спорта</th>
                        <th scope="col">Дисциплина</th>
                        <th scope="col">Пол</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list disciplines as d>
                        <#if !d.isDel()>
                            <#list programs as p>
                                <#if !p.isDel() && p.discipline.name == d.name>
                                    <tr class='clickable-row' data-href='/competition_program/${p.id}'>
                                        <th scope="row">${p.id}</th>
                                        <td>${p.name}</td>
                                        <td>${d.discipline.name}</td>
                                        <td>${p.name}</td>
                                        <td>${d.gender.name}</td>
                                    </tr>
                                </#if>
                            </#list>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>


    </div>
</@main.renderWith>