const url = 'http://localhost:8080/clientes/listaClientes'
const contenedor = document.querySelector('tbody')
let resultados = "";

const mostrar = (clientes) => {
    clientes.forEach(cliente => {
        validarCamposClientes(cliente)
        resultados += `<tr>
                            <td>${cliente.nombre}</td>
                            <td>${cliente.apellido}</td>
                            <td>${cliente.dni}</td>
                            <td>${cliente.direccion}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.telefono}</td>
                            <td>${cliente.empresa}</td>
                            <td>${cliente.cuit}</td>
                            <td>${cliente.razon_social}</td>
                            <td>${cliente.fecha_inicio}</td>
                            <td class="text-center">
                            <a id= "btnEditar" class="btn_table" onclick="editarCliente(${cliente.id})">Editar</a>
                            <a id= "btnBorrar" class="btn_table" onclick="borrarCliente(${cliente.id})">Borrar</a></td>
                        </tr>`
    })
    contenedor.innerHTML = resultados  
}

function borrarCliente(id){
    const urlBorrar = `http://localhost:8080/clientes/borrarCliente/${id}`
    fetch(urlBorrar,{ 
        method: 'DELETE'
    })
    .then( res => res.json() )
    .then( ()=> location.reload())
    window.location.reload()
}                         

function editarCliente(id){
    window.location.href = "../HTML/EditarCliente.html?idcliente="+id;
}

function dibujar(){
    fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))
}

dibujar()

function validarCamposClientes(cliente) {
    cliente.nombre = validar(cliente.nombre);
    cliente.apellido = validar(cliente.apellido);
    cliente.dni = validar(cliente.dni);
    cliente.direccion = validar(cliente.direccion);
    cliente.email = validar(cliente.email);
    cliente.telefono = validar(cliente.telefono);
    cliente.empresa = validar(cliente.empresa);
    cliente.cuit = validar(cliente.cuit);
    cliente.razon_social = validar(cliente.razon_social);
    cliente.fecha_inicio = validar(cliente.fecha_inicio);
} 

function validar(campo) {
    var cuilvalidado = campo;
    if (cuilvalidado== null) {
        cuilvalidado = ""
    } else if (cuilvalidado== false){
        cuilvalidado= "Persona"
    } else if (cuilvalidado== true){
        cuilvalidado= "Empresa"
    }
    return cuilvalidado;
} 

