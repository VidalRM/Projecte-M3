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
public class Cambiar {

    @FXML
    PasswordField pwdU;

    @FXML
    PasswordField newPwd;

    @FXML
    PasswordField confirmPwd;

    @FXML
    Label contraA;

    @FXML
    Label nuevaContra;

    @FXML
    Label confContra;

    @FXML
    Button confirmar;

    @FXML
    Button cancelar;
    
    /**

    Método que permite cancelar la acción y volver a la pantalla secundaria.
    @throws IOException si ocurre un error al cambiar de pantalla.
    */

    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

    /**

    Método que permite cambiar la contraseña del usuario.

    @throws IOException si ocurre un error al cambiar de pantalla.
    */
    
    public void cambiarPwd() throws IOException {
        boolean trobat = false;

        if (pwdU.getText().isEmpty() || newPwd.getText().isEmpty() || confirmPwd.getText().isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            for (compte compte : compte.Cuentas) {

                if (compte.getPwd().equals(pwdU.getText())) {

                    trobat = true;

                    if (newPwd.getText().equals(confirmPwd.getText())) {
                        if (newPwd.getText().equals(compte.getPwd()) && confirmPwd.getText().equals(compte.getPwd())) {
                            Alert warning = new Alert(Alert.AlertType.WARNING);
                            warning.setTitle("Atención - Warning");
                            warning.setContentText("Su contraseña no puede ser igual"
                                    + " a la actual");
                            warning.showAndWait();
                            break;
                        }

                        compte.setPwd(newPwd.getText());
                        Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                        confirm.setTitle("Contraseña actualizada - Password updated");
                        confirm.setHeaderText("La contraseña ha sido actualizada con exito - "
                                + "Password updated successfully");
                        confirm.showAndWait();
                        movimientos.Mov.add(new movimientos(compte.getUsuari(), "CambioContraseña", 0));
                        movimientos.guardarMovs();
                        compte.guardarDatos();
                        App.setRoot("secondary");
                        break;

                    } else {
                        Alert warning = new Alert(Alert.AlertType.WARNING);
                        warning.setTitle("Atención");
                        warning.setContentText("Las contraseñas no coinciden");
                        warning.showAndWait();
                        break;
                    }

                }

            }

            if (trobat == false) {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención");
                warning.setContentText("Contraseña incorrecta");
                warning.showAndWait();
            }
        }

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
            contraA.setText("Current password");
            nuevaContra.setText("New password");
            confContra.setText("Confirm password");
            cancelar.setText("Cancel");
            confirmar.setText("Confirm");
        } else {
            App.idioma = "español";
            contraA.setText("Contraseña actual");
            nuevaContra.setText("Nueva contraseña");
            confContra.setText("Confirmar contraseña");
            cancelar.setText("Cancelar");
            confirmar.setText("Confirmar");
        }

    }

}
