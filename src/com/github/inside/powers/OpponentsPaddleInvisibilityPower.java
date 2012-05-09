package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsPaddleInvisibilityPower extends PaddlePower
{
    public OpponentsPaddleInvisibilityPower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Opponent's invisibility");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.color = new Color(0, 0, 0, 0);
            this.start("left", this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.color = new Color(0, 0, 0, 0);
            this.start("right", this);
        }
    }

    public void action()
    {
        if (this.side.equals("left"))
        {
            this.board.leftPaddle.resetColor();
        }
        else if (this.side.equals("right"))
        {
            this.board.rightPaddle.resetColor();
        }
    }

    public long getLifeTime()
    {
        return 4000;
    }
}
