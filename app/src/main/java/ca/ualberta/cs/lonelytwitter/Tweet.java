package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    //Empty argument constructor with default values


    public String getMessage() {
        return this.message;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() { return this.date; }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return this.date.toString()+"|"+this.message;
    }
}
