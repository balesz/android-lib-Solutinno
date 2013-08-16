package net.solutinno.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamHelper
{
    public static String inputStreamToString(InputStream input, String charsetName) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte data[] = new byte[1024]; int count;
        while ((count = input.read(data)) != -1) output.write(data, 0, count);
        output.flush(); output.close(); input.close();
        return output.toString(charsetName);
    }
}
