<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Спортсмены">
    <div class="container">

        <div class="card my-3">
            <div class="card-body">
                <form class="row g-3">
                    <div class="col-md-2">
                        <label for="inputId" class="form-label"></label>
                        <input type="text" class="form-control" id="inputId" placeholder="ID">
                    </div>
                    <div class="col-md-5">
                        <label for="inputSurname" class="form-label"></label>
                        <input type="text" class="form-control" id="inputSurname" placeholder="Фамилия">
                    </div>
                    <div class="col-md-5">
                        <label for="inputName" class="form-label"></label>
                        <input type="text" class="form-control" id="inputName" placeholder="Имя">
                    </div>
                    <div class="col-md-4">
                        <label for="inputDiscipline" class="form-label"></label>
                        <select id="inputDiscipline" class="form-select">
                            <option>Выберите дисциплину</option>
                            <#list disciplines as d>
                                <option value="${d.name}">${d.name}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label for="inputCategory" class="form-label"></label>
                        <select id="inputCategory" class="form-select">
                            <option selected>Выберите разряд</option>
                            <#list ranks as r>
                                <option value="${r.name}">${r.name}</option>
                            </#list>
                        </select>
                    </div>
                    <#--Нужно добавить список городов-->
                    <div class="col-md-4">
                        <label for="inputCity" class="form-label"></label>
                        <select id="inputCity" class="form-select">
                            <option selected>Выберите город</option>
                            <option>Алматы</option>
                            <option>Нур-Султан</option>
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
                        <th scope="col">ID</th>
                        <th scope="col">Фамлилия</th>
                        <th scope="col">Имя</th>
                        <th scope="col">Дисцплина</th>
                        <th scope="col">Город</th>
                        <th scope="col">Пол</th>
                        <th scope="col">Категория</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list athletes as a>
                        <#if !a.isDel()>
                            <tr class='clickable-row' data-href='/athlete/${a.id}'>
                                <th scope="row">${a.id}</th>
                                <td>${a.person.surname}</td>
                                <td>${a.person.name}</td>
                                <td>${a.discipline.name}</td>
                                <td>${a.person.city}</td>
                                <td>${a.person.gender}</td>
                                <td>${a.rank.name}</td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</@main.renderWith>