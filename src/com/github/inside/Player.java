package com.github.inside;

import javax.swing.JLabel;
import java.lang.Integer;

public class Player extends JLabel
{
    public String name;
    public int score = 0;
    public int scoreDelta = 0;

    public Player(String name)
    {
        this.name = name;
        this.setText();

        if (this.name.equals("left"))
        {
            this.setBounds(
                    10,
                    Config.BOARD_HEIGHT + Config.BOARD_CONTAINER_TOP_MARGIN + 10,
                    60,
                    15);
        }
        else
        {
            this.setBounds(
                    Config.BOARD_WIDTH + Config.BOARD_CONTAINER_LEFT_MARGIN + Config.BOARD_CONTAINER_RIGHT_MARGIN - 55,
                    Config.BOARD_HEIGHT + Config.BOARD_CONTAINER_TOP_MARGIN + 10,
                    60,
                    15);
        }
    }

    public void updateScore()
    {
        this.score++;
    }

    public void updateScoreDelta(int opponentsScore)
    {
        this.scoreDelta = this.score - opponentsScore;
    }

    public void resetScore()
    {
        this.score = 0;
        this.scoreDelta = 0;
        this.setText();
    }

    public boolean hasReachedScore()
    {
        return this.score >= Config.MAX_SCORE;
    }

    public void setText()
    {
        super.setText(Integer.toString(this.score) + " \u0394 " + Integer.toString(this.scoreDelta));
    }
}
