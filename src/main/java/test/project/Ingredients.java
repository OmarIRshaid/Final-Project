/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

/**
 *
 * @author killu
 */
public abstract class Ingredients {
    private String name ;
    private double calories ;
    
    public Ingredients()
    {
        
    }
    
    public Ingredients(String name , double calories)
    {
        this.name = name ;
        this.calories = calories ;
    }
    
    public void setName(String name)
    {
        this.name = name ;
    }
    
    public String getName()
    {
        return this.name ;
    }
    
    public void setCalories(double calories)
    {
        this.calories = calories ;
    }
    
    public double getCalories()
    {
        return this.calories ;
    }
    
    public  String getInfo()
    {
        return "name : " + this.name + "calories : " + this.calories ;
    }
}
