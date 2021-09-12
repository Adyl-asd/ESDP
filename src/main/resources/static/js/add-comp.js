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
const ageAndRankInput = $("#ageAndRankInput")


function save_program() {
    let disciplineType = $("#disciplineType option:selected").text()
    let competitionProgram = $("#competitionProgram option:selected").text()


    const firstTable = `
                                <tr class="first-table-row">
                                    <td>
                                        <div class="row">
                                            <div class="col">
                                                ${disciplineType}
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center text-capitalize">
                                        <div class="row">
                                            <div class="col">
                                                ${competitionProgram}
                                            </div>
                                        </div>

                                    </td>
                                    <td>
                                        <div class="btn btn-danger delete-discipline-program-btn">Удалить</div>
                                    </td>
                                </tr>
`
    $('#program_table_body').prepend(firstTable)
    typeAndProgramInput.attr("hidden", true)
    $("#save_program_btn").attr("hidden", true)
    $("#cancel_program_btn").attr("hidden", true)
    $("#add_program_btn").removeAttr("hidden")

    $('.delete-discipline-program-btn').on('click', function () {
        $(this).closest('.first-table-row').remove();
    })

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

function save_age() {
    let rank = $("#rank option:selected").text()
    let compStartAge = $("#comp-start-age").val()
    let compEndAge = $("#comp-end-age").val()

    const secondTable = `
                                <tr class="second-table-row">
                                    <td>
                                        ${rank}
                                    </td>
                                    <td>
                                        ${compStartAge} - ${compEndAge}
                                    </td>
                                    <td>
                                        <div class="btn btn-danger delete-rank-age-btn">Удалить</div>
                                    </td>
                                </tr>
    `

    $('#age_rank_table_body').prepend(secondTable)
    ageAndRankInput.attr("hidden", true)
    $("#save_age_btn").attr("hidden", true)
    $("#add_age_btn").removeAttr("hidden")
    $("#cancel_age_btn").attr("hidden", true)

    $('.delete-rank-age-btn').on('click', function () {
        $(this).closest('.second-table-row').remove();
    })
}

function add_age() {
    $("#add_age_btn").attr("hidden", true)
    $("#save_age_btn").removeAttr("hidden")
    ageAndRankInput.removeAttr("hidden")
    $("#cancel_age_btn").removeAttr("hidden")
}

function cancel_age() {
    ageAndRankInput.attr("hidden", true)
    $("#save_age_btn").attr("hidden", true)
    $("#add_age_btn").removeAttr("hidden")
    $("#cancel_age_btn").attr("hidden", true)
}


