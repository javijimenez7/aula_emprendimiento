$(function ($) {

 $("#enlace_login").click(function(ev){
    ev.preventDefault();

     $.ajax("compruebaUsuario", {
         type:"post",
         data : {
             usuario : $("#usuario_login").val(),
             password : $("#password_login").val()

         },
         success : function(data){
           $(location).attr('href', '/admin')



         },
     }).fail(function(){
           alert("Error, usuario o contraseña incorrecta");
        })
 })




});
