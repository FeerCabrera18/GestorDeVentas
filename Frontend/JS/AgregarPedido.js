//Obtiene lista de clientes
const url_clientes = 'http://localhost:8080/clientes/listaClientes'
function cargarCliente(clientes){
    clientes.forEach(cliente => {
        var selector = document.getElementById('lista_clientes')
        const option = document.createElement('option');
        const valor = new Date().getTime();
        option.value = cliente.id;
        if(cliente.empresa == false){
            option.text = cliente.nombre;
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