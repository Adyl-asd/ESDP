<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить соревнование" scripts=["js/add-comp.js"]>

    <div class="container">
        <div class="card my-3">
            <div class="main">

                <div class="card-body">
                    <form class="first-form" enctype="multipart/form-data" id="first-form">

                        <!-- Fieldsets -->
                        <fieldset id="first">
                            <h3>Добавить соревнование</h3>
                            <#--Наименование соревнования-->
                            <div class="row">
                                <div class="col">
                                    <label for="comp-name" class="form-label fs-6">Наименование соревнования</label>
                                    <input type="text" name="name" class="form-control" id="comp-name">
                                </div>
                            </div>

                            <#--Начало и конец соревнования дата-->
                            <div class="row">
                                <div class="col">
                                    <label for="comp-start" class="form-label fs-5">Начало мероприятия</label>
                                    <input type="date" name="startDate" class="form-control" id="comp-start">
                                </div>
                                <div class="col">
                                    <label for="comp-end" class="form-label fs-5">Окончание мероприятия</label>
                                    <input type="date" name="finishDate" class="form-control" id="comp-end">
                                </div>
                                <div class="col">
                                    <label for="level" class="form-label fs-5">Уровень соревнования</label>
                                    <select name="level" id="level" class="form-select">
                                        <option selected value="" class="option">Выберите уровень</option>
                                        <#list levels as level>
                                            <option value="${level}">${level}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>

                            <#--Место проведения: страна, область, город, адрес-->
                            <div class="row">
                                <div class="col">
                                    <label for="comp-country" class="form-label fs-5">Страна</label>
                                    <input type="text" name="country" class="form-control" id="comp-country">
                                </div>
                                <div class="col">
                                    <label for="comp-region" class="form-label fs-5">Область</label>
                                    <input type="text" name="areaName" class="form-control" id="comp-region">
                                </div>
                                <div class="col">
                                    <label for="comp-city" class="form-label fs-5">Город</label>
                                    <input type="text" name="city" class="form-control" id="comp-city">
                                </div>
                            </div>

                            <#--Место проведения: адрес, название объекта-->
                            <div class="row">
                                <div class="col">
                                    <label for="comp-address" class="form-label fs-5">Адрес</label>
                                    <input type="text" name="address" class="form-control" id="comp-address">
                                </div>
                                <#--                                <div class="col">-->
                                <#--                                    <label for="comp-place-name" class="form-label fs-5">Название спортивного-->
                                <#--                                        объекта</label>-->
                                <#--                                    <input type="text" name="comp-place-name" class="form-control" id="comp-place-name">-->
                                <#--                                </div>-->
                            </div>

                            <#--Вид спорта-->
                            <div class="row">
                                <div class="col">
                                    <label for="discipline" class="form-label fs-5">Вид спорта</label>
                                    <select name="disciplineId" id="discipline" class="form-select">
                                        <option selected value="">Выберите вид спорта</option>
                                        <#list disciplines as d>
                                            <option value="${d.id}">${d.name}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>

                            <#--Если выбрана спортивная акробатика, то выбор командного первенства перенесется сюда-->
                            <div id="newTeamChampionshipDiv">

                            </div>

                            <#--Id школы-->
                            <input type="hidden" name="schoolId" value="${school.id}">

                            <div class="row">
                                <div class="col-6">
                                    <label for="contact-name" class="form-label fs-5">Контактное лицо</label>
                                    <input type="text" name="contactName" class="form-control" id="contact-name">
                                </div>
                                <div class="col-3">
                                    <label for="contact-phone" class="form-label fs-5">Номер телефона</label>
                                    <input type="text" name="contactPhone" class="form-control" id="contact-phone">
                                </div>
                                <#--                                <div class="col-3">-->
                                <#--                                    <label for="comp-city" class="form-label fs-5">Электронный адрес</label>-->
                                <#--                                    <input type="text" name="comp-city" class="form-control" id="comp-city">-->
                                <#--                                </div>-->
                            </div>

                            <div class="row">
                                <div class="col">
                                    <label for="position-file" class="form-label fs-5">Положение о проведении
                                        соревнований</label>
                                    <input type="file" name="competitionPositionFile" class="form-control"
                                           id="position-file">
                                </div>
                            </div>
                            <input id="next_btn" class="btn btn-primary mt-3" onclick="next_step()" type="button"
                                   value="Далее">
                            <input id="update_btn" class="btn btn-primary mt-3" onclick="update_comp()" type="button"
                                   value="Далее" hidden>
                        </fieldset>
                    </form>

                    <#--SECOND-->
                    <form id="second-form" method="post">
                        <fieldset id="second" hidden>
                            <table class="table table-bordered text-center" id="table-body" hidden>
                                <thead>
                                <tr>
                                    <th scope="col">Дисциплина</th>
                                    <th scope="col">Программы</th>
                                    <th scope="col">Возрастные категории / Ограничение по количеству</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody id="program_table_body">

                                </tbody>
                            </table>
                            <#--Дисциплина и вид программы-->
                            <div id="disciplineTypeAndProgramInput">
                                <div class="row">
                                    <div class="col">
                                        <label for="disciplineType" class="form-label">Дисциплина</label>
                                        <select name="disciplineTypeId" id="disciplineType" class="form-select">
                                            <option selected>Выберите дисциплину</option>
<#--                                            <#list disciplineTypes as dt>-->
<#--                                                <option value="${dt.id}">${dt.name}</option>-->
<#--                                            </#list>-->
                                        </select>
                                    </div>
                                </div>
                                <div id="oldTeamChampionshipDiv">
                                    <div class="form-check my-3" id="teamChampionshipDiv">
                                        <input class="form-check-input" type="checkbox" value="" id="teamChampionship">
                                        <label class="form-check-label" for="teamChampionship">
                                            Командное первенство
                                        </label>
                                        <div class="form-check ms-3">
                                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                   id="teamChampionshipGeneral" checked disabled>
                                            <label class="form-check-label" for="teamChampionshipGeneral">
                                                Общее
                                            </label>
                                        </div>
                                        <div class="form-check ms-3">
                                            <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                   id="teamChampionshipSeparate" disabled>
                                            <label class="form-check-label" for="teamChampionshipSeparate">
                                                Отдельное
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <#--                                <div class="form-check">-->
                                <#--                                    <input class="form-check-input" type="checkbox" value="" id="allAround">-->
                                <#--                                    <label class="form-check-label" for="allAround">-->
                                <#--                                        Многоборье-->
                                <#--                                    </label>-->
                                <#--                                </div>-->
                                <div class="row">
                                    <div class="col" id="competitionProgramDiv" hidden>
                                        <h5>Вид соревновательной программы</h5>
                                        <#list competitionPrograms as competitionProgram>
                                            <div class="form-check">
                                                <input class="form-check-input competition-program-input"
                                                       type="checkbox"
                                                       name="disciplineTypeId" value="${competitionProgram.id}"
                                                       id="disciplineType">
                                                <label class="form-check-label" for="disciplineType">
                                                    ${competitionProgram.name}
                                                </label>
                                            </div>
                                        </#list>
                                    </div>
                                    <div class="col">
                                        <h5>Разряд и возрастная категория</h5>
                                        <#list ageCategories as ageCategory>
                                            <div class="form-check">
                                                <#if ageCategory.maxYear?? && ageCategory.minYear?? && ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.maxYear} - ${ageCategory.minYear}
                                                        : ${ageCategory.rank.name}
                                                    </label>

                                                <#elseif ageCategory.maxYear?? && !ageCategory.minYear?? && ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.maxYear} : ${ageCategory.rank.name}
                                                    </label>

                                                <#elseif ageCategory.maxYear?? && ageCategory.minYear?? && !ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.maxYear} - ${ageCategory.minYear}
                                                    </label>

                                                <#elseif !ageCategory.maxYear?? && ageCategory.minYear?? && ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.minYear} : ${ageCategory.rank.name}
                                                    </label>

                                                <#elseif !ageCategory.maxYear?? && ageCategory.minYear?? && !ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.minYear}
                                                    </label>

                                                <#elseif ageCategory.maxYear?? && !ageCategory.minYear?? && !ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.maxYear}
                                                    </label>

                                                <#elseif !ageCategory.maxYear?? !&& ageCategory.minYear?? && ageCategory.rank??>
                                                    <input class="form-check-input age-category" type="checkbox"
                                                           value="${ageCategory.id}" id="ageCategory"
                                                           name="ageCategory">
                                                    <label class="form-check-label" for="ageCategory">
                                                        ${ageCategory.rank.name}
                                                    </label>
                                                </#if>
                                            </div>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                            <input id="save_program_btn" class="btn btn-primary mt-3" onclick="save_program()"
                                   type="button" value="Сохранить">
                            <input id="cancel_program_btn" class="btn btn-danger mt-3" onclick="cancel_program()"
                                   type="button" value="Отмена" hidden>
                            <input id="add_program_btn" class="btn btn-primary mt-3" onclick="add_program()"
                                   type="button" value="Добавить" hidden>

                        </fieldset>
                    </form>


                </div>
                <input id="pre_btn" onclick="prev_step()" class="btn btn-primary" type="button" value="Назад" hidden>
                <input class="btn btn-primary" hidden id="send-form-btn" onclick="send_form()" type="button"
                       value="Подать заявку">
            </div>
        </div>
    </div>

</@main.renderWith>