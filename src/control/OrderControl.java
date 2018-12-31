/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import ADT.ListInterface;
import da.OrderDA;
import domain.CorCust;
import domain.Flower;
import domain.Order;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class OrderControl {
    private OrderDA orderDA = new OrderDA();
    private Order order;
//String orderID, String itemName,color, String itemType, int itemQty, double itemPrice, Date dateAdded, String flowerID, String custID, String mode)
    public void init(){
        Date date = new Date();
        FlowerControl FC = new FlowerControl();Flower flower;
        FC.init();
        CorCustControl CC = new CorCustControl();CorCust corCust;
        CC.init();
        
        
        for(int d=1;d<12;d++){
            date= new Date();
            date.setMonth(d);date.setYear(2018);
            for(int c=0;c<CC.getAll().size();c++){
                corCust = CC.getAll().getEntry(c);
                for(int i=0;i<4;i++){
                    flower=FC.getAll().getEntry(i);
                    orderDA.add(new Order(generateID(),flower.getName(),flower.getColor(),flower.getType(),10,flower.getPrice()
                            ,date,flower.getID(),corCust.getCustID(),"EXISTING"));
                }//end nested for
            }//end nested for
        }
        /*for(int i =0;i<orderDA.getAll().size();i++){
            System.out.println(orderDA.getAll().getEntry(i).toString());
            System.out.println(orderDA.getAll().getEntry(i).getCustID());
        }*/
        
        
    }
    
    public void add(Order o){
        orderDA.add(o);
    }
    public Order search(String ID){
        return orderDA.search(ID);
    }
    public ListInterface<Order> getAll(){
        return orderDA.getAll();
    }
    public String getMessage(){
        return orderDA.getErrorMessage();
    }
    public boolean getValidation(){
        return orderDA.getValidation();
    }
    public String generateID(){
        String orderID="";
        String lastID;
        int IDArray[] = new int[4];        
        lastID=orderDA.getLastID();
        if(orderDA.getValidation()==false){
            orderID="O0001";
        }else{
            orderID= "O";
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
                orderID+=String.valueOf(IDArray[i]);
            }//end for         
        }//end if
        return orderID;
    }
}
