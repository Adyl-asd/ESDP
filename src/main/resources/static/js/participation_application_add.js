$('.add-additional-athlete-btn').on('click', function () {
    $(this).closest('.additional-athletes-div').find('.additional-athletes-text').removeAttr('hidden')
    $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').append(`
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <div class="row">
                        <div class="col-auto">
                            <select class="form-select" aria-label="Default select example" id="selectAthlete">
                            <option selected>Выбрать спортсмена</option>
                            </select>
                        </div>
                        <div class="col">
                            <button class="btn btn-danger delete-additional-btn">Удалить</button>
                        </div>
                    </div>
                </div>
            </li>
    `)

})

$('#add-additional-coach-btn').on('click', function () {
    $(this).closest('.card-body').find('.list-group').append(`
        <li class="list-group-item d-flex justify-content-between align-items-start">
            <div class="me-auto">
                <div class="row">
                    <div class="col-auto">
                        <select class="form-select" aria-label="Default select example" id="selectAthlete">
                            <option selected>Выбрать тренера</option>
                        </select>
                    </div>
                        <div class="col">
                        <button class="btn btn-danger delete-additional-btn">Удалить</button>
                    </div>
                </div>
            </div>
        </li>
    `)
})

$('#add-additional-judge-btn').on('click', function () {
    $(this).closest('.card-body').find('.list-group').append(`
        <li class="list-group-item d-flex justify-content-between align-items-start">
            <div class="me-auto">
                <div class="row">
                    <div class="col-auto">
                        <select class="form-select" aria-label="Default select example" id="selectAthlete">
                            <option selected>Выбрать судью</option>
                        </select>
                    </div>
                        <div class="col">
                        <button class="btn btn-danger delete-additional-btn">Удалить</button>
                    </div>
                </div>
            </div>
        </li>
    `)
})

$(document).on('click', '.delete-additional-btn', function () {
    $(this).closest('li').remove()
})