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
        $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').append($(this).closest('.additional-athletes-div').find('.additional-athletes-li').eq(0).clone())
    }
})

$(document).on('click', '.delete-additional-athlete-btn', function () {
    if ($(this).closest('.additional-athletes-div').find('.additional-athletes-li').length > 1) {
        $(this).closest('.additional-athletes-li').remove()
    } else {
        $(this).closest('.additional-athletes-div').find('.additional-athletes-text').prop('hidden', true)
        $(this).closest('.additional-athletes-div').find('.additional-athletes-ul').prop('hidden', true)
    }
})

$('#add-additional-coach-btn').on('click', function () {
    $(this).closest('.coaches-div').find('.coaches-ul').append($(this).closest('.coaches-div').find('.coach-li').eq(0).clone())
    $(this).closest('.coaches-div').find('.coach-li').eq($(this).closest('.coaches-div').find('.coach-li').length-1).find('.row').append(`
        <div class="col">
            <button class="btn btn-danger delete-additional-btn">
                Удалить
            </button>
        </div>
    `)
})

$('#add-additional-judge-btn').on('click', function () {
    $(this).closest('.judges-div').find('.judges-ul').append($(this).closest('.judges-div').find('.judge-li').eq(0).clone())
    $(this).closest('.judges-div').find('.judge-li').eq($(this).closest('.judges-div').find('.judge-li').length-1).find('.row').append(`
        <div class="col">
            <button class="btn btn-danger delete-additional-btn">
                Удалить
            </button>
        </div>
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

$('#send-application-btn').on('click', function () {
    let disciplineTypeId = $('.discipline-type-id')
    let applicationId = $('#application-id').val()
    let competitionId = $('#competition-id').val()

    // Пост запрос на добавление спортсменов
    for (let i = 0; i < disciplineTypeId.length; i++) {
        let disciplineTypeIdInputValue = $(disciplineTypeId).eq(i).val()
        let disciplineTypeDiv = $(disciplineTypeId).eq(i).closest('.discipline-type-div')
        let ageCategoryDivs = disciplineTypeDiv.find('.age-category-div')
        for (let j = 0; j < ageCategoryDivs.length; j++) {
            let ageCategoryId = ageCategoryDivs.eq(j).find('.age-category-id').val()
            let athletesTeamLi = ageCategoryDivs.eq(j).find('.athletes-team-li')
            let athletesLi = ageCategoryDivs.eq(j).find('.athletes-li')
            let additionalAthletesDiv = ageCategoryDivs.eq(j).find('.additional-athletes-div')
            // teamNumber: 0 - нет команды, -1 - доп. спорстмен, остальные положительные числа - номер команды
            let teamNumber
            if (athletesTeamLi.length) {
                for (let k = 0; k < athletesTeamLi.length; k++) {
                    let athletesDiv = athletesTeamLi.eq(k).find('.athletes-div')
                    teamNumber = k+1
                    for (let l = 0; l < athletesDiv.length; l++) {
                        let teamAthleteId = athletesDiv.eq(l).find('.select-athlete').val()
                        $.ajax({
                            url : "http://localhost:8080/api/participation-application/athlete",
                            type : "POST",
                            data : {
                                applicationId : applicationId,
                                athleteId : teamAthleteId,
                                disciplineAgeId : ageCategoryId,
                                disciplineTypeId : disciplineTypeIdInputValue,
                                teamNumber : teamNumber
                            }
                        })
                    }
                }
            } else {
                for (let k = 0; k < athletesLi.length; k++) {
                    let athleteId = athletesLi.eq(k).find('.select-athlete').val()
                    teamNumber = 0
                    $.ajax({
                        url : "http://localhost:8080/api/participation-application/athlete",
                        type : "POST",
                        data : {
                            applicationId : applicationId,
                            athleteId : athleteId,
                            disciplineAgeId : ageCategoryId,
                            disciplinesTypeId : disciplineTypeIdInputValue,
                            teamNumber : teamNumber
                        }
                    })
                }
            }

            if (additionalAthletesDiv.find('.additional-athletes-ul').is(':visible')) {
                let additionalAthleteLi = additionalAthletesDiv.eq(j).find('.additional-athletes-li')
                for (let k = 0; k < additionalAthleteLi.length; k++) {
                    let additionalAthleteId = additionalAthleteLi.eq(k).find('.select-athlete-additional').val()
                    teamNumber = -1
                    $.ajax({
                        url : "http://localhost:8080/api/participation-application/athlete",
                        type : "POST",
                        data : {
                            applicationId : applicationId,
                            athleteId : additionalAthleteId,
                            disciplineAgeId : ageCategoryId,
                            disciplineTypeId : disciplineTypeIdInputValue,
                            teamNumber : teamNumber
                        }
                    })
                }
            }

        }
    }

    // Пост запрос на добавление тренеров
    const coachesDiv = $('.coaches-div')
    let coachLi = coachesDiv.find('.coach-li')
    for (let i = 0; i < coachLi.length; i++) {
        let coachId = coachLi.eq(i).find('.select-coach').val()
        $.ajax({
            url : "http://localhost:8080/api/participation-application/coach",
            type : "POST",
            data : {
                applicationId : applicationId,
                coachId : coachId,
            }
        })
    }

    // Пост запрос на добавление судей
    const judgesDiv = $('.judges-div')
    let judgeLi = judgesDiv.find('.judge-li')
    for (let i = 0; i < judgeLi.length; i++) {
        let judgeId = judgeLi.eq(i).find('.select-judge').val()
        $.ajax({
            url : "http://localhost:8080/api/participation-application/judge",
            type : "POST",
            data : {
                applicationId : applicationId,
                judgeId : judgeId,
            }
        })
    }
})
