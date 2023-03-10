const url = 'http://localhost:8080/pedido/listaPedidos'
const contenedor = document.querySelector('tbody')
let resultados = ''
const producto_detalle = "";

function mostrar_datos(arr){
    const nombre = ""
    if(arr[10] == true){
        console.log(arr[8])
        return arr[8]
    } else{
        console.log(arr[1]+" "+arr[2])
        return arr[1]+" "+arr[2]
    }
}

const mostrar_pedido = (Pedidos) => {
    Pedidos.forEach(pedido=> {
        const obj = pedido.cliente;
        const arr = Object.values(obj)
        const elemento = mostrar_datos(arr)
        const obj1 = pedido.detalle_pedidos;
        const arr1 = Object.values(obj1)

        //const canculo_pedido = precio_venta * cantidad
        const product = arr1[0].producto
        if (product != null) {
            producto_id = product.id
        }
        if (producto_id != null) {
            resultados += `<tr>
                            <td>${elemento}</td>
                            <td>${pedido.fecha}</td>
                            <td>${pedido.total_pedido}</td>
                            <td><a href="#popup" onclick="verDetalle_Producto(
                                ${arr1[0].cantidad},
                                ${arr1[0].precio_venta},
                                ${producto_id},
                                ${arr1[0].servicio}
                                )">Ver Detalle</a></td>
                            <td class="text-center">
                            <a class="btn_table" onclick="borrarImpuesto(${pedido.id})">Borrar</a></td>
                        </tr>`
            contenedor.innerHTML = resultados
            producto_id = null
        }else{
            resultados += `<tr>
            <td>${elemento}</td>
            <td>${pedido.fecha}</td>
            <td>${pedido.total_pedido}</td>
            <td><a href="#popup" onclick="verDetalle_Servicio(
                ${arr1[0].cantidad},
                ${arr1[0].precio_venta},
                ${arr1[0].servicio.id}
                )">Ver Detalle</a></td>
            <td class="text-center">
            <a class="btn_table" onclick="borrarImpuesto(${pedido.id})">Borrar</a></td>
        </tr>`
            contenedor.innerHTML = resultados
            producto_id = null
        }
                   
    })
}
fetch(url)
    .then (response => response.json())
    .then (data => mostrar_pedido(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))


function verDetalle_Producto(cantidad,precio_venta,id_producto){
    limpiar();
    if (id_producto != null){
        const url_detalle = `http://localhost:8080/producto/obtenerProductoById/${id_producto}`;

        fetch(url_detalle)
            .then (response => response.json())
            .then (data => mostrar_detalle_producto(data))
            .then (data => console.log(data))
            .catch (error => console.log(error))
    }
        

    document.getElementById("id_cantidad").innerHTML = "Cantidad: " + cantidad;
    document.getElementById("id_precio_venta").innerHTML = "Precio de Venta: " + precio_venta;
}


const mostrar_detalle_producto = (detalles) => {
    if (detalles.producto != null){
        document.getElementById("id_Producto").innerHTML = "Producto: " + detalles.producto;
    }else{
        document.getElementById("id_Producto").innerHTML = "Producto: "
    }
    

}
function limpiar(){
    document.getElementById("id_cantidad").innerHTML = "Cantidad: ";
    document.getElementById("id_precio_venta").innerHTML = "Precio de Venta: ";
    document.getElementById("id_Producto").innerHTML = "Producto: ";
}

function borrarImpuesto(id){
    const urlBorrar = `http://localhost:8080/pedido/borrarPedido/${id}`
    fetch(urlBorrar,{ 
        method: 'DELETE'
    })
    .then( res => res.json() )
    .then( ()=> location.reload())
    window.location.reload()
}  