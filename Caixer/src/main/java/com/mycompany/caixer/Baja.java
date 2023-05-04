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

/**
 *
 * @author alumne
 */
public class Baja {

    @FXML
    Label pwd;

    @FXML
    Label confPwd;

    @FXML
    Button confirmar;

    @FXML
    Button cancelar;

    @FXML
    PasswordField pwdB;

    @FXML
    PasswordField confPwdB;

    /**
     *
     * Método que se encarga de eliminar una cuenta de usuario. Primero
     * comprueba que las contraseñas introducidas coinciden, luego busca la
     * cuenta a eliminar en la lista de cuentas de la aplicación y si la
     * encuentra y las contraseñas coinciden, la elimina. Si no encuentra la
     * cuenta o las contraseñas no coinciden, muestra una alerta
     * correspondiente.
     *
     * @throws IOException si hay un problema al cambiar la vista de la
     * aplicación.
     *
     */
    @FXML
    public void baja() throws IOException {
        boolean trobat = false;
        // Si alguno de los campos está vacío, muestra una alerta de advertencia.
        if ( pwdB.getText().isEmpty() || confPwdB.getText().isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            for (compte compte : compte.Cuentas) {
                if (pwdB.getText().equals(confPwdB.getText())) {
                    trobat = true;
                    if (pwdB.getText().equals(compte.getPwd()) && confPwdB.getText().equals(compte.getPwd())) {
                        Alert warning = new Alert(Alert.AlertType.INFORMATION);
                        warning.setTitle("Cuenta dada de baja - Account terminated");
                        warning.setHeaderText("Cuenta dada de baja correctamente -"
                                + " Account terminated successfully");
                        warning.showAndWait();
                        compte.Cuentas.remove(compte);
                        compte.guardarDatos();
                        App.setRoot("primary");
                        break;
                    }
                    if (trobat == false) {
                        Alert warning = new Alert(Alert.AlertType.WARNING);
                        warning.setTitle("Atención - Warning");
                        warning.setContentText("Contraseña incorrecta");
                        warning.showAndWait();
                        break;
                    }
                } else {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Atención - Warning");
                    warning.setContentText("Las contraseñas no coinciden - Passwords do not match");
                    warning.showAndWait();
                    break;
                }
            }
        }

    }

    /**
     *
     * Método que cancela una operación y vuelve a la pantalla secundaria.
     *
     * @throws IOException si hay un error en la carga de la pantalla
     * secundaria.
     *
     */
    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }
    
    /**

    Este método se llama automáticamente al inicializar la ventana.
    Se encarga de configurar el texto de los elementos de la interfaz
    dependiendo del idioma seleccionado en la aplicación.
    Si el idioma es inglés, se establece el texto en inglés para los
    elementos de la interfaz. Si es español, se establece el texto
    en español.
    * 
    */

    @FXML
    void initialize() {
        if (App.idioma.equals("ingles")) {
            pwd.setText("Password");
            confPwd.setText("Confirm password");
            confirmar.setText("Confirm");
            cancelar.setText("Cancel");
        } else {
            App.idioma = "español";
            pwd.setText("Contraseña");
            confPwd.setText("Confirmar contraseña");
            confirmar.setText("Confirmar");
            cancelar.setText("Cancelar");
        }

    }

}
