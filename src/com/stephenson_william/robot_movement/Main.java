package com.stephenson_william.robot_movement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please place the robot on the table");
        // If the application is run without any arguments, begin in manual control mode
        if (args.length == 0){
            controlLoop();
        } else {
            ArrayList<String> inputList = new ArrayList<>();
            try{
                File inputFile = new File(args[0]);
                Scanner fileReader = new Scanner(inputFile);
                while (fileReader.hasNextLine()) {
                    inputList.add(fileReader.nextLine());
                }
                autoLoop(inputList);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }

    /**
     * Runs the program automatically from file input
     * @param input an ArrayList of each command from the file
     */
    public static void autoLoop(ArrayList<String> input){
        Robot robot = new Robot();
        for(String i: input){
            parseInput(robot, i);
        }
    }

    /**
     * Runs the program and accepts direct user input
     */
    private static void controlLoop(){
        Robot robot = new Robot();
        Scanner inputReader = new Scanner(System.in);
        boolean continueLoop = true;
        while(continueLoop){
            String input = inputReader.nextLine();
            continueLoop = parseInput(robot, input);
        }
    }

    /**
     * Parses and executes each command on a specified robot
     * @param robot the robot which the command will affect
     * @param input the command to be parsed and executes
     * @return the boolean which determines if the control loops terminate
     */
    private static boolean parseInput(Robot robot, String input) {
        String[] command = input.split(" "); // Divides up the input into an array, separating the command from the arguments
        boolean continueLoop = true;
        switch (command[0]){
            case "PLACE":
                // Attempts to divide up the arguments into another array
                // This will also catch cases where the arguments are provided in the wrong order
                // If it is successful it will set the initial position and direction of the robot
                try{
                    String[] commandArgs = command[1].split( ",");
                    // Only set the direction if the robot is placed in a valid position
                    // This prevents the robot being initialised with 0,0 for its position
                    if(robot.setPosition(Integer.parseInt(commandArgs[0]),Integer.parseInt(commandArgs[1]))){
                        robot.setDirection(Robot.Direction.valueOf(commandArgs[2]));
                    } else {
                        System.out.println("The robot's X and Y coordinates must be between 1-" + Robot.TABLE_SIZE);
                    }
                } catch (ArrayIndexOutOfBoundsException e)  {
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
        return continueLoop;
    }

}
