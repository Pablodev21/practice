var digito1 = null;

var digito2 =  null;

var signo_Operacion="";

var texto_Calculadora ="";



// Funcion de prueba //

function prueba(){
    var variable = document.getElementsByClassName('numero-Calculadora')[0].value;
    console.log(variable);
    // document.getElementsByName()
}

// Funcion para recoger los digitos en funcion a la clase en la que este el elemento //
function recogerNumero(nombre_Clase,texto){

    let datos = document.getElementsByClassName(`${nombre_Clase}`).value;
    console.log(datos);
    if(digito1===null && digito2===null){

        digito1=datos;
        document.getElementsByClassName(nombre_Clase).innerHTML=digito1;

    }
    else if(digito1!=null && digito2===null ){

        digito2=datos;
        texto_Calculadora+=digito2;
        document.getElementsByClassName(texto).innerHTML=texto_Calculadora;
    }

    console.log(digito1 + " "+ digito2);

}


function recoger_Operador(clase){

        let datos = document.getElementsByClassName(clase).value;

        signo_Operacion = datos;
        texto_Calculadora+=signo_Operacion;
        document.getElementsByClassName(texto).innerHTML=texto_Calculadora;

        
        document.getElementsByClassName(texto).innerHTML= texto_Calculadora;
}




