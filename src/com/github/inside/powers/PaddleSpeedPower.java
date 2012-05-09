package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class PaddleSpeedPower extends PaddlePower
{
    public PaddleSpeedPower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Paddle speed");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.start("left", this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.start("right", this);
        }
    }

    public void end()
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
}
