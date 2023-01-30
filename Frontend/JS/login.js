const loginBtn = document.querySelector("#login");
const usernameInput = document.querySelector("#username");
const passwordInput = document.querySelector("#password");

async function login() {
    const link = `http://localhost:8080/usuario/iniciarSesion?username=${usernameInput.value}&password=${passwordInput.value}`;
    const response = await fetch(link, {
        method: "GET"
    })
    const status = response.status;
    if(response.status == "200") {
        window.location.href = "../HTML/Inicio.html";
    }
    else {
        alert("No se pudo iniciar sesión.")
    }
}

loginBtn.addEventListener("click", () => {
    if(usernameInput.value != "" && passwordInput.value != "") {
        login()
    } else {
        alert("Hay datos faltantes.")
    }
})