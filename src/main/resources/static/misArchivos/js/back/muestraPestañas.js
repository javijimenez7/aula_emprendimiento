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
            $(".main-panel").load("/actividades", function(){


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



})