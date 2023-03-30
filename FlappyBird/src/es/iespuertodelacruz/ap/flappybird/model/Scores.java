/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iespuertodelacruz.ap.flappybird.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 *
 * @author aperp
 */
public class Scores {

    private int cliks;
    private double score;

    public int getCliks() {
        return cliks;
    }

    public void setCliks(int cliks) {
        this.cliks = cliks;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public String createMsg() {
        return "Su puntuacion es: " + this.score + "\n"
                + "Ha hecho un total de " + this.cliks + " cliks "
                ;
    }

}
