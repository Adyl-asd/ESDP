$('#discipline').change(function () {
    console.log("aaaaaa")
    let disciplineId = $(this).val()
    $.ajax({
        url: `http://localhost:8080/api/competition/disciplines/types/${disciplineId}`,
        type: "GET",
        success: function (disciplineTypes) {
            $("#disciplineType").empty()
            $("#disciplineType").append(`<option selected>Выберите дисциплину</option>`)
            for (let i = 0; i < disciplineTypes.length; i++) {
                $("#disciplineType").append(`<option value="${disciplineTypes[i].id}">${disciplineTypes[i].name}</option>`)
            }
            console.log("bbbbbbbb")
        }
    })
})
