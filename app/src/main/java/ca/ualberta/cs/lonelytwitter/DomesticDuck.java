package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * The type Domestic duck.
 */
public class DomesticDuck extends Animal implements FlyingBehaviour{
    /**
     * Instantiates a new Domestic duck.
     *
     * @param type the type
     * @param food the food
     */
    public DomesticDuck(String type,String food){
        super(type,food);

    }
    public void swim(){
        Log.d("cmput-301","Yeah, I love to swim");

    }

    public void doesLikeFlying(){
        Log.d("chowdhury", "No, I fly only when a cat attacks me");
    }
}
