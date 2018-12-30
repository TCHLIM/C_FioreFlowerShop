/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import ADT.LList;
import ADT.ListInterface;
import domain.Flower;

/**
 *
 * @author jiach
 */
public class FlowerDA {
    private ListInterface<Flower> flowerList = new LList<>();
    private String message;
    private boolean validation;
    private Flower flower;
    public FlowerDA(){
        
    }
    
    public void add(Flower c){        
        flowerList.add(c);
    }
    public Flower search(String id){
        flower = new Flower();int countPlace=0;
        if(!flowerList.isEmpty()){
            while(countPlace<flowerList.size()){
                flower=flowerList.getEntry(countPlace);
                if(!"DELETED".equals(flower.getMode())&&flower.getID().equals(id)){
                    validation=true;countPlace=flowerList.size();
                    
                }else{message="*Record not found...*";validation=false;}//end if
                countPlace++;
            }//end while
        }else{validation=false;message="*Record not found...*";}
        return flower;
    }
    public void update(Flower c){
        int countPlace=0;
        if(!flowerList.isEmpty()){
            while(countPlace<flowerList.size()){
                flower=flowerList.getEntry(countPlace);
                if(!"DELETED".equals(flower.getMode())&&flower.getID().equals(c.getID())){
                    flowerList.replace(countPlace,c);validation=true;countPlace=flowerList.size();}//end if
                countPlace++;
                message="*Record updated...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    public void delete(String id){
        flower = new Flower();int countPlace=0;
        if(!flowerList.isEmpty()){
            while(countPlace<flowerList.size()){
                flowerList.getEntry(countPlace).setMode("DELETED");
                if(!"DELETED".equals(flower.getMode())&&flower.getID().equals(id)){
                    validation=true;countPlace=flowerList.size();}//end if
                countPlace++;
                message="*Record deleted...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }

    public boolean getValidation(){
        return validation;
    }
    public String getErrorMessage(){
        return message;
    }
    public ListInterface<Flower> getAll(){
        return flowerList;
    }
    public String getLastID(){
        String flowerID="";
        validation=true;
        if(!flowerList.isEmpty()){
           flowerID= flowerList.getEntry(flowerList.size()-1).getID() ;
        }else{validation=false;}
        
        return flowerID;
    }
    
}
