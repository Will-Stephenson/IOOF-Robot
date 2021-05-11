package com.stephenson_william.robot_movement;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /* int xPos = 0;
        int yPos = 0;

        Robot.Direction testDirection = Robot.Direction.NORTH;

        Robot testRobot = new Robot(xPos, yPos, testDirection);

        //System.out.println(testRobot.getDirection());
        testRobot.move();
        testRobot.rotate("RIGHT");

        //System.out.println(testRobot.getDirection());
        testRobot.move();

        testRobot.rotate("LEFT");

        testRobot.move();*/
        System.out.println("Please place the robot on the table");
        controlLoop();
    }

    public static void controlLoop(){
        Robot robot = new Robot();
        Scanner inputReader = new Scanner(System.in);
        boolean continueLoop = true;
        while(continueLoop){
            String input = inputReader.nextLine();
            String[] command = input.split(" "); // Divide up the input into an array separating
            switch (command[0]){
                case "PLACE":
                    // Ensure the user has entered the PLACE command with correctly formatted arguments
                    if (command.length == 2){
                        String[] args = command[1].split( ",");
                        robot.setPosition(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
                        robot.setDirection(Robot.Direction.valueOf(args[2]));
                    } else  {
                        System.out.println("PLACE must be followed by coordinates and a direction");
                        System.out.println("For example: PLACE 1,2,NORTH");
                    }

                    break;
                case "MOVE":
                    if (robot.getDirection() == null){
                        System.out.println("Please place the robot first");
                    } else {
                        robot.move();
                    }
                    break;
                case "REPORT":
                    if (robot.getDirection() == null){
                        System.out.println("Please place the robot first");
                    } else {
                        robot.report();
                    }
                    break;
                case "LEFT":
                    if (robot.getDirection() == null){
                        System.out.println("Please place the robot first");
                    } else {
                        robot.rotate("LEFT");
                    }
                    break;
                case "RIGHT":
                    if (robot.getDirection() == null){
                        System.out.println("Please place the robot first");
                    } else {
                        robot.rotate("RIGHT");
                    }
                    break;
                case "EXIT":
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

}
