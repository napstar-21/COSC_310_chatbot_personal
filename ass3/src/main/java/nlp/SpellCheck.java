/*
package nlp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class SpellCheck {
    String testSentence = "thiss iss a test";
    public static void main(String[] args) {
        HttpResponse<String> response = Unirest.post("https://jspell-checker.p.rapidapi.com/check" + testSentence)
                .header("X-RapidAPI-Host", "jspell-checker.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0ed8cf5c0dmsha7fcae6f8ed1076p10cd87jsn35150723b6cc")
                .asJson();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();
                JsonElement je = jp.parse(response.getBody().toString());
                String prettyJsonString = gson.toJson(je);
                System.out.println(prettyJsonString);
                .asString();


        }
    }

}
*/