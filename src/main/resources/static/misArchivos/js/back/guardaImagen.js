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


     $("#formulario_imagen").on("submit", function(e){
     debugger;
            e.preventDefault();
            var f = $(this);
            var formData = new FormData();
            var file = $("#imagen_archivo")[0].files[0];
            formData.append("imagen_archivo", file);
            if(validator.errorList.length==0 && $("#imagen_titulo").val() != ""){
            if($("#imagen_id").text() != "0"){

                $.ajax("modificaImagen", {
                     type:"post",
                     data : {
                         idImagen : $("#imagen_id").text(),
                         categoria : $("#imagen_categoria").val(),
                         titulo : $("#imagen_titulo").val(),
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
            } else {
                $.ajax("subirImagen", {
                     type:"post",
                     data : formData,
                     enctype : 'multipart/form-data',
                     cache: false,
                     contentType: false,
                     processData: false,
                     success : function(data){

                     },
                 }).done(function(data){
                    $.ajax("guardaImagen", {
                         type:"post",
                         data : {
                             idImagen : $("#imagen_id").text(),
                             categoria : $("#imagen_categoria").val(),
                             titulo : $("#imagen_titulo").val(),
                             imagen_archivo : file.name
                         },

                         success : function(data){

                             $("#modalHora").find(".modal-body").children().remove();
                             $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                             $("#modalHora").find(".modal-body").append("<p>Imagen añadida correctamente</p>");
                             $("#modalHora").modal("show");


                             $(".main-panel").remove();
                             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                             $(".main-panel").load("/galeria", function(){

                            });

                         },
                     })
                 })
            }

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