/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.controller;

import es.iespuertodelacruz.ap.flappybird.model.Escenario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
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
    
    private Escenario escenario;
    
    
    
    
    @FXML
    public void startGame(){
        this.escenario = new Escenario();
        this.escenario.pintarEscena(this.canvaPanel);
        this.escenario.setAltura(canvaPanel.getHeight());
        this.escenario.setAncho(canvaPanel.getWidth());
    }
    
    @FXML
    public void fly(){
        this.escenario.fly();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(event -> startGame());
        btnPlay.setOnAction(event -> fly());
    }    
    
}
