const url = 'http://localhost:8080/impuestos/listaImpuestos'
const contenedor = document.querySelector('tbody')
let resultados = ''

const mostrar = (Impuestos) => {
    Impuestos.forEach(impuesto=> {
        resultados += `<tr>
                            <td>${impuesto.nombre_impuesto}</td>
                            <td>${impuesto.porcentaje}</td>
                            <td class="text-center">
                            <a class="btn_table" onclick="editarImpuesto(${impuesto.id})">Editar</a>
                            <a class="btn_table" onclick="borrarImpuesto(${impuesto.id})">Borrar</a></td>
                        </tr>`    
    })
    contenedor.innerHTML = resultados  
}
fetch(url)
    .then (response => response.json())
    .then (data => mostrar(data))
    .then (data => console.log(data))
    .catch (error => console.log(error))

function borrarImpuesto(id){
    const urlBorrar = `http://localhost:8080/impuestos/borrarImpuestos/${id}`
    fetch(urlBorrar,{ 
        method: 'DELETE'
    })
    window.location.reload()
}

function editarImpuesto(id){
    window.location.href = "../HTML/EditarImpuesto.html?idcliente="+id;
}