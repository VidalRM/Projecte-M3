/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */

/**

    La clase cc representa una cuenta corriente y es una subclase de la clase compte.

    Contiene un ArrayList de tarjetas asociadas a la cuenta.
    */


public class cc extends compte {
    
    /**

    Crea una instancia de la clase cc con los atributos usuari, pwd y saldo.
    @param usuari El nombre de usuario de la cuenta.
    @param pwd La contraseña de la cuenta.
    @param saldo El saldo actual de la cuenta.
    */
    
    public cc(String usuari, String pwd, float saldo) {
        super(usuari, pwd, saldo);
    }
    
    /**

    ArrayList de tarjetas asociadas a la cuenta.
    */
    
    ArrayList <tarjeta> tarjetas = new ArrayList<tarjeta>();
    
}
