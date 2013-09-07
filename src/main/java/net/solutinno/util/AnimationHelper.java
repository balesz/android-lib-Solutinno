package net.solutinno.util;

import android.view.View;

import com.nineoldandroids.view.ViewPropertyAnimator;

public class AnimationHelper
{
    public static ViewPropertyAnimator fadeOut(View view, long duration) {
        return ViewPropertyAnimator.animate(view)
            .setDuration(duration)
            .alpha(0);
    }

    public static ViewPropertyAnimator fadeIn(View view, long duration) {
        return ViewPropertyAnimator.animate(view)
            .setDuration(duration)
            .alpha(1);
    }
}
