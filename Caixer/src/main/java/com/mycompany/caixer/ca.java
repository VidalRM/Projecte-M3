/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

/**
 *
 * @author alumne
 */

/**

    La clase "ca" representa una cuenta de ahorros y extiende la clase "compte".

    Esta clase incluye un atributo "interes" que indica la tasa de interés de la cuenta de ahorros.

    @param interes la tasa de interés de la cuenta de ahorros

    @param usuari el nombre de usuario de la cuenta

    @param pwd la contraseña de la cuenta

    @param saldo el saldo de la cuenta
    */

public class ca extends compte {
    
    double interes;

    public ca(double interes, String usuari, String pwd, float saldo) {
        super(usuari, pwd, saldo);
        this.interes = interes;
    }
    
}
