package com.stephenson_william.robot_movement;

/**
 * Model class which can create a robot and move it about on a 5x5 grid
 */
public class Robot {

    public enum Direction { NORTH, SOUTH, EAST, WEST }

    private Direction direction;

    private final int [][] position = new int[5][5];

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
        this.position[xPos][yPos] = 1;
    }

    /**
     * Get the direction the robot is currently facing
     * @return A Direction ( North , EAST, SOUTH, WEST )
     */
    public Direction getDirection(){
        return this.direction;
    }

    /**
     * Get the position of the robot as an array representing the possible positions on the table
     * [0][0] is the south west corner and [4][4] is the north east
     * @return A 2D array representing the possible positions on the table where the index containing 1 is the current position of the robot
     */
    public int[][] getPosition() {
        return this.position;
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
     *             Must be an integer between 0 - 4
     * @param yPos The coordinate on the Y axis the robot will be place
     *             Must be an integer between 0 - 4
     */
    public void setPosition(int xPos, int yPos) {
        if(xPos >= 0 && xPos <=4 && yPos >= 0 && yPos <=4  ){
            this.position[xPos][yPos] = 1;
        }
        else {
            System.out.println("Invalid coordinates - xPos and yPos must be between 0 -4");
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
            System.out.println(turnDirection + " is not a valid turn direction, please use LEFT or RIGHT");
        }
        System.out.print("\nRobot turned " + turnDirection);
    }


    /**
     * Moves the robot in the direction it is currently facing
     * If the move will make the robot fall, it will not move and the method will exit cleanly
     */
    public void move(){
        // Retrieve the position and direction faced by the robot
        Direction direction = this.getDirection();
        int[][] position = this.getPosition();

        int xPos = 0;
        int yPos = 0;

        // Loop through the array to determine the current coordinates of the robot
        for(int i = 0; i < position.length; i++) {
            for(int j = 0; j < position[i].length; j++) {
                if (position[i][j] == 1 ){
                    xPos = i;
                    yPos = j;
                    //System.out.println("\n\nStarting position");
                    //System.out.println("xPos=" + xPos + " : yPos=" + yPos);
                }
            }
        }

        // Execute the move if it will not cause the robot to exceed the bounds of the table
        switch(direction) {
            case NORTH:
                if (yPos < 4) {
                    position[xPos][yPos+1] = 1;
                    position[xPos][yPos] = 0;
                    yPos++;
                }
                break;
            case EAST:
                if (xPos < 4) {
                    position[xPos + 1][yPos] = 1;
                    position[xPos][yPos] = 0;
                    xPos++;
                }
                break;
            case SOUTH:
                if (yPos > 0) {
                    position[xPos][yPos - 1] = 1;
                    position[xPos][yPos] = 0;
                    yPos--;
                }
                break;
            case WEST:
                if (xPos > 0) {
                    position[xPos - 1][yPos] = 1;
                    position[xPos][yPos] = 0;
                    xPos--;
                }
                break;
        }

        System.out.println("\nRobot moved " + direction);
        System.out.println("xPos=" + xPos + " : yPos=" + yPos);

    }

}
