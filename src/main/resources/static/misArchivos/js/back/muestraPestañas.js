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
                                              alert("Datos modificados");
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

    // funcion que abre mediante ajax la plantilla de la categoria y crea una nueva
    $("#nueva_categoria").click(function(ev){
             $(".main-panel").remove();
             $("<div></div>").addClass("main-panel").appendTo("#contenedor");
             $(".main-panel").load("/cargaPlantillaCategoria/0", function(){

                 $("#enviar_categoria").click(function(ev){
                     ev.preventDefault();


                     $.ajax("guardaCategoria", {
                         type:"post",
                         data : {
                             idCategoria : $("#categoria_id").text(),
                             titulo : $("#categoria_titulo").val(),

                         },
                         success : function(data){

                            $(".main-panel").remove();
                            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                            $(".main-panel").load("/listado_categorias", function(){

                            });

                         },
                     })
                 })
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

                     $("#enviar_imagen").click(function(ev){
                         ev.preventDefault();


                         $.ajax("guardaImagen", {
                             type:"post",
                             data : {
                                 idImagen : $("#imagen_id").text(),
                                 categoria : $("#imagen_categoria").val(),
                                 titulo : $("#imagen_titulo").val(),
                                 archivo : $("#contenedor_imagen_img").find("img").attr("src").substr(22)
                             },
                             success : function(data){

                                $(".main-panel").remove();
                                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                                $(".main-panel").load("/galeria", function(){

                                });

                             },
                         })
                    })
                 })

                })

    // funcion que abre mediante ajax la plantilla del curso y crea uno nuevo
    $("#nuevo_curso").click(function(ev){
                  $(".main-panel").remove();
                  $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                  $(".main-panel").load("/cargaPlantillaCurso/0", function(){

                      $("#enviar_curso").click(function(ev){
                          ev.preventDefault();


                          $.ajax("guardaCurso", {
                              type:"post",
                              data : {
                                  idCurso : $("#curso_id").text(),
                                  descripcion : $("#curso_descripcion").val(),
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

    // funcion que elimina un curso y recarga el listado de cursos
    $(".borrar_cursos").click(function(){

            $.ajax("eliminaCurso", {
             type:"post",
             data : {
                 idCurso : this.id,
             },
             success : function(data){

                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/listado_cursos", function(){

                });

             },
         })

    })

    // funcion que elimina una actividad y recarga el listado de actividades
    $(".borrar_actividades").click(function(){
                $.ajax("eliminaActividad", {
                 type:"post",
                 data : {
                     idActividad : this.id,
                 },
                 success : function(data){

                    $(".main-panel").remove();
                    $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                    $(".main-panel").load("/listado_actividades", function(){

                    });

                 },
             })

        })

    // funcion que elimina una categoria y recarga el listado de categorias
    $(".borrar_categorias").click(function(){
                        $.ajax("eliminaCategoria", {
                         type:"post",
                         data : {
                             idCategoria : this.id,
                         },
                         success : function(data){

                            $(".main-panel").remove();
                            $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                            $(".main-panel").load("/listado_categorias", function(){

                            });

                         },
                     })

                })

    // funcion que elimina una imagen y recarga el listado de imagenes
    $(".borrar_imagenes").click(function(){
            $.ajax("eliminaImagen", {
             type:"post",
             data : {
                 idImagen : this.id,
             },
             success : function(data){

                $(".main-panel").remove();
                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                $(".main-panel").load("/galeria", function(){

                });

             },
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
                        alert("Campos usuario y contraseña no pueden estar vacios");
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