/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author alumne
 */

public class Logged {

    @FXML
    Label logoutext;

    @FXML
    Button saldo;

    @FXML
    Button ingresar;

    @FXML
    Button retirar;

    @FXML
    Button cmbPwd;

    @FXML
    Button transf;

    @FXML
    Button baja;

    Font font = Font.font("System", 20);
    Font font2 = Font.font("System", 22);

    @FXML
    public void logout() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    public void cambiarPwd() throws IOException{
        App.setRoot("cmbPwd");
    }
    
    @FXML
    public void baja() throws IOException{
        App.setRoot("baja");
    }
    
    @FXML
    public void ingresar() throws IOException{
        App.setRoot("ingresar");
    }
    
    @FXML
    public void retirar() throws IOException{
        App.setRoot("retirar");
    }
    
    @FXML
    public void transferencia() throws IOException {
        App.setRoot("transferir");
    }

    @FXML
    public void ingles() {
        logoutext.setText("Logout");
        logoutext.setFont(font2);
        ingresar.setText("Deposit");
        retirar.setText("Withdraw");
        transf.setText("Transfer");
        cmbPwd.setText("Change password");
        cmbPwd.setMinWidth(219);
        baja.setText("Cancel account");
        saldo.setText("Consult balance");
    }

    @FXML
    public void espanol() {
        logoutext.setText("Cerrar sesión     ");
        logoutext.setFont(font);
        ingresar.setText("Ingresar");
        retirar.setText("Retirar");
        transf.setText("Transferir");
        cmbPwd.setText("Cambiar contraseña");
        baja.setText("Dar de baja");
        saldo.setText("Consultar saldo");
    }

    @FXML
    void initialize() {

        if (App.idioma.equals("ingles")) {
            logoutext.setText("Logout    ");
            ingresar.setText("Deposit");
            logoutext.setFont(font);
            retirar.setText("Withdraw");
            transf.setText("Transfer");
            cmbPwd.setText("Change password");
            cmbPwd.setMinWidth(219);
            baja.setText("Cancel account");
            saldo.setText("Consult balance");

        } else {
            App.idioma = "español";
            logoutext.setText("Cerrar sesión     ");
            logoutext.setFont(font);
            ingresar.setText("Ingresar");
            retirar.setText("Retirar");
            transf.setText("Transferir");
            cmbPwd.setText("Cambiar contraseña");
            baja.setText("Dar de baja");
            saldo.setText("Consultar saldo");

        }

    }
}
