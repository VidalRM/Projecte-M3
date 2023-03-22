/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


/**
 *
 * @author alumne
 */
public class Controller {

    @FXML
    TextField user;

    @FXML
    PasswordField pwd;

    @FXML
    Button login;
    
    int intentos = 3;

    @FXML
    public void logear() throws IOException {
        String usuariL = user.getText();
        String pwdL = pwd.getText();
        

        compte c = new compte();
        
        if (usuariL.equals(c.getUsuari()) && pwdL.equals(c.getPwd())) {
            App.setRoot("secondary");
        } else { 
           intentos--;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error de autenticación");
            alert.setHeaderText("Los datos introducidos no són correctos.\n"
                    + "Vuelvelo a intentar.");
            alert.setContentText("Por seguridad, después de 3 intentos fallidos"
                    + " se bloqueará la cuenta. Te quedan " + intentos + " intentos");
            alert.showAndWait();
            if (intentos == 0) {
                blockUser();
            }
        }
    }

    @FXML
    public void blockUser() {
        user.setDisable(false);
        pwd.setDisable(false);
        login.setDisable(false);
    }
    
    
}
