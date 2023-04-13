var digito1 = "";

var digito2 =  "";

var signo_Operacion="";

var texto_Calculadora = " ";

var primeroTerminado = false;

var segundoTerminado = false;





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
    
    


    if(primeroTerminado===false && signo_Operacion===""){

        digito1+=valor;
        texto_Calculadora+=digito1;

        var pruebaTexto = document.getElementsByClassName('texto-Resultado');
        
        // Aqui viene pruebaTexto a null
        // pruebaTexto.innerHTML=texto_Calculadora;
        
        pruebaTexto.value= texto_Calculadora;
        console.log("hoa")

        if(signo_Operacion!=""){

            primeroTerminado=true;

        } 

        


    }
    if(primeroTerminado===true){

        digito2+=document.getElementsByClassName('numero-Calculadora')[numeroInput].value;
    }

    console.log("digito 1 " + digito1 + " digito 2 "+ digito2);

}


    function realizarOperacion (){

        comprobarIgual=true;

        // Realizar operaciones //

        if (signo_Operacion==="+") texto_Calculadora = digito1+digito2;

        if(signo_Operacion==="-") texto_Calculadora = digito1-digito2;

        if (signo_Operacion==="*") texto_Calculadora = digito1*digito2;

        if(signo_Operacion==="/") texto_Calculadora = digito1/digito2;

        else texto_Calculadora= "SYNTAX ERROR";

    }


    function reinicio(){

        // Reinicio de variables //

        digito1 = null;

        digito2 =  null;

        signo_Operacion="";

        texto_Calculadora ="";

        primeroTerminado = false;
        
        segundoTerminado = false;

    }


    function recogerOperador(numeroIndex){

        let datos = document.getElementsByClassName('operador-Calculadora')[numeroIndex].value;

        signo_Operacion = datos;

    

        // texto_Calculadora+=signo_Operacion;
        // document.getElementsByClassName(texto).innerHTML=texto_Calculadora;

        
        // document.getElementsByClassName(texto).innerHTML= texto_Calculadora;
}




