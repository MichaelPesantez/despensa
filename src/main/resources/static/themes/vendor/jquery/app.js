var boton = document.getElementById('agregar');
var lista = document.getElementById('lista');
var boton1 = document.getElementById('guardar');
var data = [];
var datacabecera = [];
var cant = 0;
boton.addEventListener("click", agregar);
boton1.addEventListener("click", guardar);


function agregar() {
    let selectProductos = document.getElementById('producto');
    var nombre = selectProductos.options[selectProductos.selectedIndex].text;
    var idProducto = document.getElementById('producto').value;
    var cantidad = parseInt(document.getElementById('cantidad').value);
    var idCliente = document.getElementById('idPersona').value;
    var idEmpleado = document.getElementById('idEmpleado').value;
    var observacion = document.getElementById('txtObservacion').value;
    datacabecera.push(
        {
            "codigoPersona": idCliente,
            "codigoEmpleado": idEmpleado,
            "observacion": observacion
        }
    );
    data.push(
        {
            "idDetalleInventario": null,
            "fkDetalleCabeceraInventario": null,
            "fkDetalleInventarioProducto": idProducto,
            "cantidad": cantidad
        }
    );

    var id_row = 'row' + cant;
    var fila = '<tr id=' + id_row + '><td>'+idProducto+'</td><td>' + nombre + '</td><td>' + cantidad + '</td>' + '<td><a href="#" class="btn btn-danger" onclick="eliminar(' + cant + ')";>Eliminar</a></td></tr>';
    $("#lista").append(fila);
    $("#cantidad").val(0);
    cant++;
}

function guardar() {

    // * cabeceras
    var idCliente = document.getElementById('idPersona').value;
    var idEmpleado = document.getElementById('idEmpleado').value;
    var observacion = document.getElementById('txtObservacion').value;

    // Obtener la referencia a la tabla
    var tabla = document.getElementById('lista');
    // Obtener todas las filas de la tabla (excepto la primera que contiene los encabezados)
    var filas = tabla.getElementsByTagName('tr');
    // Array para guardar filas
    const listaProductos = [];
    // Recorrer cada fila y obtener los valores de las celdas
    for (var i = 1; i < filas.length; i++) {
        var celdas = filas[i].getElementsByTagName('td');
        // Obtener el valor de cada celda y mostrarlo en la consola
        var codigoProducto = celdas[0].innerText;
        var cantidad = celdas[2].innerText;
        listaProductos.push({
            codigoProducto: +codigoProducto,
            cantidad: +cantidad
        })
    }
    var salida = {
        codigoPersona : +idCliente,
        codigoEmpleado: +idEmpleado,
        observacion,
        fechaCabeceraInventario: new Date(),
        detalleFactura: listaProductos
    }

    fetch("/guardadetalle", {
        method: "POST",
        headers: { "Content-Type": "application/json; charset=utf-8" },
        body: JSON.stringify(salida)
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error(error);
        });
		window.alert("Datos Grabados Exitosamente");
		window.location.reload();
}

function eliminar(row) {
    $("#row" + row).remove();
    var i = 0;
    var pos = 0;
    for (x of data) {
        if (x.id == row) {
            pos = i;
        }
        i++;
    }
    data.splice(pos, 1);
}
