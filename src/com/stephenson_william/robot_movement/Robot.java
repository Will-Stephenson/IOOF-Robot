package com.stephenson_william.robot_movement;

/**
 * Model class which can create a robot and move it about on a 5x5 grid
 */
public class Robot {

    public static int TABLE_SIZE = 5;

    private CardinalDirection cardinalDirection;

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
    public Robot(int xPos, int yPos, CardinalDirection dir) {
        this.cardinalDirection = dir;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * Get the direction the robot is currently facing
     * @return A Direction ( North , EAST, SOUTH, WEST )
     */
    public CardinalDirection getDirection(){
        return this.cardinalDirection;
    }

    public int getxPos(){
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public void report(){
        System.out.println(this.xPos + "," + this.yPos + "," + this.cardinalDirection);
    }

    /**
     * Set the direction of the robot
     * @param cardinalDirection The direction the robot will face
     *                  Must be a Direction ( North , EAST, SOUTH, WEST )
     */
    public void setDirection(CardinalDirection cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
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
    public void rotate(Direction turnDirection){

        CardinalDirection cardinalDirection = this.getDirection();

        if (turnDirection == Direction.LEFT) {
            switch(cardinalDirection) {
                case NORTH:
                    this.setDirection(CardinalDirection.WEST);
                    break;
                case EAST:
                    this.setDirection(CardinalDirection.NORTH);
                    break;
                case SOUTH:
                    this.setDirection(CardinalDirection.EAST);
                    break;
                case WEST:
                    this.setDirection(CardinalDirection.SOUTH);
                    break;
            }
        } else if (turnDirection == Direction.RIGHT){
            switch(cardinalDirection) {
                case NORTH:
                    this.setDirection(CardinalDirection.EAST);
                    break;
                case EAST:
                    this.setDirection(CardinalDirection.SOUTH);
                    break;
                case SOUTH:
                    this.setDirection(CardinalDirection.WEST);
                    break;
                case WEST:
                    this.setDirection(CardinalDirection.NORTH);
                    break;
            }
        } else {
            System.out.println(turnDirection + " is not a valid turn direction, please use LEFT or RIGHT");
        }
    }


    /**
     * Moves the robot in the direction it is currently facing
     * If the move will make the robot fall, it will not move and the method will exit cleanly
     */
    public void move(){

        // Retrieve the direction faced by the robot
        CardinalDirection cardinalDirection = this.getDirection();

        int x = this.getxPos();
        int y = this.getyPos();

        // Execute the move if it will not cause the robot to exceed the bounds of the table
        switch(cardinalDirection) {
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
    }

}
