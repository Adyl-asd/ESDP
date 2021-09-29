<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Заявка на участие">
    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <h3>${competition.name}</h3>
                <hr>
                <h4>${competition.discipline.name}</h4>
                <input type="hidden" value="${competition.discipline.id}" id="discipline-id">
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
                        <h6 class="mb-0">Место проведения</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        г. ${competition.city}, ${competition.address}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-sm-3">
                        <h6 class="mb-0">Уровень</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${competition.level}
                    </div>
                </div>
                <hr>
                <#--                <div>-->
                <#--                    <select class="form-select" id="select-school" aria-label="Default select example">-->
                <#--                        <option selected>Выберите школу</option>-->
                <#--                        <#list schools as school>-->
                <#--                            <option value="${school.id}">${school.name}</option>-->
                <#--                        </#list>-->
                <#--                    </select>-->
                <#--                </div>-->
            </div>
        </div>
        <#list disciplineTypes as disciplineType>
            <div class="discipline-type-div card mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <h5>${disciplineType.discipline.name}</h5>
                            <input type="hidden" value="${disciplineType.discipline.id}" class="discipline-type-id">
                        </div>
                        <div class="col">
                            <button class="toggle-btn btn btn-primary">Свернуть</button>
                        </div>
                    </div>

                    <hr>
                    <div class="toggle-div">
                        <#list ageCategories as a>
                            <#if a.discipline.id = disciplineType.discipline.id>
                                <div class="age-category-div">
                                    <div class="my-3 fs-6"><b>
                                            <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                                : ${a.ageCategory.rank.name}
                                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">Младше ${a.ageCategory.maxYear} : ${a.ageCategory.rank.name}
                                            <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">Старше ${a.ageCategory.minYear} : ${a.ageCategory.rank.name}
                                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">Старше ${a.ageCategory.minYear}
                                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">Младше ${a.ageCategory.maxYear}
                                            <#elseif !a.ageCategory.maxYear?? !&& a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.id}">${a.ageCategory.rank.name}
                                            </#if>
                                        </b>
                                    </div>
                                    <ul class="list-group athlete-ul" id="athlete-ul">
                                        <#if (a.maxTeams??) && (a.discipline.participantsAmountMax??)>
                                            <#assign x=a.maxTeams>
                                            <#list 1..x as i>
                                                <li class="athletes-team-li list-group-item d-flex justify-content-between align-items-start">
                                                    <div class="ms-2 me-auto">
                                                        <div class="fw-bold">Команда №${i}</div>
                                                        <#list athletes as athlete>
                                                            <#if athlete.disciplineType.id == disciplineType.discipline.id && athlete.teamNumber == i && athlete.disciplineAge.id == a.id>
                                                                <div class="row my-2">
                                                                    <div class="athletes-div col-auto">
                                                                        <#--спортсмены-->
                                                                        ${athlete.athlete.person.surname} ${athlete.athlete.person.name} ${athlete.athlete.person.middleName}
                                                                    </div>
                                                                </div>
                                                            </#if>
                                                        </#list>
                                                    </div>
                                                </li>
                                            </#list>
                                        <#else>
                                            <#if a.maxAthletes??>
                                                <#list athletes as athlete>
                                                    <#if athlete.disciplineType.id == disciplineType.discipline.id && athlete.disciplineAge.id == a.id>
                                                        <li class="athletes-li list-group-item d-flex justify-content-between align-items-start">
                                                            <div class="row my-2">
                                                                <div class="athletes-div col-auto">
                                                                    <#--спортсмены-->
                                                                    ${athlete.athlete.person.surname} ${athlete.athlete.person.name} ${athlete.athlete.person.middleName}
                                                                </div>
                                                            </div>

                                                        </li>
                                                    </#if>
                                                </#list>
                                            </#if>
                                        </#if>
                                    </ul>
                                </div>
                            </#if>
                        </#list>
                    </div>
                </div>
            </div>
        </#list>
        <div class="card mb-3">
            <div class="card-body coaches-div">
                <div class="fs-6"><b>Тренеры</b></div>
                <ul class="coaches-ul list-group my-2">
                    <li class="coach-li list-group-item d-flex justify-content-between align-items-start">
                        <div class="row my-2">
                            <div class="col-auto">
                                <select class="form-select select-coach"
                                        aria-label="Default select example"
                                        id="selectCoach">
                                    <option>Выбрать тренера</option>
                                    <#--                                    <#list coaches as coach>-->
                                    <#--                                        <option value="${coach.id}">${coach.person.surname} ${coach.person.name} ${coach.person.middleName}</option>-->
                                    <#--                                    </#list>-->
                                </select>
                            </div>
                        </div>
                    </li>
                </ul>
                <button class="btn btn-primary" id="add-additional-coach-btn">Добавить</button>
            </div>
        </div>
        <div class="card">
            <div class="card-body judges-div">
                <div class="fs-6"><b>Судьи</b></div>
                <ul class="judges-ul list-group">
                    <li class="judge-li list-group-item d-flex justify-content-between align-items-start">
                        <div class="row my-2">
                            <div class="col-auto">
                                <select class="select-judge form-select"
                                        aria-label="Default select example"
                                        id="selectJudge">
                                    <option>Выбрать судью</option>
                                    <#--                                    <#list judges as judge>-->
                                    <#--                                        <option value="${judge.id}">${judge.person.surname} ${judge.person.name} ${judge.person.middleName}</option>-->
                                    <#--                                    </#list>-->
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
        <input type="hidden" value="${competition.id}" id="competition-id">
        <input type="hidden" value="${application.id}" id="application-id">
        <button class="btn btn-primary" id="send-application-btn">Отправить заявку</button>
        <button onclick="topFunction()" id="scroll-btn" class="btn btn-primary" title="Go to top">Top</button>
    </div>

</@main.renderWith>