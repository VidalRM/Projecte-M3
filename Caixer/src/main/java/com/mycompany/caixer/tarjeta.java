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

    La clase "tarjeta" representa una tarjeta de crédito o débito con los siguientes atributos: número de tarjeta,

    fecha de caducidad y código CVV.
    */

public class tarjeta {
    long ntarjeta;
    String fechac;
    int cvv;
    
    /**

    Constructor de la clase "tarjeta".
    @param ntarjeta Número de la tarjeta.
    @param fechac Fecha de caducidad de la tarjeta.
    @param cvv Código de seguridad de la tarjeta.
    */

    public tarjeta(long ntarjeta, String fechac, int cvv) {
        this.ntarjeta = ntarjeta;
        this.fechac = fechac;
        this.cvv = cvv;
    }
    
}
