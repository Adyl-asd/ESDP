<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${school.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>${school.name}</h4>
                                    <a href="/school/${school.id}/update" class="btn btn-primary">Изменить</a>
                                    <form action="/school/${school.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить школу</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    Номер
                                </h6>
                                <span class="text-secondary">${school.phone}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    E-mail
                                </h6>
                                <span class="text-secondary">${school.email}</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Адрес</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${school.address}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Директор</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${school.director}
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>

                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="d-flex align-items-center mb-3">Информация о ролях</h5>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-12 text-secondary str">
                                            <div>
                                                <h4>Спортсмены</h4>
                                                <div class="str-column">
                                                    <#list school.athletes as a>
                                                        <#if a.isDel() == false>
                                                            <p><a href="/athlete/${a.id}">${a.person.surname} ${a.person.name}</a></p>
                                                        </#if>
                                                    </#list>
                                                </div>
                                            </div>
                                            <div>
                                                <h4>Тренеры</h4>
                                                <div class="str-column">
                                                    <#list school.coaches as a>
                                                        <#if a.isDel() == false>
                                                            <p><a href="/coach/${a.id}">${a.person.surname} ${a.person.name}</a></p>
                                                        </#if>
                                                    </#list>
                                                </div>
                                            </div>
                                            <div>
                                                <h4 class="str-column">Судьи</h4>
                                                <#list school.judges as a>
                                                    <#if a.isDel() == false>
                                                        <p><a href="/judge/${a.id}">${a.person.surname} ${a.person.name}</a></p>
                                                    </#if>
                                                </#list>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.renderWith>