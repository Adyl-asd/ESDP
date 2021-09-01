<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить федерацию">
    <div class="container">

        <h1>Добавить федерацию</h1>

        <form action="/federation" method="post">

        <#--Название, ФИО директора-->
            <div class="row">
                <div class="col">
                    <label for="name" class="form-label fs-4">Название</label>
                    <input type="text" name="name" value="test" class="form-control" id="name">
                </div>
                <div class="col">
                    <label for="director" class="form-label fs-4">ФИО директора</label>
                    <input type="text" name="director" value="test" class="form-control" id="director">
                </div>
            </div>

            <#--Адрес, телефон-->
            <div class="row">
                <div class="col">
                    <label for="address" class="form-label fs-4">Адрес</label>
                    <input type="text" name="address" value="testtesttesttest" class="form-control" id="address">
                </div>
                <div class="col">
                    <label for="phone" class="form-label fs-4">Телефон</label>
                    <input type="text" name="phone" value="testtesttesttest" class="form-control" id="phone">
                </div>
            </div>

            <#--email, пароль-->
            <div class="row">

                <div class="col">
                    <label for="email" class="form-label fs-4">email</label>
                    <input type="email" name="email" value="jane@mail.ru" class="form-control" id="email">
                </div>
                <div class="col">
                    <label for="password" class="form-label fs-4">Пароль</label>
                    <input type="password" name="password" class="form-control" id="password">
                </div>
            </div>

            <button type="submit" class="btn btn-primary mt-1">Добавить</button>
        </form>
        <#if errors??>
            <#list errors as e>
                <h2>${e}</h2>
            </#list>
            <h2></h2>
        </#if>
    </div>
</@main.renderWith>