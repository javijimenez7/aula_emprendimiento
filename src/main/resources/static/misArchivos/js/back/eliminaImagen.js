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

                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/galeria", function(){

                });

             },
         })

    })
})