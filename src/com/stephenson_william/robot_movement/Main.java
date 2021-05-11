package com.stephenson_william.robot_movement;

public class Main {
    public static void main(String[] args) {

        int xPos = 0;
        int yPos = 0;
        //int[][] testPosition = new int[5][5];
        //testPosition[yPos][xPos] = 1;

        Robot.Direction testDirection = Robot.Direction.NORTH;

        Robot testRobot = new Robot(xPos, yPos, testDirection);

        //System.out.println(testRobot.getDirection());
        testRobot.move();
        testRobot.rotate("RIGHT");

        //System.out.println(testRobot.getDirection());
        testRobot.move();

        testRobot.rotate("LEFT");

        testRobot.move();

    }
}
