package com.stephenson_william.robot_movement;

/**
 * Model class which can create a robot and move it about on a 5x5 grid
 */
public class Robot {

    public static int TABLE_SIZE = 5;

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private Direction direction;

    private int xPos;
    private int yPos;

    /**
     * Empty constructor for the robot
     */
    public Robot(){
    }

    /**
     * Constructor for the robot
     * @param xPos the X coordinate of the robot
     * @param yPos the Y coordinate of the robot
     * @param dir the direction the robot will initially be facing
     */
    public Robot(int xPos, int yPos, Direction dir) {
        this.direction = dir;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Get the direction the robot is currently facing
     * @return A Direction ( North , EAST, SOUTH, WEST )
     */
    public Direction getDirection(){
        return this.direction;
    }

    public int getxPos(){
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void report(){
        System.out.println(this.xPos + "," + this.yPos + "," + this.direction);
    }

    /**
     * Set the direction of the robot
     * @param direction The direction the robot will face
     *                  Must be a Direction ( North , EAST, SOUTH, WEST )
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Set the position of the robot
     * @param xPos The coordinate on the X axis the robot will be place
     *             Must be an integer between 1 - 5
     * @param yPos The coordinate on the Y axis the robot will be place
     *             Must be an integer between 1 - 5
     */
    public boolean setPosition(int xPos, int yPos) {
        if(xPos >= 1 && xPos <= TABLE_SIZE && yPos >= 1 && yPos <= TABLE_SIZE){
            this.xPos = xPos;
            this.yPos = yPos;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Rotates the orientation of the robot by 90 degrees
     * @param turnDirection The direction the robot will turn
     *                      Must be either LEFT or RIGHT
     */
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
        } else if (turnDirection.equals("RIGHT")){
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
        } else {
            System.out.println(turnDirection + " is not a valid turn direction, please use LEFT or RIGHT");
        }
        //System.out.print("\nRobot turned " + turnDirection);
    }


    /**
     * Moves the robot in the direction it is currently facing
     * If the move will make the robot fall, it will not move and the method will exit cleanly
     */
    public void move(){

        // Retrieve the direction faced by the robot
        Direction direction = this.getDirection();

        int x = this.getxPos();
        int y = this.getyPos();

        // Execute the move if it will not cause the robot to exceed the bounds of the table
        switch(direction) {
            case NORTH:
                if (y < TABLE_SIZE) {
                    y++;
                }
                break;
            case EAST:
                if (x < TABLE_SIZE) {
                    x++;
                }
                break;
            case SOUTH:
                if (y > 1) {
                    y--;
                }
                break;
            case WEST:
                if (x > 1) {
                    x++;
                }
                break;
        }
        this.setPosition(x,y); // Update the robot with its new coordinates


        //System.out.println("\nRobot moved " + direction);
        //System.out.println("xPos=" + this.xPos + " : yPos=" + this.yPos);

    }

}
