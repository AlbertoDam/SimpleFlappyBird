/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.controller;

import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Escenario;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Personaje;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Punto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author dam
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnStart;
    @FXML
    private Button btnA;
    @FXML
    private Button btnB;
    @FXML
    private TextField txtCliks;
    @FXML
    private TextField txtScore;
    @FXML
    private Canvas canva;
    @FXML
    private GraphicsContext gc;
    
    private Escenario escenario ;

    private AnimationTimer miBucle;
    
    private final double posXPajaro = 0;
    private final double posYPajaro = 90.00;

    
    public void startGame(){
        this.gc = canva.getGraphicsContext2D();
        escenario = new Escenario(posXPajaro, posYPajaro);
        miBucle = new AnimationTimer(){
            @Override
            public void handle(long now) {
               moverJuego();
                   
            }
        };
        miBucle.start();
        
    }
    private void moverJuego() {
        //imprimo el pajaro
        
        Personaje pajaro = escenario.getPajaro();
        Punto posPajaro = pajaro.getPos();
        
        gc.clearRect(posPajaro.getX() -1, posPajaro.getY()-5, 51, 50);
        gc.setFill(Color.YELLOW);
        gc.fillOval(posPajaro.getX(), posPajaro.getY(), 50, 50);
        
        
        escenario.applyGravity();  
    }
    
    
    private void jump() {
        escenario.getPajaro().jump();

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(event -> startGame());
        btnA.setOnAction(event -> jump());

    }    
    
    public void pintarTube(){
        
    }

    
    
}
