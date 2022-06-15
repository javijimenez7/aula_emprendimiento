$(function ($) {
    // funcion que elimina una categoria y recarga el listado de categorias
    $(".borrar_categorias").click(function(){

            $.ajax("eliminaCategoria", {
             type:"post",
             data : {
                 idCategoria : this.id,
             },
             success : function(data){

                $("#modalHora").find(".modal-body").children().remove();
                $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                $("#modalHora").find(".modal-body").append("<p>Categoria eliminada correctamente</p>");
                $("#modalHora").modal("show");
                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_categorias");

             },

             error : function(){
               $("#modalHora").find(".modal-body").children().remove();
               $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
               $("#modalHora").find(".modal-body").append("<p>No puede borrar una categoria asignada a una imagen</p>");
               $("#modalHora").modal("show");

                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_categorias", function(){

                });

             }
         })

    })
})