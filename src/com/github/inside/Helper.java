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
        String[] powers = new String[12];
        powers[0] = "com.github.inside.powers.LargePaddlePower";
        powers[1] = "com.github.inside.powers.OpponentsLargePaddlePower";
        powers[2] = "com.github.inside.powers.OpponentsPaddleImmobilityPower";
        powers[3] = "com.github.inside.powers.OpponentsPaddleInvisibilityPower";
        powers[4] = "com.github.inside.powers.OpponentsPaddleSlownessPower";
        powers[5] = "com.github.inside.powers.OpponentsPaddleSpeedPower";
        powers[6] = "com.github.inside.powers.OpponentsSmallPaddlePower";
        powers[7] = "com.github.inside.powers.PaddleImmobilityPower";
        powers[8] = "com.github.inside.powers.PaddleInvisibilityPower";
        powers[9] = "com.github.inside.powers.PaddleSlownessPower";
        powers[10] = "com.github.inside.powers.PaddleSpeedPower";
        powers[11] = "com.github.inside.powers.SmallPaddlePower";

        return powers;
    }

}
