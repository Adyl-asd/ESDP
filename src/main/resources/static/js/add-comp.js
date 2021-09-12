let competitionId

// Function that executes on click of first next button.
function next_step() {

    const firstForm = $('#first-form')
    var formData = new FormData(document.getElementById('first-form'))

    $.ajax({
        url : "http://localhost:8080/api/competition",
        type : "POST",
        data : formData,
        processData : false,
        contentType : false,
        success : function (result) {
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

}

function update_comp() {
    var formData = new FormData(document.getElementById('first-form'))

    $.ajax({
        url : `http://localhost:8080/api/competition/${competitionId}/update`,
        type : "PUT",
        data : formData,
        processData : false,
        contentType : false
    })

    $('#first').attr('hidden', true)
    $('#second').removeAttr('hidden')
    $('#pre_btn').removeAttr('hidden')
    $('#send-form-btn').removeAttr('hidden')
}


const typeAndProgramInput = $("#disciplineTypeAndProgramInput")


function save_program() {
    let disciplineType = $("#disciplineType option:selected").text()
    let disciplineTypeId = $("#disciplineType option:selected").val()
    let competitionProgram = $("#competitionProgram option:selected").text()
    let competitionProgramId = $("#competitionProgram option:selected").val()
    let rankAndAge = $("#rank option:selected").text()
    let rankAndAgeId = $("#rank option:selected").val()


    const inputResult = `
                                <tr class="first-table-row">
                                    <td>
                                        <div class="row">
                                            <div class="col">
                                                ${disciplineType}
                                                <input type="hidden" value="${disciplineTypeId}" class="disciplineTypeId">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center text-capitalize">
                                        <div class="row">
                                            <div class="col">
                                                ${competitionProgram}
                                                <input type="hidden" value="${competitionProgramId}" class="competitionProgramId">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center text-capitalize">
                                        <div class="row">
                                            <div class="col">
                                                ${rankAndAge}
                                                <input type="hidden" value="${rankAndAgeId}" class="rankAndAgeId">
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="btn btn-danger delete-discipline-program-btn">Удалить</div>
                                    </td>
                                </tr>
`
    $('#program_table_body').prepend(inputResult)
    typeAndProgramInput.attr("hidden", true)
    $("#save_program_btn").attr("hidden", true)
    $("#cancel_program_btn").attr("hidden", true)
    $("#add_program_btn").removeAttr("hidden")

    $('.delete-discipline-program-btn').on('click', function () {
        $(this).closest('.first-table-row').remove();
    })

}

function send_form() {
    for (let i = 0; i < $('.first-table-row').length; i++) {

        $.ajax({
            url : "http://localhost:8080/api/competition/disciplines",
            type : "POST",
            data : {
                competitionId : competitionId,
                disciplineTypeId : $($('.disciplineTypeId'))[i].value,
                ageCategoryId : $($('.competitionProgramId'))[i].value,
                competitionProgramId : $($('.rankAndAgeId'))[i].value
            }
        })
    }
    window.location.replace(`http://localhost:8080/competition/${competitionId}`)
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




