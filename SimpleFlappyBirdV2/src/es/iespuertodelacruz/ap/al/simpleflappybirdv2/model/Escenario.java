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
        
        
            X=ancho,y=rnd()*100+(alto/5)       X=ancho+30,y=rnd()*100+(alto/5)
         */

        double y = Math.random() * 100 + (alto / 5); // calculo altura de 0 a (alto/3)
        Tuberia tuberiaSup = new Tuberia(
                new Punto(ancho, y),
                new Punto(ancho + width, y),
                new Punto(ancho, 0),
                new Punto(ancho + width, 0)
        );

        tuberias.add(tuberiaSup);
        /*
            X=ancho,y= y + 79     X=ancho+width,y= y + 79 
        
        
            X=ancho,y=alto        X=ancho+width,y=alto
        

         */
        y += 160;
        Tuberia tuberiaInf = new Tuberia(
                new Punto(ancho, y),
                new Punto(ancho + width, y),
                new Punto(ancho, alto),
                new Punto(ancho + width, alto)
        );

        tuberias.add(tuberiaInf);
    }

    public void moveTube() {

    }

    public boolean isColision() {
        boolean response = false;
        if (this.tuberias.size() >= 2) {
            double birdRadius = this.getRadioPers();
            double birdX = this.pajaro.getPos().getX() + birdRadius;
            double birdY = this.pajaro.getPos().getY() + birdRadius;
            for (int i = 0; i < this.tuberias.size(); i++) {
                Tuberia tuberia = this.tuberias.get(i);
                double inferX1 = tuberia.getLimSupIzq().getX() + 0.45;
                double inferX2 = tuberia.getLimSupDer().getX() - 0.45;
                double inferY1 = tuberia.getLimSupIzq().getY() + 0.45;
                double inferY2 = tuberia.getLimInfIzq().getY() + birdRadius;
                double supX1 = tuberia.getLimInfIzq().getX() - 0.45;
                double supX2 = tuberia.getLimInfDer().getX() + 0.45;
                double supY1 = tuberia.getLimSupDer().getY() + birdRadius;
                double supY2 = tuberia.getLimInfDer().getY() + 0.45;

                if (birdX + birdRadius > inferX1 && birdX - birdRadius < inferX2 && birdY + birdRadius > inferY1 && birdY - birdRadius < inferY2) {
                    response = true;
                    System.out.println("HAY COLISION CON TUBERIA DE ABAJO");
                    break;
                }

                this.scores.updateScore(0.01);

                if (birdX > supX1 && birdX < supX2 && birdY > inferY2 && birdY < supY1) {
                    response = true;
                    System.out.println("HAY COLISION ARRIBA");
                    break;
                }

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
//        if (!isColision()) {
        this.pajaro.pos.setY(this.pajaro.pos.getY() + 0.5);
        response = true;
//        } else {
//            this.pajaro.pos.setX(this.pajaro.pos.getX() + 1000);        //se hace desaparecer el pajaro en caso de colision
//            this.pajaro.pos.setY(this.pajaro.pos.getY() + 1000);
//        }
        return response;
    }

}
