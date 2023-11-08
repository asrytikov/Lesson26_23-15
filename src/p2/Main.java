package p2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try{
            String urlName = "http://pravo.gov.ru/";
            URL url = new URL(urlName);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()){
                String key = entry.getKey();
                for(String value: entry.getValue()){
                    System.out.println(key + ": " + value);
                }
            }
            System.out.println("-----------------");
            System.out.println("getContentType: " + urlConnection.getContentType());
            System.out.println("getContentLength: " + urlConnection.getContentLength());
            System.out.println("getContentEncoding: " + urlConnection.getContentEncoding());
            System.out.println("getDate:" + urlConnection.getDate());
            System.out.println("------------------");

            String enc = urlConnection.getContentEncoding();
            if (enc==null) enc = "UTF-8";
            try(Scanner scanner = new Scanner(urlConnection.getInputStream(), enc)){
                for(int n=1; scanner.hasNextLine() && n<=10; n++){
                    System.out.println(scanner.nextLine());
                }
                if (scanner.hasNextLine()) System.out.println(".........");
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
