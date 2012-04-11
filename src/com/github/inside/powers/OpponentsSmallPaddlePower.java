package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.PowerTimer;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsSmallPaddlePower extends PaddlePower
{
    public OpponentsSmallPaddlePower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
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
}
