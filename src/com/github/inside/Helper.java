package com.github.inside;

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

public class Helper
{
    public static int getRandomFromRange(int min, int max)
    {
        return min + (int) Math.round(Math.random() * (max - min));
    }

    public static String getWeightedRandomValue(HashMap<String, Integer> weightedValues)
    {
        int weightSum = 0;
        int limit = 0;
        int random;
        String key = "com.github.inside.Ball";

        for (int value : weightedValues.values())
        {
            weightSum += value;
        }

        random = Helper.getRandomFromRange(0, weightSum);

        for (Map.Entry<String, Integer> weightedValue : weightedValues.entrySet())
        {
            limit += weightedValue.getValue();

            if (limit >= random)
            {
                key = weightedValue.getKey();
                break;
            }
        }

        return key;
    }
}
