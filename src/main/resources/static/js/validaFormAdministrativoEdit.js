const gUsername = document.getElementById("user.username");
const gPass = document.getElementById("user.password");
const gConfirma = document.getElementById("confirmeContraseña");
const gName = document.getElementById("user.name");
const gBirthday = document.getElementById("user.birthday");
const gDni = document.getElementById("user.dni");
const uAdmSection = document.getElementById("section");
const uAdmExp = document.getElementById("priorExp");

const admFormEdit = document.getElementById("administrativo_form");

//Llamar Validaciones Formulario Editar Administrativo
admFormEdit.addEventListener("submit", function (event) {
    if (!(valManagerId() &&
        valUserId() &&
        valUserName() &&
        valUserPass() &&
        valUserConfirmedPass() &&
        valUserCompletedName() &&
        valUserDate() &&
        valUserNumberID() &&
        valAdmSection() &&
        valAdmExp())) {
        event.preventDefault();
        return false;
    }
    return true;
});
function valUserId(){
    if (checkIfEmpty()) return;
    return true;
}
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
function valManagerId(){
    if (checkIfEmpty()) return;
    return true;
}
function valAdmSection(){
    if (checkIfEmpty(uAdmSection)) return;
    if (!meetLength(uAdmSection, 5, 20)) return;
    return true;
}
function valAdmExp(){
    if (checkIfEmpty(uAdmExp)) return;
    if (!meetLength(uAdmExp, 5, 20)) return;
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