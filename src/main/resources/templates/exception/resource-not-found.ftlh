<#--<#import "base.ftlh" as base>-->
<#--<#assign custom_css>-->
<#--    <link rel="stylesheet" href="/css/categories.css">-->
<#--</#assign>-->

<#--<@base.layout custom_css=custom_css>-->
    <#if resource??>
        <h1>${resource} с id ${id} не найден(-а)</h1>
    <#elseif forbidden??>
        <h1>${forbidden}</h1>
    </#if>
    <a href="/login" class="menu-link">Логин</a>
<#--</@base.layout>-->