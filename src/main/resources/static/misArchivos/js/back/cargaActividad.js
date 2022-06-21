$(function ($) {
      $("#tabla_actividades").find("button").click(function(){

             $(".main-panel").remove();
             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
             $(".main-panel").load("/cargaPlantillaActividad/"+ this.id, function(){

              $("#contenedor_archivo_actividad").css("visibility", "hidden");
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
             });
     })
 });