/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.ListInterface;
import da.ConsumerDA;
import domain.Consumer;

/**
 *
 * @author jiach
 */
public class ConsumerControl {
    private ConsumerDA consumerDA = new ConsumerDA();
    private Consumer consumer;

    public void init(){
        consumerDA.add(new Consumer(generateID(),"CHUEN","981206145493","MALE","01127011502","kuala lumpur","EXISTING"));
        consumerDA.add(new Consumer(generateID(),"way","981206146493","MALE","01127011402","kuala lumpur","EXISTING"));
        consumerDA.add(new Consumer(generateID(),"jes","981236145493","FEMALE","01125011502","kuala lumpur","EXISTING"));
        consumerDA.add(new Consumer(generateID(),"lily","181206145493","FEMALE","01127016502","kuala lumpur","EXISTING"));
        consumerDA.add(new Consumer(generateID(),"lisa","981206145498","FEMALE","01227011502","kuala lumpur","EXISTING"));
        consumerDA.add(new Consumer(generateID(),"doggy","981206144493","MALE","01127011512","kuala lumpur","EXISTING"));
    }
    
    public ConsumerControl(){
    
    }
    
    public void add(Consumer c){
        consumerDA.add(c);
    }
    public Consumer search(String id){
        return consumerDA.search(id);
    }
    public void update(Consumer c){
        consumerDA.update(c);
    }
    public void delete(String id){
        consumerDA.delete(id);
    }
    public ListInterface<Consumer> getAll(){
        return consumerDA.getAll();
    }
    public String getMessage(){
        return consumerDA.getErrorMessage();
    }
    public boolean getValidation(){
        return consumerDA.getValidation();
    }
    
    
    public String generateID(){
        String custID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=consumerDA.getLastID();
        if(consumerDA.getValidation()==false){
            custID="C0001";
        }else{
            custID= "C";
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
                custID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return custID;
    }
    boolean stop=false;
    public boolean inputValidation(int type, String userInput){
        stop=false;
        int countPlace=0;
        boolean validation=true;
        if(!"0".equals(userInput)){
             switch(type){

                case 1 :
                    if(userInput.length()==12){    
                        while(countPlace<userInput.length()){
                            if(!Character.isDigit(userInput.charAt(countPlace))){
                                validation=false;countPlace=userInput.length();System.out.println("IC Only in digits!!\nPlease try Again! :");
                            }countPlace++;//end if
                        }
                    }else{validation=false;System.out.println("IC only 12 digits!!\nPlease Try again!! :");}//end if
                    ;break;
                case 2 :  
                        if(!"1".equals(userInput)&&!"2".equals(userInput)){
                            validation=false;
                            System.out.println("Only enter '1'-Male, '2'-Female !!");
                        }
                    ;break;
                case 3 :  
                    while(countPlace<userInput.length()){
                        if(!Character.isDigit(userInput.charAt(countPlace))){validation=false;
                            System.out.println("Only digits!!\nPlease enter again : ");
                            countPlace=userInput.length();
                        }countPlace++;//end if
                    }
                    ;break;
                default: validation=true;

                break;
            }//end switch
        }else{validation=true;stop=true;}    
        return validation;
    }
    public boolean stopLoop(){
        return stop;
    }
    
    
    
}
