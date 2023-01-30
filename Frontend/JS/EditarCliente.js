const form  = document.getElementById('editarCliente');
const urlSearchParams = new URLSearchParams(window.location.search);
const params = Object.fromEntries(urlSearchParams.entries());
const updateBTN = document.querySelector("#guardar");
const url = `http://localhost:8080/clientes/obtenerClienteById/`

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
        if(reset_input_values[i].id == 'nombre'){
            reset_input_values[i].value = data.nombre    
        } else if(reset_input_values[i].id == 'apellido'){
            reset_input_values[i].value = data.apellido    
        } else if(reset_input_values[i].id == 'DNI'){
            reset_input_values[i].value = data.dni    
        } else if(reset_input_values[i].id == 'direccion'){
            reset_input_values[i].value = data.direccion    
        } else if(reset_input_values[i].id == 'email'){
            reset_input_values[i].value = data.email    
        }else if(reset_input_values[i].id == 'telefono'){
            reset_input_values[i].value = data.telefono    
        }
    }
}
function actualizarClienteExistente(){
    const link = `http://localhost:8080/clientes/actualizarCliente/${params.idcliente}`
    const data = {
        nombre: form.elements['nombre'].value,
        apellido: form.elements['apellido'].value,
        dni: form.elements['DNI'].value,
        direccion: form.elements['direccion'].value,
        email: form.elements['email'].value,
        telefono: form.elements['telefono'].value,
        direccion: form.elements['direccion'].value,
        empresa : 0,
        cuit: null,
        razon_social: null,
        fecha_inicio: null
    };
    const response = fetch(link, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        // .then(data => console.log(data))
        .then(data => clienteActualizadoCorrectamente())
        alert("Cliente actualizado ");
        
}
function clienteActualizadoCorrectamente(){
    window.location.href = "../HTML/ListaClientes.html";
}
updateBTN.addEventListener("click", actualizarClienteExistente);