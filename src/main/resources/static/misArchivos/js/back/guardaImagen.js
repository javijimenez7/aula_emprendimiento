$(function ($) {

    $("#tabla_imagenes").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaImagen/"+ this.id, function(){

            $("#imagen_archivo").change(function(){
                $("#contenedor_imagen_img").find("img").attr("src", "../../misArchivos/img/"+ $("#imagen_archivo").val().substr(12));
            })

             $("#enviar_imagen").click(function(ev){
                 ev.preventDefault();


                 $.ajax("guardaImagen", {
                     type:"post",
                     data : {
                         idImagen : $("#imagen_id").text(),
                         categoria : $("#imagen_categoria").val(),
                         titulo : $("#imagen_titulo").val(),
                         archivo : $("#contenedor_imagen_img").find("img").attr("src").substr(22)
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

    })

})