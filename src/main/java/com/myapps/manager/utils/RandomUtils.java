package com.myapps.manager.utils;

import java.util.Random;

public class RandomUtils
{
    public static long generateRandomNumber(long min, long max)
    {
	Random random = new Random();
	return random.longs(min, max).findAny().getAsLong();
    }
}
