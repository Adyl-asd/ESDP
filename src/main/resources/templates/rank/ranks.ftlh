<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Разряды спортсмена">
    <div class="container">
        <#--Форма для добавления нового разряда-->
        <div class="card my-3">
            <div class="card-body">
                <form action="/ranks" method="post">
                    <div class="mb-3">
                        <label for="rankNameInput" class="form-label fs-4">Название нового разряда</label>
                        <input type="text" name="name" class="form-control" id="rankNameInput">
                    </div>
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </form>
            </div>
        </div>

        <div class="card my-3">
            <div class="card-body">
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
                        <#if r.isDel() == false>
                            <tr>
                                <th scope="row">${r?counter}</th>
                                <td>${r.name}</td>
                                <#--Форма для изменения текущего разряда-->
                                <td><a href="/ranks/${r.id}/update">Изменить</a></td>
                                <#--Форма удаления текущего разряда-->
                                <td>
                                    <form action="/ranks/${r.id}/delete" method="post">
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