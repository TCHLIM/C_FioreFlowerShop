/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.CorCustControl;
import control.FlowerControl;
import control.MasterControl;
import control.OrderControl;
import domain.CorCust;
import domain.Flower;
import domain.Order;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jiach
 */
public class MakeOrderUI {
    private MasterControl MC;
    private FlowerControl FC = new FlowerControl();Flower flower;
    private CorCustControl CC = new CorCustControl();CorCust corCust;
    private OrderControl OC = new OrderControl();Order order;
    private Scanner sc = new Scanner(System.in);
    
    public MakeOrderUI(MasterControl MC){
        this.MC=MC;
        OC = MC.getoCtrl();
        FC=MC.getfCtrl();
        CC=MC.getCorCtrl();
        makeOrder();
    }
    public MasterControl returnData(){
        MC.setfCtrl(FC);
        MC.setoCtrl(OC);
        MC.setCorCtrl(CC);
        return MC;
        
    }
    
    public CorCust checkCustomer(){
        String custID;
        do {
            System.out.println("Enter the corporate customer id, '0' to cancel");
            custID=sc.nextLine();
            corCust=CC.search(custID);
        } while (!CC.getValidation()&&!"0".equals(custID));

        if("0".equals(custID)){
            System.out.println("***************************");
            corCust=null;
            System.out.println("##############################################################");
        }
        if(CC.getValidation()){
            if(corCust.calRemainCredit()<=10){
                corCust=null;
                System.out.println("credit limit is not enough...");
            }
            if(!MC.getiCtrl().checkPaymentStatus(custID)){
                System.out.println("Please pay for the last month invoice amount first...");
                corCust=null;
            }
        }    
        return corCust;
    }
    
    public void displayFlower(){
        
        System.out.printf("%-8s%-10s%-10s%-5s%-15s%-10s%-8s\n", "ÏD","Name","color","qty","Type","","price");
        System.out.println("----------------------------------------------------------------------------------");
        for(int i=0;i<FC.getAll().size();i++){
            System.out.println(FC.getAll().getEntry(i).toFormatString());
        }
        
        
        
    }
    public Flower selectFlower(){
        String userSelection;boolean validation=true;
        do{
            System.out.println("Enter the flower id to select....,0 to cancel");
            userSelection=sc.nextLine();
            flower=FC.search(userSelection);
            if(FC.getValidation()){
                validation=true;
            }else if("0".equals(userSelection)){
                flower= null;validation=true;
            }else{
                validation=false;
            }
        }while(validation!=true);
            
        return flower;
    }
    public int selectQuantity(Flower flower){
        String qty;boolean validation;
        do{validation=true;
            System.out.println("Enter the quantity....,0 to cancel");
            qty=sc.nextLine();
            if(!"0".equals(qty)){
                try{
                    if(flower.getQty()<Integer.parseInt(qty)){
                        System.out.println("stock not enough...");
                        validation=false;
                    }
                }catch(Exception ex){
                    System.out.println("Enter the valid quantity...");
                    validation=false;
                }
            }else{validation=true;qty="0";}
        }while(validation!=true);
        return Integer.parseInt(qty);
                
    }
    public void makeOrder(){
        
        Date date = new Date();LocalDate today=LocalDate.now();
        date.setMonth(today.getMonthValue());date.setYear(today.getYear());
        
        corCust=checkCustomer();
        if(corCust!=null){
            displayFlower();
            flower = selectFlower();
            if(flower!=null){
                int qty=selectQuantity(flower);
                if(qty!=0){
                    OC.add(new Order(OC.generateID(),flower.getName(),flower.getColor(),flower.getType(),qty,flower.getPrice()
                    ,date,flower.getID(),corCust.getCustID(),"PENDING"));
                    flower.setQty(flower.getQty()-qty);
                    FC.update(flower);
                    System.out.println(OC.search(OC.getAll().getEntry(OC.getAll().size()-1).getOrderID()).toString());
                    
                }else{System.out.println("Order Cancelled...");}
            }
        }//end if
    }
    
        
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
