const form  = document.getElementById('registroProducto');
const registroBtn = document.querySelector("#guardar");

function registro(){ 
    const link = 'http://localhost:8080/producto/crearProducto'
    const data = {
        producto: form.elements['producto'].value,
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
        window.location.href = "../HTML/ListaProductos.html";
    alert("Producto registrado");
}
registroBtn.addEventListener("click", registro);