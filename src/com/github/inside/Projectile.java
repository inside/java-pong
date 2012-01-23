package com.github.inside;

import com.github.inside.Config;
import com.github.inside.Vector;
import com.github.inside.Collision;
import java.lang.Math;

public class Projectile extends Equipement
{
    long creationTime, // milliseconds timestamp
         diesIn   = 0,
         lifeTime = Config.PROJECTILES_DEFAULT_LIFETIME;
    double vX,
           vY;
    boolean diesNow = false;

    public Projectile(Board board)
    {
        super(board);
        this.creationTime = System.currentTimeMillis();
        this.diesIn = this.creationTime + this.lifeTime;
    }

    public void resetPosition()
    {
        System.out.println("Calling resetPosition from Projectile.java");
        this.x = (Config.BOARD_WIDTH / 2) - (this.width / 2);
        this.y = (Config.BOARD_HEIGHT / 2) - (this.height / 2);
        this.setVelocity(this.getInitialUnitVector());

        System.out.println("this.width: " + this.width);
        System.out.println("this.height: " + this.height);

        System.out.println("Config.BOARD_WIDTH: " + Config.BOARD_WIDTH);
        System.out.println("Config.BOARD_HEIGHT: " + Config.BOARD_HEIGHT);

        System.out.println("x: " + this.x);
        System.out.println("y: " + this.y);
    }

    public void setVelocity(Vector vector)
    {
        this.vX = vector.cartesian(0);
        this.vY = vector.cartesian(1);
    }

    public Vector getInitialUnitVector()
    {
        // random between 0.0 and 1.0 with one digit after the decimal point
        double y = (double) (Math.round(Math.random() * 10)) / 10.0,
               x = 1;
        
//        y = 0.6;

        System.out.println("y from getInitialUnitVector: " + y);
    
        // 50% of the time, go downwards
        if (Math.round(Math.random()) == 0)
        {
            y *= -1;
        }
        if (Math.round(Math.random()) == 0)
        {
            x *= -1;
        }

        return new Vector(new double[] {x, y}).direction();
    }

    public Vector getUnitVector(double x, double y)
    {
        return new Vector(new double[] {x, y}).direction();
    }

    public boolean isLiving(int currentTime)
    {
        if (this.diesNow)
        {
            return false;
        }
        else if (this.lifeTime <= 0)
        {
            return true;
        }

        return this.diesIn >= currentTime;
    }

    public Boolean hitsLeftWall()
    {
        return this.x <= 0;
    }

    public Boolean hitsRightWall()
    {
        return this.x >= Config.BOARD_WIDTH - this.width;
    }

    public Boolean hitsFloor()
    {
        return this.y >= Config.BOARD_HEIGHT - this.height;
    }

    public Boolean hitsCeiling()
    {
        return this.y <= 0;
    }

    /*
    public Boolean hitsLeftPaddle()
    {
        return Collision.overlap(this, this.board.leftPaddle);
    }

    public Boolean hitsRightPaddle()
    {
        return Collision.overlap(this, this.board.rightPaddle);
    }
    */

    public void updateForNewFrame()
    {
        this.x += this.vX * this.speed * this.board.time;
        this.y += this.vY * this.speed * this.board.time;
        System.out.println("this.vX :" + this.vX);
        System.out.println("this.vY :" + this.vY);
        System.out.println("this.speed :" + this.speed);
        System.out.println("this.board.time :" + this.board.time);

        if (this.hitsLeftWall())
        {
            this.vX *= -1;
            this.x = 0;
        }
        else if (this.hitsRightWall())
        {
            this.vX *= -1;
            this.x = Config.BOARD_WIDTH - this.width;
        }

        if (this.hitsCeiling())
        {
            this.vY *= -1;
            this.y = 0;
            this.setVelocity(this.getUnitVector(this.vX, this.vY));
        }
        else if (this.hitsFloor())
        {
            this.vY *= -1;
            this.y = Config.BOARD_HEIGHT - this.height;
            this.setVelocity(this.getUnitVector(this.vX, this.vY));
        }
//        System.out.println((int) Math.round(this.x));
//        System.out.println((int) Math.round(this.y));
    }
}
