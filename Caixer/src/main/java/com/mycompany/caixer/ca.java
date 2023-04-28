/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

/**
 *
 * @author alumne
 */
public class ca extends compte {
    
    double interes;

    public ca(double interes, String usuari, String pwd, float saldo) {
        super(usuari, pwd, saldo);
        this.interes = interes;
    }
    
}
