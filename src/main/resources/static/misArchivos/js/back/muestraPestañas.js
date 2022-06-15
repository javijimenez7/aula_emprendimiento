$(function ($) {

    // funcion que muestra el contenido de la pestaña "Mails" en el back
    $("#btnMails").click(function(ev){
        ev.preventDefault();
        $(".main-panel").remove();
        $("<div></div>").addClass("main-panel").appendTo("#contenedor");
        $(".main-panel").load("/mails", function(){
            $(".emailto").text($(".emailto").text().substring(1, $(".emailto").text().length-1));
            $(".subject").text($(".subject").text().substring(1, $(".subject").text().length-1));

        });
    })

    // funcion que muestra el contenido de la pestaña "Actividades" en el back
    $("#btnActividades").click(function(ev){
            ev.preventDefault();
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/listado_actividades", function(){

            });
    })

    // funcion que muestra el contenido de la pestaña "Cursos" en el back
    $("#btnCursos").click(function(ev){
            ev.preventDefault();
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/listado_cursos", function(){

            });
    })

    // funcion que muestra el contenido de la pestaña "Galeria Imagenes" en el back
    $("#btnGaleria").click(function(ev){
            ev.preventDefault();
            $(".main-panel").remove();
            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
            $(".main-panel").load("/galeria", function(){


            });
    })

    // funcion que muestra el contenido de la pestaña "Categoria Imagenes" en el back
    $("#btnCategorias").click(function(ev){
                ev.preventDefault();
                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_categorias", function(){


                });
        })

    // funcion que muestra el contenido de la pestaña "Principal" en el back
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
                                              $("#modalHora").find(".modal-body").children().remove();
                                              $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                                              $("#modalHora").find(".modal-body").append("<p>Contenido guardado</p>");
                                              $("#modalHora").modal("show");
                                          },

                              })
                        })

        });
    })

    // funcion que abre mediante ajax la plantilla de la actividad y crea una nueva
    $("#nueva_actividad").click(function(ev){
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


          })
     })

    // funcion que abre mediante ajax la plantilla de la categoria y crea una nueva
    $("#nueva_categoria").click(function(ev){
         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCategoria/0", function(){


         })
     })

    // funcion que abre mediante ajax la plantilla de la imagen y crea una nueva
    $("#nueva_imagen").click(function(ev){
                  $(".main-panel").remove();
                  $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                  $(".main-panel").load("/cargaPlantillaImagen/0", function(){


                  $("#imagen_archivo").change(function(){
                    $("#contenedor_imagen_img").find("img").attr("src", "../../misArchivos/img/"+ $("#imagen_archivo").val().substr(12));
                  })
             })

        })

    // funcion que abre mediante ajax la plantilla del curso y crea uno nuevo
    $("#nuevo_curso").click(function(ev){
          $(".main-panel").remove();
          $("<div></div>").addClass("main-panel").appendTo("#contenedor");
          $(".main-panel").load("/cargaPlantillaCurso/0", function(){


          })
    })

    // funcion que abre mediante ajax la plantilla del usuario y lo modifica
    $("#modificar_usuario").click(function(ev){
             $(".main-panel").remove();
             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
             $(".main-panel").load("/cargaPlantillaUsuario", function(){

                $("#mostrar_contraseña").click(function(){
                    var pass = $("#usuario_password");
                    if(pass.attr('type') == 'password'){
                        pass.attr('type','text');
                    } else {
                        pass.attr('type','password');
                    }

                })

                 $("#enviar_usuario").click(function(ev){
                     ev.preventDefault();
                     debugger;
                      user = $("#usuario_username").val();
                      pass = $("#usuario_password").val();

                      if( user.length < 1 || pass.length <1 ){
                          $("#modalHora").find(".modal-body").children().remove();
                          $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                          $("#modalHora").find(".modal-body").append("<h4>Campo usuario o contraseña no pueden ser nulos</h4>");
                          $("#modalHora").modal("show");
                      } else

                     {


                     $.ajax("guardaUsuario", {
                         type:"post",
                         data : {
                             idUsuario : $("#usuario_id").text(),
                             usuario : $("#usuario_username").val(),
                             password : $("#usuario_password").val()

                         },
                         success : function(data){

                             $("#modalHora").find(".modal-body").children().remove();
                             $("#modalHora").find(".modal-body").append("<h2>AVISO DEL SISTEMA</h2>");
                             $("#modalHora").find(".modal-body").append("<p>Usuario modificado correctamente</p>");
                             $("#modalHora").modal("show");
                             $(".main-panel").remove();
                             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                             $(".main-panel").load("/listado_actividades", function(){

                            });

                         },
                     })
                     }
                 })
             })
    })
})