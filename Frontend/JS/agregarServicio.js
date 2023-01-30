const form  = document.getElementById('registroServicio');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/servicio/crearServicio'
    const data = {
        servicio: form.elements['servicio'].value,
        precio: form.elements['precio'].value
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
        window.location.href = "../HTML/ListaServicios.html";
    alert("Servicio registrado");
}
registroBtn.addEventListener("click", registro);
