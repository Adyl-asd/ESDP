<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение категории судьи">
    <div class="container">
        <h2>Изменить категорию "${category.name}"</h2>
        <#--Форма для изменения категории-->
        <form action="/judge_categories/${category.id}/update" method="post">
            <div class="mb-3">
                <label for="categoryNameInput" class="form-label fs-4">Введите новое наименование</label>
                <input type="text" name="name" class="form-control" value="${category.name}" id="categoryNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
    </div>
</@main.renderWith>