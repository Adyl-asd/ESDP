<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${athlete.person.name}" styles=["css/athlete.css"]>

    <div class="container">
        <div class="main-body">

            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <img src="/person/photo/${athlete.person.photo.filePath}" alt="Admin"
                                     class="rounded-circle" width="150">
                                <div class="mt-3">
                                    <h4>${athlete.person.surname} ${athlete.person.name}</h4>
                                    <p class="text-secondary mb-1">${athlete.person.phone}</p>
                                    <p class="text-muted font-size-sm">${athlete.person.email}</p>
                                    <p class="text-muted font-size-sm">Статус: ${athlete.status}</p>

                                    <a href="/athlete/${athlete.id}/update" class="btn btn-primary">Изменить
                                        профиль спортсмена</a>
                                    <a href="/athlete/${athlete.id}/export" class="btn btn-primary mt-2">Данные в ПДФ</a>

                                    <form action="/athlete/${athlete.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить спортсмена</button>
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
                                    <a href="/athlete/file/${athlete.registryFile}" class="link-dark">Подтверждение регистрации спортсмена</a>
                                </h6>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <a href="/athlete/file/${athlete.medicalFile}" class="link-dark">Прохождение медосмотра</a>
                                </h6>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <a href="/athlete/file/${athlete.dopingFile}" class="link-dark">Прохождение допинга</a>
                                </h6>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0">
                                    <a href="/athlete/file/${athlete.rankFile}" class="link-dark">Подтверждение разряда спортсмена</a>
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
                                    ${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">ИИН</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${athlete.person.iin}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Пол</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${athlete.person.gender}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Дата рождения</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${athlete.person.birthday}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Место учебы/работы</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${athlete.person.education}
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h4 class="d-flex align-items-center mb-3">Карточка спортсмена</h4>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Дисциплина</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${athlete.discipline.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Разряд</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${athlete.rank.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Спортивная школа (клуб)</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${athlete.school.name}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Дата регистрации спортсмена</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${athlete.registryDate}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Разряд</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${athlete.rank.name}
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Членство в сборных</h6>
                                        </div>
                                        <#if athlete.isNationalTeam()>
                                            <div class="col-sm-9 text-secondary">
                                                <h6 class="mb-0">Член национальной сборной</h6>
                                            </div>
                                        <#elseif athlete.isCityTeam()>
                                            <div class="col-sm-9 text-secondary">
                                                <h6 class="mb-0">Член сборной города</h6>
                                            </div>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="d-flex align-items-center mb-3">Информация о тренерах</h5>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
<#--                                            <h6 class="mb-0">Дата начала - дата окончания</h6>-->
<#--                                            <#list dates as d>-->
<#--                                                <p>${d.registerDate} - <#if d.finishDate??>${d.finishDate}</#if></p>-->
<#--                                                <a href="/coach/${d.coach.id}">${d.coach.person.name} ${d.coach.person.surname}</a>-->
<#--                                                <form action="/athlete/${athlete.id}/coach/${d.coach.id}/delete" method="post">-->
<#--                                                    <button class="btn btn-danger mt-1">Удалить тренера</button>-->
<#--                                                </form>-->
<#--                                            </#list>-->
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <#if coaches??>
                                                <#list coaches as c>
                                                    <#if !c.isDel()>
                                                        <a href="/coach/${c.id}">${c.person.name} ${c.person.surname}</a>
                                                        <form action="/athlete/${athlete.id}/coach/${c.id}/delete" method="post">
                                                            <button class="btn btn-danger mt-1">Удалить тренера</button>
                                                        </form>
                                                    </#if>
                                                </#list>
                                            </#if>
                                            <a href="/athlete/${athlete.id}/coach"><div class="btn btn-primary">Добавить тренера</div></a>
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h5 class="d-flex align-items-center mb-3">Результаты, достигнутые на
                                        соревнованиях</h5>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-2">
                                            <h6 class="mb-0">Дата</h6>
                                        </div>
                                        <div class="col-sm-2">
                                            <h6 class="mb-0">Место проведения</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            Название соревнования
                                        </div>
                                        <div class="col-sm-4">
                                            Результат
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <#--Метод для подвтерждения регистрации спортсмена-->
            <#if athlete.status == "На_рассмотрении">
                <form action="/athlete/${athlete.id}/confirm" method="post">
                    <button type="submit" class="btn btn-primary mt-1">Подтвердить регистрацию</button>
                </form>
            <#elseif athlete.status == "Истек" || athlete.status == "Неактивный">
                <a href="/athlete/${athlete.id}/register"><button type="button" class="btn btn-primary mt-1">Продлить регистрацию</button></a>
            </#if>

        </div>
    </div>
</@main.renderWith>