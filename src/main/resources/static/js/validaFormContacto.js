const contactArea = document.getElementById("area");
const contactRazon = document.getElementById("razon");

const contForm = document.getElementById("contacto_form");

//Llamar Validaciones Formulario Contacto
contForm.addEventListener("submit", function (event) {
    if (!(valContMethod(contactMetodo) &&
        valContArea() &&
        valContReason())) {
        event.preventDefault();
        return false;
    }
    return true;
});

function valContArea(){
    if (checkIfEmpty(contactArea)) return;
    return true;
}
function valContReason(){
    if (checkIfEmpty(contactArea)) return;
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