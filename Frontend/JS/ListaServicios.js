const url = 'http://localhost:8080/servicio/listaServicios'
const contenedor = document.querySelector('tbody')
let resultados = ''

const mostrar = (Servicios) => {
    Servicios.forEach(servicio=> {
        validarCamposServicios(servicio)
        resultados += `<tr>
                            <td>${servicio.servicio}</td>
                            <td>${servicio.precio}</td>
                            <td class="text-center">
                            <a id= "btnEditar" class="btn_table" onclick="editarServicio(${servicio.id})">Editar</a>
                            <a id= "btnBorrar" class="btn_table" onclick="borrarServicio(${servicio.id})">Borrar</a></td>
                        </tr>`    
    })
    contenedor.innerHTML = resultados  
}
fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    //.then (data => console.log(data))
    .catch (error => console.log(error))

function borrarServicio(id){
    const urlBorrar = `http://localhost:8080/servicio/borrarServicio/${id}`
    fetch(urlBorrar,{ 
        method: 'DELETE'
    })
    window.location.reload()
}

function editarServicio(id){
    window.location.href = "../HTML/EditarServicio.html?idservicio="+id;
}
function validarCamposServicios(servicio) {
    servicio.servicio = validar(servicio.servicio);
    servicio.precio = validar(servicio.precio);
} 

function validar(campo) {
    var cuilvalidado = campo;
    if (cuilvalidado== null) {
        cuilvalidado = ""
    }
    return cuilvalidado;
} 
