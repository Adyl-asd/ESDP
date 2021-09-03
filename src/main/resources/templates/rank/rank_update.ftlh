<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение разряда спортсмена">
    <div class="container">
        <#--Форма для изменения разряда-->
        <form action="/ranks/${rank.id}/update" method="post">
            <div class="mb-3">
                <label for="rankNameInput" class="form-label fs-4">Изменить разряд</label>
                <input type="text" name="name" class="form-control" value="${rank.name}" id="rankNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
    </div>
</@main.renderWith>