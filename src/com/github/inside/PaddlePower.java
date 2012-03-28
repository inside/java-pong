package com.github.inside;

class PaddlePower extends Projectile
{
    public Board board;
    public long initTime;
    public String side;

    public PaddlePower(Board board)
    {
        super(board);

        this.board = board;
    }

    public long getPowerInitTime()
    {
        return this.initTime;
    }
}
