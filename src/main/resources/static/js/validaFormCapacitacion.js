/*Capacitaciones*/
const rut = document.getElementById("crut");
const lugar = document.getElementById("clugar");
const dia = document.getElementById("cdia");
const hora = document.getElementById("chora");
const duracion = document.getElementById("cduracion");
const cantAsistentes = document.getElementById("ccasistentes");

const capaForm = document.getElementById("capa_form");



capaForm.addEventListener("submit", function (event) {
    if (!(validateRut() &&
        validateLugar() &&
        validateHora() &&
        validateDuracion() &&
        validateCantAsit())) {

        event.preventDefault();
        return false;
    }
    return true;
});


function validateHora() {
    console.log(hora.value);
    if (checkIfEmpty(hora)) return;
    return true;
}

function validateDuracion() {
    if (checkIfEmpty(duracion)) return;
    if (!isNumber(duracion)) return;
    return true;
}

function validateCantAsit() {
    if (checkIfEmpty(cantAsistentes)) return;
    if (!isNumber(cantAsistentes)) return;
    if (!meetMaxValue(cantAsistentes, 1000)) return;
    return true;
}

function validateRut() {
    if (checkIfEmpty(rut)) return;
    if (!isNumber(rut)) return;
    if (!meetMaxValue(rut, 99999999)) return;
    return true;
}

function validateLugar() {
    if (checkIfEmpty(lugar)) return;
    if (!meetLength(lugar, 10, 50)) return;
    return true;
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

function isEmpty(value) {
    if (value == "") return true;
    return false;
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
