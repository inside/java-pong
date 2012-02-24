package com.github.inside;

import com.github.inside.PowerTimer;

class PaddleSpeedPower extends PaddlePower
{
    public Board board;
    public long initTime;
    public String side;

    public PaddleSpeedPower(Board board)
    {
        super(board);

        this.board = board;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "left";
            this.initTime = System.currentTimeMillis();
            PowerTimer.leftPaddlePowers.put("paddle-speed-power", this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.diesNow = true;
            this.side = "right";
            this.initTime = System.currentTimeMillis();
            PowerTimer.rightPaddlePowers.put("paddle-speed-power", this);
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

    public long getPowerInitTime()
    {
        return this.initTime;
    }

    public long getStartTime()
    {
        return this.board.startTime;
    }
}
