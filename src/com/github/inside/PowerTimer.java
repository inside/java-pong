package com.github.inside;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.Long;

class PowerTimer
{
    public static HashMap<String, Object> leftPaddlePowers = new HashMap<String, Object>();
    public static HashMap<String, Object> rightPaddlePowers = new HashMap<String, Object>();

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
                    Method getStartTime = c.getDeclaredMethod("getStartTime");
                    long powerInitTime = Long.parseLong(getPowerInitTime.invoke(e.getValue()).toString());
                    long startTime = Long.parseLong(getStartTime.invoke(e.getValue()).toString());

                    if (powerInitTime + Config.POWER_LIFETIME <= startTime)
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
                    Method getStartTime = c.getDeclaredMethod("getStartTime");
                    long powerInitTime = Long.parseLong(getPowerInitTime.invoke(e.getValue()).toString());
                    long startTime = Long.parseLong(getStartTime.invoke(e.getValue()).toString());

                    if (powerInitTime + Config.POWER_LIFETIME <= startTime)
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
