function printError() {
    const message = document.getElementById("error")
    message.innerText = "Podany login i/lub hasło są nieprawidłowe";
}

function clearError() {
    const message = document.getElementById("error")
    message.innerText = "";
}
