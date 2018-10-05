package ca.ualberta.cs.lonelytwitter;

/**
 * Represents a Tweet
 *
 * @author ningbo
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */
public class NormalTweet extends Tweet {

    @Override
    public Boolean isImportant() {
        return false;
    }
}
