/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author aperp
 */
public class Personaje {
    private Circle circle;
    private Punto coordenada;

    
    Personaje(int radio, double x, double y){
        coordenada = new Punto();
        this.circle = new Circle();
        this.circle.setRadius(radio);
        this.circle.setFill(Color.BEIGE);
        this.coordenada.setX(x);
        this.coordenada.setY(y);
        
    }
    
    
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Punto getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Punto coordenada) {
        this.coordenada = coordenada;
    }
    
    
}
