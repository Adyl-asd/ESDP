<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Персоны" scripts=["js/person.js"]>
    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <form class="row g-3" id="filter">
                    <div class="col-md-5">
                        <label for="inputSurname" class="form-label"></label>
                        <input type="text" name="surname" class="form-control" id="inputSurname" placeholder="Фамилия">
                    </div>
                    <div class="col-md-5">
                        <label for="inputName" class="form-label"></label>
                        <input type="text" name="name" class="form-control" id="inputName" placeholder="Имя">
                    </div>
                    <div class="col-md-5">
                        <label for="inputIin" class="form-label"></label>
                        <input type="text" name="iin" class="form-control" id="inputIin" placeholder="ИИН">
                    </div>
                    <#--Нужно добавить список городов-->
                    <div class="col-md-4">
                        <label for="inputCity" class="form-label"></label>
                        <input type="text" name="city" class="form-control" id="inputSurname" placeholder="Город">
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
                        <th scope="col">ИИН</th>
                        <th scope="col">Город</th>
                        <th scope="col">Пол</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list persons as a>
                        <tr class='clickable-row' data-href='/person/${a.id}'>
                            <th scope="row">${a.id}</th>
                            <td>${a.surname}</td>
                            <td>${a.name}</td>
                            <td>${a.iin}</td>
                            <td>${a.city}</td>
                            <td>${a.gender}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</@main.renderWith>