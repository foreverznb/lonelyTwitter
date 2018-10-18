package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;

import java.io.IOException;

public class ElasitcsearchTweetController {
    static JestDroidClient client=null;

    public static void addTweets(Tweet tweet){
        setClient();
        Index index = new Index.Builder(tweet)
                .index("ningbo-thursday")
                .type("tweet")
                .build();
        try{
            DocumentResult result = client.execute(index);
            if(result.isSucceed()){
                tweet.setTweetID(result.getId());
            }
        }catch(IOException e){}
    }

    public static void setClient(){
        if(client==null){
            DroidClientConfig config= new DroidClientConfig
                    .Builder("http://cmput301.softwareprocess.es:8080/")
                    .build();
            JestClientFactory factory=new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
    public static class AddTweetTask extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(Tweet... params){
            return null;
        }
    }
}
