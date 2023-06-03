const gNombre = document.getElementById("nombreUsuario");
const gPsw = document.getElementById("contraseña");
const gConfirmaPass = document.getElementById("confirmeContraseña");
const gNombreComp = document.getElementById("nombreComleto")
const gFecha = document.getElementById("fecha");
const gRun = document.getElementById("run");
const uCliRut = document.getElementById("rut");
const uCliTelefono = document.getElementById("telefono");
const uCliAfp = document.getElementById("afp");
const uCliSalud = document.getElementById("sistSalud");
const uCliDireccion = document.getElementById("direccion");
const uCliComuna = document.getElementById("comuna");
const uCliEdad = document.getElementById("edad");

const cliForm = document.getElementById("cliente_form");

//Llamar Validaciones Formulario Ingreso Cliente
cliForm.addEventListener("submit", function (event) {
    if (!(valUserName() &&
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
        valCliAge())) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valUserName(){
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
    if (!meetLength(gNombreComp, 10, 50)) return;
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
function valCliNumberId(){
    if (checkIfEmpty(uCliRut)) return;
    if (!meetMaxValue(uCliRut, 99999999)) return;
    return true;
}
function valCliPhone(){
    if (checkIfEmpty(uCliTelefono)) return;
    return true;
}
function valCliPfa(){
    if (!meetLength(uCliAfp, 5, 30)) return;
    return true;
}
function valCliHealth(){
    if (checkIfEmpty(uCliSalud)) return;
    return true;
}
function valCliAddress(){
    if (checkIfEmpty(uCliDireccion)) return;
    if (!meetLength(uCliDireccion, 5, 70)) return;
    return true;
}
function valCliDistrict(){
    if (!meetLength(uCliComuna, 5, 50)) return;
    return true;
}
function valCliAge(){
    if (!meetMaxValue(uCliEdad, 150)) return;
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