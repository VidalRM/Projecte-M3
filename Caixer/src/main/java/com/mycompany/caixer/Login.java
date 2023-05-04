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
    Label no_tienes;

    @FXML
    Label welc;

    @FXML
    Label text;

    @FXML
    Button registro;

    int intentos = 3;

    public static compte compteLogged = null;

    /**

    Esta clase es el controlador de la vista principal del sistema de autenticación.

    Permite al usuario iniciar sesión o registrar una nueva cuenta.

    También permite cambiar el idioma de la interfaz entre español e inglés.
    */
    
    /**

    Cambia la vista a la pantalla de registro de una nueva cuenta.
    @throws IOException Si ocurre un error al cargar la vista de registro.
    */
    
    @FXML
    public void registrar() throws IOException {
        App.setRoot("registrar");
    }
    
    /**

    Verifica las credenciales del usuario y cambia a la vista de la pantalla principal si las credenciales son válidas.

    Si las credenciales no son válidas, se muestra una alerta de advertencia y se reduce el número de intentos restantes.

    Si el número de intentos restantes llega a cero, la cuenta se bloquea y se muestra una alerta de error.

    @throws IOException Si ocurre un error al cargar la vista de la pantalla principal.
    */

    @FXML
    public void logear() throws IOException {
        String usuariL = user.getText();
        String pwdL = pwd.getText();

        boolean trobat = false;

        if (usuariL.isEmpty() || pwdL.isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            for (compte compte : compte.Cuentas) {
                if (compte.getUsuari().equals(usuariL) && compte.getPwd().equals(pwdL)) {
                    compteLogged = compte;
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

    }
    
    /**

    Deshabilita los campos de usuario y contraseña y el botón de inicio de sesión.
    */

    @FXML
    public void blockUser() {
        user.setDisable(true);
        pwd.setDisable(true);
        login.setDisable(true);
    }
    
    /**

    Método que cambia el idioma de la interfaz a español.
    Cambia los textos de los elementos de la vista a español y asigna la variable de idioma a "español".
    */

    @FXML
    public void espanol() {
        registro.setText("Registro");
        welc.setText("¡Bienvenido!");
        text.setText("Por favor, introduzca sus datos de inicio de sesión");
        user.setPromptText("Usuario");
        pwd.setPromptText("Contraseña");
        no_tienes.setText("¿No tienes cuenta?");
        App.idioma = "español";

    }
    
    /**

    Método que cambia el idioma de la interfaz a inglés.
    Cambia los textos de los elementos de la vista a inglés y asigna la variable de idioma a "ingles".
    */

    @FXML
    public void ingles() {
        registro.setText("Register");
        welc.setText(" ¡Welcome!");
        text.setText("             Please, enter your login details");
        user.setPromptText("User");
        pwd.setPromptText("Password");
        no_tienes.setText("Don't have an account?");
        App.idioma = "ingles";
    }
    
    /**

    Método que muestra una alerta que avisa que bloquea la cuenta de usuario.
    Desactiva los campos de usuario y contraseña y el botón de login.
    */

    @FXML
    public void block() {
        Alert block = new Alert(Alert.AlertType.ERROR);
        block.setTitle("Cuenta bloqueada");
        block.setHeaderText("La cuenta ha sido bloqueada por seguridad.");
        block.setContentText("Contacte con su entidad");
        block.showAndWait();
        blockUser();
    }

    /**

    Método que muestra una alerta de error de autenticación.
    Informa al usuario de que los datos introducidos no son correctos y le indica el número de intentos
    que le quedan antes de bloquear la cuenta.
    */
    
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
    
     /**

    Inicializa el idioma de la aplicación en español.
    */

    @FXML
    void initialize() {
        App.idioma = "español";

    }

}
