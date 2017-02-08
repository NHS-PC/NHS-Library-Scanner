package com.example.nhs.libraryscanner;

/**
 * Created by robotics on 2/8/17.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
public class DataReader {


    private String downloadUrl() throws IOException {
        InputStream is = null;
        try {
            URL spreadSheetURL = new URL("https://docs.google.com/spreadsheets/d/1IC_vR41TsWR7b4Umjf9XfHgTGcXk4KElta64dvRYI30/pubhtml");
            HttpURLConnection httpConnection = (HttpURLConnection) spreadSheetURL.openConnection();
            httpConnection.setReadTimeout(10000);
            httpConnection.setConnectTimeout(15000);
            httpConnection.setRequestMethod("GET");
            httpConnection.setDoInput(true);
            httpConnection.connect();
            is = httpConnection.getInputStream();
            System.out.println("DEBUG: output " + getText(is));
            return getText(is);
        } finally {
            if (is != null) is.close();
        }
    }

    /**
     * Continued process to obtain makefile
     * @param stream Object for the input stream which we will get text from
     * @return String with the text we want from the makefile
     * @throws IOException
     */
    public String getText(InputStream stream) throws IOException {
        Reader reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[100]; // Should be enough to get first few lines of Makefile
        reader.read(buffer);
        return new String(buffer);
    }
}
