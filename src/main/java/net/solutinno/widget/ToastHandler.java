package net.solutinno.widget;

import android.content.Context;
import android.widget.Toast;

public class ToastHandler
{
    Context context;
    Toast toast;

    public ToastHandler(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Toast getToast() {
        return Toast.makeText(context, null, Toast.LENGTH_SHORT);
    }

    public Toast getToast(int resId, int duration) {
        Toast toast = getToast();
        toast.setText(resId);
        toast.setDuration(duration > Toast.LENGTH_SHORT ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        return toast;
    }

    public Toast getToast(CharSequence text, int duration) {
        Toast toast = getToast();
        toast.setText(text);
        toast.setDuration(duration > Toast.LENGTH_SHORT ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        return toast;
    }

    public void show(Toast toast) {
        cancel();
        toast.show();
        this.toast = toast;
    }

    public void cancel() {
        if (toast != null) toast.cancel();
        toast = null;
    }
}
