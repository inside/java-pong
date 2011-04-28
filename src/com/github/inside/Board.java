package com.github.inside;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.github.inside.Config;

public class Board extends JPanel implements Runnable
{
    private int x = 0;
    private int y = 0;
    private Thread thread;
    public boolean isRunning = false;

    public Board()
    {
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent event)
            {
                int keyCode = event.getKeyCode();

                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_SPACE)
                {
                    System.out.println("space bar was pressed");
                }
            }

            public void keyReleased(KeyEvent event)
            {
                int keyCode = event.getKeyCode();

                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_SPACE)
                {
                    System.out.println("space bar was released");
                }
            }
        });
    }

//    public void addNotify()
//    {
//        super.addNotify();
//        this.thread = new Thread(this);
//        this.thread.start();
//    }

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
