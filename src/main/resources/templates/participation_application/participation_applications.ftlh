<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Заявки на участие в соревновании">
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h4>Все заявки от школ на соревнование ${competition.name}</h4>
                <p>Крайняя дата подачи заявки - ${competition.participationDate}</p>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <table class="table text-uppercase text-center">
                    <thead>
                    <tr>
                        <th scope="col">Школа</th>
                        <th scope="col">Просмотр</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list applications as application>
                        <tr>
                            <td>${application.school.name}</td>
                            <td><a href="/competition/${competition.id}/all/${application.id}" class="btn btn-primary">Просмотр</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@main.renderWith>