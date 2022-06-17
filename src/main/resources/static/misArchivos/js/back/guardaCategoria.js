$(function ($) {

    jQuery.validator.setDefaults({
        debug: true,
        success: "¡Correcto!"
    });

     var validator = $("#formulario_categoria").validate({
            rules: {
                categoria_nombre: {
                    required: true,
                    rangelength: [4, 25]
                }
            },
            messages: {
                categoria_nombre: {
                    required: "Escribe un nombre",
                    rangelength: "El nombre debe de tener entre 4 y 25 caracteres"
                }
            }
     })


$("#enviar_categoria").click(function(ev){
                 ev.preventDefault();
                 if(validator.errorList.length==0){
                     $.ajax("guardaCategoria", {
                         type:"post",
                         data : {
                             idCategoria : $("#categoria_id").text(),
                             titulo : $("#categoria_titulo").val()

                         },
                         success : function(data){

                            $("#modalHora").find(".modal-body").children().remove();
                            $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                            $("#modalHora").find(".modal-body").append("<p>Categoria modificada correctamente</p>");
                            $("#modalHora").modal("show");
                            $(".main-panel").remove();
                            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                            $(".main-panel").load("/listado_categorias", function(){

                            });

                         },
                     })
                 } else {
                     $("#modalHora").find(".modal-body").children().remove();
                     $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                     $("#modalHora").find(".modal-body").append("<p>ERROR AL GUARDAR CATEGORIA</p>");
                     $("#modalHora").modal("show");
                     $(".main-panel").remove();
                     $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                     $(".main-panel").load("/listado_categorias", function(){

                     });
                 }
            })
         })