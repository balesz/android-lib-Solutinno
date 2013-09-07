package net.solutinno.util;

import com.google.common.base.Strings;

public class StringHelper {

    public static boolean isNullOrEmpty(CharSequence value) {
        return value == null || Strings.isNullOrEmpty(value.toString());
    }

    public static String getStringFromCharSequence(CharSequence value) {
        return value == null ? null : value.toString();
    }

}
