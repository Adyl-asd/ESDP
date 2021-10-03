<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение дисциплины">
    <div class="container">
        <h2>Изменить дисциплину "${discipline.name}"</h2>
        <#--Форма для изменения дисциплины-->
        <form action="/disciplines/${discipline.id}/update" method="post">
            <div class="mb-3">
                <label for="disciplineNameInput" class="form-label fs-4">Введите новое наименование</label>
                <input type="text" name="name" class="form-control" value="${discipline.name}" id="disciplineNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
        <a href="/disciplines/${discipline.id}/update" class="btn btn-secondary mt-1">Отменить</a>
    </div>
</@main.renderWith>