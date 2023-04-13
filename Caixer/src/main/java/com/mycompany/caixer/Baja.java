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
    Label usuario;

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
            if (user.getText().equals(compte.getUsuari())) {
                trobat = true;
                if (pwdB.getText().equals(confPwdB.getText())) {
                    if (pwdB.getText().equals(compte.getPwd()) && confPwdB.getText().equals(compte.getPwd())) {
                        App.compteE.remove(user.getText());
                        App.setRoot("secondary");
                        break;
                    } else {
                        Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención");
            warning.setContentText("Contraseña incorrecta");
            warning.showAndWait();
                    }
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
            warning.setContentText("Usuario no existente");
            warning.showAndWait();
        }
    }

    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void initialize() {
        if (App.idioma.equals("ingles")) {
            usuario.setText("User");
            pwd.setText("Password");
            confPwd.setText("Confirmar password");
            confirmar.setText("Confirm");
            cancelar.setText("Cancel");
        } else {
            App.idioma = "español";
            usuario.setText("Usuario");
            pwd.setText("Contraseña");
            confPwd.setText("Confirmar contraseña");
            confirmar.setText("Confirmar");
            cancelar.setText("Cancelar");
        }

    }

}
