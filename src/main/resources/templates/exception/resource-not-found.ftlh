<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Страница не найдена">
    <div class="container">
        <#if resource??>
            <h1 class="exception">${resource} с id ${id} не найден(-а, -о)</h1>
        <#elseif forbidden??>
            <h1 class="exception">${forbidden}</h1>
        </#if>
    </div>
</@main.renderWith>
