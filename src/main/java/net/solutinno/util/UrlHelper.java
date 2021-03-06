package net.solutinno.util;

import android.util.Patterns;

import java.net.URL;

public class UrlHelper
{
    public static boolean isUrlValid(String url) {
        try { new URL(url); return Patterns.WEB_URL.matcher(url).matches(); } catch (Exception ex) { return false; }
    }

    public static URL getUrlFromString(String url) {
        if (!isUrlValid(url)) return null;
        try { return new URL(url); } catch (Exception ex) { return null; }
    }
}
