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
                                    <label for="comp-name" class="form-label fs-5">Наименование соревнования</label>
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
                                    <input type="file" name="competitionPositionFile" class="form-control" id="position-file">
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
                            <#--Дисциплина и вид программы-->
                            <table class="table text-capitalize text-center table-bordered mt-3">
                                <thead>
                                <tr>
                                    <th scope="col" class="my-2">Дисциплина</th>
                                    <th scope="col" class="my-2">Вид соревновательной программы</th>
                                </tr>
                                </thead>
                                <tbody id="program_table_body">
                                <tr id="disciplineTypeAndProgramInput">
                                    <td>
                                        <div class="row">
                                            <div class="col">
                                                <select name="disciplineType" id="disciplineType" class="form-select">
                                                    <option>Выберите дисциплину</option>
                                                    <#list disciplineTypes as dt>
                                                        <option value="${dt.id}">${dt.name}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center text-capitalize">
                                        <div class="row">
                                            <div class="col">
                                                <select name="competitionProgram" id="competitionProgram"
                                                        class="form-select">
                                                    <option>Выберите вид программы</option>
                                                    <#list competitionPrograms as cp>
                                                        <option value="${cp.id}">${cp.name}</option>
                                                    </#list>
                                                </select>
                                            </div>
                                        </div>

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input id="save_program_btn" class="btn btn-primary mt-3" onclick="save_program()"
                                   type="button" value="Сохранить">
                            <input id="cancel_program_btn" class="btn btn-danger mt-3" onclick="cancel_program()"
                                   type="button" value="Отмена" hidden>
                            <input id="add_program_btn" class="btn btn-primary mt-3" onclick="add_program()"
                                   type="button" value="Добавить" hidden>

                            <#--Разряд и возрастная категория-->
                            <table class="table text-capitalize text-center table-bordered mt-3">
                                <thead>
                                <tr>
                                    <th scope="col">Разряд</th>
                                    <th scope="col">Возрастная категория</th>
                                </tr>
                                </thead>
                                <tbody id="age_rank_table_body">
                                <tr id="ageAndRankInput">
                                    <td>
                                        <select name="rank" id="rank" class="form-select">
                                            <option selected value="">Выберите разряд</option>
                                            <#list ranks as r>
                                                <option value="${r.id}">${r.name}</option>
                                            </#list>
                                        </select>
                                    </td>
                                    <td>
                                        <div class="row">
                                            <div class="col">
                                                <input type="number" name="comp-start-age" class="form-control"
                                                       id="comp-start-age" placeholder="возраст от">
                                            </div>
                                            <div class="col">
                                                <input type="number" name="comp-end-age" class="form-control"
                                                       id="comp-end-age" placeholder="возраст до">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input id="save_age_btn" class="btn btn-primary mt-3" onclick="save_age()"
                                   type="button" value="Сохранить">
                            <input id="cancel_age_btn" class="btn btn-danger mt-3" onclick="cancel_age()"
                                   type="button" value="Отмена" hidden>
                            <input id="add_age_btn" class="btn btn-primary mt-3" onclick="add_age()"
                                   type="button" value="Добавить" hidden>
                        </fieldset>
                    </form>


                </div>
                <input id="pre_btn" onclick="prev_step()" class="btn btn-primary" type="button" value="Назад" hidden>
                <a href="/competitions/1" class="btn btn-primary" hidden id="send-form-btn">Подать заявку</a>
            </div>
        </div>
    </div>

</@main.renderWith>