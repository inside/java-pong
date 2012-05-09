package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsPaddleSlownessPower extends PaddlePower
{
    public OpponentsPaddleSlownessPower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Opponent's paddle slowness");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.speed = Config.PADDLE_MIN_SPEED;
            this.start("left", this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.speed = Config.PADDLE_MIN_SPEED;
            this.start("right", this);
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
}
