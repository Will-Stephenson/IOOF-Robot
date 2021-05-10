package com.stephenson_william.robot_movement;

public class Robot {
    /**
     *
     */

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private Direction direction;

    private int [][] position = new int[5][5];

    // Empty constructor
    public Robot(){
    }

    // Standard constructor
    public Robot(int [][] pos, Direction dir) {
        this.direction = dir;
        this.position = pos;
    }

    // Getter methods
    public Direction getDirection(){
        return direction;
    }

    public int[][] getPosition() {
        return position;
    }

    // Setter methods
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    // Management methods
    public void rotate(String turnDirection){

        Direction currentDirection = this.getDirection();

        if (turnDirection.equals("LEFT")) {
            switch(currentDirection) {
                case NORTH:
                    this.setDirection(Direction.WEST);
                    break;
                case EAST:
                    this.setDirection(Direction.NORTH);
                    break;
                case SOUTH:
                    this.setDirection(Direction.EAST);
                    break;
                case WEST:
                    this.setDirection(Direction.SOUTH);
                    break;
            }
        }
        else if (turnDirection.equals("RIGHT")){
            switch(currentDirection) {
                case NORTH:
                    this.setDirection(Direction.EAST);
                    break;
                case EAST:
                    this.setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    this.setDirection(Direction.WEST);
                    break;
                case WEST:
                    this.setDirection(Direction.NORTH);
                    break;
            }
        }
        else {
            System.out.println("Invalid turn direction");
        }
    }

}
