<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Подать заявку на участие в соревновании">

    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <h3>${competition.name}</h3>
                <h4>${competition.discipline.name}</h4>
            </div>
        </div>
        <#list disciplineTypes as disciplineType>
            <div class="card mb-3">
                <div class="card-body">
                    <h5>${disciplineType.discipline.name}</h5>
                    <hr>
                    <#list ageCategories as a>
                        <#if a.discipline.id = disciplineType.discipline.id>
                            <div class="my-3 fs-6">
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
                            </div>
                            <ul class="list-group">

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
                        </#if>
                    </#list>
                </div>
            </div>
        </#list>
    </div>

</@main.renderWith>