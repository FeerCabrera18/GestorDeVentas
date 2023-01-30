const form  = document.getElementById('registrocliente');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    var email = form.elements['email'].value
    var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    var valido;
    if (emailRegex.test(email)) {
        valido = true;
      } else {
        valido = false;
      }
    if (valido){
        const link = 'http://localhost:8080/clientes/crearCliente'
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
}
registroBtn.addEventListener("click", registro);

