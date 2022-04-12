package User;

import javax.imageio.ImageIO;
import javax.json.JsonException;
import javax.net.ssl.HttpsURLConnection;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flickr{

    static final String BASE_URl = "https://api.flickr.com/services/rest";
    static final String API_KEY  = "381d45767e18dc7d1aec65050381897f";
    static final boolean flag = false;
    //static final String TAG = "WebServidesFunTag";

    public static String FetchDesiredPhoto(String TAG){
        String url= ConstructURL(TAG);
        FetchDesiredPhotoList task = new FetchDesiredPhotoList();
        //String imgURL = FetchDesiredPhotoList.ConstructPhotoURL();

        BufferedImageGetter.BufferedImage(task.find(url));
        return task.find(url);
        //return task.find(url) ;

    }
    public static String ConstructURL(String TAG){
        String url = BASE_URl;
        url +="?method=flickr.photos.search";
        url+= "&api_key=" + API_KEY;
        url+= "&tags="+ TAG;
        url+= "&per_page=2";
        url+= "&format=json";
        url+= "&nojsoncallback=1";
        System.out.println(url);
        return url;

    }

static class FetchDesiredPhotoList {
    private static String server_ID;
    private static String photoID;
    private static String secret;
    static final String BasePhotoURL="https://live.staticflickr.com/";

    public String find(String url) {
        List<DesiredPhoto> desiredPhotoList = new ArrayList<>();

        try {
            URL urlObject = new URL(url);
            HttpsURLConnection httpcon = (HttpsURLConnection) new URL(url).openConnection();
            //successfully opened url over https
            //attempt to read json
            httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String responseSB = in.lines().collect(Collectors.joining());
            in.close();
          //  JSONObject jsonObject = new JSONObject(responseSB);
            System.out.println(responseSB);
            String result = responseSB.split("id\":\"")[1];
            System.out.println("Result:"+ result);

            photoID= result.split("\"")[0];

            secret = result.split("secret\":\"")[1];
            secret= secret.split("\"")[0];

            server_ID = result.split("server\":\"")[1];
            server_ID= server_ID.split("\"")[0];

            System.out.println("photo ID: "+ photoID);
            System.out.println("Secret: "+ secret);
            System.out.println("Server: "+ server_ID);
           // return result;
            String imgurl = BasePhotoURL;
            imgurl += server_ID+ "/";
            imgurl+= photoID +"_";
            imgurl+= secret+"_";
            imgurl+= "w.jpg";
            System.out.println(imgurl);
            return imgurl;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonException e) {
            e.printStackTrace();
        }


        return url;
    }



    /*
    public static String ConstructPhotoURL(){
        // "https://live.staticflickr.com/{server-id}/{id}_{secret}_{size-suffix}.jpg"
        String url = BasePhotoURL;
        url += server_ID+ "/";
        url+= photoID +"_";
        url+= secret+"_";
        url+= "w.jpg";
        return url;
    }

     */
}



static class BufferedImageGetter {

        public static BufferedImage BufferedImage(String url) {
                try {
                    System.out.println("buffered image getter:"+ url);
                    BufferedImage bi= ImageIO.read(new URL(url));
                    SaveImageFromUrl.main(url);

                    return bi;

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            return null;
        }
    }
    public static class SaveImageFromUrl {

        public static void main(String url) throws Exception {
            String imageUrl = url;
            System.out.println("Save from url "+ url);
            String destinationFile = "C:\\Users\\aidan\\Documents\\imagetestcalendar.jpg";

            saveImage(imageUrl, destinationFile);
        }

        public static void saveImage(String imageUrl, String destinationFile) throws IOException {
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        }

    }
}
