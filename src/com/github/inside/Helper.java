package com.github.inside;

import java.lang.Integer;

class Helper
{
    public static int getRandomFromRange(int min, int max)
    {
        return min + (int) Math.round(Math.random() * (max - min));
    }

    public static String getWeightedRandomValue(WeightedValue[] weightedValues)
    {
        int weightSum = 0;
        int limit = 0;
        int random;

        for (int i = 0; i < weightedValues.length; i++)
        {
            weightSum += weightedValues[i].weight;
        }

        random = Helper.getRandomFromRange(0, weightSum);

        int i = 0;

        for (; i < weightedValues.length; i++)
        {
            limit += weightedValues[i].weight;

            if (limit >= random)
            {
                break;
            }
        }

        return weightedValues[i].name;
    }
}
