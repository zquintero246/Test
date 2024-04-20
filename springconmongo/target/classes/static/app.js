$(document).ready(function () {

    loadTasks();


    $('#taskForm').submit(function (event) {
        event.preventDefault();
        $.post('/tasks', $(this).serialize(), function (data) {
            $('#taskList').append('<li class="list-group-item">' + data.title + '</li>');
        });
        $(this)[0].reset();
    });


    function loadTasks() {
        $.get('/tasks', function (data) {
            data.forEach(function (task) {
                $('#taskList').append('<li class="list-group-item">' + task.title + '</li>');
            });
        });
    }
});
