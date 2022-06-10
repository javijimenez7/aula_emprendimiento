$(function ($) {

    $("#tabla_categorias").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCategoria/"+ this.id, function(){


         })

    })

})