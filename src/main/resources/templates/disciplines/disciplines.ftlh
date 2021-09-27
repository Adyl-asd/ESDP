<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Дисциплины">
    <div class="container">
        <#--Форма для добавления новой дисциплины-->
        <div class="card my-3">
            <div class="card-body">
                <form action="/disciplines" method="post">
                    <div class="mb-3">
                        <label for="disciplineNameInput" class="form-label fs-4">Название новой дисциплины</label>
                        <input type="text" name="name" class="form-control" id="disciplineNameInput">
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
                        <th scope="col">Наименование дисциплины</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list disciplines as d>
                        <#if !d.isDel()>
                            <tr>
                                <th scope="row">${d.id}</th>
                                <td>${d.name}</td>
                                <#--Форма для изменения текущей дисциплины-->
                                <td><a href="/disciplines/${d.id}/update" class="btn btn-primary">Изменить</a></td>
                                <#--Форма удаления текущей дисциплины-->
                                <td>
                                    <form action="/disciplines/${d.id}/delete" method="post">
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