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
import javafx.event.ActionEvent;
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
    private boolean isActive;

    private Partida scores;

    private final double posXPajaro = 0;
    private final double posYPajaro = 90.00;
    
    int contador;
    int aux;

    /***
     * Método que inicia el bucle del juego,
     * inicializa el escenario y la partida
     */
    @FXML
    public void startGame() {
        this.isActive = true;
        this.scores = new Partida();
        this.gc = canva.getGraphicsContext2D();
        escenario = new Escenario(posXPajaro, posYPajaro, scores);
        miBucle = new AnimationTimer() {
            @Override
            public void handle(long now) {
                boolean moverJuego = moverJuego();
                if (!moverJuego) {
                    miBucle.stop();
                }
            }
        };
        miBucle.start();

    }

    /***
     * Método que obtiene el pajaro y lo pinta
     * por otro lado llama a la función applyGravity
     * 
     */
    private boolean moverJuego() {
        Personaje pajaro = escenario.getPajaro();
        Punto posPajaro = pajaro.getPos();

        gc.clearRect(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());
        escenario.applyGravity();
        
        LinkedList<Tuberia> tuberias = escenario.getTuberias();
        if(tuberias==null || contador==45){
            escenario.spawnTube(this.canva.getHeight(), this.canva.getWidth());
            contador = 0;
        }
        
        contador++;
        for (Tuberia tuberia : tuberias) {
            if(aux%2==0){
                gc.clearRect(
                        tuberia.getLimInfIzq().getX(), 
                        0, 
                        50,
                        tuberia.getLimSupIzq().getY()
                );
            }else{
                gc.clearRect(
                        tuberia.getLimInfIzq().getX(), 
                        tuberia.getLimSupIzq().getY(), 
                        50,
                        //tuberia.getLimSupIzq().getY()
                        this.canva.getHeight()  
                );
            }
            aux++;
        }
        

        
        pintarTubo(); 

        gc.setFill(pajaro.getColor());
        gc.fillOval(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());

        return escenario.applyGravity();
    }

    /***
     * Método que modifica la posición Y del pájaro 
     * para simular un efecto de vuelo
     */
    @FXML
    private void jump() {
        if (this.isActive) {
            updateScores();
            Personaje pajaro = escenario.getPajaro();
            Punto posPajaro = pajaro.getPos();
            gc.clearRect(posPajaro.getX(), posPajaro.getY(), escenario.getRadioPers(), escenario.getRadioPers());
            escenario.getPajaro().jump();
        } else {
            System.out.println("JUEGO PAUSADO");
        }

    }
    
    /***
     * Método que actualiza las puntuaciones del usuario
     */
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
        contador = 0;
        aux = 0;
    }    
    
    private void pintarTubo(){
        LinkedList<Tuberia> tuberias = escenario.getTuberias();
        int aux = 0;
        
        //gc.fillRect(600,0,60,150);
        //gc.fillRect(600,300,60,150);
        
        for (Tuberia tuberia : tuberias) {
            tuberia.res(5);
            gc.setFill(Color.GREEN);
            if(aux%2==0){
                gc.fillRect(
                        tuberia.getLimInfIzq().getX(), 
                        0, 
                        50,
                        tuberia.getLimSupIzq().getY()
                );
            }else{
                gc.fillRect(
                        tuberia.getLimInfIzq().getX(), 
                        tuberia.getLimSupIzq().getY(), 
                        50,
                        this.canva.getHeight()
                );
            }
            
            aux++;
        }
    }

    /***
     * Método que para el juego
     */
    @FXML
    private void stopGame() {
        if (miBucle != null) {
            if (isActive) {
                miBucle.stop();
                isActive = false;
            } else {
                miBucle.start();
                isActive = true;
            }
        }

    }

}
