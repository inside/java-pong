package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class LargePaddlePower extends PaddlePower
{
    public LargePaddlePower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Large paddle");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.height = Config.PADDLE_MAX_HEIGHT;
            this.start("left", this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.height = Config.PADDLE_MAX_HEIGHT;
            this.start("right", this);
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
