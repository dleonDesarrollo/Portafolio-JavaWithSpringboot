const pMonto = document.getElementById("Monto");
const pFecha = document.getElementById("fechaPago");

const pagoForm = document.getElementById("pago_form");

//Llamar Validaciones Formulario Ingreso De Pago
pagoForm.addEventListener("submit", function (event) {
    if (!(valPayAmount(pMonto) &&
        valPayDate(pFecha))) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valPayAmount(){
    if (isNumber(pMonto)) return;
    if (checkIfEmpty(pMonto)) return;
    return true;
}
function valPayDate(){
    if (checkIfEmpty(pFecha)) return;
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