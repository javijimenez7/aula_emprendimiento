$(function ($) {

    $("#tabla_imagenes").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaImagen/"+ this.id, function(){
          tinymce.init({
                            selector: '#actividad_descripcion',
                            width: "100%",
                            height: 400,
                            plugins: [
                                     'advlist',
                                      'anchor',
                                      'link',
                                      'wordcount',
                                      'media',
                                      'charmap',
                                      'image'

                                   ],
                            toolbar: 'undo redo | formatselect | bold italic | alignleft aligncenter alignright alignjustify | forecolor backcolor|  bullist numlist outdent indent | removeformat | help'
                     });

            $("#imagen_archivo").change(function(){
                $("#contenedor_imagen_img").find("img").attr("src", "../../misArchivos/img/"+ $("#imagen_archivo").val().substr(12));
            })

             $("#enviar_imagen").click(function(ev){
                 ev.preventDefault();


                 $.ajax("guardaImagen", {
                     type:"post",
                     data : {
                         idImagen : $("#imagen_id").text(),
                         titulo : $("#imagen_titulo").val(),
                         archivo : $("#contenedor_imagen_img").find("img").attr("src").substr(22)
                     },
                     success : function(data){

                        $(".main-panel").remove();
                        $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                        $(".main-panel").load("/listado_actividades", function(){

                        });

                     },
                 })
            })
         })

    })

})