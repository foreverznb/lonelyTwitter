package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Represents a Tweet
 *
 * @author ningbo
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public class ImportantTweet extends Tweet {

    //Empty argument constructor with default values


    @Override
    public Boolean isImportant() {
        return true;
    }
}
