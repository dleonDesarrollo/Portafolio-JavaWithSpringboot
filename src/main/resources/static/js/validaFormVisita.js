const vDia = document.getElementById("dia");
const vHora = document.getElementById("hora");
const vLugar = document.getElementById("lugar");
const vComentario = document.getElementById("comentario");

const visForm = document.getElementById("visita_form");

//Llamar Validaciones Formulario Visita
visForm.addEventListener("submit", function (event) {
    if (!(valVisDia() &&
        valVisHour() &&
        valVisPlace() &&
        valVisComment())) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valVisDia(){
    if (checkIfEmpty(vDia)) return;
    return true;
}
function valVisHour(hour){
    if (checkIfEmpty(vHora)) return;
    return true;
}
function valVisPlace(place){
    if (!meetLength(vLugar, 10, 50)) return;
    return true;
}
function valVisComment(comment){
    if (!meetLength(vComentario, 10, 50)) return;
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