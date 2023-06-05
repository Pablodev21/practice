// Clase que guarda los endPoints a bbdd //
export class endPoint{

    // LOGIN //
    static GET_LOGIN: string ='http://localhost:8080/fisioSilvia/user/login';

    // Usuarios //
    static GET_Usuarios:string='http://localhost:8080/fisioSilvia/user/getUsers';
    static MOD_Usuario:string='http://localhost:8080/fisioSilvia/user/modUser';
    static DEL_Usuario:string='http://localhost:8080/fisioSilvia/user/delete';
    static SAVE_Usuario:string='http://localhost:8080/fisioSilvia/user/createUser';
    static CheckRol_Usuario:string='http://localhost:8080/fisioSilvia/user/findByLogin/';



    // Clientes //
    static GET_8_CLIENTS: string = 'http://localhost:8080/fisioSilvia/client/get8Clients';
    static MOD_CLIENT:string='http://localhost:8080/fisioSilvia/client/modify';
    static DEL_CLIENT:string='http://localhost:8080/fisioSilvia/client/delete';
    static SAVE_CLIENT:string ='http://localhost:8080/fisioSilvia/client/createClient'
    static GET_CLIENTS_BY_NOMBRE:string='http://localhost:8080/fisioSilvia/client/get/byName'
    static GET_CLIENTS_BY_PHONE:string='http://localhost:8080/fisioSilvia/client/get/byPhone'
    static GET_CLIENTS_BY_DNI:string='http://localhost:8080/fisioSilvia/client/get/byDni'

    // Backgrounds //
    static GET_BACKGROUNDS_IDCLIENT: string ='http://localhost:8080/fisioSilvia/backgrounds/get8Backgrounds/';
}
