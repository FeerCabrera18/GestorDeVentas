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

//Obtiene lista de productos
const url_producto = 'http://localhost:8080/producto/listaProductos'
function cargarProducto(productos){
    productos.forEach(producto => {
        var selector = document.getElementById('lista_productos')
        const option = document.createElement('option');
        const valor = new Date().getTime();
        option.value = producto.id;
        option.text = producto.producto;
        selector.appendChild(option);
    }
)}
fetch(url_producto)
.then (response => response.json())
.then (data => cargarProducto(data))
.then (data => console.log(data))
.catch (error => console.log(error))

//Obtiene lista de servicios
const url_servicios = 'http://localhost:8080/servicio/listaServicios'
function cargarServicio(servicios){
    servicios.forEach(servicio => {
        var selector = document.getElementById('lista_servicios')
        const option = document.createElement('option');
        const valor = new Date().getTime();
        option.value = servicio.id;
        option.text = servicio.servicio;
        selector.appendChild(option);
    }
)}
fetch(url_servicios)
.then (response => response.json())
.then (data => cargarServicio(data))
.then (data => console.log(data))
.catch (error => console.log(error))

//Agrega formulario de carga de pedido
const form  = document.getElementById('registroPedido');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/pedido/crearPedido'
    const data = {
        fecha: form.elements['fecha_pedido'].value,
        nro_comprobante: form.elements['comprobante'].value,
        total_pedido: form.elements['total_pedido'].value,
        cliente: form.elements['optionclient'].value
        
    };
    const response = fetch(link, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => console.log(data))
        window.location.href = "../HTML/ListaProductos.html";
    alert("Producto registrado");
}
registroBtn.addEventListener("click", registro);