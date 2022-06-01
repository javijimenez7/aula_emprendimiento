$(function ($) {

    $("#btnMails").click(function(ev){
        ev.preventDefault();
        $(".main-panel").remove();
        $("<div></div>").addClass("main-panel").appendTo("#contenedor");
        $(".main-panel").load("/mails", function(){
            $(".emailto").text($(".emailto").text().substring(1, $(".emailto").text().length-1));
            $(".subject").text($(".subject").text().substring(1, $(".subject").text().length-1));

        });
    })

    $("#btnActividades").click(function(ev){
            ev.preventDefault();
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/listado_actividades", function(){


            });
    })


    $("#btnGaleria").click(function(ev){
            ev.preventDefault();
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/galeria", function(){


            });
    })

    $("#btnPrincipal").click(function(ev){
        ev.preventDefault();
        $(".main-panel").remove();
        $("<div></div>").addClass("main-panel").appendTo("#contenedor");
        $(".main-panel").load("/principal", function(){



            var p = $("#text_aux").text();

                    $("#p1").html(p);

                     tinymce.init({
                            selector: '#p1',
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


                      	$("#enviar_principal").click(function(ev){
                      	    ev.preventDefault();
                              var content = tinymce.get('p1').getContent();

                              $.ajax("/procesaDatosPrincipal", {
                                          type:"get",
                                          data : {
                                              principal : content
                                          },
                                          success : function(data){
                                              alert("Datos modificados");
                                          },

                              })
                      	})

        });
    })


     $("#nueva_actividad").click(function(ev){
     debugger;
             $(".main-panel").remove();
             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
             $(".main-panel").load("/cargaPlantillaActividad/0", function(){
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