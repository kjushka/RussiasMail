var url ="http://localhost:8000/mail/"

$(document).ready(function(){
    $("#butt").click(function (e){
        e.preventDefault();
        location.href = url +"form";
    })
})