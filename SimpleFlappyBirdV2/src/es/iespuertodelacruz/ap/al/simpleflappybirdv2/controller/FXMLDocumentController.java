/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.iespuertodelacruz.ap.al.simpleflappybirdv2.controller;

import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Escenario;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Partida;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Personaje;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Punto;
import es.iespuertodelacruz.ap.al.simpleflappybirdv2.model.Tuberia;
import java.net.URL;
import java.util.LinkedList;
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
    private GraphicsContext gc;

    private Escenario escenario;

    private AnimationTimer miBucle;

    private Partida scores;

    private final double posXPajaro = 0;
    private final double posYPajaro = 90.00;

    @FXML
    public void startGame() {
        this.scores = new Partida();
        this.gc = canva.getGraphicsContext2D();
        escenario = new Escenario(posXPajaro, posYPajaro);
        miBucle = new AnimationTimer() {
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

        gc.clearRect(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());
        gc.setFill(Color.YELLOW);

        gc.fillOval(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());

        escenario.applyGravity();
        
        escenario.spawnTube(this.canva.getHeight(), this.canva.getWidth());
        LinkedList<Tuberia> tuberias = escenario.getTuberias();
        for (Tuberia tuberia : tuberias) {
            gc.clearRect(
                    tuberia.getLimInfIzq().getX(), 
                    tuberia.getLimSupIzq().getY(), 
                    50, 
                    50
            );
        }
        
        pintarTubo();
    }

    @FXML
    private void jump() {
        updateScores();
        Personaje pajaro = escenario.getPajaro();
        Punto posPajaro = pajaro.getPos();
        gc.clearRect(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());
        escenario.getPajaro().jump();

    }

    private void updateScores() {
        int cliks = this.scores.getCliks();
        this.txtCliks.setText("" + cliks);
        this.scores.updateClick();

        double score = this.scores.getScore();
        this.txtScore.setText("Puntuación: en desarrollo..." + score);
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(event -> startGame());
    }    
    
    private void pintarTubo(){
        LinkedList<Tuberia> tuberias = escenario.getTuberias();
        
        for (Tuberia tuberia : tuberias) {
            tuberia.res(5);
            gc.setFill(Color.GREEN);
            gc.fillRect(
                    tuberia.getLimInfIzq().getX(), 
                    tuberia.getLimSupIzq().getY(), 
                    50, 
                    50
            );
        }
    }

}
