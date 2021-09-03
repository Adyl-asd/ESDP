<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменение категории судьи">
    <div class="container">
        <#--Форма для изменения категории-->
        <form action="/judge_categories/${category.id}/update" method="post">
            <div class="mb-3">
                <label for="categoryNameInput" class="form-label fs-4">Изменить категорию</label>
                <input type="number" name="number" class="form-control" value="${category.number}" id="categoryNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Изменить</button>
        </form>
    </div>
</@main.renderWith>