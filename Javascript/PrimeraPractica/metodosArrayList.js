// Declaro un arraylist
let lista =[
"Pablo",
"Dani",
"Anxo",
"Nelson",
"Roberto"
]

// .splice elimina los elementos de la lista que le indico y devuelve un nuevo con array con
// estos elementos 
// .splice recibe dos parametros posicion inicial y cuantas posiciones tiene que avanzar 
let listaEliminados=lista.splice(0,3)


console.log(lista)
console.log(listaEliminados)

// el metodo .pop elimina el ultimo elemento de la lista o array

listaEliminados.pop()
console.log(listaEliminados)

// el metodo .shift elimina el primer elemento de la lista o array

listaEliminados.shift()
console.log(listaEliminados)


// el metodo .push añade un elemento al final de la lista

listaEliminados.push("Hugo")
console.log(listaEliminados)


// el metodo .unshift añade un elemento en la primera posicion de la lista

listaEliminados.unshift("Driu")
console.log(listaEliminados)



let numeros=[
1,2,3,4,5,6,7,8,9
]


// el metodo .every devuelve una respuesta en formato boolean
// evaluando si todos los elementos de dentro de la lista cumplen una condicicion o no
// En este caso devuelve true porque todos los elementos de dentro de la lista son mayores que 0
console.log(numeros.every((numero)=> numero > 0 ) )


// el metodo .filter devuelve un nuevo array o lista con los elementos que cumplan la condicion que establezca

let numeros2=numeros.filter((numero)=>numero>=4)
console.log(numeros2)


// el metodo .find se  utiliza para listas grandes de datos, devuelve el primer elemento que cumpla la condicionç
const numeroEncontrado=numeros.find((numero)=>numero>3)
console.log(numeroEncontrado)

// el metodo .map hace lo que no puede hacer el for each, es decir,
// modificar elementos de la lista o guardarlos en otro array

let numeroMultiplicados=numeros.map(numero=>{ return numero*5})
console.log(numeroMultiplicados)

// SI DUDO ENTRE HACER UN FOR EACH Y UN .map LA DIFERENCIA ES QUE
// SI SOLO QUIERE MOSTRAR Y NO PERSISTIR LA MODIFICACION SOBRE LOS ELEMENTOS = FOR EACH
// SI QUIERO HACER ALGUN CAMBIO SOBRE LOS ELEMENTOS O GUARDARLOS EN OTRA LISTA = .map