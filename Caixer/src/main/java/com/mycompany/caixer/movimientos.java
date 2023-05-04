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
    
    /**

    Carga los movimientos desde un archivo de texto y los almacena en la lista Mov.
    @throws FileNotFoundException si el archivo de movimientos no se encuentra en la ruta especificada.
    @throws IOException si ocurre un error al leer el archivo de movimientos.
    */
    
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
    
    /**

    Guarda los movimientos almacenados en la lista Mov en un archivo de texto.
    @throws IOException si ocurre un error al escribir en el archivo de movimientos.
    */
    
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
