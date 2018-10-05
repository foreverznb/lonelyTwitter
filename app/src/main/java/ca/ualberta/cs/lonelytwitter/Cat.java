package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * The type Cat.
 */
public class Cat extends Animal{
    /**
     * Instantiates a new Cat.
     *
     * @param type the type
     * @param food the food
     */
    public Cat(String type, String food){
        super(type,food);

    }
    public void swim(){
        Log.d("cmput-301","Hey, I hate swimming");

    }
}
