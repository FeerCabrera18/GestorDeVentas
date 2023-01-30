const form  = document.getElementById('editarImpuesto');
const urlSearchParams = new URLSearchParams(window.location.search);
const params = Object.fromEntries(urlSearchParams.entries());
const updateBTN = document.querySelector("#guardar");
const url = `http://localhost:8080/impuestos/obtenerImpuestoById/`

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
        if(reset_input_values[i].id == 'nombreImpuesto'){
            reset_input_values[i].value = data.nombre_impuesto    
        } else if(reset_input_values[i].id == 'porcentaje'){
            reset_input_values[i].value = data.porcentaje    
        }
    }
}
function actualizarImpuestoExistente(){
    const link = `http://localhost:8080/impuestos/actualizarImpuestos/${params.idcliente}`
    const data = {
        nombre_impuesto: form.elements['nombreImpuesto'].value,
        porcentaje: form.elements['porcentaje'].value
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
    window.location.href = "../HTML/ListaImpuestos.html";
}
updateBTN.addEventListener("click", actualizarImpuestoExistente);