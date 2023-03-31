/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.model;

/**
 *
 * @author dam
 */
public class Escenario {
    private Personaje pajaro;
    
    
    public Escenario(double x, double y){
        pajaro = new Personaje(this, x, y);
    }
    
    public Personaje getPajaro(){
        return this.pajaro;
    }

    
}
