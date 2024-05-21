/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;


import java.util.ArrayList;

/**
 *
 * @author killu
 */
public class Blender {
    private double capacity ;
    private ArrayList <Ingredients> ingredients = new ArrayList <>() ;
    private double calories = 0 ;
    private int volume = 0 ;
    private Color1 color = new Color1(0 , 0 , 0) ;
    private boolean blended = false ;
    private Logger logger ;

    public Blender(double capacity , Logger logger) {
        this.capacity = capacity;
        this.logger = logger ;
    }

    public void setBlended(boolean blended) {
        this.blended = blended;
    }

    public boolean isBlended() {
        return blended;
    }

    public Color1 getColor() {
        return color;
    }

    public double getCapacity() {
        return capacity;
    }
    
    
    
    
    
    public void addIngredients (Ingredients ingredient) throws BlenderOverflowException
    {
        if(ingredient instanceof Milk)
        {
           Milk milk = (Milk) ingredient ;
           if(this.capacity >= milk.getVolume())
           {
               ingredients.add(ingredient) ;
               this.capacity -= milk.getVolume() ;
               this.logger.log("adding milk\n");
           }
           else
           {
               throw new BlenderOverflowException() ;
           }
        }
        
        else if(ingredient instanceof Fruits)
        {
            Fruits fruit = (Fruits) ingredient ;
            if(this.capacity >= fruit.getVolume())
            {
               ingredients.add(ingredient) ;
               this.capacity -= fruit.getVolume() ;
               this.logger.log("adding fruit\n");
            }
            else
            {
               throw new BlenderOverflowException() ;
            }
        }
        
        else
        {
            ingredients.add(ingredient) ;
            this.logger.log("adding sugar\n");
        }
    }
    
    
    public void blend()
    {
        for(Ingredients s : ingredients)
        {
            this.calories += s.getCalories() ;
            if(s instanceof Fruits)
            {
                Fruits fruit = (Fruits) s;
                this.color.mixColor(fruit.getColor(), fruit.getVolume(), this.volume);
                this.volume += fruit.getVolume() ;
            }
            else if(s instanceof Milk)
            {
                Milk milk = (Milk) s;
                this.color.mixColor(milk.getColor(), milk.getVolume(), this.volume);
                this.volume += milk.getVolume();
            }
            else 
            {
                Sugar sugar = (Sugar) s ;
                this.color.mixColor(sugar.getColor(), sugar.getVolume() , this.volume);
            }
        }
        
        ingredients.clear();
        this.logger.log("Made a Cocktail\n");
        
    }
    
    public Cup pour(Cup cup) throws BlenderEmptyException
    {
        if(this.volume >= cup.getCapacity())
        {
                cup.setCalories((cup.getCapacity() / this.volume) * this.calories);
                this.calories = this.calories - ( (cup.getCapacity()  / this.volume) * this.calories) ;
                this.volume -= cup.getCapacity() ;
                this.capacity += cup.getCapacity() ;
                if(this.volume == 0)
                {
                    this.color = new Color1(0 , 0 , 0) ;
                }
                this.logger.log("Pouring into a cup\n");
        }
        else
        {
            throw new BlenderEmptyException() ;
        }
        return cup ;
    }
    
    public String getInfo()
    {
        String info = "The Final color is : " + this.color.getRed() + " , " + this.color.getGreen() + " , " + this.color.getBlue();
        info += "\nTotal Calories is :  " + (int)this.calories;
        info += "\nThe Volume of the Cocktail is : " + this.volume;
        return info ;
    }

    
}
