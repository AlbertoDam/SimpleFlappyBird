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

    public void pintarEscena(Canvas panelJuego) {
        pajaro = new Personaje(50, 0, 80);
        GraphicsContext tamLienzo = panelJuego.getGraphicsContext2D();

        Circle circle = this.pajaro.getCircle();
        circle.setLayoutX(this.pajaro.getCoordenada().getX());
        circle.setLayoutY(this.pajaro.getCoordenada().getY());

        tamLienzo.setFill(circle.getFill()); //pinto un circulo con el color de mi circulo
        tamLienzo.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); //establezco la posicion del circulo con las pos de mi circulo

        AnimationTimer bucleJuego = new AnimationTimer() {
            @Override
            public void handle(long l) {
                applyGravity(tamLienzo);
            }
        };
        bucleJuego.start();

    }

    private void applyGravity(GraphicsContext tamLienzo) {
        Circle circle = this.pajaro.getCircle();
        circle.setLayoutY(circle.getLayoutY() + 1); // Muevo el personaje hacia abajo en el eje Y
        
        tamLienzo.clearRect(0, 0, tamLienzo.getCanvas().getWidth(), tamLienzo.getCanvas().getHeight()); //limpio el lienzo
        tamLienzo.setFill(circle.getFill()); // Establezco el color de relleno del círculo
        tamLienzo.fillOval(circle.getLayoutX(), circle.getLayoutY(), circle.getRadius(), circle.getRadius()); // Pinto el círculo en la nueva posición

    }

}
