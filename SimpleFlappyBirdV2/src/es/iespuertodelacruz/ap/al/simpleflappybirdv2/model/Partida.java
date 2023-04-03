/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.model;

/**
 *
 * @author dam
 */
public class Partida {
    private int cliks;
    private double score;
    
    
    /***
     * Constructor de Partida
     */
    public Partida(){
        this.cliks = 1;
        this.score = 0;
    }
    
    /***
     * Método que actualiza los cliks 
     * que ha dado el usuario
     */
    public void updateClick(){
        this.cliks++;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    

    public int getCliks() {
        return cliks;
    }
    
    
}
