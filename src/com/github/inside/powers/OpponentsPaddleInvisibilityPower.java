package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.PowerTimer;
import com.github.inside.Board;

public class OpponentsPaddleInvisibilityPower extends PaddlePower
{
    public OpponentsPaddleInvisibilityPower(Board board)
    {
        super(board);
        this.color = Color.ORANGE;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.color = new Color(0, 0, 0, 0);
            this.diesNow = true;
            this.side = "left";
            this.initTime = Board.currentTime;
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.color = new Color(0, 0, 0, 0);
            this.diesNow = true;
            this.side = "right";
            this.initTime = Board.currentTime;
            PowerTimer.rightPaddlePowers.put(this.getClass().getName(), this);
        }
    }

    public void action()
    {
        if (this.side.equals("left"))
        {
            this.board.leftPaddle.resetColor();
        }
        else if (this.side.equals("right"))
        {
            this.board.rightPaddle.resetColor();
        }
    }

    public long getLifeTime()
    {
        return 4000;
    }
}
