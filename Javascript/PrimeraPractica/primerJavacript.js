
/*
Función básica para mostrar por consola 
*/
console.log("Esto es un ejemplo")

/*
const y let son variables genericas
const indica que el valor no varia.
let indica que el valor puede variar.
  
 */
const num =1
let num1 =1

/*
Esto es un string
*/
const palabras ="Hola bon dia"

/*
Esto es un array vacio
*/
let conjunto = [] 


/*
Asi declaro un objeto, no es necesario crear constructores
*/
let objeto = {
    id:1,
    nombre: "Pablo",
    profesion:"Programador"
}

console.log(objeto)

let objeto2={
    id:1,
    nombre: "Daniel",
    profesion:"Programador"

}
/*
    Relleno de un array manualmente
*/

conjunto =[
    {
        id:1,
        nombre: "Pablo",
        profesion:"Programador"
    },
    {
        id:2,
        nombre: "Daniel",
        profesion:"Programador"
    }  

] 
console.log(conjunto)

/*
    Con el metodo .push puedo meter todo lo que necesite dentro del array 
*/

conjunto.push(num)
conjunto.push(palabras)
conjunto.push(objeto)

console.log(conjunto)



// map es un mapa, donde le indico por posiciones que tiene dentro de ellas
let map = new Map();

// con el metodo .set meto una variable dentro del map

map.set(1,"Pablo")

// con el metodo .get obtengo lo que este introducido en la posicion que le indico 

console.log(map.get(1))

// con el metodo .has compruebo si hay algo en la posicion que le indico, con una respuesta en formato boolean
// En este caso devuelve true

console.log(map.has(1))

// con el metodo .delete elimino lo que hay dentro de una posicion

map.set(2,"Daniel")

// el metodo .delete devuelve una respuesta en formato boolean de si ha eliminado o no
console.log(map.delete(2))

// con el metodo .clear elimino todo lo que hay el map

map.clear()

console.log(map)





let lista =[
    "Pablo",
    "Dani",
    "Anxo",
    "Nelson",
    "Roberto"
    ]

// El bucle for es igual que en java, el bucle for each cambia algo
// En el bucle for each solo puedes recorrer no variar la info de sus posiciones 

// Anotacion, la funciones se definen como const
const recorrerNombres=()=>{
    lista.forEach(nombre=>console.log(nombre, nombre))
}
// Anotacion, se llama asi las funciones
recorrerNombres()






