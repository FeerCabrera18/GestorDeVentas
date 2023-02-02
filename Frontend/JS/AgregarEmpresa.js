const form  = document.getElementById('registroEmpresa');
const registroBtn = document.querySelector("#guardar");

function registro(){
    
    const link = 'http://localhost:8080/clientes/crearCliente'
    const data = {
        nombre: form.elements['nombre'].value,
        apellido: form.elements['apellido'].value,
        dni: form.elements['DNI'].value,
        direccion: form.elements['direccion'].value,
        email: form.elements['email'].value,
        telefono: form.elements['telefono'].value,
        direccion: form.elements['direccion'].value,
        empresa : 1,
        cuit: form.elements['CUIT'].value,
        razon_social: form.elements['razon_social'].value,
        fecha_inicio: form.elements['fecha_inicio'].value,
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
        window.location.href = "../HTML/ListaClientes.html";
    alert("Cliente registrado");
}
registroBtn.addEventListener("click", registro);
