<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Подать заявку на участие в соревновании">

    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3>${competition.name}</h3>
                <h4>${competition.discipline.name}</h4>
                <#list disciplineTypes as disciplineType>
                    <h5>${disciplineType.discipline.name}</h5>
                    <#list ageCategories as a>
                        <div>
                            <#if a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                <input type="hidden"
                                       value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                                : ${a.ageCategory.rank.name}
                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && a.ageCategory.rank??>
                                <input type="hidden"
                                       value="${a.ageCategory.id}">младше ${a.ageCategory.maxYear} : ${a.ageCategory.rank.name}
                            <#elseif a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                <input type="hidden"
                                       value="${a.ageCategory.id}">${a.ageCategory.maxYear} - ${a.ageCategory.minYear}
                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && a.ageCategory.rank??>
                                <input type="hidden"
                                       value="${a.ageCategory.id}">старше ${a.ageCategory.minYear} : ${a.ageCategory.rank.name}
                            <#elseif !a.ageCategory.maxYear?? && a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                <input type="hidden" value="${a.ageCategory.id}">старше ${a.ageCategory.minYear}
                            <#elseif a.ageCategory.maxYear?? && !a.ageCategory.minYear?? && !a.ageCategory.rank??>
                                <input type="hidden" value="${a.ageCategory.id}">младше ${a.ageCategory.maxYear}
                            <#elseif !a.ageCategory.maxYear?? !&& a.ageCategory.minYear?? && a.ageCategory.rank??>
                                <input type="hidden" value="${a.ageCategory.id}">${a.ageCategory.rank.name}
                            </#if>
                        </div>
                        <#if (a.teamChampionship!=0) && (a.maxTeams??)>
                            <#assign x=a.maxTeams>
                            <#list 1..x as i>
                                <div>Команда №${i}</div>
                                <#if a.maxAthletes??>
                                    <#assign y=a.maxAthletes>
                                    <#list 1..y as j>
                                        <div>Спортсмен №${j}</div>
                                        <select class="form-select" aria-label="Default select example">
                                            <option selected>Выбрать спортсмена</option>
                                            <#list athletes as athlete>
                                                <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                                            </#list>
                                        </select>
                                    </#list>
                                </#if>
                            </#list>
                        </#if>
                    </#list>
                </#list>
            </div>
        </div>
    </div>

</@main.renderWith>