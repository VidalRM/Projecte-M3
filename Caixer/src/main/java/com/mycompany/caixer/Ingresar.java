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
