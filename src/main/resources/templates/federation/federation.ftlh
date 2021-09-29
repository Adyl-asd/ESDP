<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${federation.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>${federation.name}</h4>
                                    <a href="/school/${federation.id}/update" class="btn btn-primary">Изменить</a>
                                    <form action="/school/${federation.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить федерацию</button>
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
                                <span class="text-secondary">${federation.phone}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    E-mail
                                </h6>
                                <span class="text-secondary">${federation.email}</span>
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
                                    ${federation.address}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Директор</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${federation.director}
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>

                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="d-flex align-items-center mb-3">Школы</h5>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-12 text-secondary str">
                                            <h4>Школы</h4>
                                            <div class="str-column">
                                                <#list federation.schools as s>
                                                    <#if s.isDel() == false>
                                                        <p><a href="/school/${s.id}">${s.name}</a></p>
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