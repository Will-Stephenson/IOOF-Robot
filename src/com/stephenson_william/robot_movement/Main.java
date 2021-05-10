package com.stephenson_william.robot_movement;

public class Main {
    public static void main(String[] args) {

        int xPos = 1;
        int yPos = 4;
        int[][] testPosition = new int[5][5];
        testPosition[xPos][yPos] = 1;

        Robot.Direction testDirection = Robot.Direction.NORTH;

        Robot testRobot = new Robot(testPosition, testDirection);

        System.out.println(testRobot.getDirection());

        testRobot.rotate("LEFT");

        System.out.println(testRobot.getDirection());

        testRobot.rotate("RIGHT");

        System.out.println(testRobot.getDirection());

    }
}
