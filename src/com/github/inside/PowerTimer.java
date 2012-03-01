package com.github.inside;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.Long;

class PowerTimer
{
    // The parameters were set on the advice of:
    // http://ria101.wordpress.com/2011/12/12/concurrenthashmap-avoid-a-common-misuse/
    public static ConcurrentHashMap<String, Object> leftPaddlePowers = new ConcurrentHashMap<String, Object>(8, 0.9f, 1);
    public static ConcurrentHashMap<String, Object> rightPaddlePowers = new ConcurrentHashMap<String, Object>(8, 0.9f, 1);

    public static void handlePowerTimer()
    {
        if (PowerTimer.leftPaddlePowers.size() > 0)
        {
            for (Map.Entry<String, Object> e : PowerTimer.leftPaddlePowers.entrySet())
            {
                try
                {
                    Class<?> c = e.getValue().getClass();
                    Method getPowerInitTime = c.getDeclaredMethod("getPowerInitTime");
                    Method getCurrentTime = c.getDeclaredMethod("getCurrentTime");
                    long powerInitTime = Long.parseLong(getPowerInitTime.invoke(e.getValue()).toString());
                    long currentTime = Long.parseLong(getCurrentTime.invoke(e.getValue()).toString());

                    if (powerInitTime + Config.POWER_LIFETIME <= currentTime)
                    {
                        Method action = c.getDeclaredMethod("action");
                        action.invoke(e.getValue());
                        PowerTimer.leftPaddlePowers.remove(e.getKey());
                    }
                }
                catch (NoSuchMethodException x)
                {
                    System.out.println("NoSuchMethodException was catched");
                }
                catch (IllegalAccessException x)
                {
                    System.out.println("IllegalAccessException was catched");
                }
                catch (InvocationTargetException x)
                {
                    System.out.println("InvocationTargetException was catched");
                }
            }
        }
        if (PowerTimer.rightPaddlePowers.size() > 0)
        {
            for (Map.Entry<String, Object> e : PowerTimer.rightPaddlePowers.entrySet())
            {
                try
                {
                    Class<?> c = e.getValue().getClass();
                    Method getPowerInitTime = c.getDeclaredMethod("getPowerInitTime");
                    Method getCurrentTime = c.getDeclaredMethod("getCurrentTime");
                    long powerInitTime = Long.parseLong(getPowerInitTime.invoke(e.getValue()).toString());
                    long currentTime = Long.parseLong(getCurrentTime.invoke(e.getValue()).toString());

                    if (powerInitTime + Config.POWER_LIFETIME <= currentTime)
                    {
                        Method action = c.getDeclaredMethod("action");
                        action.invoke(e.getValue());
                        PowerTimer.rightPaddlePowers.remove(e.getKey());
                    }
                }
                catch (NoSuchMethodException x)
                {
                    System.out.println("NoSuchMethodException was catched");
                }
                catch (IllegalAccessException x)
                {
                    System.out.println("IllegalAccessException was catched");
                }
                catch (InvocationTargetException x)
                {
                    System.out.println("InvocationTargetException was catched");
                }
            }
        }
    }
}
