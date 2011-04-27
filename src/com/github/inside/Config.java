package com.github.inside;

class Config
{
    public static final short FRAME_RATE = 60; // 30 to 100 images per second
    public static final short MAX_SCORE = 50;
    public static final short PONG_WIDTH = 500;
    public static final short PONG_HEIGHT = 250;

    public static final float PADDLE_INITIAL_SPEED = 0.2F;
    public static final float PADDLE_MIN_SPEED = 0.1F;
    public static final float PADDLE_MAX_SPEED = 0.5F;
    public static final short PADDLE_INITIAL_WIDTH = 6;
    public static final short PADDLE_INITIAL_HEIGHT = 60;
    public static final short PADDLE_MIN_HEIGHT = 30;
    public static final short PADDLE_MAX_HEIGHT = 90;

    public static final float BALL_INITIAL_SPEED = 0.2F;
    public static final short BALL_INITIAL_WIDTH = 10;
    public static final short BALL_INITIAL_HEIGHT = 10;

    public static final float POWER_PROJECTILE_INITIAL_SPEED = 0.05F;
    public static final short POWER_PROJECTILE_INITIAL_WIDTH = 10;
    public static final short POWER_PROJECTILE_INITIAL_HEIGHT = 10;

    public static final short POWER_LIFETIME = 10000; // milliseconds

    public static final short MAX_PROJECTILES = 10;
    public static final short PROJECTILES_DEFAULT_LIFETIME = 20000; // milliseconds
}
