package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

class Equipement
{
    int width     = Config.BALL_INITIAL_WIDTH,
        height    = Config.BALL_INITIAL_HEIGHT;

    double speed  = Config.BALL_INITIAL_SPEED,
           x,
           y;
    Board board;
    Color color   = Color.RED;

    public Equipement(Board board)
    {
        this.board = board;
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
