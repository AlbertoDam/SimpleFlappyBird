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
    public void startGame(){
        Escenario escenario = new Escenario();
        escenario.pintarEscena(this.canvaPanel);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnStart.setOnAction(event -> startGame());
    }    
    
}
