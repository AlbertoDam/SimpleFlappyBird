/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;


/**
 *
 * @author angel_luis
 */
public class Tuberia {
    double bordeArr;
    double bordeAbj;
    
    public Tuberia(double altura){
        bordeArr = Math.random()*(altura - (altura-(altura/4)) + (altura/4)) ;
        bordeAbj = bordeArr - (altura/4);// revisar porque puede estar mal (y lo hace hacia abajo y no hacia arriba)
    }

    public double getBordeArr() {
        return bordeArr;
    }

    public void setBordeArr(double bordeArr) {
        this.bordeArr = bordeArr;
    }

    public double getBordeAbj() {
        return bordeAbj;
    }

    public void setBordeAbj(double bordeAbj) {
        this.bordeAbj = bordeAbj;
    }
    
}
