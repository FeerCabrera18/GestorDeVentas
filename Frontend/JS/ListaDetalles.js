const url = 'http://localhost:8080/detalle_pedido/listaDetalle_pedido'
const contenedor = document.querySelector('tbody')
let resultados = "";

const mostrar = (detalles) => {
    detalles.forEach(detalle => {
        validarCamposDetalles(detalle)
        const obj = detalle.producto;
        const arr = Object.values(obj)
        const obj1 = detalle.servicio;
        const arr1 = Object.values(obj1)
        resultados += `<tr>
                            <td>${arr}</td>
                            <td>${arr1}</td>
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
    }
    return cuilvalidado;
}