<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${coach.person.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">

            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <img src="/person/photo/${coach.person.photo.filePath}" alt="Admin"
                                     class="rounded-circle" width="150">
                                <div class="mt-3">
                                    <h4>${coach.person.surname} ${coach.person.name}</h4>
                                    <p class="text-secondary mb-1">${coach.person.phone}</p>
                                    <p class="text-muted font-size-sm">${coach.person.email}</p>

                                    <a href="/coach/${coach.id}/update" class="btn btn-primary">Изменить
                                        профиль тренера</a>

                                    <form action="/coach/${coach.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить тренера</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-3">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round"
                                         class="feather feather-instagram mr-2 icon-inline text-danger">
                                        <rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect>
                                        <path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path>
                                        <line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line>
                                    </svg>
                                    Instagram
                                </h6>
                                <span class="text-secondary">@instagram</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round"
                                         class="feather feather-facebook mr-2 icon-inline text-primary">
                                        <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path>
                                    </svg>
                                    Facebook
                                </h6>
                                <span class="text-secondary">@facebook</span>
                            </li>
                        </ul>
                    </div>
                    <div class="card mt-3">
                        <h5 class="mx-2">Прикрепленные документы</h5>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <a href="/coach/file/${coach.categoryFile}" class="link-dark">Подтверждение категории тренера</a>
                                </h6>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">ФИО</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${coach.person.surname} ${coach.person.name} ${coach.person.middleName}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">ИИН</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${coach.person.iin}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Пол</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${coach.person.gender}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Дата рождения</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${coach.person.birthday}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Место учебы/работы</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${coach.person.education}
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h4 class="d-flex align-items-center mb-3">Карточка тренера</h4>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Дисциплина</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${coach.discipline.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Разряд</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${coach.category.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Спортивная школа (клуб)</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${coach.school.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="d-flex align-items-center mb-3">Информация о тренируемых</h5>
                                    <hr>
                                    <div class="row">
                                        <#list coach.athletes as a>
                                            <div class="col-sm-9 text-secondary">
                                                <a href="/athlete/${a.id}">${a.person.surname} ${a.person.name}</a>
                                            </div>
                                        </#list>
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