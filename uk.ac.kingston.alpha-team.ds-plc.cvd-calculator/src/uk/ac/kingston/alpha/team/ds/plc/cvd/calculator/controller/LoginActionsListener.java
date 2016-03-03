/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.view.ApplicationViewer;

/**
 *
 * @author k1317897
 */
public class LoginActionsListener implements ActionListener{

    private ApplicationViewer frame; 
    
    public LoginActionsListener(ApplicationViewer frame) 
    {
     this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        if(command != null)
        {
         switch(command) 
         {
             case "Login":
                 
                 break;
             case "Clear":
                 
                 break;
             case "Back to Main Menu":
                 frame.exitLoginPanel();
                 break;
         }
        }
    }
    
}
