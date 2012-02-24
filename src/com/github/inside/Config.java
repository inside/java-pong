package com.github.inside;

class Config
{
    public static final int FRAME_RATE = 60; // 30 to 100 images per second
    public static final int BOARD_CONTAINER_TOP_MARGIN = 50;
    public static final int BOARD_CONTAINER_RIGHT_MARGIN = 100;
    public static final int BOARD_CONTAINER_BOTTOM_MARGIN = 100;
    public static final int BOARD_CONTAINER_LEFT_MARGIN = 100;

    public static final int MAX_SCORE = 50;

    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 250;

    public static final double PADDLE_INITIAL_SPEED = 0.2;
    public static final double PADDLE_MIN_SPEED = 0.1;
    public static final double PADDLE_MAX_SPEED = 0.5;
    public static final int PADDLE_INITIAL_WIDTH = 6;
    public static final int PADDLE_INITIAL_HEIGHT = 60;
    public static final int PADDLE_MIN_HEIGHT = 30;
    public static final int PADDLE_MAX_HEIGHT = 90;

    public static final double BALL_INITIAL_SPEED = 0.2;
    public static final int BALL_INITIAL_WIDTH = 10;
    public static final int BALL_INITIAL_HEIGHT = 10;

    public static final double POWER_PROJECTILE_INITIAL_SPEED = 0.05;
    public static final int POWER_PROJECTILE_INITIAL_WIDTH = 10;
    public static final int POWER_PROJECTILE_INITIAL_HEIGHT = 10;

    public static final long POWER_LIFETIME = 10000; // milliseconds

    public static final int MAX_PROJECTILES = 10;
    public static final long PROJECTILES_DEFAULT_LIFETIME = 20000; // milliseconds
}
