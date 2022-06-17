$(function ($) {

    //Escondemos el campo de empresa desde el inicio
     $(".empresa").css("display","none");

     var id = $("#boxes").id;

    // Controlar si es empresa o alumno
    $("#bEmpresa").click(function(){
        if($("#bEmpresa").prop('checked')){
            $(".alumno").css("display","none");
            $(".empresa").css("display","inline-block");
        } else {
             $(".empresa").css("display","none");
             $(".alumno").css("display","block");
        }
    })



    //Enviar el formulario mediante ajax

    $("#btnEnviar").click(function(ev){


        ev.preventDefault();
        var nombre = $("#name").val();
        var apellidos = $("#surname").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var mensaje = $("#mensaje").val();
        var asunto = $("#asunto").val();
        var empresa = $("#empresa").val();
        var curso = $("#curso").val();
        var array = [nombre, apellidos, email, phone, mensaje, asunto, empresa, curso];

        $.ajax("enviaformulario", {
            type:"post",
            data : {
                contacto : JSON.stringify(array)
            },
            success : function(data){

                $("#empresa").val("");
                $("#btn_modal").trigger("click");


            },

        })

        $("#exampleModal").find("button").click(function(ev){
            ev.preventDefault();
           º
        })

    })



})
