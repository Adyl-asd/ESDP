const disciplineId = $('#discipline-id')

$('#select-school').change(function () {
    let schoolId = $(this).val()
    let athleteUl = $('.athlete-ul')
    let athleteLi = $('.athletes-li')
    let ageCategoryDiv = $('.age-category-div')
    let selectAthlete = $('.select-athlete')
    for (let i = 0; i < ageCategoryDiv.length; i++) {
        let ageCategoryId = $(ageCategoryDiv).eq(i).find($('.age-category-id')).val()
        for (let j = 0; j < $(ageCategoryDiv).eq(i).find(athleteLi).length; j++) {
            $.ajax({
                url : `http://localhost:8080/api/athlete/${ageCategoryId}`,
                type : 'GET',
                data : {
                    id : ageCategoryId,
                    schoolId : schoolId,
                    disciplineId : disciplineId
                },
                success : function (athlete) {
                    console.log(athlete)
                    for (let k = 0; k < $(ageCategoryDiv).eq(i).find(athleteLi).eq(j).find(selectAthlete).length; k++) {
                        $(ageCategoryDiv).eq(i).find(athleteLi).eq(j).find(selectAthlete).eq(k).append(`
                            <option value="${athlete.id}">${athlete.person.surname} ${athlete.person.name} ${athlete.person.middleName}</option>
                        `)
                    }
                }
            })
        }

    }
})

$('.add-additional-athlete-btn').on('click', function () {
    if (!$(this).closest('.additional-athletes-div').find('.additional-athletes-ul').is(':visible')) {
        $(this).closest('.additional-athletes-div').find('.additional-athletes-text').removeAttr('hidden')
        $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').removeAttr('hidden')
    } else {
        $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').append($(this).closest('.additional-athletes-div').find('.athletes-li').eq(0).clone())
    }
})

$(document).on('click', '.delete-additional-athlete-btn', function () {
    if ($(this).closest('.additional-athletes-div').find('.athletes-li').length > 1) {
        $(this).closest('.athletes-li').remove()
    } else {
        $(this).closest('.additional-athletes-div').find('.additional-athletes-text').prop('hidden', true)
        $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').prop('hidden', true)
    }
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

$(".toggle-btn").click(function() {
    $(this).closest('.card-body').find('.toggle-div').toggle(500)
})

$(".first-type").on("click", function () {
    let count = $(this).closest('.list-group-item').find('.first-type:checked').length;
    if (count < 5) {  // we only want to allow 5 to be checked here.
        $(this).closest('.list-group-item').find('.first-type').removeAttr("disabled");
        // re-enable all checkboxes
    } else {
        $(this).closest('.list-group-item').find('.first-type').prop("disabled","disabled");
        // disable all checkboxes
        $(this).closest('.list-group-item').find('.first-type:checked').removeAttr("disabled");
        // only enable the elements that are already checked.
    }
});

$(".second-type").on("click", function () {
    let count = $(this).closest('.list-group-item').find('.second-type:checked').length;
    if (count < 5) {  // we only want to allow 3 to be checked here.
        $(this).closest('.list-group-item').find('.second-type').removeAttr("disabled");
        // re-enable all checkboxes
    } else {
        $(this).closest('.list-group-item').find('.second-type').prop("disabled","disabled");
        // disable all checkboxes
        $(this).closest('.list-group-item').find('.second-type:checked').removeAttr("disabled");
        // only enable the elements that are already checked.
    }
});
