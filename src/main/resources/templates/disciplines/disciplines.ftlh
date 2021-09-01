<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Федерация Гимнастики">
    <div class="container">
        <#--        Форма для добавления новой дисциплины-->
        <form action="" method="post">
            <div class="mb-3">
                <label for="disciplineNameInput" class="form-label">Название новой дисциплины</label>
                <input type="text" name="name" class="form-control" id="disciplineNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Наименование дисциплины</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list disciplines as d>
                <tr>
                    <th scope="row">${d.id}</th>
                    <td>${d.name}</td>
                    <#--                    Форма для изменения одной дисциплины-->
                    <td>
                        <form action="" method="post">
                            <button class="btn btn-primary">
                                Изменить
                            </button>
                        </form>
                    </td>
                    <#--                    Форма удаления одной дисциплины-->
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