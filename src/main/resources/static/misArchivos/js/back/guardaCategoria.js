$(function ($) {

    $("#tabla_categorias").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCategoria/"+ this.id, function(){

             $("#enviar_categoria").click(function(ev){
                 ev.preventDefault();


                 $.ajax("guardaCategoria", {
                     type:"post",
                     data : {
                         idCategoria : $("#categoria_id").text(),
                         titulo : $("#categoria_titulo").val()

                     },
                     success : function(data){

                        $(".main-panel").remove();
                        $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                        $(".main-panel").load("/listado_categorias", function(){

                        });

                     },
                 })
            })
         })

    })

})