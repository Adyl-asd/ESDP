<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Соревновательные программы">
    <div class="container">
        <h1>Соревновательные программы</h1>
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