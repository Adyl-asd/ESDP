<#macro navbar>

    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
        <div class="container">
            <a class="navbar-brand" href="#">Федерация Гимнастики</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Спортсмены</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Тренеры</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Судьи</a>
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