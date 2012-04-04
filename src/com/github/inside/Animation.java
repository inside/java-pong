package com.github.inside;

//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

// See http://gizma.com/easing/
// and http://robertpenner.com/easing/penner_chapter7_tweening.pdf
class Animation
{
//    public static ConcurrentHashMap<String, Object> animatedElements = new ConcurrentHashMap<String, Object>(8, 0.9f, 1);

    // time
    // begin
    // change in time (relative to begin)
    // duration
    public static double easeOutQuad(double t, double b, double c, double d)
    {
        t /= d;

        return -c * t * (t-2) + b;
    } 

//    public static void animate(int frameNumber)
//    {
//
//    }
}
