
package ca.ualberta.cs.lonelytwitter;

        import java.util.Date;
        import java.text.DateFormat;
        import java.text.SimpleDateFormat;

/**
 * Created by caochenlin on 2018-01-16.
 */
public abstract class Mood {

    /**
     * The Date.
     */
    public Date date;

    /**
     * Gets date.
     *
     * @return the date
     */
    public abstract Date getDate();

    /**
     * Sets date.
     *
     * @param date_value the date value
     */
    public abstract void setDate(Date date_value);


}

/**
 * The type Happy.
 */
class Happy extends Mood {

    public Date getDate(){
        return date;
    }

    public void setDate(Date date_value) {
        this.date = date_value;
    }

    /**
     * Instantiates a new Happy.
     *
     * @param date the date
     */
    public Happy(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
    }

    /**
     * Express happy.
     */
    public void express_happy() {
        String happiness = "I am feelling happy!";
        System.out.println(happiness);
    }

}

/**
 * The type Sad.
 */
class Sad extends Mood {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date_value){
        this.date = date_value;
    }

    /**
     * Instantiates a new Sad.
     *
     * @param date the date
     */
    public Sad(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
    }

    /**
     * Express sad.
     */
    public void express_sad() {
        String sadness = "I am feeling very sad!";
        System.out.println(sadness);
    }
}