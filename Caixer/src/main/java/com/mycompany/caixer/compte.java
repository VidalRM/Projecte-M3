/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class compte {
    
    public static final String CUENTAS = "/home/alumne/NetBeansProjects/Caixer/src/main/java/com/mycompany/caixer/cuentas.csv";
    public static ArrayList<compte> Cuentas = new ArrayList<compte>();
    private static final String DELIMITADOR = ",";
    
    public String usuari;
    public String pwd;
    public float saldo;

    public compte(String usuari, String pwd, float saldo) {
        this.usuari = usuari;
        this.pwd = pwd;
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }   

    
    public static void cargarDatos(){
        try (BufferedReader reader = new BufferedReader(new FileReader (CUENTAS))){
            String linea;
            while ((linea = reader.readLine()) != null){
                String[] sep = linea.split(DELIMITADOR);
                float saldo = Float.parseFloat(sep[2]);
                compte cuenta = new compte(sep[0], sep[1], saldo);
                Cuentas.add(cuenta);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("ERROR");
        }
                
    }
    
    public static void guardarDatos(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(CUENTAS));
            for (compte compte : Cuentas) {
                writer.write(String.valueOf(compte.getUsuari()));
                writer.write(",");
                writer.write(String.valueOf(compte.getPwd()));
                writer.write(",");
                writer.write(String.valueOf(compte.getSaldo()));
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e){
                  e.printStackTrace();  
                }
            }
        }
    }
    

}
