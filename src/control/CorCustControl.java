/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.ListInterface;
import da.CorCustDA;
import domain.CorCust;

/**
 *
 * @author jiach
 */
public class CorCustControl {
    private CorCustDA corCustDA = new CorCustDA();
    private CorCust corCust;

    public void init(){
        corCustDA.add(new CorCust(generateID(),"CHUEN BHD","01127011502","WANGSA MAJU",5000,3000,"EXISTING"));
        corCustDA.add(new CorCust(generateID(),"OPOPO BHD","01127011502","TT Wangsa",500,2000,"EXISTING"));
        corCustDA.add(new CorCust(generateID(),"AAAAA BHD","01127011502","Taman Duta",400,200,"EXISTING"));
        corCustDA.add(new CorCust(generateID(),"CHLIM BHD","01127011502","Pulau pniang",50,0,"EXISTING"));
        corCustDA.add(new CorCust(generateID(),"TUTLE BHD","01127011502","WANGSA MAJU",5000,3000,"EXISTING"));
        corCustDA.add(new CorCust(generateID(),"PHLIM BHD","01127011502","WANGSA MAJU",5000,1000,"EXISTING"));
    }
    
    public CorCustControl(){
    
    }
    
    public void add(CorCust c){
        corCustDA.add(c);
    }
    public CorCust search(String id){
        return corCustDA.search(id);
    }
    public void update(CorCust c){
        corCustDA.update(c);
    }
    public void delete(String id){
        corCustDA.delete(id);
    }
    public ListInterface<CorCust> getAll(){
        return corCustDA.getAll();
    }
    public String getMessage(){
        return corCustDA.getErrorMessage();
    }
    public boolean getValidation(){
        return corCustDA.getValidation();
    }
    
    public String generateID(){
        String custID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=corCustDA.getLastID();
        if(corCustDA.getValidation()==false){
            custID="B0001";
        }else{
            custID= "B";
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
        int countPlace=0;stop=false;
        boolean validation=true;
        if(!"0".equals(userInput)){
            switch(type){

                case 1 : 
                    while(countPlace<userInput.length()){
                        if(!Character.isDigit(userInput.charAt(countPlace))){validation=false;
                            System.out.println("Only digits!!\nPlease enter again : ");
                            countPlace=userInput.length();
                        }countPlace++;//end if
                    }
                    ;break;
                case 3 :  
                    try{
                        Double.parseDouble(userInput);
                        
                    }catch(Exception ex){
                        validation=false;
                        System.out.println("Please enter the valid credit limit...");
                    }
                    ;break;
                default : break;
            }
        }else{validation=true;stop=true;}
        return validation;
    }
    
    public boolean stopLoop(){
        return stop;
    }
}
