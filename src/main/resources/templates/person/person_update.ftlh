<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Изменить человека">
    <div class="container">
        <div class="card my-3">
            <div class="card-body">
                <h1>Изменить персону ${person.surname} ${person.name}</h1>

                <form action="/person/${person.id}/update" method="post" enctype="multipart/form-data">

                    <#--ФИО-->
                    <div class="row">
                        <div class="col">
                            <label for="surname" class="form-label fs-4">Фамилия</label>
                            <input type="text" name="surname" value="${person.surname}" class="form-control" id="surname">
                        </div>
                        <div class="col">
                            <label for="name" class="form-label fs-4">Имя</label>
                            <input type="text" name="name" value="${person.name}" class="form-control" id="name">
                        </div>
                        <div class="col">
                            <label for="middleName" class="form-label fs-4">Отчество</label>
                            <input type="text" name="middleName" value="${person.middleName}" class="form-control" id="middleName">
                        </div>
                    </div>

                    <#--Дата рождения, ИИН, пол-->
                    <div class="row">
                        <div class="col">
                            <label for="birthday" class="form-label fs-4">Дата рождения</label>
                            <input type="date" name="birthday" value="${person.birthday}" class="form-control" id="birthday">
                        </div>
                        <div class="col">
                            <label for="iin" class="form-label fs-4">ИИН</label>
                            <input type="text" name="iin" value="${person.iin}" class="form-control" id="iin">
                        </div>
                        <div class="col">
                            <label for="gender" class="form-label fs-4">Пол</label>
                            <option selected value="${person.gender}">${person.gender}</option>
                            <select name="gender" id="gender" class="form-control">
                                <option value="Женский">Женский</option>
                                <option value="Мужской">Мужской</option>
                            </select>
                        </div>
                    </div>

                    <#--Город, адрес-->
                    <div class="row">
                        <div class="col">
                            <label for="city" class="form-label fs-4">Город</label>
                            <input type="text" name="city" value="${person.city}" class="form-control" id="city">
                        </div>
                        <div class="col">
                            <label for="address" class="form-label fs-4">Адрес</label>
                            <input type="text" name="address" value="${person.address}" class="form-control"
                                   id="address">
                        </div>
                        <div class="col">
                            <label for="education" class="form-label fs-4">Образование</label>
                            <input type="text" name="education" value="${person.education}" class="form-control"
                                   id="education">
                        </div>
                    </div>

                    <#--Телефон, email, фото-->
                    <div class="row">
                        <div class="col">
                            <label for="phone" class="form-label fs-4">Телефон</label>
                            <input type="text" name="phone" value="${person.phone}" class="form-control" id="phone">
                        </div>
                        <div class="col">
                            <label for="email" class="form-label fs-4">email</label>
                            <input type="email" name="email" value="${person.email}" class="form-control" id="email">
                        </div>
                        <div class="col">
                            <label for="file" class="form-label fs-4">Фото</label>
                            <input type="file" name="file" class="form-control" id="file">
                        </div>
                    </div>

                    <#--Поле для примечания-->
                    <label for="comment" class="form-label fs-4">Примечание</label>
                    <textarea name="comment" placeholder="${person.comment}" class="form-control" id="comment"
                              style="height: 200px"></textarea>

                    <button type="submit" class="btn btn-primary">Изменить</button>
                </form>
                <a href="/person/${person.id}/update" class="btn btn-secondary mt-1">Отменить</a>
            </div>
        </div>

        <#if errors??>
            <#list errors as e>
                <h2>${e}</h2>
            </#list>
        <#elseif iinError??>
            <h2>${iinError}</h2>
        </#if>
    </div>
</@main.renderWith>