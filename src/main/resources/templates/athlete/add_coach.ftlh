<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить спортсмена">
    <div class="container">

    <h1>Добавить тренера для спортсмена ${athlete.person.surname} ${athlete.person.name}</h1>

    <form action="/athlete/${athlete.id}/coach" method="post">

        <#--Выбор тренера-->
        <div class="row">
            <div class="col">
                <label for="coach" class="form-label fs-4">Тренер</label>
                <select name="coachId" class="form-select" id="coach">
                    <option selected>Выберите тренера</option>
                    <#list coaches as c>
                        <option value="${c.id}">${c.person.surname} ${c.person.name} ${c.person.iin}</option>
                    </#list>
                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-1">Добавить</button>
    </form>
    </div>

    <#if errors??>
        <#list errors as e>
            <h2>${e}</h2>
        </#list>
    <#elseif fileError??>
        <h2>${fileError}</h2>
    </#if>
</@main.renderWith>