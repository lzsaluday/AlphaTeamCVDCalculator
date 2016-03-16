/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller;

import java.io.File;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CSVPatient;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model.CVDRisk;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils.Database;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.ApplicationViewer;

/**
 *
 * @author k1317897
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Connect to db.
        Database.establishConnection();
        //Initiate app with viewer.
        ApplicationViewer appViewer = new ApplicationViewer();    
        
    }
    
}
