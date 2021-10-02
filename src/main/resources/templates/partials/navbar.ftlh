<#macro navbar>

    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
        <div class="container">
            <a class="navbar-brand" href="/"><img src="images/logo.png" alt="logo" width="50%"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/competitions" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Календарь</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/competitions">Соревнования</a></li>
                            <li><a class="dropdown-item" href="/competitions/add">Добавить соревнование</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Результаты</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/persons" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Персона
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/person/all">Список персон</a></li>
                            <li><a class="dropdown-item" href="/person">Добавить персону</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/athletes" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Спортсмены
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/athletes">Список спортсменов</a></li>
                            <li><a class="dropdown-item" href="/athlete">Добавить спортсмена</a></li>
                            <li><a class="dropdown-item" href="/ranks">Разряды спортсменов</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/coaches" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Тренеры
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/coach/all">Список тренеров</a></li>
                            <li><a class="dropdown-item" href="/coach">Добавить тренера</a></li>
                            <li><a class="dropdown-item" href="/coach_categories">Категории тренеров</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="/judges" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Судьи
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/judge/all">Список судей</a></li>
                            <li><a class="dropdown-item" href="/judge">Добавить судей</a></li>
                            <li><a class="dropdown-item" href="/judge_categories">Категории судей</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="/disciplines">Виды спорта</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/disciplines">Виды спорта</a></li>
                            <li><a class="dropdown-item" href="/discipline_type/all">Дисциплины</a></li>
                            <li><a class="dropdown-item" href="/competition_program/all">Соревновательные программы</a></li>
                            <li><a class="dropdown-item" href="/age_category/all">Возрастные категории</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Школы
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/school/all">Школы</a></li>
                            <li><a class="dropdown-item" href="/school">Добавить школу</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Федерация
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/federation">Добавить федерацию</a></li>
                            <li><a class="dropdown-item" href="/federation/all">Федерации</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="d-flex">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Вход</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Регистрация</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <#nested>

</#macro>