/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caixer;

import static com.mycompany.caixer.compte.CUENTAS;
import static com.mycompany.caixer.compte.Cuentas;
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
public class movimientos {
    public String usuario;
    public String tipoMov;
    public float saldo;
    
    public static final String MOVS = "/home/alumne/NetBeansProjects/Caixer/src/main/java/com/mycompany/caixer/MOVS.csv";
    public static ArrayList<movimientos> Mov = new ArrayList<movimientos>();
    private static final String DELIMITADOR = ",";

    public movimientos(String usuario, String tipoMov, float saldo) {
        this.usuario = usuario;
        this.tipoMov = tipoMov;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public static void cargarMovs(){
        try (BufferedReader reader = new BufferedReader(new FileReader (MOVS))){
            String linea;
            while ((linea = reader.readLine()) != null){
                String[] sep = linea.split(DELIMITADOR);
                float saldo = Float.parseFloat(sep[2]);
                movimientos movimiento = new movimientos(sep[0], sep[1], saldo);
                Mov.add(movimiento);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("ERROR");
        }
                
    }
    
    public static void guardarMovs(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(MOVS));
            for (movimientos movimientos : Mov) {
                writer.write(String.valueOf(movimientos.getUsuario()));
                writer.write(",");
                writer.write(String.valueOf(movimientos.getTipoMov()));
                writer.write(",");
                writer.write(String.valueOf(movimientos.getSaldo()));
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
