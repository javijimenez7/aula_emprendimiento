$(function ($) {
      $("#tabla_cursos").find("button").click(function(){
          debugger;
               $(".main-panel").remove();
               $("<div></div>").addClass("main-panel").appendTo("#contenedor");
               $(".main-panel").load("/cargaPlantillaCurso/"+ this.id, function(){

                })

      })
 });