var digito1 = null;

var digito2 =  null;

var signo_Operacion="";

var texto_Calculadora ="";



// Funcion de prueba //

function prueba(valor){
    var variable = document.getElementsByClassName('numero-Calculadora')[valor].value;
    console.log(variable);


    // document.getElementsByClassName('texto-Resultado').innerHTML=7;

}

// Funcion para recoger los digitos en funcion a la clase en la que este el elemento //
function recogerNumero(numeroInput){

    // let datos = document.getElementsByClassName(`${nombre_Clase}`).value;
    var valor = document.getElementsByClassName('numero-Calculadora')[numeroInput].value;  
    if(digito1===null && digito2===null && signo_Operacion!=""){

        digito1=valor;
        // document.getElementsByClassName(nombre_Clase).innerHTML=digito1;

        console.log(digito1+" ");

    }
    else if(digito1!=null && digito2===null ){

        digito2=valor;
        texto_Calculadora+=digito2; 
        // document.getElementsByClassName('texto-calculadora').innerHTML=texto_Calculadora;
        
        console.log(digito2);
    }

}

function recogerOperador(numeroIndex){

        let datos = document.getElementsByClassName('operador-Calculadora')[numeroIndex].value;

        signo_Operacion = datos;
        // texto_Calculadora+=signo_Operacion;
        // document.getElementsByClassName(texto).innerHTML=texto_Calculadora;

        
        // document.getElementsByClassName(texto).innerHTML= texto_Calculadora;
}




