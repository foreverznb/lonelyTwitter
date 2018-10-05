package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * The type Animal.
 */
public abstract class Animal {
    /**
     * The Type.
     */
    protected String type;
    /**
     * The Food.
     */
    protected String food;

    /**
     * Instantiates a new Animal.
     *
     * @param type the type
     * @param food the food
     */
    public Animal(String type, String food){
        this.type=type;
        this.food=food;

    }

    /**
     * Set type.
     *
     * @param type the type
     */
    public void setType(String type){
        this.type=type ;
    }

    /**
     * Set food.
     *
     * @param food the food
     */
    public void setFood(String food){
        this.food=food ;
    }

    /**
     * Get type string.
     *
     * @return the string
     */
    public String getType(){
        return this.type;
    }

    /**
     * Get food string.
     *
     * @return the string
     */
    public String getFood(){
        return this.food;
    }

    /**
     * Swim.
     */
    public abstract void swim();

}
