$(function ($) {

//Metodo que convierte la tabla de mails en datatable
    $("#tabla_mail").DataTable({
                             language: {
                                "decimal": "",
                                "emptyTable": "No hay información",
                                "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                                "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                                "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                                "infoPostFix": "",
                                "thousands": ",",
                                "lengthMenu": "Mostrar _MENU_ Entradas",
                                "loadingRecords": "Cargando...",
                                "processing": "Procesando...",
                                "search": "Buscar:",
                                "zeroRecords": "Sin resultados encontrados",
                                "paginate": {
                                    "first": "Primero",
                                    "last": "Ultimo",
                                    "next": "Siguiente",
                                    "previous": "Anterior"
                                }
                            },
                           "pageLength": 7,
                           "bJQueryUI": true,
                           "sPaginationType": "full_numbers",
                           "bPaginate": true,
                           "bFilter": true,
                           "bSort": true
    });

    $("#tabla_contactos").DataTable({
         language: {
            "decimal": "",
            "emptyTable": "No hay información",
            "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
            "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
            "infoFiltered": "(Filtrado de _MAX_ total entradas)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Mostrar _MENU_ Entradas",
            "loadingRecords": "Cargando...",
            "processing": "Procesando...",
            "search": "Buscar:",
            "zeroRecords": "Sin resultados encontrados",
            "paginate": {
                "first": "Primero",
                "last": "Ultimo",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        },
       "pageLength": 7,
       "bJQueryUI": true,
       "sPaginationType": "full_numbers",
       "bPaginate": true,
       "bFilter": true,
       "bSort": true
    });
//Metodo que convierte la tabla de actividades en datatable
    $("#tabla_actividades").DataTable({
                          language: {
                             "decimal": "",
                             "emptyTable": "No hay información",
                             "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                             "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                             "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                             "infoPostFix": "",
                             "thousands": ",",
                             "lengthMenu": "Mostrar _MENU_ Entradas",
                             "loadingRecords": "Cargando...",
                             "processing": "Procesando...",
                             "search": "Buscar:",
                             "zeroRecords": "Sin resultados encontrados",
                             "paginate": {
                                 "first": "Primero",
                                 "last": "Ultimo",
                                 "next": "Siguiente",
                                 "previous": "Anterior"
                             }
                         },
                         "pageLength": 7,
                         "bJQueryUI": true,
                         "sPaginationType": "full_numbers",
                         "bPaginate": true,
                         "bFilter": true,
                         "bSort": true
    });


    $("#tabla_cursos").DataTable({
                        language: {
                           "decimal": "",
                           "emptyTable": "No hay información",
                           "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                           "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                           "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                           "infoPostFix": "",
                           "thousands": ",",
                           "lengthMenu": "Mostrar _MENU_ Entradas",
                           "loadingRecords": "Cargando...",
                           "processing": "Procesando...",
                           "search": "Buscar:",
                           "zeroRecords": "Sin resultados encontrados",
                           "paginate": {
                               "first": "Primero",
                               "last": "Ultimo",
                               "next": "Siguiente",
                               "previous": "Anterior"
                           }
                       },
                       "pageLength": 7,
                       "bJQueryUI": true,
                       "sPaginationType": "full_numbers",
                       "bPaginate": true,
                       "bFilter": true,
                       "bSort": true
    });

    $("#tabla_categorias").DataTable({
                            language: {
                               "decimal": "",
                               "emptyTable": "No hay información",
                               "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                               "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                               "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                               "infoPostFix": "",
                               "thousands": ",",
                               "lengthMenu": "Mostrar _MENU_ Entradas",
                               "loadingRecords": "Cargando...",
                               "processing": "Procesando...",
                               "search": "Buscar:",
                               "zeroRecords": "Sin resultados encontrados",
                               "paginate": {
                                   "first": "Primero",
                                   "last": "Ultimo",
                                   "next": "Siguiente",
                                   "previous": "Anterior"
                               }
                           },
                           "pageLength": 7,
                           "bJQueryUI": true,
                           "sPaginationType": "full_numbers",
                           "bPaginate": true,
                           "bFilter": true,
                           "bSort": true
    });

       $("#tabla_imagenes").DataTable({
                language: {
                   "decimal": "",
                   "emptyTable": "No hay información",
                   "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                   "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                   "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                   "infoPostFix": "",
                   "thousands": ",",
                   "lengthMenu": "Mostrar _MENU_ Entradas",
                   "loadingRecords": "Cargando...",
                   "processing": "Procesando...",
                   "search": "Buscar:",
                   "zeroRecords": "Sin resultados encontrados",
                   "paginate": {
                       "first": "Primero",
                       "last": "Ultimo",
                       "next": "Siguiente",
                       "previous": "Anterior"
                   }
               },
               "pageLength": 7,
               "bJQueryUI": true,
               "sPaginationType": "full_numbers",
               "bPaginate": true,
               "bFilter": true,
               "bSort": true
        });
});