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

     $("#enviar_actividad").click(function(ev){
         if(validator.errorList.length==0){
             var content = tinymce.get('actividad_descripcion').getContent();

             $.ajax("guardaActividad", {
                 type:"post",
                 data : {
                     idActividad : $("#actividad_id").text(),
                     nombre : $("#actividad_nombre").val(),
                     descripcion : content,
                     archivo : $("#contenedor_imagen_actividad").find("img").attr("src").substr(22)
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