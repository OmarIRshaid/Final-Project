/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.project;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author killu
 */
public class FileLogger implements Logger {
    private String path ;
    public FileLogger(String path)
    {
        this.path = path ;
    }
    
    public void log(String log)
    {

        try {
            FileWriter fw = new FileWriter(path , true);
            fw.write(log);
            fw.close();
        } catch(FileNotFoundException ex)
        {
            System.out.println("file not found!!");
        }
        catch (IOException ex) {
            java.util.logging.Logger.getLogger(FileLogger.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }
    
}
