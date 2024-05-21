/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

/**
 *
 * @author killu
 */
public class BlenderEmptyException extends Exception {
    @Override
    public String getMessage()
    {
        return "not enough volume in the blender to fill the cup!!" ;
    }
}
