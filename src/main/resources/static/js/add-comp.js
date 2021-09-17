let competitionId

// Function that executes on click of first next button.
function next_step() {

    const firstForm = $('#first-form')
    var formData = new FormData(document.getElementById('first-form'))

    $.ajax({
        url: "http://localhost:8080/api/competition",
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (result) {
            competitionId = result.id
        }
    })

    $('#first').attr('hidden', true)
    $('#second').removeAttr('hidden')
    $('#pre_btn').removeAttr('hidden')
    $('#send-form-btn').removeAttr('hidden')
}

// Function that executes on click of first previous button.
function prev_step() {
    $('#first').removeAttr('hidden')
    $('#second').attr('hidden', true)
    $('#pre_btn').attr('hidden', true)
    $('#send-form-btn').attr('hidden', true)
    $('#next_btn').attr('hidden', true)
    $('#update_btn').removeAttr('hidden')
    $('#competitionProgramDiv').attr("hidden", true)
    $('#ageCategoryDiv').attr("hidden", true)

}

function update_comp() {
    var formData = new FormData(document.getElementById('first-form'))

    $.ajax({
        url: `http://localhost:8080/api/competition/${competitionId}/update`,
        type: "PUT",
        data: formData,
        processData: false,
        contentType: false
    })

    $('#first').attr('hidden', true)
    $('#second').removeAttr('hidden')
    $('#pre_btn').removeAttr('hidden')
    $('#send-form-btn').removeAttr('hidden')
}

$('#discipline').change(function () {
    let disciplineId = $(this).val()
    $.ajax({
        url : `http://localhost:8080/api/competition/disciplines/${disciplineId}/`,
        type : "GET",
        success : function (result) {
            if (result.teamChampByDisciplineType === false) {
                $("#newTeamChampionshipDiv").append($("#teamChampionshipDiv"))
            } else {
                $("#oldTeamChampionshipDiv").append($("#teamChampionshipDiv"))
            }
            $.ajax({
                url : `http://localhost:8080/api/competition/disciplines/types/${disciplineId}/`,
                type : "GET",
                success : function (disciplineTypes) {
                    $("#disciplineType").empty()
                    $("#disciplineType").append(`<option selected>Выберите дисциплину</option>`)
                    for (let i = 0; i < disciplineTypes.length; i++) {
                        $("#disciplineType").append(`<option value="${disciplineTypes[i].id}">${disciplineTypes[i].name}</option>`)
                    }
                }
            })
        }
    })
})

$('#disciplineType').change(function () {
    let disciplineTypeId = $(this).val()
    $.ajax({
        url : `http://localhost:8080/api/competition/disciplines/programs/${disciplineTypeId}`,
        type : "GET",
        success : function (competitionPrograms) {
            $('#competitionProgramDiv').empty()
            $('#competitionProgramDiv').removeAttr("hidden")
            for (let i = 0; i < competitionPrograms.length; i++) {
                $("#competitionProgramDiv").append(`
                    <div class="form-check">
                        <input class="form-check-input competition-program-input"
                        type="checkbox"
                        name="disciplineTypeId" value="${competitionPrograms[i].id}"
                        id="disciplineType">
                        <label class="form-check-label" for="disciplineType">
                            ${competitionPrograms[i].name}
                        </label>
                    </div>
                `)
            }
        }
    })

    $.ajax({
        url : `http://localhost:8080/api/competition/disciplines/ages/${disciplineTypeId}`,
        type : "GET",
        success : function (ageCategories) {
            $('#ageCategoryDiv').empty()
            $('#ageCategoryDiv').removeAttr("hidden")
            let ageCategoryText;
            for (let i = 0; i < ageCategories.length; i++) {
                if (ageCategories[i].maxYear !== null && ageCategories[i].minYear !== null && ageCategories[i].rank !== null) {
                    ageCategoryText = ageCategories[i].maxYear + " - " + ageCategories[i].minYear + " : " + ageCategories[i].rank.name
                }
                if (ageCategories[i].maxYear !== null && ageCategories[i].minYear === null && ageCategories[i].rank !== null) {
                    ageCategoryText = "младше " + ageCategories[i].maxYear  + " : " + ageCategories[i].rank.name
                }
                if (ageCategories[i].maxYear !== null && ageCategories[i].minYear !== null && ageCategories[i].rank === null) {
                    ageCategoryText = ageCategories[i].maxYear + " - " + ageCategories[i].minYear
                }
                if (ageCategories[i].maxYear === null && ageCategories[i].minYear !== null && ageCategories[i].rank !== null) {
                    ageCategoryText = "старше " + ageCategories[i].minYear  + " : " + ageCategories[i].rank.name
                }
                if (ageCategories[i].maxYear === null && ageCategories[i].minYear !== null && ageCategories[i].rank === null) {
                    ageCategoryText = "старше " + ageCategories[i].minYear
                }
                if (ageCategories[i].maxYear !== null && ageCategories[i].minYear === null && ageCategories[i].rank === null) {
                    ageCategoryText = "младше " + ageCategories[i].maxYear
                }
                if (ageCategories[i].maxYear === null && ageCategories[i].minYear === null && ageCategories[i].rank !== null) {
                    ageCategoryText = ageCategories[i].rank.name
                }
                $('#ageCategoryDiv').append(`
                    <div class="form-check">
                        <input class="form-check-input age-category" type="checkbox"
                            value="${ageCategories[i].id}" id="ageCategory"
                            name="ageCategory">
                        <label class="form-check-label" for="ageCategory">${ageCategoryText}</label>
                    </div>
                `)
            }
        }
    })
})




const typeAndProgramInput = $("#disciplineTypeAndProgramInput")


$("#teamChampionship").change(function () {
    if (this.checked) {
        $("#teamChampionshipGeneral").removeAttr("disabled")
        $("#teamChampionshipSeparate").removeAttr("disabled")
    } else {
        $("#teamChampionshipGeneral").attr("disabled", true)
        $("#teamChampionshipSeparate").attr("disabled", true)
    }
});

// $("#allAround").change(function () {
//     for (let i = 0; i < $('.competition-program-input').length; i++) {
//         if (this.checked) {
//             $(".competition-program-input").eq(i).attr("disabled", true)
//         } else {
//             $(".competition-program-input").eq(i).removeAttr("disabled")
//         }
//     }
//
// });

function save_program() {
    let disciplineType = $("#disciplineType option:selected").text()
    let disciplineTypeId = $("#disciplineType option:selected").val()
    let competitionProgram = $("#competitionProgram option:selected").text()
    let competitionProgramId = $("#competitionProgram option:selected").val()
    let rankAndAge = $("#ageCategory option:selected").text()
    let rankAndAgeId = $("#ageCategory option:selected").val()

    let teamChampionship
    let teamChampionshipText

    if ($('#teamChampionshipGeneral').prop("checked") === true && $('#teamChampionshipGeneral').prop("disabled") === false) {
        teamChampionship = 1
        teamChampionshipText = "Командное первенство (Общее)"
    } else if ($('#teamChampionshipSeparate').prop("checked") === true && $('#teamChampionshipSeparate').prop("disabled") === false) {
        teamChampionship = 2
        teamChampionshipText = "Командное первенство (Отдельное)"
    } else {
        teamChampionship = 0
        teamChampionshipText = ""
    }

    // let allAround
    // let allAroundText = ""
    //
    // allAround = !!$('#allAround').prop("checked") === true;
    // if (allAround) {
    //     allAroundText = "Многоборье"
    // }

    const inputResult = `
    <tr class="input-row">
        <td>
            <div>
                ${disciplineType}
                <input type="hidden" value="${disciplineTypeId}" class="disciplineTypeId">
            </div>
            <div>
                ${teamChampionshipText}
                <input type="hidden" value="${teamChampionship}" class="teamChampionship">
            </div>
        </td>
        <td class="program-body">
            <div class="col">
               
            </div>
        </td>
        <td class="age-body">
            
        </td>

        <td>
            <input type="button" class="btn btn-danger delete-discipline-program-btn" value="Удалить">
        </td>
    </tr>
    `

    $('#program_table_body').append(inputResult)
    $.each($("input[name='disciplineTypeId']:checked"), function () {
        let programText = $(this).next('label').text()
        let programValue = $(this).val()
        $($('.program-body')).eq(($('.program-body').length-1)).append(`<div>${programText}</div><input type="hidden" class="competitionProgramId" value="${programValue}">`)
    })
    let maxAthletesText
    let maxClassName
    if (teamChampionship === 0) {
        maxAthletesText = "спортсменов"
        maxClassName = "maxAthletes"
    } else {
        maxAthletesText = "команд"
        maxClassName = "maxTeams"
    }

    $.each($("input[name='ageCategory']:checked"), function () {
        let ageText = $(this).next('label').text()
        let ageValue = $(this).val()
        $($('.age-body')).eq(($('.age-body').length-1)).append(`
    <div class="row my-1">
        <div class="col-8">
            <div>${ageText}</div><input type="hidden" class="ageCategoryId" value="${ageValue}">
        </div>
        <div class="col-2">
            <input type="number" class="form-control form-control-sm ${maxClassName}">
        </div>
        <div class="col-2">
            <label for="" class="form-label">${maxAthletesText}</label>
        </div>
    </div>
    <hr>
`)
    })


    typeAndProgramInput.attr("hidden", true)
    $('#table-body').removeAttr("hidden")
    $("#save_program_btn").attr("hidden", true)
    $("#cancel_program_btn").attr("hidden", true)
    $("#add_program_btn").removeAttr("hidden")

    $('.delete-discipline-program-btn').on('click', function () {
        $(this).closest('.input-row').remove();
    })

}

function send_form() {
    for (let i = 0; i < $('.input-row').length; i++) {
        let disciplineTypeId = $($('.disciplineTypeId'))[i].value
        let teamChampionship = $($('.teamChampionship'))[i].value

        for (let j = 0; j < $('.competitionProgramId').length; j++) {
            $.ajax({
                url: "http://localhost:8080/api/competition/disciplines/programs",
                type: "POST",
                data: {
                    competitionId: competitionId,
                    disciplineTypeId: disciplineTypeId,
                    competitionProgramId: $($('.competitionProgramId'))[j].value,
                }
            })
        }

        for (let j = 0; j < $('.ageCategoryId').length; j++) {
            $.ajax({
                url: "http://localhost:8080/api/competition/disciplines/ages",
                type: "POST",
                data: {
                    teamChampionship : teamChampionship,
                    competitionId: competitionId,
                    disciplineTypeId: disciplineTypeId,
                    ageCategoryId: $($('.ageCategoryId'))[j].value,
                    maxTeams : $($('.maxTeams'))[j].value,
                    maxAthletes : $($('.maxAthletes'))[j].value
                }
            })
        }

    }
}



function add_program() {
    $("#add_program_btn").attr("hidden", true)
    $("#save_program_btn").removeAttr("hidden")
    $("#cancel_program_btn").removeAttr("hidden")
    typeAndProgramInput.removeAttr("hidden")

}

function cancel_program() {
    typeAndProgramInput.attr("hidden", true)
    $("#save_program_btn").attr("hidden", true)
    $("#add_program_btn").removeAttr("hidden")
    $("#cancel_program_btn").attr("hidden", true)
}




