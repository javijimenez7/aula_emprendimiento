$(function ($) {
     $("#logout").click(function(){
             $.ajax("cierrasesion", {
                      type:"post",
                      data : true,

                      success : function(data){
                        $(location).attr('href', '/admin')
                      }
             })
     })

});