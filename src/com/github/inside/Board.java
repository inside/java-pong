package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Toolkit;
import com.github.inside.Config;
//import java.util.Random;
import java.lang.Math;

public class Board extends JPanel implements Runnable
{
    private int x = 250;
    private int y = 125;
    private Thread thread;
    private boolean started = false;
    private boolean paused = false;
    public boolean isRunning = false;

    public Board()
    {
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new Keyboard(this));
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
        this.x += Math.random() * 2 - 1;
        this.y += Math.random() * 2 - 1;
        System.out.println(this.x);
    }

    public void run()
    {
        while (true)
        {
            this.cycle();
            this.repaint();

            try
            {
                Thread.sleep(33);
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException catched");
                break;
            }
        }
    }

    public void start()
    {
        if (this.started)
        {
            return;
        }

        this.started = true;
        this.thread = new Thread(this);
        this.thread.setPriority(Thread.MIN_PRIORITY);
        this.thread.start();

        System.out.println("start called");
    }

    public void stop()
    {
        if (this.thread != null)
        {
            this.thread.interrupt();
        }

        this.thread = null;
        this.started = false;
        System.out.println("stop called");
    }

    public void togglePause()
    {
        System.out.println("togglePause called");
    }
}
