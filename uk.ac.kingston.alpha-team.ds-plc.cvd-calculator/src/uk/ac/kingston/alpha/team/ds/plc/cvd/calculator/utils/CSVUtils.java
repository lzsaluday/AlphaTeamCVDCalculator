/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CSVPatient;

/**
 *
 * @author k1357811
 */
public class CSVUtils 
{
    public static int getNumberOfPatients(File[] selectedFiles)
    {
        int numberOfPatients = 0;
        
        for(File f: selectedFiles)
        {
            BufferedReader br;
            try
            {
                br = new BufferedReader(new FileReader(f));
                
                String firstLine = br.readLine(); //read and ignore firstline.
                String nextLine;
                
                while((nextLine = br.readLine()) != null)
                {
                    numberOfPatients++;
                }
            }
            catch(Exception e)
            {
                System.err.println("getNumberOfPatients:: error with file "
                        + f + ": " + e.getMessage());
            }
        }
        
        return numberOfPatients;
    }
    
    public static CSVPatient[] getPatientsFromFile(File[] selectedFiles, int numberOfPatients)
    {
        final int MAX_PATIENTS = numberOfPatients;
        CSVPatient[] patients = new CSVPatient[MAX_PATIENTS];
        int i = 0;
        
        for(File f: selectedFiles)
        {
            BufferedReader br;
            try 
            {
                br = new BufferedReader(new FileReader(f));
                
                String firstLine = br.readLine(); //read and ignore firstline.
                String nextLine;
                
                while((nextLine = br.readLine()) != null && i < MAX_PATIENTS)
                {
                    CSVPatient p = new CSVPatient(nextLine);
                    
                    patients[i] = p;
                    
                    i++;
                }
            } 
            catch (Exception e) 
            {
                System.err.println("calculateRiskFromFile:: error with file "
                        + f + ": " + e.getMessage());
            }
        }
        return patients;
    }
    
    public static void saveResult(File filename, int cvdResult)
    {
        
    }
}
