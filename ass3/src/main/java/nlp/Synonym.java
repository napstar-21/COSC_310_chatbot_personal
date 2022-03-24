package nlp;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

public class Synonym {

    public static void main(String[] args) throws UnirestException {
         String host = "https://wordsapiv1.p.rapidapi.com/words/";
         String query = "/synonyms";
        String word = "test";

//        HttpResponse<String> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/off/similarTo")
//                .header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
//                .header("X-RapidAPI-Key", "0ed8cf5c0dmsha7fcae6f8ed1076p10cd87jsn35150723b6cc")
//                .asString();


        HttpResponse<String> response2 = Unirest.get(host + word + query)
                .header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0ed8cf5c0dmsha7fcae6f8ed1076p10cd87jsn35150723b6cc")
                .asString();
        String output = response2.getBody();
        output = output.replace("{\"word\":\"test\",\"synonyms\":[","");
        output = output.replaceAll(",","");
        output = output.replaceAll("]}","");
//        System.out.println(output);
        String[] outputArray = output.split("\"");
        for (int i = 0; i < outputArray.length; i++){
            System.out.println(outputArray[i]);
        }
//        System.out.println(response2.getBody().contains("tryout"));
    }
}
