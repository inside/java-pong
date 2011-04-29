package com.github.inside;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Keyboard extends KeyAdapter
{
    private Board board;

    public Keyboard(Board board)
    {
        this.board = board;
    }

    public void keyPressed(KeyEvent event)
    {
//        int keyCode = event.getKeyCode();
//
//        if (keyCode == KeyEvent.VK_SPACE)
//        {
//            System.out.println("space bar was pressed");
//        }
    }

    public void keyReleased(KeyEvent event)
    {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_P)
        {
            this.board.togglePause();
        }
        else if (keyCode == KeyEvent.VK_S)
        {
            this.board.stop();
        }
        else if (keyCode == KeyEvent.VK_SPACE)
        {
            this.board.start();
        }
    }
}
