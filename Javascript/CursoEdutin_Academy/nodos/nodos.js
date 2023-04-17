// PASOS PARA LA CREACION DE ELEMENTOS DE FORMA DINAMICA //


// // 1. Crear un elemento 
// var elemento = document.createElement("h2")

// // 2. Crear contenido 
// var contenido = document.createTextNode("Este es un texto");

// // 3. Añadir el nodo de texto al elemento 
// elemento.appendChild(contenido);

// // 4. Añadir atributos //
// elemento.setAttribute("align", "center");

// // Añadir el elemento al DOM //
// document.getElementById("subtitulo").appendChild(elemento);

// // Para añadirlo al final del body //
// // document.body.appendChild(elemento);




// // MODIFICACION DE NODOS //

// // Creo el elemento y el nodo //
// var elemento1 = document.createElement("li"), contenido1 = document.createTextNode("Nuevo texto");

// // Añado el nodo al elemento //
// elemento1.appendChild(contenido1);




// // var padre = document.getElementById("lista");

// // Tambien podria acceder a todos los elementos de la lista, accediendo de esta forma al primer elemento //
// // Con parentNode nos devuelve cual es el padre de este elemento //
// var padre = document.getElementsByTagName("li")[0].parentNode;

// // De esta forma lo añade al final de la lista //
// padre.appendChild(elemento1);

// // De esta forma le indico donde quiero añadir este elemento //
// // Como parametros lleva el elemento que quiero introducir y el elemento previo en este caso siendo el primero //
// primerElemento = document.getElementsByTagName("li")[0];
// padre.insertBefore(elemento1, primerElemento);




// ACCEDER Y MODIFICAR CONTENIDO DE UN ELEMENTO, Y AÑADIR Y ELIMINAR ELEMENTOS Y NODOS DEL DOM //



// var elemento2 = document.createElement("li");
// var contenido2 = document.createTextNode("Texto edicion nodos");

// elemento2.appendChild(contenido2);




// Acceder a un elemento para modificar su contenido //

// var elemento3 = document.getElementsByClassName("primerElemento")[0];
// Si quiero añadir algo con codigo html se usa .innetHtml //
// var texto = elemento3.textContent;


// Para sustituir un elemento //

var primerElemento = document.getElementsByTagName("li")[0];
var elementoModificado = document.createElement("li");
contenidoModificado = document.createTextNode("Elemento Modificado");
;

elementoModificado.appendChild(contenidoModificado);

var contenidoSegundo = document.createTextNode("Esto es un elemento modificado");

// Recibe 2 parametros, el elemento que quiero añadir y el elemento que quiero eliminar //
elementoPadre.replaceChild(elementoModificado,primerElemento);
