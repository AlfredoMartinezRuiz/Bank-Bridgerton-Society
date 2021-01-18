/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
