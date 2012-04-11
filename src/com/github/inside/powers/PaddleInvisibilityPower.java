package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.PowerTimer;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PaddlePower;

public class PaddleInvisibilityPower extends PaddlePower
{
    public PaddleInvisibilityPower(Board board)
    {
        super(board);
        this.color = Config.MALUS_COLOR;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
            this.board.leftPaddle.color = new Color(0, 0, 0, 0);
            this.diesNow = true;
            this.side = "left";
            this.initTime = Board.currentTime;
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
        }
        else if (this.hitsRightPaddle())
        {
            this.board.rightPaddle.color = new Color(0, 0, 0, 0);
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
