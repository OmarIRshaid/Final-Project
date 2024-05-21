/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

/**
 *
 * @author killu
 */
public class Cup {
    private int capacity ;
    private double calories ;

    public Cup(int capacity) {
        this.capacity = capacity ;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    
    
    public double getCapacity() {
        return capacity;
    }

    public double getCalories() {
        return calories;
    }

    public String getInfo()
    {
        return "size : " + this.capacity + " calories : " + this.calories ;
    }
    
}
