
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.LList;
import ADT.ListInterface;
import da.InvoiceDA;
import domain.Invoice;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class InvoiceControl {
    private InvoiceDA invoiceDA = new InvoiceDA();
    private Invoice invoice;
    private OrderControl OC = new OrderControl();
    
    public void init(){
        OC.init();
        ListInterface<String> orderID=new LList<>();double totalPrice=0;Date date= new Date();
        for(int i=0;i<OC.getAll().size();i++){
            if("B0001".equals(OC.getAll().getEntry(i).getCustID())&&OC.getAll().getEntry(i).getDateAdded().getMonth()==11){
                orderID.add(OC.getAll().getEntry(i).getOrderID());//System.out.println(OC.getAll().getEntry(i).getOrderID());
                totalPrice+=OC.getAll().getEntry(i).getItemPrice();//System.out.println(totalPrice);
        
            }
//Invoice(String invoiceID, String invoiceStatus, Date currentMonth, String corCustID,double price)
            
        
        }//end for
        date.setMonth(11);date.setYear(2018);
        invoiceDA.add(new Invoice(generateID(),"OVERDUED",date,"B0001",orderID,totalPrice));
        invoiceDA.add(new Invoice(generateID(),"OVERDUED",date,"B0002",orderID,totalPrice));
        System.out.println("****************************************"+invoiceDA.searchCorCust("B0002").getOrderID()+"\n");
    }

    public void generate(Invoice v){
        invoiceDA.add(v);
    }
    
    
    
    public boolean checkPaymentStatus(String corCustID){
        invoice=invoiceDA.searchCorCust(corCustID);
        if(getValidation()){
            System.out.println(invoice.getInvoiceStatus());
            if("OVERDUED".equals(invoice.getInvoiceStatus())){
                System.out.println(invoice.getInvoiceStatus());
                return false;
            }else{
                return true;
            }
        }else{return true;}
        
    }
    
    private Date date = new Date();
    boolean stop=false;
    public boolean inputValidation(String type, String userInput){
        int countPlace=0;stop=false;
        
        LocalDate todayDate = LocalDate.now();
        boolean validation=true;
        if(!"0".equals(userInput)){
            switch(type){

                case "MONTH" : 
                    try{
                        date.setMonth(Integer.parseInt(userInput));
                        if(Integer.parseInt(userInput)>12){
                            validation=false;
                            System.out.println("please enter the valid month in digit***");
                        }
                    }catch(Exception ex){
                        System.out.println("please enter the valid month in digit***");
                        validation=false;
                    }//end try
                    ;break;
                case "YEAR" :  
                    Date newDate= new Date();
                    newDate.setMonth(todayDate.getMonthValue());newDate.setYear(todayDate.getYear());
                    System.out.println(newDate.getMonth()+"="+date.getMonth());
                    System.out.println(newDate.getYear()+"="+date.getYear());
                    try{
                        date.setMonth(Integer.parseInt(userInput));
                        if(date.after(newDate)&&date.getMonth()!=newDate.getMonth()){
                            validation=false;
                            System.out.println("that is future***");
                        }
                    }catch(Exception ex){
                        System.out.println("please enter the valid year in digit***");
                        validation=false;date.setYear(0);
                    }//end try
                    ;break;
                
                default : break;
            }
        }else{validation=true;stop=true;date= new Date();}
        return validation;
    }
    
    public boolean stopLoop(){
        return stop;
    }
    public boolean getValidation(){
        return invoiceDA.getValidation();
    }
    
    public String generateID(){
        String invID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=invoiceDA.getLastID();
        if(invoiceDA.getValidation()==false){
            invID="V0001";
        }else{
            invID= "V";
            int j=0;
            for(int i =1;i<lastID.length();i++){
                IDArray[j]=lastID.charAt(i)-48;j++;
            }//end for
            if(IDArray[3]<9){IDArray[3]+=1;}
                else{if(IDArray[2]<9){IDArray[2]+=1;IDArray[3]=0;}
                    else{if(IDArray[1]<9){IDArray[1]+=1;IDArray[2]=0;IDArray[3]=0;}
                        else{if(IDArray[0]<9){IDArray[0]+=1;IDArray[1]=0;IDArray[2]=0;IDArray[3]=0;}
                }}}
            for(int i=0;i<4;i++){
                invID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return invID;
    }
}
