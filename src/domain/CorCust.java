/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public class CorCust extends Customer{
    private String contractName;
    private double currentCreditLimit=0.00;
    private double spentCreditLimit=0.00;
    
    public CorCust(){

    }
    
    public CorCust(String custID,String contractName, String custPhone, String custAddress,double currentCreditLimit,double spentCreditLimit,String custMode){
        super(custID,custPhone,custAddress,custMode);
        this.contractName = contractName;
        this.currentCreditLimit=currentCreditLimit;
        this.spentCreditLimit=spentCreditLimit;
    }
    
    public void setCurrentCreditLimit(double currentCreditLimit) {
        this.currentCreditLimit = currentCreditLimit;
    }

    public void setSpentCreditLimit(double spentCreditLimit) {
        this.spentCreditLimit = spentCreditLimit;
    }

    public double getCurrentCreditLimit() {
        return currentCreditLimit;
    }

    public double getSpentCreditLimit() {
        return spentCreditLimit;
    }
    
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

   public String getContractName() {
        return contractName;
    }
   public double calRemainCredit(){
       return currentCreditLimit-spentCreditLimit;
   }
   public String toString(){
       return "Name: " + contractName+"\nPhone: "+super.getCustPhone()+"\nAddress: "+super.getCustAddress()+
               "\ntotal credit limit: "+currentCreditLimit+"\nspent credit limit: "+spentCreditLimit;
   }


}
