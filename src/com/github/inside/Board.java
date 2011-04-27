package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Toolkit;
import com.github.inside.Config;

public class Board extends JPanel implements Runnable
{
    private int x = 0;
    private int y = 0;
    private Thread thread;
    public boolean isRunning = false;

    public Board()
    {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
    }

    public void addNotify()
    {
        super.addNotify();
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 10, 10);
        Toolkit.getDefaultToolkit().sync();
    }

    public void cycle()
    {
        this.x += 10;
        this.y += 10;
    }

    public void run()
    {
        while (true)
        {
            this.cycle();
            this.repaint();

            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                System.out.println("interrupted");
            }
        }
    }
}
