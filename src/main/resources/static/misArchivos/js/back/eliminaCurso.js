$(function ($) {
  // funcion que elimina un curso y recarga el listado de cursos
    $(".borrar_cursos").click(function(){

            $.ajax("eliminaCurso", {
             type:"post",
             data : {
                 idCurso : this.id,
             },
             success : function(data){

                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_cursos", function(){

                });

             },
         })

    })
})