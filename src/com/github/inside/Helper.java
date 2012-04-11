package com.github.inside;

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;
import java.io.File;

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

    public static String[] getPowerList()
    {
        File directory = new File("src"
                + File.separator
                + "com"
                + File.separator
                + "github"
                + File.separator
                + "inside"
                + File.separator
                + "powers");
        File[] files = directory.listFiles();
        String[] powers = new String[files.length];

        for (int i = 0; i < files.length; i++)
        {
            powers[i] = files[i]
                .toString()
                .substring(4)
                .replaceFirst("\\.java$", "")
                .replaceAll(File.separator, ".");
        }

        return powers;
    }
}
