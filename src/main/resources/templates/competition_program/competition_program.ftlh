<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="${program.name}" styles=["css/athlete.css"]>
    <div class="container">
        <div class="main-body">
            <div class="row gutters-sm">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div class="mt-3">
                                    <h4>${program.name}</h4>
                                    <p>Дисциплина:
                                        <a href="/discipline_type/${program.discipline.id}">${program.discipline.name}</a>
                                    </p>
                                    <p>Пол: ${program.discipline.gender.name}</p>
                                    <p>Вид спорта: ${program.discipline.discipline.name}</p>
                                    <a href="/competition_program/${program.id}/update" class="btn btn-primary">Внести изменения</a>
                                    <form action="/competition_program/${program.id}" method="post">
                                        <button class="btn btn-danger mt-1">Удалить программу</button>
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