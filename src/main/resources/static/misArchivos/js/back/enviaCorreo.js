$(function ($) {

    $("table").find("button").click(function(){
         $(".main-panel").remove();
         $("<div></div>").addClass("main-panel").appendTo("#contenedor");
         $(".main-panel").load("/cargaPlantillaCorreo/"+this.id.substring(1), function(){

                                tinymce.init({
                                       selector: '#p2',
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


                                    $("#enviar_email").click(function(ev){
                                         ev.preventDefault();
                                         var content = tinymce.get('p2').getContent();

                                         $.ajax("enviaCorreo", {
                                             type:"post",
                                             data : {
                                                 idEmail : $("#email_id").text(),
                                                 body : content,
                                                 email : $("#email_address").val(),
                                                 subject : $("#email_subject").val()
                                             },
                                             success : function(data){

                                                $(".main-panel").remove();
                                                $("<div></div>").addClass("main-panel").appendTo("#contenedor");
                                                $(".main-panel").load("/mails", function(){

                                                });

                                             },
                                         })
                                    })

         });

    })

});