package net.solutinno.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ToastValidationProvider
{
    Context context;

    OnValidate onValidate;

    ToastHandler toastHandler;

    public ToastValidationProvider(ToastHandler toastHandler) {
        this.toastHandler = toastHandler;
        this.context = toastHandler.getContext();
    }

    public boolean validate(View[] views) {
        for (View view : views) if(!validate(view)) return false;
        return true;
    }

    public boolean validate(View view) {
        Integer resId = onValidate(view);
        if (resId != null) {
            showNotification(view, resId);
            return false;
        }
        return true;
    }

    private void showNotification(View view, int resId) {
        view.requestFocus();
        int[] loc = new int[2]; view.getLocationOnScreen(loc);
        Toast toast = toastHandler.getToast(resId, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.START | Gravity.TOP, loc[0] + view.getWidth()/6, loc[1] - view.getHeight()/2);
        toast.setMargin(0, 0);
        toastHandler.show(toast);
    }

    private Integer onValidate(View view) {
        if (this.onValidate != null) return onValidate.validate(view);
        else return null;
    }

    public void setOnValidate(OnValidate onValidate) {
        this.onValidate = onValidate;
    }

    public static interface OnValidate {
        Integer validate(View view);
    }
}
