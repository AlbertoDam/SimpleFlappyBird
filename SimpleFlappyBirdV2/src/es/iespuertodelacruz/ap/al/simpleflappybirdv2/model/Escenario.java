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
    private LinkedList<Tuberia> tuberias;
    private final int radioPers = 20;
    

        
    public Escenario(double x, double y){
        pajaro = new Personaje(this, radioPers, radioPers);
        tuberias = new LinkedList();
    }

    public int getRadioPers() {
        return radioPers;
    }
    
    
    public Personaje getPajaro(){
        return this.pajaro;
    }


    public LinkedList<Tuberia> getTuberias() {
        return tuberias;
    }
    
    public void spawnTube(double alto, double ancho){
        int width = 30;
        /*
            X=ancho,y=0                 X=ancho+width,y=0
        
        
            X=ancho,y=rnd(alto/3)       X=ancho+30,y=rnd(alto/3)
        
        */
        double y = Math.random()*100+(alto/3); // calculo altura de 0 a (alto/3)
        Tuberia tuberiaSup = new Tuberia(
                new Punto(ancho,0),
                new Punto(ancho+width,0),
                new Punto(ancho, y),
                new Punto(ancho+width,y)
        );
        
        tuberias.add(tuberiaSup);
        /*
            X=ancho,y=rnd(alto/3)               X=ancho+width,y=rnd(alto/3)
        
        
            X=ancho,y=alto                      X=ancho+30,y=alto
        
        */
        /*y = Math.random()*100+(alto/3);// vuelvo a calcular la altura de 0 a (alto/3) para que sea distinto
        Tuberia tuberiaInf = new Tuberia(
                new Punto(ancho,y),
                new Punto(ancho+width,y),
                new Punto(ancho,alto),
                new Punto(ancho,alto)
        );*/
        
        //tuberias.add(tuberiaInf);
    }
    
    public void moveTube(){
        
    }

    public void applyGravity() {
        
//        double x = this.pajaro.pos.getX();

       this.pajaro.pos.setY( this.pajaro.pos.getY() + 1 );
       

    }
    
}
