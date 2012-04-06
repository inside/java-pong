package com.github.inside;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

public class Equipement
{
    public int width,
           height;
    public double speed,
           x,
           y;
    Board board;
    public Color color;
    String side;

    // Ball
    public Equipement(Board board)
    {
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

    public void draw(Graphics2D g)
    {
        g.setColor(this.color);
        Rectangle2D.Double rectangle = new Rectangle2D.Double();
        rectangle.setRect(Math.round(this.x), Math.round(this.y), this.width, this.height);
        g.fill(rectangle);
    }

    // Implemented in child classes
    public void resetPosition()
    {
    }
}
