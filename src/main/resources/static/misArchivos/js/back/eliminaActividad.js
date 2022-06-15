$(function ($) {

    // funcion que elimina una actividad y recarga el listado de actividades
    $(".borrar_actividades").click(function(){
                $.ajax("eliminaActividad", {
                 type:"post",
                 data : {
                     idActividad : this.id,
                 },
                 success : function(data){

                    $("#modalHora").find(".modal-body").children().remove();
                    $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                    $("#modalHora").find(".modal-body").append("<p>Actividad eliminada correctamente</p>");
                    $("#modalHora").modal("show");
                    $(".main-panel").remove();
                    $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                    $(".main-panel").load("/listado_actividades", function(){

                    });

                 },
         })

    })
})