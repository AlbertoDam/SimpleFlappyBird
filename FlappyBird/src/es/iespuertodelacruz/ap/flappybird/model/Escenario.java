/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;

import java.util.LinkedList;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author aperp
 */
public class Escenario {

    private Personaje pajaro;
    private Circle pajaroPintado;
    private LinkedList<Tuberia> tuberias;
    private GraphicsContext lienzoPajaros;
    private GraphicsContext lienzoTuberia;

    public void pintarEscena(Canvas panelJuego) {
        pajaro = new Personaje(50, 70, 80);
        this.lienzoPajaros = panelJuego.getGraphicsContext2D();
        this.lienzoTuberia = panelJuego.getGraphicsContext2D();
        
        Circle circle = this.pajaro.getCircle();
        circle.setLayoutX(this.pajaro.getCoordenada().getX());
        circle.setLayoutY(this.pajaro.getCoordenada().getY());

        this.lienzoPajaros.setFill(circle.getFill()); //pinto un circulo con el color de mi circulo
        this.lienzoPajaros.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); //establezco la posicion del circulo con las pos de mi circulo
        
        Tuberia tuberiaA = spawnTube();
        Rectangle tubo = tuberiaA.getTubo();
        
        tubo.setLayoutX(tuberiaA.getPosX());
        tubo.setLayoutY(tuberiaA.getPosY());

        this.lienzoTuberia.setFill(tubo.getFill()); 
        this.lienzoTuberia.fillRect(tubo.getLayoutX(), tubo.getLayoutY(), tubo.getWidth(), tubo.getHeight());
        
        Tuberia tuberiaB = spawnTube();
        Rectangle segundoTubo = tuberiaB.getTubo();
        
        segundoTubo.setLayoutX(tuberiaB.getPosX());
        segundoTubo.setLayoutY(tuberiaB.getPosY());

        this.lienzoTuberia.setFill(segundoTubo.getFill());
        this.lienzoTuberia.fillRect(segundoTubo.getLayoutX(), segundoTubo.getLayoutY(), segundoTubo.getWidth(), segundoTubo.getHeight());
    
        moveTube();
        
        AnimationTimer bucleJuego = new AnimationTimer() {
            @Override
            public void handle(long l) {
                applyGravity();
            }
        };
        bucleJuego.start();
    }

    private void applyGravity() {
        Circle circle = this.pajaro.getCircle();
        
        this.lienzoPajaros.clearRect(circle.getLayoutX(), circle.getLayoutY()-2, this.lienzoPajaros.getCanvas().getWidth(), this.lienzoPajaros.getCanvas().getHeight()); //limpio el lienzo
        
        circle.setLayoutY(circle.getLayoutY() + 2); // Muevo el personaje hacia abajo en el eje Y
        circle.setLayoutX(circle.getLayoutX() - 0.28); // Muevo el personaje hacia IZQUIERDA en el eje X
        
        
        this.lienzoPajaros.setFill(circle.getFill()); // Establezco el color de relleno del círculo
        this.lienzoPajaros.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); // Pinto el círculo en la nueva posición

    }

    public void fly() {
        Circle circle = this.pajaro.getCircle();
        
        this.lienzoPajaros.clearRect(circle.getLayoutX(), circle.getLayoutY()-2, this.lienzoPajaros.getCanvas().getWidth(), this.lienzoPajaros.getCanvas().getHeight()); //limpio el lienzo
        
        circle.setLayoutY(circle.getLayoutY() - 45); // Muevo el personaje hacia ARRIBA en el eje Y
        circle.setLayoutX(circle.getLayoutX() + 7); // Muevo el personaje hacia DERECHA en el eje X
        
        
        this.lienzoPajaros.setFill(circle.getFill()); // Establezco el color de relleno del círculo
        this.lienzoPajaros.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius());
    }

    private double altura;
    
    public double getAltura(){
        return this.altura;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    private double ancho;
    
    public double getAncho(){
        return this.ancho;
    }
    
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    
    private final double SPACING;
    
    public Escenario() {
        this.SPACING = (ancho/8);
    }
 
    public Tuberia spawnTube(){
        Tuberia tuberia = new Tuberia(getAltura(),getAncho());
        if(tuberias == null){
            tuberias = new LinkedList();
        }
        tuberias.add(tuberia);
        return tuberia;
    }
    
    public void moveTube(){
        /*
            deberia funcionar pero no lo hace y no se porque
        
            falta limpiar pero eso luego de que funcione
        */
        for (Tuberia tuberia : tuberias) {
            tuberia.setPosX(tuberia.getPosX()-5);
            
            Rectangle tubo = tuberia.getTubo();

            tubo.setLayoutX(tuberia.getPosX());
            tubo.setLayoutY(tuberia.getPosY());

            this.lienzoTuberia.setFill(tubo.getFill()); 
            this.lienzoTuberia.fillRect(tubo.getLayoutX(), tubo.getLayoutY(), tubo.getWidth(), tubo.getHeight());
            
        }
    }
    
}
