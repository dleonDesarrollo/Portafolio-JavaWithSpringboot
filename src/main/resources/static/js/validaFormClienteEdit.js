const gUsername = document.getElementById("user.username");
const gPass = document.getElementById("user.password");
const gConfirma = document.getElementById("confirmeContraseña");
const gName = document.getElementById("user.name");
const gBirthday = document.getElementById("user.birthday");
const gDni = document.getElementById("user.dni");
const uCliStr = document.getElementById("str");
const uCliPhoneNumber = document.getElementById("phoneNumber");
const uCliPfa = document.getElementById("pfa");
const uCliHealthSystem = document.getElementById("healthSystem");
const uCliAddress = document.getElementById("address");
const uCliDistrict = document.getElementById("district");
const uCliAge = document.getElementById("age");
const cliFormEdit = document.getElementById("cliente_form");

//Llamar Validaciones Formulario Editar Cliente
cliFormEdit.addEventListener("submit", function (event) {
    if (!(valCliId() &&
        valUserId() &&
        valUserName() &&
        valUserPass() &&
        valUserConfirmedPass() &&
        valUserCompletedName() &&
        valUserDate() &&
        valUserNumberID() &&
        valCliNumberId() &&
        valCliPhone() &&
        valCliPfa() &&
        valCliHealth() &&
        valCliAddress() &&
        valCliDistrict() &&
        valCliAge()
    )) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valUserName(){
    if (checkIfEmpty(gUsername)) return;
    return true;
}
function valUserPass(){
    if (checkIfEmpty(gPass)) return;
    return true;
}
function valUserConfirmedPass(){
    if (checkIfNotEquals(gPass,gConfirma,gConfirma)) return;
    if (checkIfEmpty(gConfirma)) return;
    return true;
}
function valUserCompletedName(){
    if (!meetLength(gName, 10, 50)) return;
    if (checkIfEmpty(gName)) return;
    return true;
}
function valUserDate(){
    if (checkIfEmpty(gBirthday)) return;
    return true;
}

function valUserNumberID(){
    if (checkIfEmpty(gDni)) return;
    if (!meetMaxValue(gDni, 99999999)) return;
    return true;
}
function valCliId(){
    if (checkIfEmpty(uCliRut)) return;
    if (!meetMaxValue(uCliRut, 99999999)) return;
    return true;
}
function valCliNumberId(){
    if (checkIfEmpty(uCliStr)) return;
    if (!meetMaxValue(uCliStr, 99999999)) return;
    return true;
}
function valCliPhone(){
    if (checkIfEmpty(uCliPhoneNumber)) return;
    return true;
}
function valCliPfa(){
    if (!meetLength(uCliPfa, 5, 30)) return;
    return true;
}
function valCliHealth(){
    if (checkIfEmpty(uCliHealthSystem)) return;
    return true;
}
function valCliAddress(){
    if (checkIfEmpty(uCliAddress)) return;
    if (!meetLength(uCliAddress, 5, 70)) return;
    return true;
}
function valCliDistrict(){
    if (!meetLength(uCliDistrict, 5, 50)) return;
    return true;
}
function valCliAge(){
    if (!meetMaxValue(uCliAge, 150)) return;
    return true;
}

function checkIfNotEquals(fieldA,fieldB,field) {
    if (fieldA != fieldB) {
        setInvalid(field, `Las contraseñas ingresadas no coinciden`);
        return true;
    } else {
        return false;
    }
}
function isEmpty(value) {
    if (value == "") return true;
    return false;
}


function isNumber(field) {
    if (/^[\d]+$/.test(field.value)) {
        setValid(field);
        return true;
    } else {
        setInvalid(field, `${field.name} debe ser un numero`);
        return false;
    }
}

function meetMaxValue(field, maxValue) {
    if (field.value > maxValue) {
        setInvalid(
            field,
            `Debe ingresar un número menor a ${maxValue}`
        );
        return false;
    } else {
        setValid(field);
    }
    return true;
}

function checkIfEmpty(field) {
    if (isEmpty(field.value.trim())) {
        setInvalid(field, `Este campo es obligatorio.`);
        return true;
    } else {
        setValid(field);
        return false;
    }
}

function setInvalid(field, msg) {
    field.classList.remove("valid");
    field.classList.add("invalid"); //create invalid css class
    field.previousElementSibling.innerHTML = msg;

}

function setValid(field) {
    field.classList.remove("invalid");
    field.classList.add("valid"); //create invalid css class
    field.previousElementSibling.innerHTML = "";
}

function meetLength(field, minLength, maxLength) {
    if (field.value.length >= minLength && field.value.length <= maxLength) {
        setValid(field);
        return true;
    } else if (field.value.length < minLength) {
        setInvalid(
            field,
            `${field.name} debe contener al menos ${minLength} caracteres`
        );
        return false;
    } else {
        setInvalid(
            field,
            `${field.name} no puede tener mas de ${maxLength} caracteres`
        );
    }
    return false;
}