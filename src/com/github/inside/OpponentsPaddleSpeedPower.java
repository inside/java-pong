package com.github.inside;

import com.github.inside.PowerTimer;

class OpponentsPaddleSpeedPower extends PaddlePower
{
    public OpponentsPaddleSpeedPower(Board board)
    {
        super(board);
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "left";
            this.initTime = System.currentTimeMillis();
            PowerTimer.leftPaddlePowers.put("opponents-paddle-speed-power", this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "right";
            this.initTime = System.currentTimeMillis();
            PowerTimer.rightPaddlePowers.put("opponents-paddle-speed-power", this);
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
    public long getStartTime()
    {
        return super.getStartTime();
    }
}
