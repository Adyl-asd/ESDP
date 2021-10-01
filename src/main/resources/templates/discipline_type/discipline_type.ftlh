<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${discipline_type.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>${discipline_type.name}</h4>
                                    <p>Пол: ${discipline_type.gender.name}</p>
                                    <#if discipline_type.participantsAmountMin??>
                                        <p>Минимальное количество участников: ${discipline_type.participantsAmountMin}</p>
                                    </#if>
                                    <#if discipline_type.participantsAmountMax??>
                                        <p>Максимальное количество участников: ${discipline_type.participantsAmountMax}</p>
                                    </#if>
                                    <p>Вид спорта: ${discipline_type.discipline.name}</p>
                                    <a href="/discipline_type/${discipline_type.id}/update" class="btn btn-primary">Внести изменения</a>
                                    <form action="/discipline_type/${discipline_type.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить дисциплину</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row gutters-sm">
                    <div class="col">
                        <div class="card h-100">
                            <div class="card-body str-flex">
                                <h4>Возрастные категории</h4>
                                <#list discipline_type.ageCategories as cd>
                                    <#if !cd.isDel()>
                                        <#if cd.maxYear?? && cd.minYear?? && cd.rank??>
                                            <p>#{cd.maxYear} - #{cd.minYear}
                                                : ${cd.rank.name}</p>
                                        <#elseif cd.maxYear?? && !cd.minYear?? && cd.rank??>
                                            <p>#{cd.maxYear} : ${cd.rank.name}</p>
                                        <#elseif cd.maxYear?? && cd.minYear?? && !cd.rank??>
                                            <p>#{cd.maxYear} - #{cd.minYear}</p>
                                        <#elseif !cd.maxYear?? && cd.minYear?? && cd.rank??>
                                            <p>#{cd.minYear} : ${cd.rank.name}</p>
                                        <#elseif !cd.maxYear?? && cd.minYear?? && !cd.rank??>
                                            <p>#{cd.minYear}</p>
                                        <#elseif cd.maxYear?? && !cd.minYear?? && !cd.rank??>
                                            <p>#{cd.maxYear}</p>
                                        <#elseif !cd.maxYear?? !&& cd.minYear?? && cd.rank??>
                                            <p>${cd.rank.name}</p>
                                        </#if>
                                    </#if>
                                </#list>
                                <a href="/discipline_type/${discipline_type.id}/add_ages" class="btn btn-primary">Добавить возрастную категорию</a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <div class="card-body str-flex">
                                <h4>Соревновательные программы</h4>
                                <#list discipline_type.programs as p>
                                    <p>${p.name}</p>
                                </#list>
                                <a href="/discipline_type/${discipline_type.id}/add_program" class="btn btn-primary">Добавить соревновательную программу</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.renderWith>