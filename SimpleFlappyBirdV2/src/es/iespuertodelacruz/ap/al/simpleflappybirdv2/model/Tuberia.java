/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.model;

/**
 *
 * @author dam
 */
public class Tuberia {
    
    private Punto limInfIzq;
    private Punto limInfDer;
    private Punto limSupDer;
    private Punto limSupIzq;

    public Tuberia(Punto limInfIzq, Punto limInfDer, Punto limSupDer, Punto limSupIzq) {
        this.limInfIzq = limInfIzq;
        this.limInfDer = limInfDer;
        this.limSupDer = limSupDer;
        this.limSupIzq = limSupIzq;
    }
    
    public Punto getLimInfIzq() {
        return limInfIzq;
    }

    public void setLimInfIzq(Punto limInfIzq) {
        this.limInfIzq = limInfIzq;
    }

    public Punto getLimInfDer() {
        return limInfDer;
    }

    public void setLimInfDer(Punto limInfDer) {
        this.limInfDer = limInfDer;
    }

    public Punto getLimSupDer() {
        return limSupDer;
    }

    public void setLimSupDer(Punto limSupDer) {
        this.limSupDer = limSupDer;
    }

    public Punto getLimSupIzq() {
        return limSupIzq;
    }

    public void setLimSupIzq(Punto limSupIzq) {
        this.limSupIzq = limSupIzq;
    }
    
    public void res(double valor){
        Punto aux = new Punto((-1*valor),0);
        this.limInfIzq.sumar(aux);
        this.limInfDer.sumar(aux);

    }
    
}
