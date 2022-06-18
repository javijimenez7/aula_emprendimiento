$(function ($) {

    jQuery.validator.setDefaults({
        debug: true,
        success: "¡Correcto!"
    });

     var validator = $("#formulario_curso").validate({
            rules: {
                curso_descripcion: {
                    required: true,
                    rangelength: [4, 25]
                }
            },
            messages: {
                curso_descripcion: {
                    required: "Escribe un nombre",
                    rangelength: "El curso debe de tener entre 4 y 25 caracteres"
                }
            }
     })


    $("#enviar_curso").click(function(ev){
         if(validator.errorList.length==0 && $("#curso_descripcion").val()!=""){
             ev.preventDefault();

             $.ajax("guardaCurso", {
                 type:"post",
                 data : {
                     idCurso : $("#curso_id").text(),
                     descripcion : $("#curso_descripcion").val(),
                 },
                 success : function(data){

                    $("#modalHora").find(".modal-body").children().remove();
                    $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                    $("#modalHora").find(".modal-body").append("<p>Curso modificado correctamente</p>");
                    $("#modalHora").modal("show");
                    $(".main-panel").remove();
                    $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                    $(".main-panel").load("/listado_cursos", function(){

                    });

                 },
             })
         } else {
            $("#modalHora").find(".modal-body").children().remove();
            $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
            $("#modalHora").find(".modal-body").append("<p>ERROR AL GUARDAR CURSO</p>");
            $("#modalHora").modal("show");
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/listado_cursos", function(){

            });
         }
    })

})