$(function ($) {
  // funcion que elimina un curso y recarga el listado de cursos
    $(".borrar_cursos").click(function(){

            $.ajax("eliminaCurso", {
             type:"post",
             data : {
                 idCurso : this.id,
             },
             success : function(data){

                $("#modalHora").find(".modal-body").children().remove();
                $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                $("#modalHora").find(".modal-body").append("<p>Curso eliminado correctamente</p>");
                $("#modalHora").modal("show");
                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_cursos", function(){

                });

             },
         })

    })
})