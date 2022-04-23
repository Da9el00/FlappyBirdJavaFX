package com.example.flappybird;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ObstaclesHandler {

    private AnchorPane plane;
    private double planeHeight;
    private double planeWidth;
    Random random = new Random();

    public ObstaclesHandler(AnchorPane plane, double planeHeight, double planeWidth) {
        this.plane = plane;
        this.planeHeight = planeHeight;
        this.planeWidth = planeWidth;
    }

    public ArrayList<Rectangle> createObstacles(){

        int width = 25;
        double xPos = planeWidth;
        double space = 200;
        double recTopHeight = random.nextInt((int)(planeHeight - space - 100)) + 50;
        double recBottomHeight = planeHeight - space - recTopHeight;

        //                                     x      y   width   height
        Rectangle rectangleTop = new Rectangle(xPos,0,width,recTopHeight);
        Rectangle rectangleBottom = new Rectangle(xPos, recTopHeight + space, width, recBottomHeight);

        plane.getChildren().addAll(rectangleTop,rectangleBottom);
        return new ArrayList<>(Arrays.asList(rectangleTop,rectangleBottom));
    }


    public void moveObstacles(ArrayList<Rectangle> obstacles){

        ArrayList<Rectangle> outOfScreen = new ArrayList<>();

        for (Rectangle rectangle: obstacles) {
            moveRectangle(rectangle, - 0.75);

            if(rectangle.getX() <= -rectangle.getWidth()){
                outOfScreen.add(rectangle);
            }
        }
        obstacles.removeAll(outOfScreen);
        plane.getChildren().removeAll(outOfScreen);
    }

    private void moveRectangle(Rectangle rectangle, double amount){
        rectangle.setX(rectangle.getX() + amount);
    }
}
