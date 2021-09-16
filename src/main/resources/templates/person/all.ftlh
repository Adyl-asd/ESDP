<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Персоны">
    <div class="container">

        <div class="card">
            <div class="card-body">
                <table class="table text-uppercase text-center">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Фамлилия</th>
                        <th scope="col">Имя</th>
                        <th scope="col">ИИН</th>
                        <th scope="col">Город</th>
                        <th scope="col">Пол</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list persons as a>
                        <tr class='clickable-row' data-href='/person/${a.id}'>
                            <th scope="row">${a.id}</th>
                            <td>${a.surname}</td>
                            <td>${a.name}</td>
                            <td>${a.iin}</td>
                            <td>${a.city}</td>
                            <td>${a.gender}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</@main.renderWith>