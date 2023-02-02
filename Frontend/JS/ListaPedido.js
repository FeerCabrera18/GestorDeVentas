const url = 'http://localhost:8080/pedido/listaPedidos'
const contenedor = document.querySelector('tbody')
let resultados = ''

function mostrar_datos(arr){
    if(arr[10] == true){
        console.log(arr[8])
        arr[8]
    } else{
        console.log(arr[1]+" "+arr[2])
        arr[1]+" "+arr[2]
    }
}

const mostrar = (Pedidos) => {
    Pedidos.forEach(pedido=> {
        const obj = pedido.cliente;
        const arr = Object.values(obj)
        const elemento = mostrar_datos(arr)
        resultados += `<tr>
                            <td>${elemento}</td>
                            <td>${pedido.nro_comprobante}</td>
                            <td>${pedido.fecha}</td>
                            <td>${pedido.total_pedido}</td>
                            <td>${pedido.detalle_pedidos}</td>
                            <td class="text-center">
                            <a class="btn_table" onclick="editarImpuesto(${pedido.id})">Editar</a>
                            <a class="btn_table" onclick="borrarImpuesto(${pedido.id})">Borrar</a></td>
                        </tr>`           
    })
    contenedor.innerHTML = resultados  
}
fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))


