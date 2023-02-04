const url = 'http://localhost:8080/detalle_pedido/listaDetalle_pedido'
const contenedor = document.querySelector('tbody')
let resultados = "";

const mostrar = (detalles) => {
    detalles.forEach(detalle => {
        validarCamposDetalles(detalle)
        var detalleProducto=""
        var detalleServicio=""
        if (detalle.producto != "") {
            detalleProducto=detalle.producto.producto
        }
        if (detalle.servicio != "") {
            detalleServicio=detalle.servicio.servicio
        }
        resultados += `<tr>
                            <td>${detalle.id}</td>
                            <td>${detalleProducto}</td>
                            <td>${detalleServicio}</td>
                            <td>${detalle.cantidad}</td>
                            <td>${detalle.precio_venta}</td>
                            <td>${detalle.subtotal}</td>
                            <td class="text-center">
                            <a id= "btnEditar" class="btn_table" onclick="editarCliente(${detalle.id})">Editar</a>
                            <a id= "btnBorrar" class="btn_table" onclick="borrarCliente(${detalle.id})">Borrar</a></td>
                        </tr>`
    })
    contenedor.innerHTML = resultados  
}
fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))

function validarCamposDetalles(detalle) {
    detalle.producto = validar(detalle.producto);
    detalle.servicio = validar(detalle.servicio);
    detalle.cantidad = validar(detalle.cantidad);
    detalle.precio_venta = validar(detalle.precio_venta);
    detalle.subtotal = validar(detalle.subtotal)
    
} 

function validar(campo) {
    var cuilvalidado = campo;
    if (cuilvalidado== null) {
        cuilvalidado = ""
    } else if(cuilvalidado == undefined){
        cuilvalidado = ""
    }
    return cuilvalidado;
}