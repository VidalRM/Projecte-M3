/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author alumne
 */
public class logged {
    
    @FXML
    Label logoutext;
    
    Font font = Font.font("System", 20);
    Font font2 = Font.font("System", 24);
      
    @FXML
    public void logout() throws IOException{
        App.setRoot("primary");
        
    }
    
    @FXML
    public void ingles(){
        logoutext.setText("Logout");
        logoutext.setFont(font2);
    }
    
    @FXML
    public void espanol(){
        logoutext.setText("Cerrar sesión     ");
        logoutext.setFont(font);
    }
}
