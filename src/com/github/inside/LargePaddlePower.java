package com.github.inside;

import java.awt.Color;
import com.github.inside.PowerTimer;

class LargePaddlePower extends PaddlePower
{
    public LargePaddlePower(Board board)
    {
        super(board);
        this.color = Color.ORANGE;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.height = Config.PADDLE_MAX_HEIGHT;
            this.diesNow = true;
            this.side = "left";
            this.initTime = Board.currentTime;
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.height = Config.PADDLE_MAX_HEIGHT;
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
