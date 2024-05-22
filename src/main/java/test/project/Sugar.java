/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

/**
 *
 * @author killu
 */
public class Sugar extends Ingredients {

    private int noOfSpoons ;
    private Color1 color = new Color1(255 , 255 , 255) ;
    private int volume = 0 ;
    
    public Sugar() {
        super("Sugar" , 20) ;
    }

    public Sugar(int noOfSpoons) {
        super("Sugar" , noOfSpoons * 20) ;
        this.noOfSpoons = noOfSpoons;
    }
    
    @Override
    public String getInfo()
    {
        return super.getInfo() + " number of spoons of sugar : " + this.noOfSpoons ;
    }

    public int getNoOfSpoons() {
        return noOfSpoons;
    }

    public void setNoOfSpoons(int noOfSpoons) {
        this.noOfSpoons = noOfSpoons;
    }

    public Color1 getColor() {
        return color;
    }

    

    public int getVolume() {
        return volume;
    }

    
    
    
    
}
