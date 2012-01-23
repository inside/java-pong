package com.github.inside;

public class Collision
{
    public static Boolean hoverlap(Equipement rectangle1, Equipement rectangle2)
    {
        return (rectangle1.x < rectangle2.x + rectangle2.width) && (rectangle2.x < rectangle1.x + rectangle1.width);
    }

    public static Boolean voverlap(Equipement rectangle1, Equipement rectangle2)
    {
        return (rectangle1.y < rectangle2.y + rectangle2.height) && (rectangle2.y < rectangle1.y + rectangle1.height);
    }

    public static Boolean overlap(Equipement rectangle1, Equipement rectangle2)
    {
        return Collision.hoverlap(rectangle1, rectangle2) && Collision.voverlap(rectangle1, rectangle2);
    }
}
