$(function ($) {

    $("#tabla_imagenes").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaImagen/"+ this.id, function(){
              $("#contenedor_archivo").css("visibility", "hidden");
         })
    })

})