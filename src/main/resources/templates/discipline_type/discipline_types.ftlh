<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Дисциплины">
    <div class="container">
        <h1>Дисциплины</h1>
        <a class="btn btn-primary" href="/discipline_type/add">Добавить дисциплину</a>
        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Наименование дисциплины</th>
                        <th scope="col">Вид спорта</th>
                        <th scope="col">Пол</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list disciplines as d>
                        <#if !d.isDel()>
                            <#list discipline_types as t>
                                <#if !t.isDel() && t.discipline.name == d.name>
                                    <tr class='clickable-row' data-href='/discipline_type/${t.id}'>
                                        <th scope="row">${t.id}</th>
                                        <td>${t.name}</td>
                                        <td>${d.name}</td>
                                        <td>${t.gender.name}</td>
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