//Obtiene lista de clientes
const url_clientes = 'http://localhost:8080/clientes/listaClientes'
function cargarCliente(clientes){
    clientes.forEach(cliente => {
        var selector = document.getElementById('lista_clientes')
        const option = document.createElement('option');
        const valor = new Date().getTime();
        option.value = cliente.id;
        if(cliente.empresa == false){
            option.text = cliente.nombre +" "+ cliente.apellido;
        }else{
            option.text = cliente.razon_social;
        }
        selector.appendChild(option);
    }
)}
fetch(url_clientes)
.then (response => response.json())
.then (data => cargarCliente(data))
.then (data => console.log(data))
.catch (error => console.log(error))

//Obtiene lista de detalles
const url_detalle = 'http://localhost:8080/detalle_pedido/listaDetalle_pedido'
function cargarDetalle(detalles){
    detalles.forEach(detalle => {
        var selector = document.getElementById('lista_detalles')
        const option = document.createElement('option');
        const valor = new Date().getTime();
        option.value = detalle.id;
        option.text = detalle.id;
            // "Producto: " + detalle.producto.producto +" / "+
            // "Servicio: " + detalle.servicio.servicio +" / "+  
            // "Cantidad: " + detalle.cantidad +" / "+ 
            // "Precio de venta: " + detalle.precio_venta +" / "+
            // "Sub-Total: " + detalle.subtotal
        selector.appendChild(option);
    }
)}
fetch(url_detalle)
.then (response => response.json())
.then (data => cargarDetalle(data))
.then (data => console.log(data))
.catch (error => console.log(error))

//Agrega formulario de carga de pedido
const form  = document.getElementById('registroPedido');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/pedido/crearPedido'
    let detalles_pedidos=[]
    detalles_pedidos.push({"id": form.elements['lista_detalles'].value})
    const data = {
        cliente: {"id": parseInt(form.elements['lista_clientes'].value)},
        fecha: form.elements['fecha_pedido'].value,
        total_pedido: parseFloat(form.elements['total_pedido'].value),
        detalle_pedidos: detalles_pedidos
    };
    console.log(data)
    const response = fetch(link, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => console.log(data))
        window.location.href = "../HTML/ListaPedido.html";
    alert("Pedido registrado");
}
registroBtn.addEventListener("click", registro);