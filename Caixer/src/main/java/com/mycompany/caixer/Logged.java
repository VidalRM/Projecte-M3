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
    
    /**

    Método que permite redirigir a la ventana de logout.
    @throws IOException si hay un error al cargar la vista "primary.fxml".
    */

    
    @FXML
    public void logout() throws IOException {
        App.setRoot("primary");
    }
    
    /**

    Método que permite redirigir a la ventana de cambiar contraseña.
    @throws IOException si hay un error al cargar la vista "cmbPwd.fxml".
    */


    @FXML
    public void cambiarPwd() throws IOException {
        App.setRoot("cmbPwd");
    }
    
    /**

    Método que permite redirigir a la ventana de baja.
    @throws IOException si hay un error al cargar la vista "baja.fxml".
    */


    @FXML
    public void baja() throws IOException {
        App.setRoot("baja");
    }
    
    /**

    Método que permite redirigir a la ventana de ingresar.
    @throws IOException si hay un error al cargar la vista "ingresar.fxml".
    */


    @FXML
    public void ingresar() throws IOException {
        App.setRoot("ingresar");
    }
    
    /**

    Método que permite redirigir a la ventana de retirar.
    @throws IOException si hay un error al cargar la vista "retirar.fxml".
    */


    @FXML
    public void retirar() throws IOException {
        App.setRoot("retirar");
    }
    
    /**

    Método que permite redirigir a la ventana de transferencia.
    @throws IOException si hay un error al cargar la vista "transferir.fxml".
    */


    @FXML
    public void transferencia() throws IOException {
        App.setRoot("transferir");
    }
    
    /**

    Muestra en una ventana emergente el saldo de la cuenta del usuario logueado.
    @throws IOException si ocurre un error al mostrar la ventana de alerta.
    */

    @FXML
    public void saldo() throws IOException {
        Alert warning = new Alert(Alert.AlertType.INFORMATION);
        warning.setTitle("Saldo - Balance");
        warning.setHeaderText("");
        warning.setContentText("Su saldo és - Your balance is: " + Login.compteLogged.getSaldo() + "€");
        warning.showAndWait();
    }
    
    /**

    Método que cambia el idioma de la interfaz a ingles.
    Cambia los textos de los elementos de la vista a ingles y asigna la variable de idioma a "ingles".
    */

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
    
    /**

    Método que cambia el idioma de la interfaz a español.
    Cambia los textos de los elementos de la vista a español y asigna la variable de idioma a "español".
    */

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
