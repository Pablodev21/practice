// Clase que guarda los endPoints a bbdd //
export class endPoint{

    // LOGIN //
    static GET_LOGIN: string ='http://localhost:8080/fisioSilvia/user/login';

    // Clientes //
    static GET_8_CLIENTS: string = 'http://localhost:8080/fisioSilvia/client/get8Clients';
    static MOD_CLIENT:string='http://localhost:8080/fisioSilvia/client/modify';
    static DEL_CLIENT:string='http://localhost:8080/fisioSilvia/client/delete';
    


    // Backgrounds //
    static GET_BACKGROUNDS_IDCLIENT: string ='http://localhost:8080/fisioSilvia/backgrounds/get8Backgrounds/';
}