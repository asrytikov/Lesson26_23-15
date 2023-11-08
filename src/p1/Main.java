package p1;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.ya.ru");
        InputStream inputStream = url.openStream();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        //[схема:]спец часть[фрагмент]

        /*../../java/index.html
        http://docs.google.com/api/java/index.html#Socket()
        /java/index.html#Socket()*/

        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);


        String input = "alex:123456";
        Base64.Encoder encoder = Base64.getEncoder();
        String encoding = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoding);
        urlConnection.setRequestProperty("Autorization", "Basic " + encoding);
        urlConnection.connect();
    }
}