<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Подать заявку на участие в соревновании">

    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3>${competition.name}</h3>
                <h4>${competition.discipline.name}</h4>
                <#list disciplineTypes as disciplineType>
                    <h5>${disciplineType.discipline.name}</h5>
                </#list>
            </div>
        </div>
    </div>

</@main.renderWith>