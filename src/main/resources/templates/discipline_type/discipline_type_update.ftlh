<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить дисцпилину">
    <div class="container">

        <div class="card my-3">
            <div class="card-body">
                <h1>Изменить дисциплину ${discipline_type.name}</h1>

                <form action="/discipline_type/${discipline_type.id}/update" method="post">

                    <#--Вид спорта-->
                    <div class="row">
                        <div class="col">
                            <label for="discipline" class="form-label fs-4">Вид спорта</label>
                            <select name="disciplineId" class="form-select" id="discipline">
                                <option selected value="${discipline_type.discipline.id}">${discipline_type.discipline.name}</option>
                                <#list disciplines as d>
                                    <option value="${d.id}">${d.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>

                    <#--Название-->
                    <div class="row">
                        <div class="col">
                            <label for="name" class="form-label fs-4">Название</label>
                            <input type="text" name="name" value="${discipline_type.name}" class="form-control" id="name">
                        </div>
                    </div>

                    <#--Пол-->
                    <div class="col">
                        <label for="gender" class="form-label fs-4">Пол</label>
                        <select name="gender" id="gender" class="form-control">
                            <option selected value="${discipline_type.gender}">${discipline_type.gender}</option>
                            <option value="Женский">Женский</option>
                            <option value="Мужской">Мужской</option>
                        </select>
                    </div>

                    <#--Количество участников в команде-->
                    <h4>Заполнить, если дисциплина командная</h4>
                    <div class="row">
                        <div class="col">
                            <label for="participantsAmountMin" class="form-label fs-4">Минимальное количество участников в команде</label>
                            <input type="number" name="participantsAmountMin" <#if discipline_type.participantsAmountMin??>value='${discipline_type.participantsAmountMin}' </#if> class="form-control" id="participantsAmountMin">
                        </div>
                        <div class="col">
                            <label for="address" class="form-label fs-4">Максимальное количество участников в команде</label>
                            <input type="number" name="participantsAmountMax" <#if discipline_type.participantsAmountMax??>value='${discipline_type.participantsAmountMax}' </#if> class="form-control" id="participantsAmountMax">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary mt-1">Изменить</button>
                </form>
                <a href="/discipline_type/${discipline_type.id}/update" class="btn btn-secondary">Отменить</a>
            </div>
        </div>


        <#if errors??>
            <#list errors as e>
                <h2>${e.field} - ${e.defaultMessage!'__no message__'}</h2>
            </#list>
        </#if>
    </div>
</@main.renderWith>