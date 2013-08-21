package net.solutinno.widget;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import net.solutinno.util.DisplayHelper;

public class ToastHintProvider implements View.OnLongClickListener
{
    private final ToastHandler toastHandler;

    private OnGetToastHint onGetToastHint;

    public ToastHintProvider(ToastHandler toastHandler) {
        this.toastHandler = toastHandler;
    }

    public void setOnGetToastHint(OnGetToastHint onGetToastHint) {
        this.onGetToastHint = onGetToastHint;
    }

    private Integer onGetToastHint(View view) {
        if (onGetToastHint == null) return null;
        return onGetToastHint.getHint(view);
    }

    @Override
    public boolean onLongClick(View view) {
        Integer hint = onGetToastHint(view);
        if (hint == null) return false;

        int[] loc = new int[2];
        view.getLocationInWindow(loc);
        DisplayMetrics metrics = DisplayHelper.getDisplayMetrics(view.getContext());

        Toast toast = toastHandler.getToast(hint, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.RIGHT|Gravity.TOP, metrics.widthPixels-loc[0], loc[1]);
        toastHandler.show(toast);

        return true;
    }

    public static interface OnGetToastHint
    {
        Integer getHint(View view);
    }
}
