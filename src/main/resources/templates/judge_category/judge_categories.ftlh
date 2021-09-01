<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Категории судей">
    <div class="container">
        <#--Форма для добавления новой категории-->
        <form action="" method="post">
            <div class="mb-3">
                <label for="categoryNameInput" class="form-label fs-4">Название новой категории</label>
                <input type="text" name="name" class="form-control" id="categoryNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
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
                <tr>
                    <th scope="row">${c.id}</th>
                    <td>${c.number}</td>
                    <#--Форма для изменения текущей категории-->
                    <td>
                        <form action="" method="post">
                            <button class="btn btn-primary">
                                Изменить
                            </button>
                        </form>
                    </td>
                    <#--Форма удаления текущей категории-->
                    <td>
                        <form action="" method="post">
                            <button class="btn btn-danger">
                                Удалить
                            </button>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>

    </div>
</@main.renderWith>