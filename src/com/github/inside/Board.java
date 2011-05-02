package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Toolkit;
import com.github.inside.Config;
import java.lang.Math;

public class Board extends JPanel implements Runnable
{
    private int x = 0;
    private int y = 0;
    private Thread thread;
    private boolean started = false;
    private boolean paused = false;
    public boolean isRunning = false;
    private long period = 0;
    public long startTime = 0;
    public long time = 0;

    public Board()
    {
        this.period = Math.round((long) 1000 / Config.FRAME_RATE);
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

    public void updateForNewFrame()
    {
        this.time = System.currentTimeMillis() - this.startTime;
        this.startTime = System.currentTimeMillis();

        this.x += (int) (Config.BALL_INITIAL_SPEED * (double) this.time);
        this.y += (int) (Config.BALL_INITIAL_SPEED * (double) this.time);
        System.out.println(Config.BALL_INITIAL_SPEED);
        System.out.println(this.time);
        System.out.println((double) this.time);
        System.out.println(this.x);
    }

    public void run()
    {
        while (true)
        {
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
