/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package test.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author killu
 */
public class Project {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in) ;
        
        ArrayList <Fruits> fruits = new ArrayList <>() ;
        fruits.add(new Fruits("banana" , 110 , new Color1(255 , 235 , 109) , 130)) ;
        fruits.add(new Fruits("apple" , 95 , new Color1(255 , 0 , 0) , 187)) ;
        fruits.add(new Fruits("Orange" , 60 , new Color1(255 , 165 , 0) , 217)) ;
        fruits.add(new Fruits("slice of Pineapple" , 50 , new Color1(255 , 200 , 50) , 87)) ;
        fruits.add(new Fruits("slice of Watermelon" , 46 , new Color1(242 , 60 , 78) , 200)) ;
        
        System.out.print("whats the size of the blender ? ");
        int choicee = in.nextInt();
        Blender blender = new Blender(choicee , new FileLogger("log.log")) ;
        
        int choice ;
        do{
            System.out.print("1- add ingredients\n2- blend\n3- pour into a cup\n4- done\nyour choice : ");
            choice = in.nextInt() ;
            switch(choice)
            {
                case 1 : 
                    int choice1 ;
                    do{
                        System.out.print("choose ingredient : \n1-milk\n2-sugar\n3-banana\n4-apple\n5-orange\n6-slice of pineapple\n7-slice of watermelon\n8-enough\nyour choice : ");
                        choice1 = in.nextInt();
                        switch(choice1)
                        {
                            case 1 :
                                System.out.print("how much milliliters? : ");
                                int volume = in.nextInt() ;
                                Milk milk = new Milk(volume) ;
                                try
                                {
                                    blender.addIngredients(milk);
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 2 :
                                System.out.print("number of spoons?? : ");
                                int spoons = in.nextInt();
                                Sugar sugar = new Sugar(spoons) ;
                                try
                                {
                                    blender.addIngredients(sugar);
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 3 :
                                try
                                {
                                    blender.addIngredients(fruits.get(0));
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 4 : 
                                try
                                { 
                                    blender.addIngredients(fruits.get(1));
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 5 :
                                try
                                {
                                    blender.addIngredients(fruits.get(2));
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 6 :
                                try
                                {
                                    blender.addIngredients(fruits.get(3));
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 7 :
                                try
                                {
                                    blender.addIngredients(fruits.get(4));
                                }
                                catch(BlenderOverflowException ex)
                                {
                                    System.out.println(ex.getMessage());
                                }
                                break ;
                            case 8 :
                                break ;
                        }
                    }while(choice1 != 8);
                    break ;
                case 2 :    
                    blender.blend();
                    break ;
                case 3 : 
                        System.out.print("Choose a size of the Cup :\n1- 100 ml\n2- 200 ml\n3- 300 ml\nyour choice : ");
                        int choice2 = in.nextInt();
                        Cup cup = new Cup(choice2) ;
                        try
                        {
                            cup = blender.pour(cup);
                        }
                        catch(BlenderEmptyException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                        System.out.println("the calories in the cup = " + (int)cup.getCalories());
                        break ;
                case 4 : 
                    break ;
            }
        }while(choice != 4);
        
        
    }
}
