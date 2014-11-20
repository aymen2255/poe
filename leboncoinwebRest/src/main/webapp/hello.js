$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/leboncoinwebRest/user"
    }).then(function(data) {
       $('.user-id').append(data.id);
       $('.user-content').append(data.content);
    });
});