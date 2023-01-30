const form  = document.getElementById('editarServicio');
const urlSearchParams = new URLSearchParams(window.location.search);
const params = Object.fromEntries(urlSearchParams.entries());
const updateBTN = document.querySelector("#guardar");
const url = `http://localhost:8080/servicio/obtenerServicioById/`

function findInfoClient(){ 
    let urlBuscarServicio = url+params.idservicio
    fetch(urlBuscarServicio)
        .then (response => response.json())
        .then(data => asignarValorFormularioServicio(data))
}
function asignarValorFormularioServicio(data){
    form.value = data
    var reset_input_values = document.querySelectorAll('input');
    for (var i = 0; i < reset_input_values.length; i++) {
        console.log(reset_input_values[i].id)
        if(reset_input_values[i].id == 'servicio'){
            reset_input_values[i].value = data.servicio   
        } else if(reset_input_values[i].id == 'precio'){
            reset_input_values[i].value = data.precio 
        } else if(reset_input_values[i].id == 'cargo_soporte'){
            reset_input_values[i].value = data.cargo_soporte  
        }
    }
}
function actualizarServicioExistente(){
    const link = `http://localhost:8080/servicio/actualizarServicio/${params.idservicio}`
    const data = {
        servicio: form.elements['servicio'].value,
        precio: form.elements['precio'].value,
        cargo_soporte: form.elements['cargo_soporte'].value
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
        .then(data => servicioActualizadoCorrectamente())
        alert("Servicio actualizado ");
        
}
function servicioActualizadoCorrectamente(){
    window.location.href = "../HTML/ListaServicios.html";
}
updateBTN.addEventListener("click", actualizarServicioExistente);