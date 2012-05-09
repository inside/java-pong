package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsPaddleSpeedPower extends PaddlePower
{
    public OpponentsPaddleSpeedPower(Board board)
    {
        super(board);
        this.color = Config.MALUS_COLOR;
        this.setName("Opponent's paddle speed");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MAX_SPEED;
            this.start("left", this);
        }
        else if (this.hitsLeftPaddle())
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
