package net.solutinno.util;

import android.util.Log;

public class LogHelper
{
    private static final String TAG = "SOLUTINNO-DEBUG";

    public static void DEBUG(String format, Object... args) {
        Log.d(TAG, String.format(format, args));
    }
}
