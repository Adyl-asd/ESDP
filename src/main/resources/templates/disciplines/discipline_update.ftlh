<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение дисциплины">
    <div class="container">
        <#--Форма для изменения дисциплины-->
        <form action="/disciplines/${discipline.id}/update" method="post">
            <div class="mb-3">
                <label for="disciplineNameInput" class="form-label fs-4">Изменить категорию</label>
                <input type="text" name="name" class="form-control" value="${discipline.name}" id="disciplineNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
    </div>
</@main.renderWith>