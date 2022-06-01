$(function ($) {

    $("#tabla_actividades").find("button").click(function(){

         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaActividad/"+ this.id, function(){
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

            $("#actividad_archivo").change(function(){
                $("#contenedor_imagen_actividad").find("img").attr("src", "../../misArchivos/img/"+ $("#actividad_archivo").val().substr(12));
            })

             $("#enviar_actividad").click(function(ev){
                 ev.preventDefault();
                  var content = tinymce.get('actividad_descripcion').getContent();

                 $.ajax("guardaActividad", {
                     type:"post",
                     data : {
                         idActividad : $("#actividad_id").text(),
                         nombre : $("#actividad_nombre").val(),
                         descripcion : content,
                         archivo : $("#contenedor_imagen_actividad").find("img").attr("src").substr(22)
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