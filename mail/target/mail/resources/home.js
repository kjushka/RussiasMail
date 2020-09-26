var url ="http://localhost:8080/mail/"

$(document).ready(function(){
    $("#butt").click(function (e){
        e.preventDefault();
        location.href = url +"form";
    })
})