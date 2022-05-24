$(function ($) {

    var contenedorImagenes = $("#contenedor_imagenes");

    $("#numeroImagenes").change(function(){

        $("#contenedor_imagenes").empty();

        for(let i = 0; i<$("#numeroImagenes").val();i++){
            $("<input></input>").attr({
                "type" : "file",
                "id" : "img"+(i+1),
                "class" : "form-group",
            }).appendTo(contenedorImagenes);
            $("<br>").appendTo(contenedorImagenes);
        }

    })


    $("#enviar_galeria").click(function(ev){

        var imagenesTotales = $("#contenedor_imagenes").children().length/2;
        var img = [];
        for(let i=1; i<=imagenesTotales; i++){
            img.push($("#img"+i).val().substring(12));
        }

        $.ajax("/enviaImagenes", {
                    type:"get",
                    data : {
                        imagenes : JSON.stringify(img)
                    },
                    success : function(data){
                       /* $("#btn_modal").trigger("click");*/


                    },

        })

    })

})
