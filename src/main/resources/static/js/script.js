const navbar = document.querySelector(".navbar");
const menuItems = document.querySelectorAll(".navbar__link")
const hamburguer = document.querySelector(".hamburger");
const closeIcon = document.getElementById('close-icon');
const menuIcon = document.getElementById("menu-icon");

const popTitulo = document.getElementById("popup__titulo");
const popDetalle = document.getElementById("popup__text");


function toggleMenu(){
  if (navbar.classList.contains("mostrarMenu")){
    navbar.classList.remove("mostrarMenu");
    closeIcon.style.display = "none";
    menuIcon.style.display = "block";
  } else {
    navbar.classList.add("mostrarMenu");
 
    closeIcon.style.display = "block";
    menuIcon.style.display = "none";
  }
}

hamburguer.addEventListener("click", toggleMenu);

menuItems.forEach(
  function(menuItem){
    menuItem.addEventListener("click", toggleMenu);
  }
)

function spanPopup(titulo, texto) {
  popTitulo.innerHTML = titulo;
  popDetalle.innerHTML = texto;
  let popup = document.getElementById("popup");
  popup.classList.add("active");
}
function closePopup(){
  let popup = document.getElementById("popup");
  popup.classList.remove("active");
}