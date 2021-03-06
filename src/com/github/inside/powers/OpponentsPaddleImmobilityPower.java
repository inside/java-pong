package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class OpponentsPaddleImmobilityPower extends PaddlePower
{
    public OpponentsPaddleImmobilityPower(Board board)
    {
        super(board);
        this.color = Config.BONUS_COLOR;
        this.setName("Opponent's immobility");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsRightPaddle())
        {
            this.board.leftPaddle.speed = 0;
            this.start("left", this);
        }
        else if (this.hitsLeftPaddle())
        {
            this.board.rightPaddle.speed = 0;
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

    public long getLifeTime()
    {
        return 4000;
    }
}
