package User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.stream.Collectors;

public class wikiapi {


    public static String returninfo(String usertext) {
        //Create the Scanner Object that we need
        final Scanner scanner = new Scanner(System.in);
        final String encoding = "UTF-8";
        boolean exit = false;

        //Run until exit =true
        while (!exit) {

            try {

                //Wait for user response
                System.out.println(usertext);
                System.out.println("\n\nType something that you want me to search on the internet...");

                String searchText = usertext + " wikipedia";
                System.out.println("Searching on the web....");

                //Search the google for Wikipedia Links
                Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).get();

                //Get the first link about Wikipedia
                String wikipediaURL = google.getElementsByTag("cite").get(0).text();
                wikipediaURL = wikipediaURL.replaceAll("\\s", "");
                wikipediaURL = wikipediaURL.replaceAll("›", "/");
                wikipediaURL = "https://en.wikipedia.org/wiki/"+usertext;

                //Use Wikipedia API to get JSON File
                String wikipediaApiJSON = "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
                        + URLEncoder.encode(wikipediaURL.substring(wikipediaURL.lastIndexOf("/") + 1), encoding);

                //Let's see what it found
                System.out.println(wikipediaURL);
                System.out.println("Json: " + wikipediaApiJSON);

                //"extract":" the summary of the article
                HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
                httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
                BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

                //Read line by line
                String responseSB = in.lines().collect(Collectors.joining());
                in.close();

                //Print the result for us to see
                //System.out.println(responseSB);
                String result = responseSB.split("extract\":\"")[1];

                String result3 = responseSB.split("\\.")[2] + ".";
                String result2 = responseSB.split("\\.")[1] + ".";
                result = result.split("\\.")[0] + ".";
//            System.out.println(result);
//            System.out.println(result2);
//            System.out.println(result3);
                result = result +result2 + result3;
                return result;


            } catch (Exception ex) {
                ex.printStackTrace();

            }

        }


        return encoding;
    }
}

