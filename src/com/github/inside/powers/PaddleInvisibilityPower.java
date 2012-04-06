package com.github.inside.powers;

import java.awt.Color;
import com.github.inside.PowerTimer;
import com.github.inside.Board;

public class PaddleInvisibilityPower extends PaddlePower
{
    public PaddleInvisibilityPower(Board board)
    {
        super(board);
        this.color = Color.RED;
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();

        if (this.hitsLeftPaddle())
        {
//            this.board.leftPaddle.startFadeOut();
            this.diesNow = true;
            this.side = "left";
            this.initTime = Board.currentTime;
            PowerTimer.leftPaddlePowers.put(this.getClass().getName(), this);
//            Animation.animatedElements.put("", this.board.leftPaddle);
        }
        else if (this.hitsRightPaddle())
        {
//            this.board.rightPaddle.startFadeOut();
            this.diesNow = true;
            this.side = "right";
            this.initTime = Board.currentTime;
            PowerTimer.rightPaddlePowers.put(this.getClass().getName(), this);
//            Animation.animatedElements.put("", this.board.rightPaddle);
        }
    }

    public void action()
    {
        if (this.side.equals("left"))
        {
            this.board.leftPaddle.color = new Color(0, 0, 0, 255);
        }
        else if (this.side.equals("right"))
        {
            this.board.rightPaddle.color = new Color(0, 0, 0, 255);
        }
    }

    // The method needs to be implemented here to avoid a NoSuchMethodException.
    // The real implementation is done in the parent.
    public long getPowerInitTime()
    {
        return super.getPowerInitTime();
    }
}
