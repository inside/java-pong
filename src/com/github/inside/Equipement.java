package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

//class Equipement extends JPanel
class Equipement
{
//    int width,
//        height;
    int width     = Config.BALL_INITIAL_WIDTH,
        height    = Config.BALL_INITIAL_HEIGHT;

    double speed  = Config.BALL_INITIAL_SPEED,
           x,
           y;
    Board board;
//    Color color;
    Color color   = Color.RED;

    public Equipement(Board board)
    {
//        System.out.println("### width from equipement " + this.width);
//        System.out.println("### height from equipement " + this.height);
        this.board = board;
        this.resetPosition();
    }

    public void draw(Graphics g)
    {
//        System.out.println("here");
//        System.out.println((int) Math.round(this.x));
//        System.out.println((int) Math.round(this.y));
//        System.out.println(this.width);
//        System.out.println(this.height);
//        System.out.println(this.color);
        g.setColor(this.color);
//        g.setColor(Color.RED);
        g.fillRect((int) Math.round(this.x), (int) Math.round(this.y), this.width, this.height);
//        g.fillRect(100, 50, this.width, this.height);
//        g.fillRect(150, 50, 25, 25);
    }

    // Implemented in child classes
    public void resetPosition()
    {
    }
}
