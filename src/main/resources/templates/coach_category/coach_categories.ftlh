<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Категории тренера">
    <div class="container">
        <#--Форма для добавления новой категории-->
        <div class="card my-3">
            <div class="card-body">
                <form action="/coach_categories" method="post">
                    <div class="mb-3">
                        <label for="categoryNameInput" class="form-label fs-4">Название новой категории</label>
                        <input type="text" name="name" class="form-control" id="categoryNameInput">
                    </div>
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Наименование категории</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list categories as c>
                        <#if c.isDel() == false>
                            <tr>
                                <th scope="row">${c.id}</th>
                                <td>${c.name}</td>
                                <#--Форма для изменения текущей категории-->
                                <td><a href="coach_categories/${c.id}/update" class="btn btn-primary">Изменить</a></td>
                                <#--Форма удаления текущей категории-->
                                <td>
                                    <form action="/coach_categories/${c.id}/delete" method="post">
                                        <button class="btn btn-danger">
                                            Удалить
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</@main.renderWith>