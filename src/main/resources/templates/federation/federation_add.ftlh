<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Добавить федерацию">
    <div class="container">

        <div class="card my-3">
            <div class="card-body">
                <h1>Добавить федерацию</h1>

                <form action="/federation" method="post">

                    <#--Название, ФИО директора-->
                    <div class="row">
                        <div class="col">
                            <label for="name" class="form-label fs-4">Название</label>
                            <input type="text" name="name" <#if federationDTO??> value='${federationDTO.name}' </#if> class="form-control" id="name">
                        </div>
                        <div class="col">
                            <label for="director" class="form-label fs-4">ФИО директора</label>
                            <input type="text" name="director" <#if federationDTO??> value='${federationDTO.director}' </#if> class="form-control" id="director">
                        </div>
                    </div>

                    <#--Адрес, телефон-->
                    <div class="row">
                        <div class="col">
                            <label for="address" class="form-label fs-4">Адрес</label>
                            <input type="text" name="address" <#if federationDTO??> value='${federationDTO.address}' </#if> class="form-control" id="address">
                        </div>
                        <div class="col">
                            <label for="phone" class="form-label fs-4">Телефон</label>
                            <input type="text" name="phone" <#if federationDTO??> value='${federationDTO.phone}' </#if>' class="form-control" id="phone">
                        </div>
                    </div>

                    <#--email, пароль-->
                    <div class="row">

                        <div class="col">
                            <label for="email" class="form-label fs-4">email</label>
                            <input type="email" name="email" <#if federationDTO??> value='${federationDTO.email}' </#if> class="form-control" id="email">
                        </div>
                        <div class="col">
                            <label for="password" class="form-label fs-4">Пароль</label>
                            <input type="password" name="password" <#if federationDTO??> value='${federationDTO.password}'  </#if> class="form-control" id="password">
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary mt-1">Добавить</button>
                </form>
            </div>
        </div>

        <#if errors??>
            <#list errors as e>
                <h2>$${e.field} - ${e.defaultMessage!'__no message__'}</h2>
            </#list>
        </#if>
    </div>
</@main.renderWith>