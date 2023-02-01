const url = 'http://localhost:8080/producto/listaProductos'
const contenedor = document.querySelector('tbody')
let resultados = ''

const mostrar = (Productos) => {
    Productos.forEach(producto=> {
        validarCamposProductos(producto)
        resultados += `<tr>
                            <td>${producto.producto}</td>
                            <td>${producto.precio}</td>
                            <td class="text-center">
                            <a class="btn_table" onclick="editarProducto(${producto.id})">Editar</a>
                            <a class="btn_table" onclick="borrarProducto(${producto.id})">Borrar</a></td>
                        </tr>`
    })
    contenedor.innerHTML = resultados
}
const response = fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))

function borrarProducto(id){
    const urlBorrar = `http://localhost:8080/producto/borrarProducto/${id}`
    fetch(urlBorrar,{ 
        method: 'DELETE'
    })
    window.location.reload()
}
    
function editarProducto(id){
    window.location.href = "../HTML/EditarProducto.html?idcliente="+id;
}

function validarCamposProductos(producto) {
    producto.nombre = validar(producto.nombre);
    producto.precio = validar(producto.precio);
} 

function validar(campo) {
    var cuilvalidado = campo;
    if (cuilvalidado== null) {
        cuilvalidado = ""
    }
    return cuilvalidado;
}
