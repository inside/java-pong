package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Toolkit;
import com.github.inside.Config;
import java.lang.Math;
import com.github.inside.Ball;

public class Board extends JPanel implements Runnable
{
    private Thread thread;
    private boolean started = false;
    private boolean paused = false;
    public boolean isRunning = false;
    private long period = 0;
    public long startTime = 0;
    public long time = 0;
    public Ball[] projectiles;
    public int projectileCount = 10;

    public Board()
    {
        System.out.println("Board constructor called");
        this.setLayout(null);
        this.setBounds(Config.FRAME_LEFT_MARGIN, Config.FRAME_TOP_MARGIN, Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        this.period = Math.round((long) 1000 / Config.FRAME_RATE);
        this.projectiles = new Ball[this.projectileCount];

        for (int i = 0; i < this.projectileCount; i++)
        {
            System.out.println("Adding a Ball object to the projectiles array");
            this.projectiles[i] = new Ball(this);
        }

        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setBackground(Color.decode("#ffffff"));
        this.addKeyListener(new Keyboard(this));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(100, 0, 25, 25);

        for (int i = 0; i < this.projectileCount; i++)
        {
            System.out.println("Calling the draw method on a Ball");
            this.projectiles[i].draw(g);
        }
    }

    public void updateForNewFrame()
    {
        this.time = System.currentTimeMillis() - this.startTime;
        this.startTime = System.currentTimeMillis();

        for (int i = 0; i < this.projectileCount; i++)
        {
            System.out.println("Calling the updateForNewFrame method on a Ball");
            this.projectiles[i].updateForNewFrame();
        }
    }

    public void run()
    {
        while (true)
        {
            System.out.println("Beginning new iteration");
            this.updateForNewFrame();
            this.repaint();

            try
            {
                Thread.sleep(this.getNextFrameDelay());
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

        this.stop();
        this.pursue();
        System.out.println("start called");
    }

    public void stop()
    {
        this.started = false;
        this.paused  = true;
        this.stopThread();
        System.out.println("stop called");
    }

    public void pause()
    {
        this.started = true;
        this.paused  = true;
        this.stopThread();
    }

    public void pursue()
    {
        this.started = true;
        this.paused = false;
        this.startTime = System.currentTimeMillis();
//        this.initFireProjectileTime();
        this.startThread();
        System.out.println("pursue called");
    }

    public void togglePause()
    {
        if (!this.started)
        {
            return;
        }
        if (this.paused)
        {
            this.pursue();
        }
        else
        {
            this.pause();
        }
        System.out.println("togglePause called");
    }

    private void startThread()
    {
        this.thread = new Thread(this);
        this.thread.setPriority(Thread.MIN_PRIORITY);
        this.thread.start();
    }

    private void stopThread()
    {
        if (this.thread != null)
        {
            this.thread.interrupt();
        }

        this.thread = null;
    }

    private long getNextFrameDelay()
    {
        long processingTime = System.currentTimeMillis() - this.startTime;

        if (this.period < processingTime)
        {
            return 0;
        }

        return this.period - processingTime;
    }
}
