<#--Код для вставки основного шаблона в страницу-->
<#import "../partials/main.ftlh" as main/>

<@main.renderWith title="Шаблоны">

    <div class="container">
        <div class="card">
            <div class="card-body">
                Блоки желательно оборачивать в классы .card и .card-body
            </div>
        </div>
        <hr>
        <div class="card py-4 mt-2">
            <div class="card-body">
                <p>Отступы можно задавать классами .m (margin), .p (padding)</p>
                <p>Направления отступов: t (вверх), b (вниз), s (слева), e (справа), x (слева и справа), y (вверх и
                    вниз)</p>
                <p>И значение от 1 до 5, например .mt-3 (margin сверху на 3 единицы), .px-1 (padding слева и справа на 1
                    единицу)</p>
            </div>
        </div>
        <hr>
        <div class="card">
            <div class="card-body">
                <p>Для контейнера используем стандартный класс .container</p>
                <p>Все файлы стилей и js уже подключены в основном шаблоне main.ftlh, в нем же встроены навбар и
                    футер</p>
            </div>
        </div>

        <hr>
        <div class="card">
            <div class="card-body">
                Добавить/изменить .btn-primary
                <div class="btn btn-primary">Добавить</div>
                <div class="btn btn-primary">Изменить</div>
            </div>
        </div>

        <hr>
        <div class="card">
            <div class="card-body">
                Удалить .btn-danger
                <div class="btn btn-danger">Удалить</div>
            </div>
        </div>

        <hr>
        <div class="card">
            <div class="card-body">
                <p>К ссылкам добавляем класс .link-dark для стилизации под темный цвет</p>
                <a href="#" class="link-dark">Ссылка</a>
            </div>
        </div>

        <hr>
        <div class="card">
            <div class="card-body">
                <h4>Формы</h4>
                <p>Для label используем класс .form-label, для input - .form-control</p>
                <p>Для вставки инпутов в один ряд оборачиваем их вместе с лэйблами в класс .row и .col</p>
                <p>Не забываем, что бутстрап поддерживает сетку, которая состоит из 12 "блоков". То есть в классе .col
                    можно указывать, сколько этих блоков будет занимать объект.</p>
                <div class="row">
                    <form>
                        <div class="col-4">
                            <label for="surname" class="form-label fs-4">Фамилия</label>
                            <input type="text" name="surname" value="test" class="form-control" id="surname">
                        </div>
                        <div class="col-2">
                            <label for="name" class="form-label fs-4">Имя</label>
                            <input type="text" name="name" value="test" class="form-control" id="name">
                        </div>
                        <div class="col-6">
                            <label for="middleName" class="form-label fs-4">Отчество</label>
                            <input type="text" name="middleName" value="test" class="form-control" id="middleName">
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

</@main.renderWith>