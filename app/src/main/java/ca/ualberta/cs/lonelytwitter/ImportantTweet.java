package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

public class ImportantTweet extends Tweet {

    //Empty argument constructor with default values


    @Override
    public Boolean isImportant() {
        return true;
    }
}
