/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;



/**
 *
 * @author killu
 */
public class Milk extends Ingredients {
    private int  volume  ;
    private final Color1 color = new Color1(255 , 255 , 255) ;

    public Milk() {
        super("Milk" , 2) ;
    }

    public Milk(int volume) {
        super("Milk", 2);
        this.volume = volume;
        this.setCalories(volume * 2);
    }

    
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public Color1 getColor() {
        return color;
    }

    @Override
    public String getInfo()
    {
        return super.getInfo() + " volume : " + this.volume + " color : " + this.color ;
    }
    
}
