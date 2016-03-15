/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.utils;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author k1317897
 */
public class FileChooser extends JFileChooser
{
    private final FileNameExtensionFilter CSVFilter = new FileNameExtensionFilter("csv files", "csv");
    private static JFileChooser fc;
    
    public FileChooser()
    {      
        this.setFileFilter(CSVFilter);
        this.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.setMultiSelectionEnabled(true);
    }
    
}
