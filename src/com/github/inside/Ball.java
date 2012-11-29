package com.github.inside;

import java.awt.Color;
import com.github.inside.Config;

public class Ball extends Projectile
{
    public Ball(Board board)
    {
        super(board);

        this.speed  = Config.BALL_INITIAL_SPEED;
        this.width  = Config.BALL_INITIAL_WIDTH;
        this.height = Config.BALL_INITIAL_HEIGHT;
        this.color  = Color.BLACK;
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
            this.board.leftPlayer.updateScore();
            this.board.leftPlayer.updateScoreDelta(this.board.rightPlayer.score);
            this.board.rightPlayer.updateScoreDelta(this.board.leftPlayer.score);
            this.board.leftPlayer.setText();
            this.board.rightPlayer.setText();
        }
        else if (this.hitsRightPaddle())
        {
            this.x = this.board.rightPaddle.x - this.width;
            this.reboundsOnPaddle(this.board.rightPaddle);
            this.setVelocity(this.getUnitVector(this.vX, this.vY));
            this.board.rightPlayer.updateScore();
            this.board.rightPlayer.updateScoreDelta(this.board.leftPlayer.score);
            this.board.leftPlayer.updateScoreDelta(this.board.rightPlayer.score);
            this.board.leftPlayer.setText();
            this.board.rightPlayer.setText();
        }
    }

    public void reboundsOnPaddle(Equipement paddle)
    {
        this.vX *= -1;
        this.vY = ((this.y + this.height / 2) - (paddle.y + paddle.height / 2)) / (paddle.height / 2);
    }
}
