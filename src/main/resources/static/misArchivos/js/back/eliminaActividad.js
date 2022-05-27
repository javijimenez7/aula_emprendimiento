$(function ($) {

    $(".borrar").click(function(){
    debugger;

        $.ajax("eliminaActividad", {
         type:"post",
         data : {
             idActividad : this.id,
         },
         success : function(data){

            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/actividades", function(){

            });

         },
     })

    })
})