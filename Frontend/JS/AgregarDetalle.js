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

//Agrega formulario de carga de pedido
const form  = document.getElementById('registrodetalle');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/detalle_pedido/crearDetalle_pedido'
    const data = {
        cantidad: parseInt(form.elements['cantidad'].value),
        precio_venta: form.elements['precio_venta'].value,
        producto: {"id": parseInt(form.elements['lista_productos'].value)},
        servicio: null
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
        window.location.href = "../HTML/ListaDetalles.html";
    alert("Detalle registrado");
}
registroBtn.addEventListener("click", registro);