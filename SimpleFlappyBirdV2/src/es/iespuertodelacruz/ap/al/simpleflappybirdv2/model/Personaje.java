/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.model;

import javafx.scene.paint.Color;

/**
 *
 * @author dam
 */
public class Personaje {
    private Escenario escenario;
    Punto pos;
    Color color;
    
    
    /***
     * Constructor de personaje 
     * @param escenario
     * @param x posición x
     * @param y posición y
     */
    Personaje(Escenario escenario, double x, double y){
        this.escenario = escenario;
        this.pos = new Punto(x,y);
        this.color = Color.AQUA;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public Punto getPos() {
        return pos;
    }

    public void setPos(Punto pos) {
        this.pos = pos;
    }
    
    

    void spawn() {
        
    }

    public void jump() {
        
        this.pos.setY(this.pos.getY() - 60);
        

    }
}
