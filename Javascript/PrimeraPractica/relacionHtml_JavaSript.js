
// document.getElementById("nombre del id") me devuelve lo que contenga la estructura de html con este id 
// al recuperarlo puedo cambiarle cualquier propiedad que cambiaria en html/css pero desde aqui
const titulo = document.getElementById("titulo")

// Con la propiedad.textContent puedo cambiar la propiedad de texto del h1 de html con id= titulo
titulo.textContent="He cambiado el titulo"

// document.querySelector("nombre del class") me devuelve lo que contenga la estructura de html con este class
// al recuperarlo puedo cambiarle cualquier propiedad que cambiaria en html/css pero desde aqui
// IMPORTANTE: poner punto "." antes del nombre del class
const titulo2 = document.querySelector(".titulo2")

titulo2.textContent ="He cambiado el titulo del class"



