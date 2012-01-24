package com.github.inside;

import java.awt.Color;
import com.github.inside.Config;

class Ball extends Projectile
{
    public Ball(Board board)
    {
        super(board);
    }

    public void updateForNewFrame()
    {
        super.updateForNewFrame();
        this.handlePaddleRebound();
    }

    public void handlePaddleRebound()
    {
        if (this.hitsLeftPaddle())
        {
            this.x = this.board.leftPaddle.x + this.board.leftPaddle.width;
            this.reboundsOnPaddle(this.board.leftPaddle);
            this.setVelocity(this.getUnitVector(this.vX, this.vY));
//            this.board.leftPlayer.updateScore();
        }
        else if (this.hitsRightPaddle())
        {
            this.x = this.board.rightPaddle.x - this.width;
            this.reboundsOnPaddle(this.board.rightPaddle);
            this.setVelocity(this.getUnitVector(this.vX, this.vY));
//            this.board.rightPlayer.updateScore();
        }
    }

    public void reboundsOnPaddle(Equipement paddle)
    {
        this.vX *= -1;
        this.vY = ((this.y + this.height / 2) - (paddle.y + paddle.height / 2)) / (paddle.height / 2);
    }
}
