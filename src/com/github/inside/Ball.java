package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.lang.Math;
import com.github.inside.Config;

class Ball extends JPanel
{
    int x = 250;
    int y = 125;
    int newX, newY;
    int width = Config.BALL_INITIAL_WIDTH; 
    int height = Config.BALL_INITIAL_HEIGHT; 
    double speed = Config.BALL_INITIAL_SPEED;

    public Ball()
    {
        this.newX = (int) ((Math.random() * 2.0 - 1.0) * 10);
        this.newY = (int) ((Math.random() * 2.0 - 1.0) * 10);
    }

    public void draw(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void updateForNewFrame()
    {
        if (this.x <= 0 || this.x >= Config.PONG_WIDTH)
        {
            this.newX *= -1;
        }
        if (this.y <= 0 || this.y >= Config.PONG_HEIGHT)
        {
            this.newY *= -1;
        }

        this.x += this.newX;
        this.y += this.newY;
    }
}
