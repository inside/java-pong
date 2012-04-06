package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.PowerTimer;
import com.github.inside.Board;
import com.github.inside.Config;

public class OpponentsSmallPaddlePower extends PaddlePower
{
    public OpponentsSmallPaddlePower(Board board)
    {
        super(board);
        this.color = Color.ORANGE;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.height = Config.PADDLE_MIN_HEIGHT;
            this.diesNow = true;
            this.side = "left";
            this.initTime = Board.currentTime;
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.height = Config.PADDLE_MIN_HEIGHT;
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
            this.board.leftPaddle.resetHeight();
        }
        else if (this.side.equals("right"))
        {
            this.board.rightPaddle.resetHeight();
        }
    }

    // The method needs to be implemented here to avoid a NoSuchMethodException.
    // The real implementation is done in the parent.
    public long getPowerInitTime()
    {
        return super.getPowerInitTime();
    }
}
