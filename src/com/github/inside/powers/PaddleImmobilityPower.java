package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class PaddleImmobilityPower extends PaddlePower
{
    public PaddleImmobilityPower(Board board)
    {
        super(board);
        this.color = Config.MALUS_COLOR;
        this.setName("Immobility");
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.speed = 0;
            this.start("left", this);
        }
        else if (this.hitsRightPaddle())
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
