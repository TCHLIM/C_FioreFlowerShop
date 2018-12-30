/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.ListInterface;
import da.FlowerDA;
import domain.Flower;

/**
 *
 * @author jiach
 */
public class FlowerControl {
    FlowerDA flowerDA= new FlowerDA();
//Flower(String ID, String Name,String color, int qty, String Type, double price, boolean status,String mode)    
    
    public void init(){
        flowerDA.add(new Flower(generateID(),"rose","red",30,"fresh flower",20,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","blue",30,"graduation",12,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","orange",30,"birthday",10,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","green",30,"fresh flower",10,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","white",30,"wedding",15,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","pink",30,"romance",18,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","gray",30,"fresh flower",20,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","black",30,"fresh flower",40,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","yellow",30,"fresh flower",15,true,"EXISTING"));
        flowerDA.add(new Flower(generateID(),"rose","gold",30,"fresh flower",30,true,"EXISTING"));
        
    }
    
    public ListInterface<Flower> getAll(){
        return flowerDA.getAll();
    }
    
    public boolean getValidation(){
        return flowerDA.getValidation();
    }
    
    public Flower search(String ID){
        return flowerDA.search(ID);
    }
    public void update(Flower f){
        flowerDA.update(f);
    }
    
    
    public String generateID(){
        String flowerID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=flowerDA.getLastID();
        if(flowerDA.getValidation()==false){
            flowerID="F0001";
        }else{
            flowerID= "F";
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
                flowerID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return flowerID;
    }
}
