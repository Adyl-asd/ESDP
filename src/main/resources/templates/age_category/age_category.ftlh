<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Возрастная категория" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>Возрастная категория ${category.discipline.name}</h4>
                                    <p><#if category.maxYear??>Максимальный возраст: #{category.maxYear}</#if></p>
                                    <p><#if category.minYear??>Минимальный возраст: #{category.minYear}</#if></p>
                                    <p><#if category.rank??>Разряд: ${category.rank.name}</#if></p>
                                    <p>Дисциплина:
                                        <a href="/discipline_type/${category.discipline.id}">${category.discipline.name}</a>
                                    </p>
                                    <p>Пол: ${category.discipline.gender.name}</p>
                                    <p>Вид спорта: ${category.discipline.discipline.name}</p>
                                    <a href="/age_category/${category.id}/update" class="btn btn-primary">Внести изменения</a>
                                    <form action="/age_category/${category.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить категорию</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.renderWith>