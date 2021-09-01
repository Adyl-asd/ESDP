<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить человека">
    <div class="container">

        <h1>Добавить персону</h1>

        <form action="/person" method="post" enctype="multipart/form-data">

            <#--ФИО-->
            <div class="row">
                <div class="col">
                    <label for="surname" class="form-label fs-4">Фамилия</label>
                    <input type="text" name="surname" value="test" class="form-control" id="surname">
                </div>
                <div class="col">
                    <label for="name" class="form-label fs-4">Имя</label>
                    <input type="text" name="name" value="test" class="form-control" id="name">
                </div>
                <div class="col">
                    <label for="middleName" class="form-label fs-4">Отчество</label>
                    <input type="text" name="middleName" value="test" class="form-control" id="middleName">
                </div>
            </div>

            <#--Дата рождения, ИИН, пол-->
            <div class="row">
                <div class="col">
                    <label for="birthday" class="form-label fs-4">Дата рождения</label>
                    <input type="date" name="birthday" class="form-control" id="birthday">
                </div>
                <div class="col">
                    <label for="iin" class="form-label fs-4">ИИН</label>
                    <input type="text" name="iin" value="980908405689" class="form-control" id="iin">
                </div>
                <div class="col">
                    <label for="gender" class="form-label fs-4">Пол</label>
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
                    <input type="text" name="city" value="test" class="form-control" id="city">
                </div>
                <div class="col">
                    <label for="address" class="form-label fs-4">Адрес</label>
                    <input type="text" name="address" value="testtesttesttest" class="form-control" id="address">
                </div>
                <div class="col">
                    <label for="education" class="form-label fs-4">Образование</label>
                    <input type="text" name="education" value="testtesttesttest" class="form-control" id="education">
                </div>
            </div>

            <#--Телефон, email, фото-->
            <div class="row">
                <div class="col">
                    <label for="phone" class="form-label fs-4">Телефон</label>
                    <input type="text" name="phone" value="testtesttesttest" class="form-control" id="phone">
                </div>
                <div class="col">
                    <label for="email" class="form-label fs-4">email</label>
                    <input type="email" name="email" value="jane@mail.ru" class="form-control" id="email">
                </div>
                <div class="col">
                    <label for="file" class="form-label fs-4">Фото</label>
                    <input type="file" name="file" class="form-control" id="file">
                </div>
            </div>

            <#--Поле для примечания-->
            <label for="comment" class="form-label fs-4">Примечание</label>
            <textarea name="comment" placeholder="testtesttesttest" class="form-control" id="comment"
                      style="height: 200px"></textarea>

            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
        <#if errors??>
            <#list errors as e>
                <h2>${e}</h2>
            </#list>
        <#elseif iinError??>
            <h2>${iinError}</h2>
        </#if>
    </div>
</@main.renderWith>