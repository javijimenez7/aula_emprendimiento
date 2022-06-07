$(function ($) {

    $("#tabla_cursos").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCurso/"+ this.id, function(){


             $("#enviar_curso").click(function(ev){
                 ev.preventDefault();


                 $.ajax("guardaCurso", {
                     type:"post",
                     data : {
                         idCurso : $("#curso_id").text(),
                         nombre : $("#curso_descripcion").val(),
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

    })

})