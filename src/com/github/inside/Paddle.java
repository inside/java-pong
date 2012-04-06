package com.github.inside;

import java.awt.Color;

public class Paddle extends Equipement
{
    public boolean isGoingUp   = false,
                   isGoingDown = false;

    public Paddle(String side, Board board)
    {
        super(side, board);
    }

    public void updateForNewFrame()
    {
        if (this.isGoingUp)
        {
            this.moveUp();
        }
        else if (this.isGoingDown)
        {
            this.moveDown();
        }
    }

    public void resetPosition()
    {
        this.y = Config.BOARD_HEIGHT / 2 - this.height / 2;

        if (this.side == "right")
        {
            this.x = Config.BOARD_WIDTH - this.width;
        }
        else if (this.side == "left")
        {
            this.x = 0;
        }
    }

    public void resetSpeed()
    {
        this.speed = Config.PADDLE_INITIAL_SPEED;
    }

    public void resetColor()
    {
        this.color = Config.PADDLE_COLOR;
    }

    public void resetHeight()
    {   
        this.height = Config.PADDLE_INITIAL_HEIGHT;
    }

    public void moveUp()
    {       
        double y = this.y - this.speed * this.board.time;
        
        if (y <= 0)
        {   
            this.y = 0;
        }
        else
        {   
            this.y = y;
        }
    }

    public void moveDown()
    {
        double y = this.y + this.speed * this.board.time;

        if (y >= Config.BOARD_HEIGHT - this.height)
        {
            this.y = Config.BOARD_HEIGHT - this.height;
        }
        else
        {
            this.y = y;
        }
    }

    public void reset()
    {
        this.resetPosition();
        this.resetColor();
        this.resetHeight();
        this.resetSpeed();
    }
}
