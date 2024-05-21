/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;
/**
 *
 * @author killu
 */
public class Color1 {
    private int red ;
    private int blue ;
    private int green ;

    public Color1(int red, int green, int blue) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    
    public void mixColor(Color1 color , int volume1 , int volume2)
    {
        this.red = (this.red * volume2 + color.red * volume1 ) / (volume1 + volume2) ;
        this.green = (this.green * volume2 + color.green * volume1 ) / (volume1 + volume2) ;
        this.blue = (this.blue * volume2 + color.blue * volume1 ) / (volume1 + volume2) ;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }
    
    
    
    
}
