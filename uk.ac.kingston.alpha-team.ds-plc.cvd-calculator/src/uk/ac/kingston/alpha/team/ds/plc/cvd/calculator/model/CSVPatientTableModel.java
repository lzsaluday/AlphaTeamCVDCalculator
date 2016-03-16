/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author k1357811
 */
public class CSVPatientTableModel extends AbstractTableModel
{
    private String[] patientNames;
    private int[] results;
    
    public CSVPatientTableModel(String[] patientNames, int[] results)
    {
        this.patientNames = patientNames;
        this.results = results;
    }

    @Override
    public int getRowCount() 
    {
        return patientNames.length;
    }

    @Override
    public int getColumnCount() 
    {
        return 2;
    }
    
    @Override
    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return "Patient Name";
            case 1:
                return "CVD Risk (%)";       
        }
        return null;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        String patientName = patientNames[rowIndex];
        int result = results[rowIndex];
        
        switch(columnIndex)
        {
            case 0:
                return patientName;
            case 1:
                return result;
        }
        
        return null;
    }
    
}
