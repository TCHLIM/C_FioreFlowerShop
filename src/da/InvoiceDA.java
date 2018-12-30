/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import ADT.LList;
import ADT.ListInterface;
import domain.Invoice;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class InvoiceDA {

    private ListInterface<Invoice> invoiceList = new LList<>();
    private String message="";
    private boolean validation;
    private Invoice invoice;
    
    public InvoiceDA(){
        
    }
    
    
    public void add(Invoice c){        
        invoice = new Invoice();int countPlace=0;
        if(!invoiceList.isEmpty()){    
            while(countPlace<invoiceList.size()){
                invoice=invoiceList.getEntry(countPlace);
                if(invoice.getCurrentMonth().getMonth()==c.getCurrentMonth().getMonth()&&invoice.getCurrentMonth().getYear()==c.getCurrentMonth().getYear()&&!"PAID".equals(invoice.getInvoiceStatus())){
                    validation=false;countPlace=invoiceList.size();
                    invoiceList.replace(countPlace,c);
                }else{validation=true;}
                countPlace++;
            }//end while
            if(validation==true){invoiceList.add(c);validation=true;}//end if
        }else{
            invoiceList.add(c);validation=true;
        }//end else
        
        
    }
    public Invoice searchCorCust(String ID){
        invoice = new Invoice();int countPlace=0;
        if(!invoiceList.isEmpty()){    
            while(countPlace<invoiceList.size()){
                invoice=invoiceList.getEntry(countPlace);
                if(invoice.getCorCustID().equals(ID)){
                    validation=true;countPlace=invoiceList.size();
                }else{validation=false;}
                countPlace++;
            }//end while
            
        }//end if
        return invoice;
    }

    public boolean getValidation(){
        return validation;
    }
    public String getErrorMessage(){
        return message;
    }
    public String getLastID(){
        String invoiceID="";
        validation=true;
        if(!invoiceList.isEmpty()){
           invoiceID= invoiceList.getEntry(invoiceList.size()-1).getInvoiceID() ;
        }else{validation=false;}
        
        return invoiceID;
    }    
}
