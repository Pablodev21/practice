
// Tipos de datos y Tipos de variables //
// Al ser de tipado debil, la variable se adapta al valor, no el valor a la variable //

numero = 15;
numero = "Hola";

// Tipos de datos primitivos : string, number, boolean //

string = "Cadena de texto";
number = 21;
booleano = true;


// Casos especiales de datos Undefined, Nan, Null //
// Undefined es una variable declarada (let numero;) pero no esta inicializada, es decir, no se le ha asignado aun un valor //
// Null, si que es un valor, no esta indefinida, aunque su valor es VACIO, de forma intencional //
// Nan es algo que se indica cuando se esta fallando en el uso de operadores con diferentes tipos de datos //


// Tipos de variables var, let y const //
// let limita el espacio de actuación de la variable a el bloque donde la estoy usando, este alcance se llama scope//
// var tiene alcance global //
// const para una variable constante, que NO varia //
var variable1= 1;
const variable2=2;
let varibale3 =3;

// Se pueden crear varias variables a la vez //
let variable3, variable4, variable5;

// Hoisting : Funcionamiento de los contextos de ejecucion //


// prompt es una funcion que recoge info por texto desde la pantalla de chrome //

/*
let nombre =prompt("Hola, que tal estas?");

console.log(nombre);

*/



// Concaquenar //
// Se utiliza el simbolo backtip " ` "

nombre = " soy Pablo";

frase =`Hola ${nombre} y estoy aprendiendo JS`;

document.write(frase);

document.write(frase);








