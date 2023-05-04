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
public class Retirar {

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
    
    /**

    Este método se encarga de realizar una retirada de dinero de la cuenta bancaria del usuario logueado, siempre y cuando
    se cumplan las siguientes condiciones:
        Los campos "cantidadT", "pwdB" y "confPwdB" deben estar rellenos.
        La contraseña introducida en ambos campos debe coincidir.
        La cantidad a retirar debe ser mayor que cero y menor o igual al saldo disponible en la cuenta.
    Si se cumplen todas las condiciones, se realizará la retirada de dinero y se mostrará un mensaje de confirmación.
    En caso contrario, se mostrarán mensajes de advertencia informando de los problemas encontrados.
    Además, se actualizará el archivo de movimientos de la cuenta y se redirigirá al usuario a la ventana principal de la aplicación.
    @throws IOException Si ocurre un error al redirigir a la ventana principal de la aplicación.
    */

    @FXML
    public void retirar() throws IOException {
        boolean trobat = false;

        if (cantidadT.getText().isEmpty() || pwdB.getText().isEmpty() || confPwdB.getText().isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            for (compte compte : compte.Cuentas) {
                if (compte.getPwd().equals(pwdB.getText()) && compte.getPwd().equals(confPwdB.getText())) {
                    trobat = true;
                    if (pwdB.getText().equals(confPwdB.getText())) {
                        float cantidadN = Float.parseFloat(cantidadT.getText());
                        if (cantidadN > compte.getSaldo()) {
                            Alert confirm = new Alert(Alert.AlertType.WARNING);
                            confirm.setTitle("Atención - Warning");
                            confirm.setHeaderText("Saldo insuficiente - Insufficient balance");
                            confirm.showAndWait();
                            break;
                        } else if (cantidadN <= 0) {
                            Alert warning = new Alert(Alert.AlertType.WARNING);
                            warning.setTitle("Atención - Warning");
                            warning.setContentText("Cantidad inválida - Invalid amount");
                            warning.showAndWait();
                        } else {
                            compte.setSaldo(compte.getSaldo() - cantidadN);
                            Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                            confirm.setTitle("Retiro realizado - Withdrawal done");
                            confirm.setHeaderText("Retiro realizado"
                                    + " correctamente - The withdrawal has been successfully completed");
                            confirm.showAndWait();
                            movimientos.Mov.add(new movimientos(compte.getUsuari(), "Retiro", -cantidadN));
                            movimientos.guardarMovs();
                            compte.guardarDatos();
                            App.setRoot("secondary");
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
            if (trobat == false) {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención - Warning");
                warning.setContentText("Contraseña incorrecta - Wrong password");
                warning.showAndWait();
            }
        }

    }
    
     /**

    Método que permite redirigir a la ventana de logout.
    @throws IOException si hay un error al cargar la vista "primary.fxml".
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
