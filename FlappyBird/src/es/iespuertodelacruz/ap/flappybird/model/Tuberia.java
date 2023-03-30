/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;


/**
 *
 * @author angel_luis
 * 
 */
public class Tuberia {
    private double limSupIzq;
    private double limSupDer;
    private double limInfIzq;
    private double limInfDer;

    public Tuberia(double limSupIzq, double limSupDer, double limInfIzq, double limInfDer) {
        this.limSupIzq = limSupIzq;
        this.limSupDer = limSupDer;
        this.limInfIzq = limInfIzq;
        this.limInfDer = limInfDer;
    }

    public double getLimSupIzq() {
        return limSupIzq;
    }

    public void setLimSupIzq(double limSupIzq) {
        this.limSupIzq = limSupIzq;
    }

    public double getLimSupDer() {
        return limSupDer;
    }

    public void setLimSupDer(double limSupDer) {
        this.limSupDer = limSupDer;
    }

    public double getLimInfIzq() {
        return limInfIzq;
    }

    public void setLimInfIzq(double limInfIzq) {
        this.limInfIzq = limInfIzq;
    }

    public double getLimInfDer() {
        return limInfDer;
    }

    public void setLimInfDer(double limInfDer) {
        this.limInfDer = limInfDer;
    }
    
    public void sum(double valor){
        this.limSupIzq += valor;
        this.limSupDer += valor;
        this.limInfIzq += valor;
        this.limInfDer += valor;
    }
    
    public void res(double valor){
        this.limSupIzq -= valor;
        this.limSupDer -= valor;
        this.limInfIzq -= valor;
        this.limInfDer -= valor;
    }
    
}
