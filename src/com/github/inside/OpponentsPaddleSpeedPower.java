package com.github.inside;

import java.awt.Color;
import com.github.inside.PowerTimer;

class OpponentsPaddleSpeedPower extends PaddlePower
{
    public OpponentsPaddleSpeedPower(Board board)
    {
        super(board);
        this.color = Color.RED;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "left";
            this.initTime = this.getCurrentTime();
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "right";
            this.initTime = this.getCurrentTime();
            PowerTimer.rightPaddlePowers.put(this.getClass().getName(), this);
        }
    }

    public void action()
    {
        if (this.side.equals("left"))
        {
            this.board.leftPaddle.resetSpeed();
        }
        else if (this.side.equals("right"))
        {
            this.board.rightPaddle.resetSpeed();
        }
    }

    // The method needs to be implemented here to avoid a NoSuchMethodException.
    // The real implementation is done in the parent.
    public long getPowerInitTime()
    {
        return super.getPowerInitTime();
    }

    // The method needs to be implemented here to avoid a NoSuchMethodException.
    // The real implementation is done in the parent.
    public long getCurrentTime()
    {
        return super.getCurrentTime();
    }
}
