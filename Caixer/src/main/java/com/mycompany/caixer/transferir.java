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
public class transferir {

    @FXML
    Label cantidad;

    @FXML
    Label destinatario;

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
    TextField destinatarioT;

    @FXML
    PasswordField pwdB;

    @FXML
    PasswordField confPwdB;

    /**

    Realiza una transferencia de fondos entre dos cuentas.
    Si los campos de cantidad, destinatario, contraseña y confirmación de contraseña están vacíos, muestra una alerta de advertencia.
    Si la cantidad es inválida, muestra una alerta de advertencia.
    Si el saldo de la cuenta del usuario que realiza la transferencia es insuficiente, muestra una alerta de advertencia.
    Si el destinatario es la misma cuenta del usuario que realiza la transferencia, muestra una alerta de advertencia.
    Si las contraseñas no coinciden, muestra una alerta de advertencia.
    Si la contraseña es incorrecta, muestra una alerta de advertencia.
    Si la transferencia se realiza con éxito, muestra una alerta de información y actualiza los saldos de las cuentas involucradas y guarda los datos de la cuenta y los movimientos realizados en archivos.
    @throws IOException si ocurre un error de entrada/salida al guardar los datos de la cuenta y los movimientos realizados.
    */


    public void transferencia() throws IOException {
        compte CompteD = null; //Cuenta destino
        compte CompteR = null; //Cuenta remitente

        boolean existe = false;

        String cantT = cantidadT.getText(); //cantidad a transfeir
        String destT = destinatarioT.getText(); //nombre usuario cuenta destinatario
        String pwdT = pwdB.getText(); //contraseña de la cuenta remitente
        String confT = confPwdB.getText();//confirmacion de contraseña de la cuenta remitente

        //verifica si los campos están vacíos
        if (cantT.isEmpty() || destT.isEmpty() || pwdT.isEmpty() || confT.isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            // Buscar la cuenta destino
            for (compte cuenta : compte.Cuentas) {
                if (destinatarioT.getText().equals(cuenta.getUsuari())) {
                    CompteD = cuenta;
                    existe = true;
                    break;
                } else {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setTitle("Atención - Warning");
                    warning.setContentText("Cuenta inexistente - Non-existent account");
                    warning.showAndWait();
                    break;
                }
            }

            // Buscar la cuenta remitente
            for (compte cuenta : compte.Cuentas) {
                if (cuenta.getUsuari().equals(Login.compteLogged.getUsuari())) {
                    CompteR = cuenta;
                    break;
                }
            }

            // Convertir la cantidad a transferir a un número de punto flotante
            float cantidadN = Float.parseFloat(cantidadT.getText());

            // Verificar si la cantidad es inválida (menor o igual a 0)
            if (cantidadN <= 0) {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención - Warning");
                warning.setContentText("Cantidad inválida - Invalid amount");
                warning.showAndWait();

                // Verificar si la cuenta remitente no tiene suficiente saldo
            } else if (cantidadN > CompteR.getSaldo()) {
                Alert confirm = new Alert(Alert.AlertType.WARNING);
                confirm.setTitle("Atención - Warning");
                confirm.setHeaderText("Saldo insuficiente - Insufficient balance");
                confirm.showAndWait();

                // Verificar si la cuenta destino es la misma que la cuenta remitente
            } else if (destinatarioT.getText().equals(CompteR.getPwd())) {
                Alert confirm = new Alert(Alert.AlertType.WARNING);
                confirm.setTitle("Atención - Warning");
                confirm.setHeaderText("Operación imposible - Impossible operation");
                confirm.showAndWait();

                // Verificar si las contraseñas no coinciden
            } else if (!pwdB.getText().equals(confPwdB.getText())) {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención - Warning");
                warning.setContentText("Las contraseñas no coinciden - Passwords do not match");
                warning.showAndWait();
                
                 // Verificar si la contraseña de la cuenta remitente es incorrecta
            } else if (!CompteR.getPwd().equals(pwdB.getText())) {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención - Warning");
                warning.setContentText("Contraseña incorrecta - Wrong password");
                warning.showAndWait();
            } else {
                if (CompteR.getPwd().equals(pwdB.getText()) && existe == true) {
                    Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                    confirm.setTitle("Transferencia realizada - Transfer done");
                    confirm.setHeaderText("Transferencia realizada"
                            + " correctamente - The transfer has been successfully completed");
                    confirm.showAndWait();
                    CompteD.setSaldo(CompteD.getSaldo() + cantidadN);
                    CompteR.setSaldo(CompteR.getSaldo() - cantidadN);
                    movimientos.Mov.add(new movimientos(CompteD.getUsuari(), "Transferir", cantidadN));
                    movimientos.Mov.add(new movimientos(CompteR.getUsuari(), "Transferir", -cantidadN));
                    movimientos.guardarMovs();
                    compte.guardarDatos();
                    App.setRoot("secondary");

                }

            }
        }

    }

    /**
     * Método que permite redirigir a la ventana de logout.
     *
     * @throws IOException si hay un error al cargar la vista "primary.fxml".
     */
    public void cancelar() throws IOException {
        App.setRoot("secondary");
    }

    /**
     *
     * Este método se llama automáticamente al inicializar la ventana. Se
     * encarga de configurar el texto de los elementos de la interfaz
     * dependiendo del idioma seleccionado en la aplicación. Si el idioma es
     * inglés, se establece el texto en inglés para los elementos de la
     * interfaz. Si es español, se establece el texto en español.
     *
     */
    @FXML
    void initialize() {
        if (App.idioma.equals("ingles")) {
            cantidad.setText("Quantity");
            pwd.setText("Password");
            confPwd.setText("Confirm password");
            confirmar.setText("Confirm");
            cancelar.setText("Cancel");
            destinatario.setText("Addressee");
        } else {
            App.idioma = "español";
            cantidad.setText("Cantidad");
            pwd.setText("Contraseña");
            confPwd.setText("Confirmar contraseña");
            confirmar.setText("Confirmar");
            cancelar.setText("Cancelar");
            destinatario.setText("Destinatario");
        }

    }
}
