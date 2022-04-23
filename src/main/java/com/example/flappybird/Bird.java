package com.example.flappybird;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Bird {

    private Rectangle bird;
    private int jumpHeight;
    CollisionHandler collisionHandler = new CollisionHandler();

    public Bird(Rectangle bird, int jumpHeight) {
        this.bird = bird;
        this.jumpHeight = jumpHeight;
    }

    public void fly(){
        double movement = -jumpHeight;
        if(bird.getLayoutY() + bird.getY() <= jumpHeight){
            movement = -(bird.getLayoutY() + bird.getY());
        }

        moveBirdY(movement);
    }

    public void moveBirdY(double positionChange){
        bird.setY(bird.getY() + positionChange);
    }

    public boolean isBirdDead(ArrayList<Rectangle> obstacles, AnchorPane plane){
        double birdY = bird.getLayoutY() + bird.getY();

        if(collisionHandler.collisionDetection(obstacles, bird)){
            return  true;
        }

        return birdY >= plane.getHeight();
    }
}
