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
    
    private Partida scores;
    private Personaje pajaro;
    private LinkedList<Tuberia> tuberias;
    private final int radioPers = 20;

    /**
     * *
     * Constructor de escenario, instancia un nuevo Personaje
     *
     * @param x punto en la x
     * @param y punto en la y
     */
    public Escenario(double x, double y, Partida scores) {
        pajaro = new Personaje(this, x, y);
        tuberias = new LinkedList();
        this.scores = scores;
    }

    /**
     * *
     * @return Radio del personaje;
     */
    public int getRadioPers() {
        return radioPers;
    }
    
    public Personaje getPajaro() {
        return this.pajaro;
    }
    
    public LinkedList<Tuberia> getTuberias() {
        return tuberias;
    }
    
    public void spawnTube(double alto, double ancho) {
        int width = 30;
        /*
            X=ancho,y=0                 X=ancho+width,y=0
        
        
            X=ancho,y=rnd(alto/3)       X=ancho+30,y=rnd(alto/3)
        
         */
        double y = Math.random() * 100 + (alto / 3); // calculo altura de 0 a (alto/3)
        Tuberia tuberiaSup = new Tuberia(
                new Punto(ancho, 0),
                new Punto(ancho + width, 0),
                new Punto(ancho, y),
                new Punto(ancho + width, y)
        );
        
        tuberias.add(tuberiaSup);
        /*
            X=ancho,y=rnd(alto/3)               X=ancho+width,y=rnd(alto/3)
        
        
            X=ancho,y=alto                      X=ancho+30,y=alto
        
         */
        y = Math.random() * 100 + (alto / 3);// vuelvo a calcular la altura de 0 a (alto/3) para que sea distinto
        Tuberia tuberiaInf = new Tuberia(
                new Punto(ancho, y),
                new Punto(ancho + width, y),
                new Punto(ancho, alto),
                new Punto(ancho, alto)
        );
        
        tuberias.add(tuberiaInf);
    }
    
    public void moveTube() {
        
    }
    
    private boolean isColision() {          //ELIMINAR EL PRIMER IF ESTA PUESTO PORQUE NO HAY TUBERIAS
        boolean response = false;
        if (!this.tuberias.isEmpty()) {
            if (this.pajaro.pos.getY() + 1 > this.tuberias.get(0).getLimInfIzq().getY()     //tuberia de arriba en pos pares y cero
                    && this.pajaro.pos.getY() + 1 > this.tuberias.get(1).getLimSupIzq().getY()) {
                response = true;
            } else {
//                if (this.scores.getCliks() < 10) {
//                    this.scores.setScore(15);
//                } else {
//                    this.scores.setScore(20);
//                }
                
            }
        }
        
        return response;
    }

    /**
     * Método que modifica la posición del personaje simulando la gravedad
     * siempre y cuando la posición a la que se vaya a mover el pajaro sea mayor
     * al limite sup de la tuberia
     */
    public boolean applyGravity() {
        boolean response = false;
        if (!isColision()) {
            this.pajaro.pos.setY(this.pajaro.pos.getY() + 1);
            response = true;
        } else {
            this.pajaro.pos.setX(this.pajaro.pos.getX() + 1000);        //se hace desaparecer el pajaro en caso de colision
            this.pajaro.pos.setY(this.pajaro.pos.getY() + 1000);
        }
        return response;
    }
    
}
