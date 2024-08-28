
getAllEmployee();
function saveEmploye() {


    var name = $("#exampleFormControlInput2").val();
    var address = $("#exampleFormControlInput3").val();
    var number = $("#exampleFormControlInput4").val();

    console.log(name, address, number);
    //use jqurey

    $.ajax({
        url: "http://localhost:8080/api/v1//employee/saveEmployee",
        type: "POST",
        contentType: "application/json",
        async:true,
        data: JSON.stringify({
            "empID": "",
            "empName": name,
            "empAddress": address,
            "empMobile": number
        }),
        dataType: "json",

        success: function (data) {
            console.log(data);
            alert("saved");
            getAllEmployee();
        },
        error: function (data) {
            console.log(data);
        }
    });



}


function updateEmploye() {


    var name = $("#exampleFormControlInput2").val();
    var address = $("#exampleFormControlInput3").val();
    var number = $("#exampleFormControlInput4").val();

    console.log(name, address, number);
    //use jqurey

    $.ajax({
        url: "http://localhost:8080/api/v1//employee/updateEmployee",
        type: "PuT",
        contentType: "application/json",
        async:true,
        data: JSON.stringify({
            "empID": "",
            "empName": name,
            "empAddress": address,
            "empMobile": number
        }),
        dataType: "json",

        success: function (data) {
            console.log(data);
            alert("saved");
            getAllEmployee();
        },
        error: function (data) {
            console.log(data);
        }
    });



}


function deleteEmploye() {

let empID=$("#exampleFormControlInput1").val();



    $.ajax({
        url: "http://localhost:8080/api/v1//employee/deleteEmployee/"+empID,
        type: "DELETE",
        async:true,
        success: function (data) {
            console.log(data);
            alert("Delected");
            getAllEmployee();
        },
        error: function (data) {
            console.log(data);
        }
    });



}

function getAllEmployee() {


    $.ajax({
        url: "http://localhost:8080/api/v1//employee/getAllEmployee",
        type: "GET",
        contentType: "application/json",
        async:true,


        success: function (data) {
           if (data.code==="00"){
$("#empTabel").empty();

for (let emp of data.content){

    let empID = emp.empID;
    let Name = emp.empName;
    let Address = emp.empAddress;
    let Mobile = emp.empMobile;
    var row = `<tr><td>${empID}</td><td>${Name}</td><td>${Address}</td><td>${Mobile}</td></tr>`;
    $("#empTabel").append(row);
}
           }
        },
        error: function (data) {
            console.log(data);
        }
    });



}

$(document).ready(function () {

    $(document).on("click",'#empTabel tr',function () {

        $("#exampleFormControlInput1").val($(this).find('td:eq(0)').text());
        $("#exampleFormControlInput2").val($(this).find('td:eq(1)').text());
        $("#exampleFormControlInput3").val($(this).find('td:eq(2)').text());
        $("#exampleFormControlInput4").val($(this).find('td:eq(3)').text());
    });


})