const form  = document.getElementById('editarProducto');
const urlSearchParams = new URLSearchParams(window.location.search);
const params = Object.fromEntries(urlSearchParams.entries());
const updateBTN = document.querySelector("#guardar");
const url = `http://localhost:8080/producto/obtenerProductoById/`

function findInfoClient(){ 
    let urlBuscarCliente = url+params.idcliente
    fetch(urlBuscarCliente)
        .then (response => response.json())
        .then(data => asignarValorFormulario(data))
}
function asignarValorFormulario(data){
    form.value = data
    var reset_input_values = document.querySelectorAll('input');
    for (var i = 0; i < reset_input_values.length; i++) {
        console.log(reset_input_values[i].id)
        if(reset_input_values[i].id == 'producto'){
            reset_input_values[i].value = data.producto    
        } else if(reset_input_values[i].id == 'precio'){
            reset_input_values[i].value = data.precio    
        }
    }
}
function actualizarProductoExistente(){
    const link = `http://localhost:8080/producto/actualizarProducto/${params.idcliente}`
    const data = {
        producto: form.elements['producto'].value,
        precio: form.elements['precio'].value
    };
    const response = fetch(link, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .then(data => clienteActualizadoCorrectamente())
        alert("Producto actualizado ");
        
}
function clienteActualizadoCorrectamente(){
    window.location.href = "../HTML/ListaProductos.html";
}
updateBTN.addEventListener("click", actualizarProductoExistente);