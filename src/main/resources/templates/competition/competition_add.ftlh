<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить соревнование">

    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <h3>Добавить соревнование</h3>
                <#--Наименование соревнования-->
                <div class="row">
                    <div class="col">
                        <label for="comp-name" class="form-label fs-5">Наименование соревнования</label>
                        <input type="text" name="comp-name" class="form-control" id="comp-name">
                    </div>
                </div>

                <#--Начало и конец соревнования дата-->
                <div class="row">
                    <div class="col">
                        <label for="comp-start" class="form-label fs-5">Начало мероприятия</label>
                        <input type="date" name="comp-start" class="form-control" id="comp-start">
                    </div>
                    <div class="col">
                        <label for="comp-end" class="form-label fs-5">Окончание мероприятия</label>
                        <input type="date" name="comp-end" class="form-control" id="comp-end">
                    </div>
                </div>

                <#--Место проведения: страна, область, город, адрес-->
                <div class="row">
                    <div class="col">
                        <label for="comp-country" class="form-label fs-5">Страна</label>
                        <input type="text" name="comp-country" class="form-control" id="comp-country">
                    </div>
                    <div class="col">
                        <label for="comp-region" class="form-label fs-5">Область</label>
                        <input type="text" name="comp-region" class="form-control" id="comp-region">
                    </div>
                    <div class="col">
                        <label for="comp-city" class="form-label fs-5">Город</label>
                        <input type="text" name="comp-city" class="form-control" id="comp-city">
                    </div>
                </div>

                <#--Место проведения: адрес, название объекта-->
                <div class="row">
                    <div class="col">
                        <label for="comp-address" class="form-label fs-5">Адрес</label>
                        <input type="text" name="comp-address" class="form-control" id="comp-address">
                    </div>
                    <div class="col">
                        <label for="comp-place-name" class="form-label fs-5">Название спортивного объекта</label>
                        <input type="text" name="comp-place-name" class="form-control" id="comp-place-name">
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label for="sport-name" class="form-label fs-5">Вид спорта</label>
                        <select name="sport-name" id="sport-name" class="form-select">
                            <option selected value="">Выберите вид спорта</option>
                            <option value="">Спортивная гимнастика</option>
                            <option value="">Художественная гимнастика</option>
                        </select>
                    </div>
                </div>

                <#--Вид спорта и дисциплина-->
                <#--                <div class="row">-->
                <#--                    <div class="col">-->
                <#--                        <label for="sport-name" class="form-label fs-5">Вид спорта</label>-->
                <#--                        <input type="text" name="sport-name" class="form-control" id="sport-name">-->
                <#--                    </div>-->
                <#--                    <div class="col">-->
                <#--                        <label for="discipline-name" class="form-label fs-5">Дисциплина</label>-->
                <#--                        <input type="text" name="discipline-name" class="form-control" id="discipline-name">-->
                <#--                    </div>-->
                <#--                </div>-->

                <table class="table text-uppercase text-center table-bordered mt-3">
                    <thead>
                    <tr>
                        <th scope="col" class="my-2">Дисциплина</th>
                        <th scope="col" class="my-2">Вид соревновательной программы</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col">
                                    <select name="age-start" id="age-end" class="form-select">
                                        <option selected value="">Выберите дисциплину</option>
                                        <option value="">Индивидуальная программа</option>
                                        <option value="">Групповые упражнения (5-6 спортсменов)</option>
                                    </select>
                                </div>
                            </div>
                        </td>
                        <td class="text-start text-capitalize">
                            <div class="row">
                                <div class="col">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Многоборье
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Командное первенство
                                        </label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Скакалка
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Обруч
                                        </label>
                                    </div>
                                </div>
                            </div>


                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col">
                                    <select name="age-start" id="age-end" class="form-select">
                                        <option selected value="">Выберите дисциплину</option>
                                        <option value="">Индивидуальная программа</option>
                                        <option value="">Групповые упражнения (5-6 спортсменов)</option>
                                    </select>
                                </div>
                            </div>
                        </td>
                        <td class="text-start text-capitalize">
                            <div class="row">
                                <div class="col">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Многоборье
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Командное первенство
                                        </label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Скакалка
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Обруч
                                        </label>
                                    </div>
                                </div>
                            </div>


                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn btn-primary">Добавить</div>
                <#--Разряд и возрастная категория-->
                <#--                <div class="row">-->
                <#--                    <div class="col">-->
                <#--                        <label for="rank" class="form-label fs-5">Разряд</label>-->
                <#--                        <input type="text" name="rank" class="form-control" id="rank">-->
                <#--                    </div>-->
                <#--                    <div class="col">-->
                <#--                        <div class="row">-->
                <#--                            <div class="col">-->
                <#--                                <label for="age-from" class="form-label fs-5">От</label>-->
                <#--                                <input type="text" name="age-from" class="form-control" id="age-from">-->
                <#--                            </div>-->
                <#--                            <div class="col">-->
                <#--                                <label for="age-to" class="form-label fs-5">До</label>-->
                <#--                                <input type="text" name="age-to" class="form-control" id="age-to">-->
                <#--                            </div>-->
                <#--                        </div>-->
                <#--                    </div>-->
                <#--                </div>-->

                <table class="table text-uppercase text-center table-bordered mt-3">
                    <thead>
                    <tr>
                        <th scope="col">Разряд</th>
                        <th scope="col">Возрастная категория</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <select name="rank" id="rank" class="form-select">
                                <option selected value="">Выберите разряд</option>
                                <option value="">1</option>
                                <option value="">2</option>
                            </select>
                        </td>
                        <td>
                            <div class="row">
                                <div class="col">
                                    <select name="age-start" id="age-start" class="form-select">
                                        <option selected value="">от</option>
                                        <option value="">2009</option>
                                        <option value="">2010</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <select name="age-start" id="age-end" class="form-select">
                                        <option selected value="">до</option>
                                        <option value="">2012</option>
                                        <option value="">2013</option>
                                    </select>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="rank" id="rank" class="form-select">
                                <option selected value="">Выберите разряд</option>
                                <option value="">1</option>
                                <option value="">2</option>
                            </select>
                        </td>
                        <td>
                            <div class="row">
                                <div class="col">
                                    <select name="age-start" id="age-start" class="form-select">
                                        <option selected value="">от</option>
                                        <option value="">2009</option>
                                        <option value="">2010</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <select name="age-start" id="age-end" class="form-select">
                                        <option selected value="">до</option>
                                        <option value="">2012</option>
                                        <option value="">2013</option>
                                    </select>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="btn btn-primary">Добавить</div>

                <div class="row">
                    <div class="col-6">
                        <label for="comp-region" class="form-label fs-5">Контактное лицо</label>
                        <input type="text" name="comp-region" class="form-control" id="comp-region">
                    </div>
                    <div class="col-3">
                        <label for="comp-city" class="form-label fs-5">Номер телефона</label>
                        <input type="text" name="comp-city" class="form-control" id="comp-city">
                    </div>
                    <div class="col-3">
                        <label for="comp-city" class="form-label fs-5">Электронный адрес</label>
                        <input type="text" name="comp-city" class="form-control" id="comp-city">
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <label for="comp-region" class="form-label fs-5">Положение о проведении соревнований</label>
                        <input type="file" name="comp-region" class="form-control" id="comp-region">
                    </div>
                </div>
            </div>
            <a href="/competitions/1" class="btn btn-primary">Подать заявку</a>
        </div>


    </div>

</@main.renderWith>