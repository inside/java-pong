package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Toolkit;
import com.github.inside.Config;
import java.lang.Math;
import com.github.inside.Ball;
import com.github.inside.Helper;
import com.github.inside.WeightedValue;
import com.github.inside.Paddle;
import java.awt.RenderingHints;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Board extends JPanel implements Runnable
{
    private Thread thread;
    private boolean started = false;
    private boolean paused = false;
    public boolean isRunning = false;
    private long period = 0;
    public long currentTime = 0;
    public long fireProjectileTime = 0;
    public long time = 0;
    public List<Projectile> projectiles;
    public Paddle leftPaddle;
    public Paddle rightPaddle;
    public Player leftPlayer;
    public Player rightPlayer;
    public WeightedValue[] weightedValues;

    public Board()
    {
        this.setLayout(null);
        this.setBounds(0, 0, Config.BOARD_WIDTH, Config.BOARD_HEIGHT);
        this.period = Math.round((long) 1000 / Config.FRAME_RATE);
        this.projectiles = new CopyOnWriteArrayList<Projectile>();
        this.projectiles.add(this.createNewProjectile("com.github.inside.Ball"));
        this.leftPaddle = new Paddle("left", this);
        this.rightPaddle = new Paddle("right", this);
        this.weightedValues = new WeightedValue[9];
        this.weightedValues[0] = new WeightedValue("com.github.inside.Ball",                        68);
        this.weightedValues[1] = new WeightedValue("com.github.inside.PaddleSpeedPower",             4);
        this.weightedValues[2] = new WeightedValue("com.github.inside.OpponentsPaddleSpeedPower",    4);
        this.weightedValues[3] = new WeightedValue("com.github.inside.PaddleSlownessPower",          4);
        this.weightedValues[4] = new WeightedValue("com.github.inside.OpponentsPaddleSlownessPower", 4);
        this.weightedValues[5] = new WeightedValue("com.github.inside.LargePaddlePower",             4);
        this.weightedValues[6] = new WeightedValue("com.github.inside.OpponentsLargePaddlePower",    4);
        this.weightedValues[7] = new WeightedValue("com.github.inside.SmallPaddlePower",             4);
        this.weightedValues[8] = new WeightedValue("com.github.inside.OpponentsSmallPaddlePower",    4);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setBackground(Color.decode("#ffffff"));
        this.addKeyListener(new Keyboard(this));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // This fixes flickering on OpenJDK
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        for (Projectile projectile : this.projectiles)
        {
            projectile.draw(g2D);
        }

        this.leftPaddle.draw(g2D);
        this.rightPaddle.draw(g2D);
    }

    public void updateForNewFrame()
    {
        this.time = System.currentTimeMillis() - this.currentTime;
        this.currentTime = System.currentTimeMillis();

        // Paddles
        this.leftPaddle.updateForNewFrame();
        this.rightPaddle.updateForNewFrame();

        // Projectiles
        if (this.needsNewProjectile())
        {
            this.initFireProjectileTime();
            this.projectiles.add(this.createNewProjectile("random"));
        }

        int i = 0;

        for (Projectile projectile : this.projectiles)
        {
            if (projectile.isLiving(this.currentTime))
            {
                projectile.updateForNewFrame();
            }
            else
            {
                this.projectiles.remove(i);
            }

            i++;
        }

        // Power timer
        PowerTimer.handlePowerTimer();

        // Score
        if (this.leftPlayer.hasReachedScore())
        {
            System.out.println("Left player won with "
                               + this.leftPlayer.score
                               + " points. Right player lost with "
                               + this.rightPlayer.score);
            this.stop();
        }
        else if (this.rightPlayer.hasReachedScore())
        {
            System.out.println("Right player won with "
                               + this.rightPlayer.score
                               + " points. Left player lost with "
                               + this.leftPlayer.score);
            this.stop();
        }
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
        this.leftPlayer.resetScore();
        this.rightPlayer.resetScore();
        this.pursue();
        System.out.println("start called");
    }

    public void stop()
    {
        this.started = false;
        this.paused  = true;
        this.stopThread();
        this.projectiles = new CopyOnWriteArrayList<Projectile>();
        this.projectiles.add(this.createNewProjectile("com.github.inside.Ball"));
        this.leftPaddle.resetPosition();
        this.rightPaddle.resetPosition();
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
        this.currentTime = System.currentTimeMillis();
        this.initFireProjectileTime();
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
        long processingTime = System.currentTimeMillis() - this.currentTime;

        if (this.period < processingTime)
        {
            return 0;
        }

        return this.period - processingTime;
    }

    public Projectile createNewProjectile(String name)
    {
        Projectile projectile = null;

        if (name.equals("random"))
        {
            name = Helper.getWeightedRandomValue(this.weightedValues);
        }

        try
        {
            Class<?> projectileClass = Class.forName(name);
            Constructor<?> constructor = projectileClass.getConstructor(new Class<?>[] {Board.class});
            projectile = (Projectile) constructor.newInstance(this);
        }
        catch (NoSuchMethodException x)
        {
            System.out.println("NoSuchMethodException was catched from Board.java");
        }
        catch (ClassNotFoundException x)
        {
            System.out.println("ClassNotFoundException was catched from Board.java");
        }
        catch (InstantiationException x)
        {
            System.out.println("InstantiationException was catched from Board.java");
        }
        catch (IllegalAccessException x)
        {
            System.out.println("IllegalAccessException was catched from Board.java");
        }
        catch (InvocationTargetException x)
        {
            System.out.println("InvocationTargetException was catched from Board.java");
        }

        return projectile;
    }

    public boolean needsNewProjectile()
    {
        return this.fireProjectileTime <= this.currentTime && this.projectiles.size() < Config.MAX_PROJECTILES;
    }

    public void initFireProjectileTime()
    {
        this.fireProjectileTime = Helper.getRandomFromRange(1000, 2000) + this.currentTime;
    }
}
