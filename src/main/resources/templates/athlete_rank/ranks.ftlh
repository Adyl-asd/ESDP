<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Разряды спортсменов">
    <div class="container">
        <#--Форма для добавления нового разряда-->
        <form action="" method="post">
            <div class="mb-3">
                <label for="categoryNameInput" class="form-label fs-4">Название нового разряда</label>
                <input type="text" name="name" class="form-control" id="categoryNameInput">
            </div>
            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Наименование разряда</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <#list ranks as r>
                <tr>
                    <th scope="row">${r.id}</th>
                    <td>${r.name}</td>
                    <#--Форма для изменения текущего разряда-->
                    <td>
                        <form action="" method="post">
                            <button class="btn btn-primary">
                                Изменить
                            </button>
                        </form>
                    </td>
                    <#--Форма удаления текущего разряда-->
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