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
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_I) // i
        {
            this.board.leftPaddle.isGoingUp = true;
            this.board.leftPaddle.isGoingDown = false;
        }
        else if (keyCode == KeyEvent.VK_K) // k
        {
            this.board.leftPaddle.isGoingUp = false;
            this.board.leftPaddle.isGoingDown = true;
        }
        else if (keyCode == KeyEvent.VK_UP) // Up arrow
        {
            this.board.rightPaddle.isGoingUp = true;
            this.board.rightPaddle.isGoingDown = false;
        }
        else if (keyCode == KeyEvent.VK_DOWN) // Down arrow
        {
            this.board.rightPaddle.isGoingUp = false;
            this.board.rightPaddle.isGoingDown = true;
        }
    }

    public void keyReleased(KeyEvent event)
    {
        int keyCode = event.getKeyCode();

        if (keyCode == KeyEvent.VK_I) // i
        {
            this.board.leftPaddle.isGoingUp = false;
        }
        else if (keyCode == KeyEvent.VK_K) // k
        {
            this.board.leftPaddle.isGoingDown = false;
        }
        else if (keyCode == KeyEvent.VK_UP) // Up arrow
        {
            this.board.rightPaddle.isGoingUp = false;
        }
        else if (keyCode == KeyEvent.VK_DOWN) // Down arrow
        {
            this.board.rightPaddle.isGoingDown = false;
        }
        else if (keyCode == KeyEvent.VK_P) // p
        {
            this.board.togglePause();
        }
        else if (keyCode == KeyEvent.VK_S) // s
        {
            this.board.stop();
        }
        else if (keyCode == KeyEvent.VK_SPACE) // Space bar
        {
            this.board.start();
        }
    }
}
