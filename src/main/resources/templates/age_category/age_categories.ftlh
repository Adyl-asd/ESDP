<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Возрастные категории">
    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <form class="row g-3" id="filter">
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

        <h1>Возрастные категории</h1>
        <a href="/age_category" class="btn btn-primary">Добавить возрастную категорию</a>
        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Минимальный возраст</th>
                        <th scope="col">Максимальный возраст</th>
                        <th scope="col">Разраяд</th>
                        <th scope="col">Дисциплина</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list disciplines as d>
                        <#if !d.isDel()>
                            <#list categories as c>
                                <#if !c.isDel() && c.discipline.name == d.name>
                                    <tr class='clickable-row' data-href='/age_category/${c.id}'>
                                        <th scope="row">${c.id}</th>
                                        <td><#if c.minYear??>#{c.minYear}</#if></td>
                                        <td><#if c.maxYear??>#{c.maxYear}</#if></td>
                                        <td><#if c.rank??>${c.rank.name}</#if></td>
                                        <td>${d.name}</td>
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