$(function ($) {

     jQuery.validator.setDefaults({
            debug: true,
            success: "¡Correcto!"
    });

     var validator = $("#formulario_imagen").validate({
        rules: {
            imagen_titulo: {
                required: true,
                rangelength: [4, 25]
            }
        },
        messages: {
            imagen_titulo: {
                required: "Escribe un nombre",
                rangelength: "El titulo debe de tener entre 4 y 25 caracteres"
            }
        }
     })


     $("#enviar_imagen").click(function(ev){
         if(validator.errorList.length==0){

             $.ajax("guardaImagen", {
                 type:"post",
                 data : {
                     idImagen : $("#imagen_id").text(),
                     categoria : $("#imagen_categoria").val(),
                     titulo : $("#imagen_titulo").val(),
                     archivo : $("#contenedor_imagen_img").find("img").attr("src").substr(22)
                 },
                 success : function(data){

                     $("#modalHora").find(".modal-body").children().remove();
                     $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                     $("#modalHora").find(".modal-body").append("<p>Imagen modificada correctamente</p>");
                     $("#modalHora").modal("show");


                     $(".main-panel").remove();
                     $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                     $(".main-panel").load("/galeria", function(){

                    });

                 },
             })
         }else {
            $("#modalHora").find(".modal-body").children().remove();
            $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
            $("#modalHora").find(".modal-body").append("<p>ERROR AL GUARDAR IMAGEN</p>");
            $("#modalHora").modal("show");
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/galeria", function(){

            });
         }
    })
    })