/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author angel_luis
 * 
 */
public class Tuberia {
    private Rectangle tubo;
    private Punto pos;
    
    public Tuberia(double altura,double ancho){
        pos = new Punto();
        pos.setX(ancho);
        tubo = new Rectangle(40,Math.random()* (altura/3) + 100, Color.GREEN );
        pos.setY(altura);
    }

    public Rectangle getTubo() {
        return tubo;
    }

    public void setTubo(Rectangle tubo) {
        this.tubo = tubo;
    }

    public double getPosX() {
        return pos.getX();
    }

    public void setPosX(double x) {
        this.pos.setX(x);
    }
    
    public double getPosY() {
        return pos.getY();
    }

    public void setPosY(double y) {
        this.pos.setY(y);
    }
    
}
