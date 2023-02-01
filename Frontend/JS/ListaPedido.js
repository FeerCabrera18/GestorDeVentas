const url = 'http://localhost:8080/pedido/listaPedidos'
const contenedor = document.querySelector('tbody')
let resultados = ''

const mostrar = (Pedidos) => {
    Pedidos.forEach(pedido=> {
        resultados += `<tr>
                            <td>${pedido.fecha}</td>
                            <td>${pedido.nro_comprobante}</td>
                            <td>${pedido.empresa_emisora}</td>
                            <td>${pedido.total_pedido}</td>
                            <td>${pedido.cliente}</td>
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