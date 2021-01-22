
package bridgerton.bank.society.GUI;

import java.io.Serializable;


public class Admin implements Serializable{ // Calse que se usa para inicializar los 
    public String user;
    public String pass;

    Admin(String username, String password) { // Inicializamos a cada usuario
        this.user = username;
        this.pass = password;
        
    }

    Admin() {
        
    }
    

}
