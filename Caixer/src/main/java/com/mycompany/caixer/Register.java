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
public class Register {

    @FXML
    Label user;

    @FXML
    Label pwd;

    @FXML
    Label confPwd;

    @FXML
    TextField new_user;

    @FXML
    PasswordField pwdB;

    @FXML
    PasswordField confPwdB;

    @FXML
    Button confirmar;

    @FXML
    Button cancelar;
    
    /**

    Este método se encarga de registrar una nueva cuenta en el sistema.
    Si alguno de los campos está vacío, se muestra una alerta de advertencia.
    Si las contraseñas no coinciden, también se muestra una alerta de advertencia.
    Si se crea la cuenta correctamente, se muestra una alerta informativa y se guarda la información de la cuenta en el archivo de datos.
    Por último, se redirige al usuario a la pantalla de inicio de sesión.
    @throws IOException Si ocurre un error al cargar la pantalla de inicio de sesión.
    */

    public void registrar() throws IOException {
        if (new_user.getText().isEmpty() || pwdB.getText().isEmpty() || confPwdB.getText().isEmpty()) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setTitle("Atención - Warning");
            warning.setContentText("Por favor, rellena los campos - Please, fill in the fields");
            warning.showAndWait();
        } else {
            if (confPwdB.getText().equals(pwdB.getText())) {
                compte.Cuentas.add(new compte(new_user.getText(), pwdB.getText(), 0));
                Alert warning = new Alert(Alert.AlertType.INFORMATION);
                warning.setTitle("Cuenta creada - Account created");
                warning.setHeaderText("");
                warning.setContentText("Cuenta creada correctamente - Account created successfully");
                warning.showAndWait();
                compte.guardarDatos();
                App.setRoot("secondary");
            } else {
                Alert warning = new Alert(Alert.AlertType.WARNING);
                warning.setTitle("Atención - Warning");
                warning.setContentText("Las contraseñas no coinciden - Passwords do not match");
                warning.showAndWait();
            }
        }
    }
    
     /**

    Método que permite redirigir a la ventana de logout.
    @throws IOException si hay un error al cargar la vista "primary.fxml".
    */

    public void cancelar() throws IOException {
        App.setRoot("primary");
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
            user.setText("User");
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
            user.setText("Usuario");
        }

    }

}
