package net.solutinno.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class PackageHelper
{
    public static String getPackageVersionName(Context context) {
        PackageInfo info = getPackageInfo(context);
        return info == null ? null : info.versionName;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) return null;
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0);
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
