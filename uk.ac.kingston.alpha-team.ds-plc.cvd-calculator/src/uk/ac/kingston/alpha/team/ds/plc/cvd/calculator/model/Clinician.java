/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.kingston.alpha.team.ds.plc.cvd.calculator.model;

/**
 *
 * @author k1317897
 */
public class Clinician extends User{

    public Clinician() {
        
    }

    public Clinician(String id, String firstname, String surname, String dob, String gender, String email, String contactNumber, String password, String addressLine1, String addressLine2, String city, String postcode) {
        super(id, firstname, surname, dob, gender, email, contactNumber, password, addressLine1, addressLine2, city, postcode);
    }
 
}
