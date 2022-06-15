$(function ($) {

    // funcion que elimina una actividad y recarga el listado de actividades
   // funcion que elimina una imagen y recarga el listado de imagenes
    $(".borrar_imagenes").click(function(){
            $.ajax("eliminaImagen", {
             type:"post",
             data : {
                 idImagen : this.id,
             },
             success : function(data){

                $("#modalHora").find(".modal-body").children().remove();
                $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                $("#modalHora").find(".modal-body").append("<p>Imagen eliminada correctamente</p>");
                $("#modalHora").modal("show");
                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/galeria", function(){

                });

             },
         })

    })
})