package net.solutinno.util;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class DisplayHelper
{
    public static DisplayMetrics getDisplayMetrics(Context context) {
        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics result = new DisplayMetrics();
        display.getMetrics(result);
        return result;
    }

    public static int getScreenRotation(Context context) {

        final Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        boolean isPortrait = metrics.widthPixels < metrics.heightPixels;

        switch (display.getRotation()) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_90:
                return isPortrait ? ActivityInfo.SCREEN_ORIENTATION_PORTRAIT : ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
            case Surface.ROTATION_180:
            case Surface.ROTATION_270:
                return isPortrait ? ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT : ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            default:
                return ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
        }
    }
}
