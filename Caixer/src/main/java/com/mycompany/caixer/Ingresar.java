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
public class Ingresar {

    @FXML
    Label cantidad;

    @FXML
    Label pwd;

    @FXML
    Label confPwd;

    @FXML
    Button confirmar;

    @FXML
    Button cancelar;

    @FXML
    TextField cantidadT;

    @FXML
    PasswordField pwdB;

    @FXML
    PasswordField confPwdB;

    @FXML
    public void ingresar() throws IOException {
        boolean trobat = false;
        for (compte cuenta : compte.Cuentas) {
            if (cuenta.getPwd().equals(pwdB.getText()) && cuenta.getPwd().equals(confPwdB.getText())) {
                trobat = true;
                if (pwdB.getText().equals(confPwdB.getText())) {
                    float nuevosaldo = Float.parseFloat(cantidadT.getText());
                    cuenta.setSaldo(cuenta.getSaldo() + nuevosaldo);
                    Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                    confirm.setTitle("Ingreso realizado - Income done");
                    confirm.setHeaderText("Ingreso realizado"
                            + " correctamente - The deposit has been successfully completed");
                    confirm.showAndWait();
                    compte.cargarDatos();
                    App.setRoot("secondary");
                    break;
                } else {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Atención - Warning");
                    warning.setContentText("Las contraseñas no coinciden - Passwords do not match");
                    warning.showAndWait();
                    break;
                }
            }
        }
        if (trobat == false) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Contraseña incorrecta - Wrong password");
            warning.showAndWait();
        }

    }
    
    

    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void initialize() {
        if (App.idioma.equals("ingles")) {
            cantidad.setText("Quantity");
            pwd.setText("Password");
            confPwd.setText("Confirm password");
            confirmar.setText("Confirm");
            cancelar.setText("Cancel");
        } else {
            App.idioma = "español";
            cantidad.setText("Cantidad");
            pwd.setText("Contraseña");
            confPwd.setText("Confirmar contraseña");
            confirmar.setText("Confirmar");
            cancelar.setText("Cancelar");
        }

    }
}
