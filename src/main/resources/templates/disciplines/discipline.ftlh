<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${discipline.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>${discipline.name}</h4>
                                    <a href="/disciplines/${discipline.id}/update" class="btn btn-primary">Изменить</a>
                                    <form action="/disciplines/${discipline.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить вид спорта</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="row gutters-sm">
                        <div class="col mb-3">
                            <div class="card h-100">
                                <div class="card-body">
                                    <h3 class="d-flex align-items-center mb-3">Дисциплины</h3>
                                    <a href="/discipline_type/add" class="btn btn-primary">Добавить дисциплину</a>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-12 text-secondary">
                                            <div>
                                                <div class="str-column">
                                                    <#list discipline.disciplineTypes as d>
                                                        <#if !d.isDel()>
                                                            <div class="str">
                                                                <h3>${d.name}</h3>
                                                                <form action="/discipline_type/${d.id}" method="post">
                                                                    <button type="submit"class="btn-danger">
                                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
                                                                            <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                                                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                                                        </svg>
                                                                    </button>
                                                                </form>
                                                            </div>
                                                            <div class="str">
                                                                <div class="str-table">
                                                                    <h4>Возрастные категории</h4>
                                                                    <#list d.ageCategories as cd>
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
                                                                    <a href="/disciplines/${discipline.id}/type/${d.id}/add_ages" class="btn btn-primary">Добавить возрастную категорию</a>
                                                                </div>
                                                                <div class= "str-table">
                                                                    <h4>Соревновательные программы</h4>
                                                                    <#list d.programs as p>
                                                                        <p>${p.name}</p>
                                                                    </#list>
                                                                    <a href="/disciplines/${discipline.id}/type/${d.id}/add_program" class="btn btn-primary">Добавить соревновательную программу</a>
                                                                </div>
                                                            </div>
                                                        </#if>
                                                        <hr>
                                                    </#list>
                                                </div>
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