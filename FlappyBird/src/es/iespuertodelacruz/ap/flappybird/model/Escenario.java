/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

/**
 *
 * @author aperp
 */
public class Escenario {

    private Personaje pajaro;
    private Circle pajaroPintado;
    private List<Tuberia> tuberia;
    private GraphicsContext lienzo;

    public void pintarEscena(Canvas panelJuego) {
        pajaro = new Personaje(50, 70, 80);
        this.lienzo = panelJuego.getGraphicsContext2D();

        Circle circle = this.pajaro.getCircle();
        circle.setLayoutX(this.pajaro.getCoordenada().getX());
        circle.setLayoutY(this.pajaro.getCoordenada().getY());

        this.lienzo.setFill(circle.getFill()); //pinto un circulo con el color de mi circulo
        this.lienzo.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); //establezco la posicion del circulo con las pos de mi circulo

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
        circle.setLayoutY(circle.getLayoutY() + 2); // Muevo el personaje hacia abajo en el eje Y
        circle.setLayoutX(circle.getLayoutX() - 0.28); // Muevo el personaje hacia IZQUIERDA en el eje X
        
        this.lienzo.clearRect(0, 0, this.lienzo.getCanvas().getWidth(), this.lienzo.getCanvas().getHeight()); //limpio el lienzo
        this.lienzo.setFill(circle.getFill()); // Establezco el color de relleno del círculo
        this.lienzo.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); // Pinto el círculo en la nueva posición

    }

    public void fly() {
        Circle circle = this.pajaro.getCircle();
        circle.setLayoutY(circle.getLayoutY() - 45); // Muevo el personaje hacia ARRIBA en el eje Y
        circle.setLayoutX(circle.getLayoutX() + 7); // Muevo el personaje hacia DERECHA en el eje X
        
        this.lienzo.clearRect(0, 0, this.lienzo.getCanvas().getWidth(), this.lienzo.getCanvas().getHeight()); //limpio el lienzo
        this.lienzo.setFill(circle.getFill()); // Establezco el color de relleno del círculo
        this.lienzo.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius());
    }

    private double altura;
    
    public double getAltura(){
        return this.altura;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
}
