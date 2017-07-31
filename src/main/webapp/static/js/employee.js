function buildTable(){
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function(data){
        console.log(data);
        $.each(data, function(index, single){
            var fullName = single.firstName + " " + single.lastName;
            $('#employee-table').find('tbody')
                .append($('<tr>')
                    .append($('<td>').text(single.id))
                    .append($('<td>').text(fullName))
                    .append($('<td>').text(single.background))
                    .append($('<td>').append($('<select class="form-control">').append($('<option>').text("(Select Project)"))))
                    .append($('<td>').append($("<button onclick=editEmployee(" + single.id + ")>").text("Edit")))
                    .append($('<td>').append($("<button data-toggle='modal' data-target='#employeeConfirmDeleteModal' data-record-id='" + single.id + "'>").text("Delete")))
                )
        });
    });
}

function insertEmployee(){
    $('#employeeId').val("");
    $('#employeeVersion').val("");
    $('#inputFirstName').val("");
    $('#inputLastName').val("");
    $('#textAreaBackground').val("");

    $('#employeeModal').modal('show');
}

function saveEmployee(){
    var id = $('#employeeId').val();
    var version = $('#employeeVersion').val();
    var firstName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var background = $('#textAreaBackground').val();

    var employee = {
        id: id,
        version: version,
        firstName: firstName,
        lastName: lastName,
        background: background,
        project: []
    };

    console.log(employee);

    $.ajax({
        type: "post",
        data: employee,
        url: "/api/employee/",
        async: true,
        dataType: "json",
        success: function(){
            window.location.reload();
        }
    })

}

function editEmployee(id){
    //retrieve employee
    $.getJSON('/api/employee/' + id, {
        ajax: 'true'
    }, function(employee){
        console.log(employee);

        $('#employeeId').val(employee.id);
        $('#employeeVersion').val(employee.version);
        $('#inputFirstName').val(employee.firstName);
        $('#inputLastName').val(employee.lastName);
        $('#textAreaBackground').val(employee.background);

        $('#employeeModal').modal('show')
    })

}

function deleteModal(){
    $('#employeeConfirmDeleteModal').on('click', '.btn-ok', function(e){
        var $modalDiv = $(e.delegateTarget);
        var id = $(this).data('recordId');
        $.ajax({
            type: "delete",
            url: "/api/employee/" + id,
            async: true,
            dataType: "json",
            success: function(){
                window.location.reload();
            },
            error: function(){
                alert("Error deleting Employee!");
            }
        })
    });

    $('#employeeConfirmDeleteModal').on('show.bs.modal', function(e){
        var data = $(e.relatedTarget).data();
        $('.btn-ok', this).data('recordId', data.recordId);
    });
}
