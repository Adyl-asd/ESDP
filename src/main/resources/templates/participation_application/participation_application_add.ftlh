<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Подать заявку на участие в соревновании" scripts=["js/participation_application_add.js"]>

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
                        <h6 class="mb-0">Уровень</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${competition.level}
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
            <div class="card mb-3">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <h5>${disciplineType.discipline.name}</h5>
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
                                    <input type="hidden" value="${a.discipline.id}" class="discipline-type-id">
                                    <div class="my-3 fs-6"><b>
                                            <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                                : ${a.ageCategory.rank.name}
                                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">Младше ${a.ageCategory.maxYear} : ${a.ageCategory.rank.name}
                                            <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">Старше ${a.ageCategory.minYear} : ${a.ageCategory.rank.name}
                                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">Старше ${a.ageCategory.minYear}
                                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">Младше ${a.ageCategory.maxYear}
                                            <#elseif !a.ageCategory.maxYear?? !&& a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                <input type="hidden" class="age-category-id"
                                                       value="${a.ageCategory.id}">${a.ageCategory.rank.name}
                                            </#if>
                                        </b>
                                    </div>
                                    <ul class="list-group athlete-ul" id="athlete-ul">
                                        <#if (a.maxTeams??) && (a.discipline.participantsAmountMax??)>
                                            <#assign x=a.maxTeams>
                                            <#list 1..x as i>
                                                <li class="athletes-li list-group-item d-flex justify-content-between align-items-start">
                                                    <div class="ms-2 me-auto">
                                                        <div class="fw-bold">Команда №${i}</div>
                                                        <#list 1..a.discipline.participantsAmountMax as j>
                                                            <div class="row my-2">
                                                                <div class="col text-end">
                                                                    <label for="selectAthlete" class="mt-1">${j}
                                                                        .</label>
                                                                </div>
                                                                <div class="col-auto">
                                                                    <select class="form-select select-athlete"
                                                                            aria-label="Default select example"
                                                                            id="selectAthlete">
                                                                        <option selected>Выбрать спортсмена</option>
                                                                        <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        <#elseif !a.ageCategory.maxYear?? !&& a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                            <#list athletes as athlete>
                                                                                <#if (athlete.rank == a.ageCategory.rank)>
                                                                                    <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                                </#if>
                                                                            </#list>
                                                                        </#if>
                                                                    </select>
                                                                </div>
                                                                <#if a.teamChampionship != 0>
                                                                    <div class="col-auto">
                                                                        <div class="form-check">
                                                                            <input class="form-check-input team-championship"
                                                                                   type="checkbox" value=""
                                                                                   id="team-championship">
                                                                            <label class="form-check-label"
                                                                                   for="team-championship">
                                                                                Командное первенство
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </#if>
                                                                <#if (a.discipline.id == 4)>
                                                                    <div class="col-auto">
                                                                        <div class="form-check">
                                                                            <input class="form-check-input first-type"
                                                                                   type="checkbox" value=""
                                                                                   id="first-type">
                                                                            <label class="form-check-label"
                                                                                   for="first-type">
                                                                                1-й вид
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-auto">
                                                                        <div class="form-check">
                                                                            <input class="form-check-input second-type"
                                                                                   type="checkbox" value=""
                                                                                   id="second-type">
                                                                            <label class="form-check-label"
                                                                                   for="second-type">
                                                                                2-й вид
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </#if>
                                                            </div>
                                                        </#list>
                                                    </div>
                                                </li>
                                            </#list>
                                        <#else>
                                            <#if a.maxAthletes??>
                                                <#assign y=a.maxAthletes>
                                                <#list 1..y as j>
                                                    <li class="athletes-li list-group-item d-flex justify-content-between align-items-start">
                                                        <div class="row my-2">
                                                            <div class="col text-end">
                                                                <label for="selectAthlete" class="mt-1">${j}.</label>
                                                            </div>
                                                            <div class="col-auto">
                                                                <select class="form-select select-athlete"
                                                                        aria-label="Default select example"
                                                                        id="selectAthlete">
                                                                    <option selected>Выбрать спортсмена</option>
                                                                    <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    <#elseif !a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                        <#list athletes as athlete>
                                                                            <#if (athlete.rank == a.ageCategory.rank)>
                                                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                            </#if>
                                                                        </#list>
                                                                    </#if>
                                                                </select>
                                                            </div>
                                                            <#if a.teamChampionship != 0>
                                                                <div class="col-auto">
                                                                    <div class="form-check">
                                                                        <input class="form-check-input team-championship"
                                                                               type="checkbox" value=""
                                                                               id="team-championship">
                                                                        <label class="form-check-label"
                                                                               for="team-championship">
                                                                            Командное первенство
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                            </#if>
                                                        </div>
                                                    </li>
                                                </#list>
                                            </#if>
                                        </#if>
                                    </ul>
                                    <div class="additional-athletes-div my-3">
                                        <b class="additional-athletes-text" hidden>Доп. спортсмены</b>
                                        <ul class="list-group additional-athletes-ul" hidden>
                                            <li class="athletes-li list-group-item d-flex justify-content-between align-items-start">
                                                <div class="row my-2">
                                                    <div class="col-auto">
                                                        <select class="form-select select-athlete-additional"
                                                                aria-label="Default select example">
                                                            <option selected>Выбрать спортсмена</option>
                                                            <#if competition.level == "Республиканский">
                                                                <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                </#if>
                                                            </#if>
                                                            <#if competition.level == "Региональный">
                                                                <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear) && (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear) && (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() > a.ageCategory.minYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.person.birthday.getYear() < a.ageCategory.maxYear)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                <#elseif !a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                                                    <#list athletesNational as athlete>
                                                                        <#if (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                    <#list athletesCity as athlete>
                                                                        <#if (athlete.rank == a.ageCategory.rank)>
                                                                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                                                        </#if>
                                                                    </#list>
                                                                </#if>
                                                            </#if>
                                                        </select>
                                                    </div>
                                                    <div class="col">
                                                        <button class="btn btn-danger delete-additional-athlete-btn">
                                                            Удалить
                                                        </button>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                        <div>
                                            <button class="btn btn-primary add-additional-athlete-btn">Добавить</button>
                                        </div>
                                    </div>
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
        <button onclick="topFunction()" id="scroll-btn" class="btn btn-primary" title="Go to top">Top</button>
    </div>

</@main.renderWith>