package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsSmallPaddlePower extends PaddlePower
{
    public OpponentsSmallPaddlePower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Opponent's small paddle");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.height = Config.PADDLE_MIN_HEIGHT;
            this.start("left", this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.height = Config.PADDLE_MIN_HEIGHT;
            this.start("right", this);
        }
    }

    public void end()
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
