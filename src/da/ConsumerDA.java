/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import ADT.LList;
import ADT.ListInterface;
import domain.Consumer;

/**
 *
 * @author jiach
 */
public class ConsumerDA {
    private ListInterface<Consumer> consumerList = new LList<>();
    private Consumer consumer;
    private boolean validation;
    private String message;
    
    public ConsumerDA(){
        
    }
    
    public void add(Consumer c){        
        consumerList.add(c);
        message="*Record added...*";
    }
    public Consumer search(String id){
        consumer = new Consumer();int countPlace=0;
        if(!consumerList.isEmpty()){
            while(countPlace<consumerList.size()){
                consumer=consumerList.getEntry(countPlace);
                if(!"DELETED".equals(consumer.getCustMode())&&consumer.getCustID().equals(id)){
                    validation=true;countPlace=consumerList.size();
                }//end if
                countPlace++;
            }//end while
        }else{validation=false;message="*Record not found...*";}
        return consumer;
    }
    public void update(Consumer c){
        int countPlace=0;
        if(!consumerList.isEmpty()){
            while(countPlace<consumerList.size()){
                if(!"DELETED".equals(consumer.getCustMode())&&consumer.getCustID().equals(c.getCustID())){
                    consumerList.replace(countPlace,c);validation=true;countPlace=consumerList.size();}//end if
                countPlace++;
                message="*Record updated...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    public void delete(String id){
        consumer = new Consumer();int countPlace=0;
        if(!consumerList.isEmpty()){
            while(countPlace<consumerList.size()){
                if(!"DELETED".equals(consumer.getCustMode())&&consumer.getCustID().equals(id)){
                    consumerList.getEntry(countPlace).setCustMode("DELETED");validation=true;countPlace=consumerList.size();}//end if
                countPlace++;
                message="*Record deleted...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    
    public ListInterface<Consumer> getAll(){
        if(!consumerList.isEmpty()){
            return consumerList;
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
        if(!consumerList.isEmpty()){
           custID= consumerList.getEntry(consumerList.size()-1).getCustID() ;
        }else{validation=false;}
        
        return custID;
    }

}
