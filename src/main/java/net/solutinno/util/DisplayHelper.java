package net.solutinno.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayHelper
{
    public static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager mgr = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = mgr.getDefaultDisplay();
        DisplayMetrics result = new DisplayMetrics();
        defaultDisplay.getMetrics(result);
        return result;
    }
}
