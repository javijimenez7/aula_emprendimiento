$(function ($) {

    // funcion que elimina una actividad y recarga el listado de actividades
    $(".borrar_actividades").click(function(){
                $.ajax("eliminaActividad", {
                 type:"post",
                 data : {
                     idActividad : this.id,
                 },
                 success : function(data){

                    $(".main-panel").remove();
                    $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                    $(".main-panel").load("/listado_actividades", function(){

                    });

                 },
         })

    })
})