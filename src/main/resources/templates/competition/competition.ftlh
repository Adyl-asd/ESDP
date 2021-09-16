<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Соревнование">

    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <div class="row">
                    <div class="col-3 fs-6">
                        Наименование:
                    </div>
                    <div class="col-9 fs-6">
                        ${competition.name}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Даты проведения:
                    </div>
                    <div class="col-9 fs-6">
                        ${competition.startDate} - ${competition.finishDate}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Место проведения:
                    </div>
                    <div class="col-9 fs-6">
                        ${competition.country}, ${competition.areaName}, ${competition.city}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Адрес:
                    </div>
                    <div class="col-9 fs-6">
                        ${competition.address}
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Контактное лицо:
                    </div>
                    <div class="col-9 fs-6">
                        ${competition.contact} (${competition.phone})
                    </div>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <div class="fs-4">Программа соревнования</div>
                <div class="fs-5">${competition.discipline.name}</div>
                <table class="table text-center text-capitalize table-bordered mt-3">
                    <thead>
                    <tr>
                        <th scope="col" class="my-2">Дисциплина</th>
                        <th scope="col" class="my-2">Вид соревновательной программы</th>
                        <th scope="col" class="my-2">Разряд и возрастная группа</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list competitionDisciplines as cd>
                        <tr>
                            <td class="fs-6">
                                ${cd.disciplineType.name}
                            </td>
                            <td>
                                <div class="fs-6">
                                    ${cd.competitionProgram.name}
                                </div>
                            </td>
                            <td>
                                <div class="fs-6">
                                    <#if cd.ageCategory.maxYear?? && cd.ageCategory.minYear?? && cd.ageCategory.rank??>
                                        ${cd.ageCategory.maxYear} - ${cd.ageCategory.minYear}
                                        : ${cd.ageCategory.rank.name}
                                    <#elseif cd.ageCategory.maxYear?? && !cd.ageCategory.minYear?? && cd.ageCategory.rank??>
                                        ${cd.ageCategory.maxYear} : ${cd.ageCategory.rank.name}
                                    <#elseif cd.ageCategory.maxYear?? && cd.ageCategory.minYear?? && !cd.ageCategory.rank??>
                                        ${cd.ageCategory.maxYear} - ${cd.ageCategory.minYear}
                                    <#elseif !cd.ageCategory.maxYear?? && cd.ageCategory.minYear?? && cd.ageCategory.rank??>
                                        ${cd.ageCategory.minYear} : ${cd.ageCategory.rank.name}
                                    <#elseif !cd.ageCategory.maxYear?? && cd.ageCategory.minYear?? && !cd.ageCategory.rank??>
                                        ${cd.ageCategory.minYear}
                                    <#elseif cd.ageCategory.maxYear?? && !cd.ageCategory.minYear?? && !cd.ageCategory.rank??>
                                        ${cd.ageCategory.maxYear}
                                    <#elseif !cd.ageCategory.maxYear?? !&& cd.ageCategory.minYear?? && cd.ageCategory.rank??>
                                        ${cd.ageCategory.rank.name}
                                    </#if>
                                </div>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="btn btn-primary">Подтвердить заявку</div>

        </div>
    </div>

</@main.renderWith>