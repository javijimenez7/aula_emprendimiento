$(function ($) {

    $("#tabla_actividades").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaActividad/"+ this.id, function(){
            $("#actividad_archivo").change(function(){
                $("#contenedor_imagen_actividad").find("img").attr("src", "../../misArchivos/img/"+ $("#actividad_archivo").val().substr(12));
            })
         })

    })

})