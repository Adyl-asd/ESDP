// Function that executes on click of first next button.
function next_step() {
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

}

const typeAndProgramInput = $("#disciplineTypeAndProgramInput")
const ageAndRankInput = $("#ageAndRankInput")


function save_program() {
    let disciplineType = $("#disciplineType option:selected").text()
    let competitionProgram = $("#competitionProgram option:selected").text()


    const firstTable = `
                                <tr>
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
                                </tr>
`
    $('#program_table_body').prepend(firstTable)
    typeAndProgramInput.attr("hidden", true)
    $("#save_program_btn").attr("hidden", true)
    $("#add_program_btn").removeAttr("hidden")

}

function add_program() {
    $("#add_program_btn").attr("hidden", true)
    $("#save_program_btn").removeAttr("hidden")
    typeAndProgramInput.removeAttr("hidden")

}

function save_age() {
    let rank = $("#rank option:selected").text()
    let compStartAge = $("#comp-start-age").val()
    let compEndAge = $("#comp-end-age").val()

    const secondTable = `
                                <tr>
                                    <td>
                                        ${rank}
                                    </td>
                                    <td>
                                        ${compStartAge} - ${compEndAge}
                                    </td>
                                </tr>
    `

    $('#age_rank_table_body').prepend(secondTable)
    ageAndRankInput.attr("hidden", true)
    $("#save_age_btn").attr("hidden", true)
    $("#add_age_btn").removeAttr("hidden")
}

function add_age() {
    $("#add_age_btn").attr("hidden", true)
    $("#save_age_btn").removeAttr("hidden")
    ageAndRankInput.removeAttr("hidden")
}


