package com.github.inside;

class PaddlePower extends Projectile
{
    public Board board;
    public long initTime;
    public String side;

    public PaddlePower(Board board)
    {
        super(board);

        this.board  = board;
        this.speed  = Config.POWER_PROJECTILE_INITIAL_SPEED;
        this.width  = Config.POWER_PROJECTILE_INITIAL_WIDTH;
        this.height = Config.POWER_PROJECTILE_INITIAL_HEIGHT;
    }

    public long getPowerInitTime()
    {
        return this.initTime;
    }
}
