/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.controller;

import es.iespuertodelacruz.ap.flappybird.model.Escenario;
import es.iespuertodelacruz.ap.flappybird.model.Scores;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author aperp
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane paneCont;
    @FXML
    private Canvas canvaPanel;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnPlay;
    @FXML
    private TextField txtCliks;
    @FXML
    private TextField txtScore;
    @FXML
    private TextField txtTime;
    
    private Escenario escenario;
    private Scores score;
    
    
    
    
    @FXML
    public void startGame(){
        this.escenario = new Escenario();
        this.escenario.pintarEscena(this.canvaPanel);
        this.score = new Scores();    
    }
    
    @FXML
    public void fly(){
        this.escenario.fly();
        this.score.setCliks(this.score.getCliks() + 1);
        this.txtCliks.setText("Clicks --> " + this.score.getCliks());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(event -> startGame());
        btnPlay.setOnAction(event -> fly());
        
    }    
    
}
