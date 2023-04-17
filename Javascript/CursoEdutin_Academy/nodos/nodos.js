// PASOS PARA LA CREACION DE ELEMENTOS DE FORMA DINAMICA //

// 1. Crear un elemento 
var elemento = document.createElement("h2")

// 2. Crear contenido 
var contenido = createTextNode("Este es un texto");

// 3. Añadir el nodo de texto al elemento 
elemento.appendChild(contenido);

// 4. Añadir atributos //
elemento.setAttribute("align", "center");

// Añadir el elemento al DOM //
document.getElementsByid("subtitulo").appendChild(elemento);