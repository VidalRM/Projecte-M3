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
    TextField user;

    @FXML
    PasswordField pwdB;

    @FXML
    PasswordField confPwdB;

    @FXML
    public void baja() throws IOException {
        boolean trobat = false;
        for (compte compte : App.compteE) {
                if (pwdB.getText().equals(confPwdB.getText())) {
                    trobat = true;
                    if (pwdB.getText().equals(compte.getPwd()) && confPwdB.getText().equals(compte.getPwd())) {
                        Alert warning = new Alert(Alert.AlertType.INFORMATION);
                        warning.setTitle("Cuenta dada de baja - Account terminated");
                        warning.setHeaderText("Cuenta dada de baja correctamente -"
                                + " Account terminated successfully");
                        warning.showAndWait();
                        App.compteE.remove(compte);
                        App.setRoot("secondary");
                        break;
                    } if (trobat == false) {
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

    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

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
