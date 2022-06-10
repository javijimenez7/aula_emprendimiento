$(function ($) {

    $("#tabla_cursos").find("button").click(function(){
    debugger;
         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCurso/"+ this.id, function(){


             $("#enviar_curso").click(function(ev){
                 ev.preventDefault();


                 $.ajax("guardaCurso", {
                     type:"post",
                     data : {
                         idCurso : $("#curso_id").text(),
                         descripcion : $("#curso_descripcion").val(),
                     },
                     success : function(data){

                        $("#modalHora").find(".modal-body").children().remove();
                        $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                        $("#modalHora").find(".modal-body").append("<p>Curso modificado correctamente</p>");
                        $("#modalHora").modal("show");
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