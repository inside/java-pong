package com.github.inside;

import com.github.inside.Projectile;
import com.github.inside.Board;
import com.github.inside.Config;
import com.github.inside.PowerTimer;

public abstract class PaddlePower extends Projectile
{
    public Board board;
    public long initTime;
    public String side;
    public String name;

    public PaddlePower(Board board)
    {
        super(board);

        this.board  = board;
        this.speed  = Config.POWER_PROJECTILE_INITIAL_SPEED;
        this.width  = Config.POWER_PROJECTILE_INITIAL_WIDTH;
        this.height = Config.POWER_PROJECTILE_INITIAL_HEIGHT;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public long getInitTime()
    {
        return this.initTime;
    }

    public long getLifeTime()
    {
        return Config.POWER_LIFETIME;
    }

    public void start(String side, PaddlePower power)
    {
        this.side = side;
        this.diesNow = true;
        this.initTime = Board.currentTime;

        if (this.side.equals("left"))
        {
            PowerTimer.leftPaddlePowers.put(power.getClass().getName(), power);
        }
        // Right side
        else
        {
            PowerTimer.rightPaddlePowers.put(power.getClass().getName(), power);
        }

        System.out.println(this.side + " player caught a power: \"" + this.getName() + "\"");
    }

    public abstract void end();
}
