<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Подать заявку на участие в соревновании" scripts=["js/participation_application_add.js"]>

    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <h3>${competition.name}</h3>
                <hr>
                <h4>${competition.discipline.name}</h4>
                <hr>
                <div class="row">
                    <div class="col-sm-3">
                        <h6 class="mb-0">Даты</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${competition.startDate} - ${competition.finishDate}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm-3">
                        <h6 class="mb-0">Крайняя дата подачи заявки</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${competition.participationDate}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm-3">
                        <h6 class="mb-0">Место проведения</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        г. ${competition.city}, ${competition.address}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm-3">
                        <h6 class="mb-0">Контактное лицо</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${competition.contact} (${competition.phone})
                    </div>
                </div>
                <hr>
            </div>
        </div>
        <#list disciplineTypes as disciplineType>
            <div class="card mb-3">
                <div class="card-body">
                    <h5>${disciplineType.discipline.name}</h5>
                    <hr>
                    <ul class="list-group">
                        <#list programs as program>
                            <#if program.discipline.id = disciplineType.discipline.id>
                                <li class="list-group-item">${program.competitionProgram.name}</li>
                            </#if>
                        </#list>
                    </ul>
                    <#list ageCategories as a>
                        <#if a.discipline.id = disciplineType.discipline.id>
                            <div class="my-3 fs-6"><b>
                                    <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                        <input type="hidden"
                                               value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                        : ${a.ageCategory.rank.name}
                                    <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                        <input type="hidden"
                                               value="${a.ageCategory.id}">Младше ${a.ageCategory.maxYear} : ${a.ageCategory.rank.name}
                                    <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                        <input type="hidden"
                                               value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                    <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                        <input type="hidden"
                                               value="${a.ageCategory.id}">Старше ${a.ageCategory.minYear} : ${a.ageCategory.rank.name}
                                    <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                        <input type="hidden" value="${a.ageCategory.id}">Старше ${a.ageCategory.minYear}
                                    <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                        <input type="hidden" value="${a.ageCategory.id}">Младше ${a.ageCategory.maxYear}
                                    <#elseif !a.ageCategory.maxYear?? !&& a.ageCategory.minYear?? && a.ageCategory.rank??>
                                        <input type="hidden" value="${a.ageCategory.id}">${a.ageCategory.rank.name}
                                    </#if>
                                </b></div>
                            <ul class="list-group" id="athlete-ul">
                                <#if (a.teamChampionship!=0) && (a.maxTeams??)>
                                    <#assign x=a.maxTeams>
                                    <#list 1..x as i>
                                        <li class="list-group-item d-flex justify-content-between align-items-start">
                                            <div class="ms-2 me-auto">
                                                <div class="fw-bold">Команда №${i}</div>
                                                <#list 1..3 as j>
                                                    <div class="row my-2">
                                                        <div class="col text-end">
                                                            <label for="selectAthlete" class="mt-1">${j}.</label>
                                                        </div>
                                                        <div class="col-auto">
                                                            <select class="form-select"
                                                                    aria-label="Default select example"
                                                                    id="selectAthlete">
                                                                <option selected>Выбрать спортсмена</option>
                                                                <#list athletes as athlete>
                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                </#list>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </#list>
                                            </div>
                                        </li>
                                    </#list>
                                <#else>
                                    <#if a.maxAthletes??>
                                        <#assign y=a.maxAthletes>
                                        <#list 1..y as j>
                                            <li class="list-group-item d-flex justify-content-between align-items-start">
                                                <div class="row my-2">
                                                    <div class="col text-end">
                                                        <label for="selectAthlete" class="mt-1">${j}.</label>
                                                    </div>
                                                    <div class="col-auto">
                                                        <select class="form-select"
                                                                aria-label="Default select example"
                                                                id="selectAthlete">
                                                            <option selected>Выбрать спортсмена</option>
                                                            <#list athletes as athlete>
                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                            </#list>
                                                        </select>
                                                    </div>
                                                </div>
                                            </li>
                                        </#list>
                                    </#if>
                                </#if>
                            </ul>
                            <div class="additional-athletes-div my-3">
                                <b class="additional-athletes-text" hidden>Доп. спортсмены</b>
                                <ul class="list-group additional-athletes-ul">

                                </ul>
                                <div>
                                    <button class="btn btn-primary add-additional-athlete-btn">Добавить</button>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
            </div>
        </#list>
        <div class="card mb-3">
            <div class="card-body">
                <div class="fs-6"><b>Тренеры</b></div>
                <ul class="list-group my-2">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="row my-2">
                            <div class="col">
                                <select class="form-select"
                                        aria-label="Default select example"
                                        id="selectCoach">
                                    <option selected>Выбрать тренера</option>
                                    <#list coaches as coach>
                                        <option value="${coach.id}">${coach.person.surname} ${coach.person.name} ${coach.person.middleName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>
                <div>
                    <button class="btn btn-primary" id="add-additional-coach-btn">Добавить</button>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <div class="fs-6"><b>Судьи</b></div>
                <ul class="list-group">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="row my-2">
                            <div class="col">
                                <select class="form-select"
                                        aria-label="Default select example"
                                        id="selectJudge">
                                    <option selected>Выбрать судью</option>
                                    <#list judges as judge>
                                        <option value="${judge.id}">${judge.person.surname} ${judge.person.name} ${judge.person.middleName}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>
                <div>
                    <button class="btn btn-primary" id="add-additional-judge-btn">Добавить</button>
                </div>
            </div>
        </div>
        <button class="btn btn-primary">Отправить заявку</button>
    </div>

</@main.renderWith>