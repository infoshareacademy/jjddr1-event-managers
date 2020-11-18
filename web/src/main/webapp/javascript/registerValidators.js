function validateUsername() {


    const username = document.getElementById('username');
    const message = document.getElementById('username-error');
    const errorColor = '#ff6666';
    const illegalChars = /\W/; // allow letters, numbers, and underscores

    if ((username.value.length < 5) || (username.value.length > 15)) {
        message.style.color = errorColor;
        message.innerText = " Nazwa użytkownika musi się składać z 5-15 znaków";
        return false;
    } else if (username.value.match(illegalChars)) {
        message.style.color = errorColor;
        message.innerText = " Błędna nazwa uzytkownika. Proszę użyć tylko znaków alfanumerycznych"
        return false
    } else {
        message.innerText = "";
        return true;
    }

}

function validateEmail() {
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    const message = document.getElementById('email-error');
    const errorColor = '#ff6666';
    const email = document.getElementById('email');


    if (email.value.match(re)) {
        message.innerText = "";
        return true;
    } else {
        message.innerText = "Podany e-mail jest nieprawidłowy";
        message.style.color = errorColor;
        return false;
    }
}

function checkPassword() {
    const password = document.getElementById('password');
    const errorColor = '#ff6666';
    const lowerCaseLetters = /[a-z]/g;
    const upperCaseLetters = /[A-Z]/g;
    const numbers = /[0-9]/g;
    const message = document.getElementById('password-error');

    if (password.value.length >= 8) {
        if (password.value.match(upperCaseLetters)) {
            if (password.value.match(numbers)) {
                if (password.value.match(lowerCaseLetters)) {
                    message.innerText = "";
                    return true;
                } else {
                    message.style.color = errorColor;
                    message.innerText = "Hasło musi zawierać małą literę";
                }
            } else {
                message.style.color = errorColor
                message.innerHTML = "Hasło musi zawierać cyfrę";
            }
        } else {
            message.style.color = errorColor;
            message.innerText = "Hasło musi zawierać dużą literę"
        }
    } else {
        message.style.color = errorColor;
        message.innerHTML = "Hasło musi zawierać conajmniej 8 znaków";
    }
    return false;


}

function isPasswordsAreTheSame() {

    const message = document.getElementById('password-confirm-error');
    const password = document.getElementById('password');
    const repeatedPassword = document.getElementById('password_confirm');
    const errorColor = '#ff6666';


    if (password.value === repeatedPassword.value) {
        message.innerText = "";
        return true;
    } else {
        message.style.color = errorColor;
        message.innerHTML = "Hasła różnią się"
    }
    return false;

}

function checkAll() {

     if (!validateUsername()) {
         return false
     } else if (!validateEmail()) {
         return false;
     } else if (!checkAll()) {
         return false;
     } else if (!isPasswordsAreTheSame()) {
         return false;
     }
     return true;

}