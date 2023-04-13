/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author alumne
 */
public class Login {

    @FXML
    TextField user;

    @FXML
    PasswordField pwd;

    @FXML
    Button login;

    @FXML
    Label welc;

    @FXML
    Label text;

    int intentos = 3;

   

    @FXML
    public void logear() throws IOException {
        String usuariL = user.getText();
        String pwdL = pwd.getText();
        

        boolean trobat = false;
        for (compte compte : App.compteE) {
            if (compte.getUsuari().equals(usuariL) && compte.getPwd().equals(pwdL)) {
                App.setRoot("secondary");
                trobat = true;
                break;
            }

        }
        if (trobat == false) {
            intentos--;
            warning();

            if (intentos <= 0) {
                block();

            }

        }
    }

    @FXML
    public void blockUser() {
        user.setDisable(true);
        pwd.setDisable(true);
        login.setDisable(true);
    }

    @FXML
    public void espanol() {
        welc.setText("¡Bienvenido!");
        text.setText("Por favor, introduzca sus datos de inicio de sesión");
        user.setPromptText("Usuario");
        pwd.setPromptText("Contraseña");
        App.idioma = "español";
    }

    @FXML
    public void ingles() {
        welc.setText(" ¡Welcome!");
        text.setText("             Please, enter your login details");
        user.setPromptText("User");
        pwd.setPromptText("Password");
        
        App.idioma = "ingles";
    }

    @FXML
    public void block() {
        Alert block = new Alert(Alert.AlertType.ERROR);
        block.setTitle("Cuenta bloqueada");
        block.setHeaderText("La cuenta ha sido bloqueada por seguridad.");
        block.setContentText("Contacte con su entidad");
        block.showAndWait();
        blockUser();
    }

    @FXML
    public void warning() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error de autenticación");
        alert.setHeaderText("Los datos introducidos no són correctos.\n"
                + "Vuelvelo a intentar.");
        alert.setContentText("Por seguridad, después de 3 intentos fallidos"
                + " se bloqueará la cuenta. Te quedan " + intentos + " intentos");
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        App.idioma = "español";
        App.almacenaUsuarios();
    }

}
