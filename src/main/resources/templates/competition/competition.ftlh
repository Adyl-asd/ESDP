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
                        Соревнование #1
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Даты проведения:
                    </div>
                    <div class="col-9 fs-6">
                        13.09.21 - 19.09.21
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Место проведения:
                    </div>
                    <div class="col-9 fs-6">
                        Казахстан, Алматинская обл., г. Алматы
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Адрес:
                    </div>
                    <div class="col-9 fs-6">
                        Адрес #1, Объект #1
                    </div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-3 fs-6">
                        Контактное лицо:
                    </div>
                    <div class="col-9 fs-6">
                        Иванов Иван, +77771234567, test@test.com
                    </div>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <div class="fs-4">Программа соревнования</div>
                <div class="fs-5">Художественная гимнастика</div>
                <table class="table text-center text-capitalize table-bordered mt-3">
                    <thead>
                    <tr>
                        <th scope="col" class="my-2">Дисциплина</th>
                        <th scope="col" class="my-2">Вид соревновательной программы</th>
                        <th scope="col" class="my-2">Разряд</th>
                        <th scope="col" class="my-2">Возрастная группа</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="fs-6">
                            Индивидуальная программа
                        </td>
                        <td>
                            <div class="fs-6">
                                Многоборье
                            </div>
                            <div class="fs-6">
                                Командное первенство
                            </div>
                        </td>
                        <td class="fs-6">
                            1 разряд
                        </td>
                        <td class="fs-6">
                            2012 - 2009
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="btn btn-primary">Подтвердить заявку</div>

        </div>
    </div>

</@main.renderWith>