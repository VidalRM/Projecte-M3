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

    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

    public void cambiarPwd() throws IOException {
        boolean trobat = false;
        for (compte compte : App.compteE) {

            if (compte.getPwd().equals(pwdU.getText())) {

                trobat = true;

                if (newPwd.getText().equals(confirmPwd.getText())) {
                    if (newPwd.getText().equals(compte.getPwd()) && confirmPwd.getText().equals(compte.getPwd())) {
                        Alert warning = new Alert(Alert.AlertType.WARNING);
                        warning.setTitle("Atención");
                        warning.setContentText("Su contraseña no puede ser igual"
                                + " a la actual");
                        warning.showAndWait();
                        break;
                    }

                    compte.setPwd(newPwd.getText());
                    Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                    confirm.setTitle("Contraseña actualizada");
                    confirm.setHeaderText("La contraseña ha sido actualizada con exito");
                    confirm.showAndWait();
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

    @FXML
    void initialize() {
        if (App.idioma.equals("ingles")) {
            contraA.setText("Current password");
            nuevaContra.setText("New password");
            confContra.setText("Confirm password");
        } else {
            App.idioma = "español";
            contraA.setText("Contraseña actual");
            nuevaContra.setText("Nueva contraseña");
            confContra.setText("Confirmar contraseña");
        }

    }

}
