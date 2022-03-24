package nlp;



import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.HttpResponse;
import java.util.Arrays;

public class SpellCheck {
    static String str = "this iss sparta!!!";
    static String host = "https://spellcheck-tokenization-wordbreak.p.rapidapi.com/v1/spellcheck?str=";
    static Arrays s;
//    static String charset = "UTF-8";
//
//    static String query;
//
//    static {
//        try {
//            query = String.format("s=%s",URLEncoder.encode(s, charset));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.get(host + str)
                .header("X-RapidAPI-Host", "spellcheck-tokenization-wordbreak.p.rapidapi.com")
                .header("X-RapidAPI-Key", "0ed8cf5c0dmsha7fcae6f8ed1076p10cd87jsn35150723b6cc")
                .asString();

        //Prettifying
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonParser jp = new JsonParser();
//        JsonElement je = jp.parse(response.getBody().toString());
//        String prettyJsonString = gson.toJson(je);
//        System.out.println(prettyJsonString);


//
//        JsonParser parse = new JsonParser();
//        JsonObject inter = new JsonObject();

//        System.out.println(response.getHeaders().get("suggestions"));
        System.out.println(response.getBody());
        }
    }

