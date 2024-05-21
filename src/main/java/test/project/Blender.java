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
    private double calories ;
    private int volume ;
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
        this.calories = 0 ;
        for(Ingredients s : ingredients)
        {
            this.calories += s.getCalories() ;
        }
        
        
        
        if(!ingredients.isEmpty())
        {
            if(ingredients.get(0) instanceof Fruits)
            {
                Fruits fruit = (Fruits) ingredients.get(0);
                int red = fruit.getColor().getRed();
                int green = fruit.getColor().getGreen();
                int blue = fruit.getColor().getBlue() ;
                Color1 test = new Color1(red , green, blue);
                this.color = test;
                this.volume = fruit.getVolume();
            }
            else if(ingredients.get(0) instanceof Milk )
            {
                Milk milk = (Milk) ingredients.get(0);
                int red = milk.getColor().getRed();
                int green = milk.getColor().getGreen();
                int blue = milk.getColor().getBlue() ;
                Color1 test = new Color1(red , green, blue);
                this.color = test;
                this.volume = milk.getVolume();
            }
            else 
            {
                Sugar sugar = (Sugar) ingredients.get(0) ;
                int red = sugar.getColor().getRed();
                int green = sugar.getColor().getGreen();
                int blue = sugar.getColor().getBlue() ;
                Color1 test = new Color1(red , green, blue);
                this.color = test;
                this.volume = sugar.getVolume();
            }
            this.logger.log("Made a Cocktail\n");
        }
        
        for(int i = 1 ; i < ingredients.size() ; i++)
        {
            if(ingredients.get(i) instanceof Fruits)
            {
                Fruits fruit = (Fruits) ingredients.get(i);
                this.color.mixColor(fruit.getColor(), fruit.getVolume(), this.volume);
                this.volume += fruit.getVolume() ;
            }
            else if(ingredients.get(i) instanceof Milk)
            {
                Milk milk = (Milk) ingredients.get(i);
                this.color.mixColor(milk.getColor(), milk.getVolume(), this.volume);
                this.volume += milk.getVolume();
            }
            else 
            {
                Sugar sugar = (Sugar) ingredients.get(i) ;
                this.color.mixColor(sugar.getColor(), sugar.getVolume() , this.volume);
                this.volume += sugar.getVolume();
            }
        }
        
        
        
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
        
        String ingredients = "" ;
        for(Ingredients d : this.ingredients)
        {
            ingredients += d.getName() ;
            ingredients += " " ;
        }
        //return "size : " + this.capacity + " Ingredients : " + ingredients ;
        String info = "The Final color is : " + this.color.getRed() + " , " + this.color.getGreen() + " , " + this.color.getBlue();
        info += "\nTotal Calories is :  " + (int)this.calories;
        info += "\nThe Volume of the Cocktail is : " + this.volume;
        return info ;
    }

    
}
