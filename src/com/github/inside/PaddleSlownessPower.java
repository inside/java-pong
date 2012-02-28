package com.github.inside;

import com.github.inside.PowerTimer;

class PaddleSlownessPower extends PaddlePower
{
    public PaddleSlownessPower(Board board)
    {
        super(board);
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MIN_SPEED;
            this.diesNow = true;
            this.side = "left";
            this.initTime = System.currentTimeMillis();
            PowerTimer.leftPaddlePowers.put("paddle-slowness-power", this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MIN_SPEED;
            this.diesNow = true;
            this.side = "right";
            this.initTime = System.currentTimeMillis();
            PowerTimer.rightPaddlePowers.put("paddle-slowness-power", this);
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

    // super method needs to be called to avoid NoSuchMethodException
    public long getPowerInitTime()
    {
        return super.getPowerInitTime();
    }

    // super method needs to be called to avoid NoSuchMethodException
    public long getStartTime()
    {
        return super.getStartTime();
    }
}
