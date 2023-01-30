const form  = document.getElementById('form');
const registroBtn = document.querySelector("#registro");

function registro(){
    
    const link = 'http://localhost:8080/usuario/registro'
    const data = {
        nombre: form.elements['nombre'].value,
        apellido: form.elements['apellido'].value,
        username: form.elements['username'].value,
        password: form.elements['password'].value,
    };
    const response = fetch(link, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => res.json())
        .then(data => console.log(data))

    alert("Registro completado");
}

registroBtn.addEventListener("click", registro);