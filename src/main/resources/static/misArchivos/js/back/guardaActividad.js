$(function ($) {

   jQuery.validator.setDefaults({
          debug: true,
          success: "¡Correcto!"
      });

   var validator = $("#formulario_actividad").validate({
          rules: {
              actividad_nombre: {
                  required: true,
                  rangelength: [5, 25]
              }
          },
          messages: {
              actividad_nombre: {
                  required: "Escribe un nombre",
                  rangelength: "El nombre debe de tener entre 5 y 25 caracteres"
              }
          }
   })

    $("#formulario_actividad").on("submit", function(e){
         debugger;
            e.preventDefault();
            var f = $(this);
            var formData = new FormData();
            var file = $("#actividad_archivo")[0].files[0];
            formData.append("imagen_archivo", file);
            if(validator.errorList.length==0 && $("#actividad_nombre").val() != ""){
            var content = tinymce.get('actividad_descripcion').getContent();
            if($("#actividad_id").text() != "0"){

                $.ajax("modificaActividad", {
                     type:"post",
                     data : {
                         idActividad : $("#actividad_id").text(),
                         nombre : $("#actividad_nombre").val(),
                         descripcion : content,
                     },

                     success : function(data){

                         $("#modalHora").find(".modal-body").children().remove();
                         $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                         $("#modalHora").find(".modal-body").append("<p>Actividad modificada correctamente</p>");
                         $("#modalHora").modal("show");


                         $(".main-panel").remove();
                         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                         $(".main-panel").load("/listado_actividades", function(){

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
                    $.ajax("guardaActividad", {
                         type:"post",
                         data : {
                              idActividad : $("#actividad_id").text(),
                              nombre : $("#actividad_nombre").val(),
                              descripcion : content,
                              archivo : file.name
                         },

                         success : function(data){

                             $("#modalHora").find(".modal-body").children().remove();
                             $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                             $("#modalHora").find(".modal-body").append("<p>Actividad añadida correctamente</p>");
                             $("#modalHora").modal("show");


                             $(".main-panel").remove();
                             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                             $(".main-panel").load("/listado_actividades", function(){

                            });

                         },
                     })
                 })
            }

         }else {
            $("#modalHora").find(".modal-body").children().remove();
            $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
            $("#modalHora").find(".modal-body").append("<p>ERROR AL GUARDAR ACTIVIDAD</p>");
            $("#modalHora").modal("show");
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/listado_actividades", function(){

            });
         }
    })
 })