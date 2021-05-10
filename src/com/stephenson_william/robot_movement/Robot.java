package com.stephenson_william.robot_movement;

public class Robot {
    /**
     *
     */

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private Direction robotDirection;

    private int [][] robotPosition = new int[5][5];

    // Empty constructor
    public Robot(){
    }

    // Standard constructor
    public Robot(int [][] pos, Direction dir) {
        this.robotDirection = dir;
        this.robotPosition = pos;
    }

    // Getter functions
    public Direction getRobotDirection(){
        return robotDirection;
    }

    public int[][] getRobotPosition() {
        return robotPosition;
    }

    // Setter functions
    public void setRobotDirection(Direction robotDirection) {
        this.robotDirection = robotDirection;
    }

    public void setRobotPosition(int[][] robotPosition) {
        this.robotPosition = robotPosition;
    }

}
