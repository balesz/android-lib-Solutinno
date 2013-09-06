package net.solutinno.util;

import com.google.common.io.ByteStreams;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkHelper
{
    public static byte[] downloadIntoByteArray(URL url) {
        if (url == null) return null;
        try {
            ByteArrayOutputStream outputStream = downloadIntoByteArrayOutputStream(url);
            return outputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String downloadIntoText(URL url) {
        if (url == null) return null;
        try {
            String result;
            ByteArrayOutputStream outputStream = downloadIntoByteArrayOutputStream(url);
            result = outputStream.toString("UTF-8");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ByteArrayOutputStream downloadIntoByteArrayOutputStream(URL url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteStreams.copy(url.openStream(), output);

        return output;
    }
}
