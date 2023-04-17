var digito1 = "";

var digito2 =  "";

var signo_Operacion="";

var texto_Calculadora = " ";

var primeroTerminado = false;

var segundoTerminado = false;

var existeOperador = false;

var resultado =0;



// Porque no se actualiza visualmente ?? //


// Funcion para recoger los digitos en funcion a la clase en la que este el elemento //
function recogerNumero(numeroInput){

    

    // let datos = document.getElementsByClassName(`${nombre_Clase}`).value;
    var valor = document.getElementsByClassName('numero-Calculadora')[numeroInput].value;
    

    if(primeroTerminado===false && signo_Operacion===""){

        digito1+=valor;
        texto_Calculadora=digito1;

        
        document.getElementsByClassName('texto-Resultado')[0].value = texto_Calculadora;


    }
    else if(primeroTerminado===true){

        digito2+=valor;
        texto_Calculadora+=digito2;

        document.getElementsByClassName('texto-Resultado')[0].value = texto_Calculadora;
       

    }


}


    function realizarOperacion (){

        console.log(signo_Operacion);
        comprobarIgual=true;

        // Realizar operaciones //

        if (signo_Operacion==="+") {
            texto_Calculadora = parseFloat(digito1)  + parseFloat(digito2) ;
            
        }

        else if(signo_Operacion==="-") {texto_Calculadora = parseFloat(digito1)-parseFloat(digito2);}

        else if (signo_Operacion==="*") {texto_Calculadora = parseFloat(digito1)*parseFloat(digito2);}

        else if(signo_Operacion==="/") {texto_Calculadora = parseFloat(digito1)/parseFloat(digito2);}

        else texto_Calculadora= "SYNTAX ERROR";

        document.getElementsByClassName('texto-Resultado')[0].value = texto_Calculadora;

    }


    function reinicio(){

        // Reinicio de variables //

        digito1 = "";

        digito2 =  "";

        signo_Operacion="";

        texto_Calculadora ="";

        primeroTerminado = false;
        
        segundoTerminado = false;

        existeOperador= false;

        document.getElementsByClassName('texto-Resultado')[0].value = texto_Calculadora;

    }


    function recogerOperador(numeroIndex){

        if(existeOperador===false){

            let datos = document.getElementsByClassName('operador-Calculadora')[numeroIndex].value;

            signo_Operacion = datos;
    
            texto_Calculadora+=signo_Operacion;
    
            document.getElementsByClassName('texto-Resultado')[0].value = texto_Calculadora;

            primeroTerminado = true;

            existeOperador= true;

        }
        
    

}




