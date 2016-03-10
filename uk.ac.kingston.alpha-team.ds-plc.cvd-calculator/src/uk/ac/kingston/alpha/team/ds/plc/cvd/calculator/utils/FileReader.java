/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils;

import java.io.BufferedReader;
import java.io.File;

/**
 *
 * @author k1357811
 */
public class FileReader 
{
    public static void readList(String filename)
    {
        BufferedReader br;
        try 
        {
            br = new BufferedReader(new java.io.FileReader(new File(filename)));
            String firstLine = br.readLine();
//            if (firstLine.startsWith()) 
//            {            
//            }
            br.close();
        } 
        catch (Exception e) 
        {
            System.err.println("isValidHeader:: error with file "
                    + filename + ": " + e.getMessage());
        }
    }
}
