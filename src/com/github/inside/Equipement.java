package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

class Equipement
{
    int width,
        height;
    double speed,
           x,
           y;
    Board board;
    Color color;
    String side;

    // Ball
    public Equipement(Board board)
    {
        if (this instanceof Ball)
        {
            this.speed  = Config.BALL_INITIAL_SPEED;
            this.width  = Config.BALL_INITIAL_WIDTH;
            this.height = Config.BALL_INITIAL_HEIGHT;
            this.color  = Color.BLACK;
        }

        this.board = board;
        this.resetPosition();
    }

    // Paddle
    public Equipement(String side, Board board)
    {
        System.out.println("Equipement paddle constructor called");
        this.side   = side;
        this.speed  = Config.PADDLE_INITIAL_SPEED;
        this.width  = Config.PADDLE_INITIAL_WIDTH;
        this.height = Config.PADDLE_INITIAL_HEIGHT;
        this.color  = Color.BLACK;
        this.board  = board;
        this.resetPosition();
    }

    public void draw(Graphics g)
    {
        g.setColor(this.color);
        g.fillRect((int) Math.round(this.x), (int) Math.round(this.y), this.width, this.height);
    }

    // Implemented in child classes
    public void resetPosition()
    {
    }
}
