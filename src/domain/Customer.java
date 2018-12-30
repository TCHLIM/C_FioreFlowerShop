/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiach
 */
public class Customer {
    private String custID;
    private String custPhone;
    private String custAddress;
    private String custMode;

    public void setCustMode(String custMode) {
        this.custMode = custMode;
    }

    public String getCustMode() {
        return custMode;
    }
    
    public Customer(String custID,String custPhone,String custAddress, String custMode){
        this.custID=custID;
        this.custPhone=custPhone;
        this.custAddress=custAddress;
    }
    public Customer(){
        
    }

    public String getCustID() {
        return custID;
    }


    public String getCustPhone() {
        return custPhone;
    }


    public String getCustAddress() {
        return custAddress;
    }


    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }    
}
