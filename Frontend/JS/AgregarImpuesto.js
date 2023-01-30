const form  = document.getElementById('registroImpuesto');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/impuestos/crearImpuesto'
    const data = {
        nombre_impuesto: form.elements['nombreImpuesto'].value,
        porcentaje: form.elements['porcentaje'].value
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

    alert("Impuesto registrado");
}
registroBtn.addEventListener("click", registro);