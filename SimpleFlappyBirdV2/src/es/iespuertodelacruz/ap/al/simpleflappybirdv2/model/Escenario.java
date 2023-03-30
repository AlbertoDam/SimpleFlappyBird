/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.model;

import java.util.LinkedList;

/**
 *
 * @author dam
 */
public class Escenario {
    
    private LinkedList<Tuberia> tuberias;
    private Personaje pajaro;
    
    public Escenario(){
        pajaro = new Personaje();
        tuberias = new LinkedList();
    }
    
    public void spawnTube(double alto, double ancho){
        // izq x = ancho; der x = x + 30;
        // width 30; altura variable con rnd;
        // izq y = Math.random()*100+(alto/3); der y = y + 30;
        int width = 30;
        Tuberia tuberiaSup = new Tuberia(new Punto(ancho,0),new Punto(ancho+width,0),new Punto(ancho, Math.random()*100+(alto/3)),new Punto(ancho+width,Math.random()*100+(alto/3)));
        //Tuberia tuberiaInf = new Tuberia(new Punto(ancho,alto),new Punto(ancho+width,alto+width),null,null);
        
        tuberias.add(null);
    }
    
}
