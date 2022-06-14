$(function ($) {

    $("#tabla_imagenes").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaImagen/"+ this.id, function(){
            $("#imagen_archivo").change(function(){
                $("#contenedor_imagen_img").find("img").attr("src", "../../misArchivos/img/"+ $("#imagen_archivo").val().substr(12));
            })
         })
    })

})