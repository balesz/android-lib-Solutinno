package net.solutinno.util;

import android.graphics.Rect;
import android.view.View;

public class ViewHelper
{
    public static Rect getViewRectangle(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int left = location[0];
        int top = location[1];
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();

        return new Rect(left, top, left+width, top+height);
    }
}
