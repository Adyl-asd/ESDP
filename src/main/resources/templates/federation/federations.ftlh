<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Федерации">
    <div class="container">
        <#--Форма для добавления новой дисциплины-->
        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Наименование</th>
                        <th scope="col">Адрес</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list federations as s>
                        <#if !s.isDel()>
                            <tr class='clickable-row' data-href='/federation/${s.id}'>
                                <td>${s.id}</td>
                                <td>${s.name}</td>
                                <td>${s.address}</td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>


    </div>
</@main.renderWith>