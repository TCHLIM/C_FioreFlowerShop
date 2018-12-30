/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import ADT.LList;
import ADT.ListInterface;
import domain.CorCust;

/**
 *
 * @author jiach
 */
public class CorCustDA {
    private ListInterface<CorCust> corCustList = new LList<>();
    private CorCust corCust;
    private boolean validation;
    private String message;
    
    public CorCustDA(){
        
    }
    
    public void add(CorCust c){        
        corCustList.add(c);
        message="*Record Added...*";
    }
    public CorCust search(String id){
        corCust = new CorCust();int countPlace=0;
        if(!corCustList.isEmpty()){
            while(countPlace<corCustList.size()){
                corCust=corCustList.getEntry(countPlace);
                if(!"DELETED".equals(corCust.getCustMode())&&corCust.getCustID().equals(id)){
                    validation=true;countPlace=corCustList.size();
                    
                }else{corCust=null;validation=false;message="*no such reccord...*";}//end if
                countPlace++;
            }//end while
        }else{validation=false;message="*Record not found...*";}
        return corCust;
    }
    public void update(CorCust c){
        int countPlace=0;
        if(!corCustList.isEmpty()){
            while(countPlace<corCustList.size()){
                if(!"DELETED".equals(corCust.getCustMode())&&corCust.getCustID().equals(c.getCustID())){
                    corCustList.replace(countPlace,c);validation=true;countPlace=corCustList.size();}//end if
                countPlace++;
                message="*Record updated...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    public void delete(String id){
        corCust = new CorCust();int countPlace=0;
        if(!corCustList.isEmpty()){
            while(countPlace<corCustList.size()){
                if(!"DELETED".equals(corCust.getCustMode())&&corCust.getCustID().equals(id)){
                    corCustList.getEntry(countPlace).setCustMode("DELETED");validation=true;countPlace=corCustList.size();}//end if
                countPlace++;
                message="*Record deleted...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    
     public ListInterface<CorCust> getAll(){
        if(!corCustList.isEmpty()){
            return corCustList;
        }else{message ="*No record, database is empty...*";return null;}
        
    }
    public boolean getValidation(){
        return validation;
    }
    public String getErrorMessage(){
        return message;
    }
    public String getLastID(){
        String custID="";
        validation=true;
        if(!corCustList.isEmpty()){
           custID= corCustList.getEntry(corCustList.size()-1).getCustID() ;
        }else{validation=false;}
        
        return custID;
    }
}
