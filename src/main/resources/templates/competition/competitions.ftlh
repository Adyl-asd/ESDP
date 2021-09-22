<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Соревнования">
    <div class="container">

        <div class="card my-3">
            <div class="card-body">
                <form class="row g-3">
                    <div class="col-md-2">
                        <label for="inputCity" class="form-label">Город</label>
                        <input type="text" class="form-control" id="inputCity" placeholder="Город">
                    </div>
                    <div class="col-md-3">
                        <label for="inputDateFrom" class="form-label">Дата начала</label>
                        <input type="date" class="form-control" id="inputDateFrom" placeholder="Дата от">
                    </div>
                    <div class="col-md-3">
                        <label for="inputDateTo" class="form-label">Дата завершения</label>
                        <input type="date" class="form-control" id="inputDateTo" placeholder="Дата до">
                    </div>
                    <div class="col-md-4">
                        <label for="inputDiscipline" class="form-label">Дисциплина</label>
                        <select id="inputDiscipline" class="form-select">
                            <option>Выберите дисциплину</option>
                            <#list disciplines as d>
                                <option value="${d.name}">${d.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary mb-2">Поиск</button>
                    </div>
                </form>
            </div>
        </div>


        <div class="card">
            <div class="card-body">
                <table class="table text-uppercase text-center">
                    <thead>
                    <tr>
                        <th scope="col">Наименование</th>
                        <th scope="col">Дата начала</th>
                        <th scope="col">Дата завершения</th>
                        <th scope="col">Город</th>
                        <th scope="col">Вид спорта</th>
                        <th scope="col">Срок подачи заявки</th>
                        <th scope="col">Просмотр</th>
                        <th scope="col">Подать</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list competitions as c>
                        <#if !c.isDel()>
                            <tr class='clickable-row' data-href='/competitions/${c.id}'>
                                <th scope="row">${c.name}</th>
                                <td>${c.startDate}</td>
                                <td>${c.finishDate}</td>
                                <td>${c.city}</td>
                                <td>${c.discipline.name}</td>
                                <td>${c.participationDate}</td>
                                <td><a href="/competitions/${c.id}"><div class="btn btn-primary">Просмотр</div></a></td>
                                <td><a href="/competition/${c.id}/apply"><div class="btn btn-primary">Подать</div></a></td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</@main.renderWith>