const gNombre = document.getElementById("nombreUsuario");
const gPsw = document.getElementById("contraseña");
const gConfirmaPass = document.getElementById("confirmeContraseña");
const gNombreComp = document.getElementById("nombreComleto")
const gFecha = document.getElementById("fecha");
const gRun = document.getElementById("run");
const uProfTitulo = document.getElementById("titulo");
const uProfIngreso = document.getElementById("fIngreso");

const profForm = document.getElementById("profesional_form");
//Llamar Validaciones Formulario Ingreso Profesional
profForm.addEventListener("submit", function (event) {
    if (!(valUserName() &&
        valUserPass() &&
        valUserConfirmedPass() &&
        valUserCompletedName() &&
        valUserDate() &&
        valUserNumberID() &&
        valProfDegree() &&
        valProfEntryDate())) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valUserName(){
    if (!meetLength(gNombre, 10, 50)) return;
    if (checkIfEmpty(gNombre)) return;
    return true;
}
function valUserPass(){
    if (checkIfEmpty(gPsw)) return;
    return true;
}
function valUserConfirmedPass(){
    if (checkIfNotEquals(gPsw,gConfirmaPass,gConfirmaPass)) return;
    if (checkIfEmpty(gConfirmaPass)) return;
    return true;
}
function valUserCompletedName(){
    if (checkIfEmpty(gNombreComp)) return;
    return true;
}
function valUserDate(){
    if (checkIfEmpty(gFecha)) return;
    return true;
}

function valUserNumberID(){
    if (checkIfEmpty(gRun)) return;
    if (!meetMaxValue(gRun, 99999999)) return;
    return true;
}
function valProfDegree(){
    if (!meetLength(uProfTitulo, 10, 50)) return;
    return true;
}
function valProfEntryDate(){
    if (checkIfEmpty(uProfIngreso)) return;
    return true;
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