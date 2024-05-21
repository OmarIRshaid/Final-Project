/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

/**
 *
 * @author killu
 */
public class Fruits extends Ingredients {
    private int volume ;
    private Color1 color ;

    public Fruits() {
        
    }
    
    
    public Fruits(String name , double calories , Color1 color , int volume)
    {
        super(name , calories) ;
        this.color = color ;
        this.volume = volume ;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Color1 getColor() {
        return color;
    }

    public void setColor(Color1 color) {
        this.color = color;
    }
    
    @Override
    public String getInfo()
    {
        return super.getInfo() + " volume : " +this.volume + " color : " + this.color ;
    }
    
}
