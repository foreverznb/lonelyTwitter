package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import io.searchbox.annotations.JestId;

/**
 * Represents a Tweet
 *
 * @author ningbo
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet {


    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    @JestId
    private String tweetID;


    /**
     * Constructs Tweet objects
     *
     * @param message tweet message
     * @param date    tweet date
     * @return the message
     */
//Empty argument constructor with default values


    public String getMessage() {
        return this.message;
    }

    /**
     * Set date.
     *
     * @param date the date
     */
    public void setDate(Date date){
        this.date = date;
    }


    /**
     * Sets tweet messages
     *
     * @param message Tweet message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() { return this.date; }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
//No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return this.date.toString()+"|"+this.message;
    }
}
