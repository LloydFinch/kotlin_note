package net.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpTools {

    public static byte[] doGet(String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(HttpConfig.CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(HttpConfig.READ_TIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    byte[] data = null;
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int len = -1;
                    byte[] buffer = new byte[128];
                    while ((len = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                    }
                    data = outputStream.toByteArray();

                    outputStream.close();
                    inputStream.close();

                    return data;
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
