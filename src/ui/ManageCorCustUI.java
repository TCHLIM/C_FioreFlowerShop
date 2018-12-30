/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.CorCustControl;
import control.MasterControl;
import domain.CorCust;
import java.util.Scanner;
/**
 *
 * @author jiach
 */
public class ManageCorCustUI {
    private CorCustControl CC = new CorCustControl();
    private CorCust corCust;
    private MasterControl MC ;
    private Scanner sc = new Scanner(System.in);
    
    public ManageCorCustUI(MasterControl MC){
        this.MC=MC;
        this.CC=MC.getCorCtrl();
        functionMenu();
    }
    public MasterControl returnData(){
        MC.setCorCtrl(CC);
        return MC;
    }
    
    public void functionMenu(){
        String functionSelection="";
        System.out.println("##############################################################");
        System.out.println("--------------------Manage CorCust---------------------------");
        System.out.println("##############################################################");
        System.out.println("0 - main menu");
        System.out.println("1 - Add new corCust");
        System.out.println("2 - Search corCust Info");
        System.out.println("3 - set corporate customer credit limit");
        System.out.println("4 - Show all corCust details\n");
        System.out.println("##############################################################");
        System.out.println("Enter the number to proceed");//menu selection
        functionSelection = sc.nextLine();
        System.out.println("--------------------------------------------------------------");
        switch(functionSelection){
            case "0": break;
            case "1": addCorCustUI();functionMenu();break;
            case "2": searchCorCustUI();functionMenu();break;
            case "3": updateCorCustUI();functionMenu();break;
            case "4": showAll();functionMenu();break;
            default :System.out.println("Please enter the valid number");functionMenu();break;
        }//end switch
    }
    
    public void addCorCustUI(){
        //sc=new Scanner(System.in);
        corCust = new CorCust();
        String[] corCustAtt=new String[]{"Name:","Phone: ","Address: ","Total Credit Limit:[more than 0] "};
        String[] getDetails= new String[corCustAtt.length];
        
        System.out.println();
        System.out.println("##############################################################");
        System.out.println("-----------------------Add CorCust---------------------------");
        System.out.println("##############################################################");
        System.out.println("u can use '0' to cancel this function");
        System.out.println("ID: "+CC.generateID());
        int Attl=0;
        do {
            do {
                System.out.println(corCustAtt[Attl]);
                getDetails[Attl]=sc.nextLine();
                
            } while (!CC.inputValidation(Attl, getDetails[Attl])&&!CC.stopLoop());
            Attl++;
        }while(Attl<corCustAtt.length&&!CC.stopLoop());
        if(!CC.stopLoop()){
            CC.add(new CorCust(CC.generateID(),getDetails[0],getDetails[1],getDetails[2],Double.parseDouble(getDetails[3]),corCust.getSpentCreditLimit(),"EXISTING"));
            System.out.println("***************************");
            System.out.println(CC.getMessage());
            System.out.println("##############################################################");
        }
        //System.out.println(CC.search(CC.generateID()));
    }
    public void searchCorCustUI(){
        System.out.println();
        System.out.println("##############################################################");
        System.out.println("-----------------------Search CorCust---------------------------");
        System.out.println("##############################################################");
        System.out.println("Enter the corporate customer id: ");
        String id = sc.nextLine();
        corCust=CC.search(id);
        System.out.println("***************************");
        if(CC.getValidation()){System.out.println(corCust.toString());}else{System.out.println(CC.getMessage());}
        System.out.println("##############################################################");
    }
    public void updateCorCustUI(){
        System.out.println();
        System.out.println("##############################################################");
        System.out.println("-----------------------Update CorCust---------------------------");
        System.out.println("##############################################################");
        System.out.println("Enter the corporate customer id: ");
        String id = sc.nextLine();
        corCust=CC.search(id);
        String newDetail = null;
        if(CC.getValidation()){System.out.println(corCust.toString());
            
            do {
                System.out.println("Enter the new credit limit:");
                newDetail=sc.nextLine();
                System.out.println(CC.getMessage());
            } while (!CC.inputValidation(3,newDetail)&&!CC.stopLoop());
            System.out.println("");
        }else{System.out.println(CC.getMessage());}//end if else
    
        if(!CC.stopLoop()){
            corCust.setCurrentCreditLimit(Double.parseDouble(newDetail));
            CC.update(corCust);
            System.out.println("***************************");
            System.out.println(CC.getMessage());
            System.out.println("##############################################################");
        }
    }
    
    public void showAll(){
        if(CC.getAll()!=null){
            System.out.printf("%-8s%-10s%-18s%-20s%-25s%-25s\n","ID","Name","Phone",
                "Address","Current creditLimit","used ceditLimit");
                
            for(int i=0;i<CC.getAll().size();i++){
                corCust=CC.getAll().getEntry(i);
                System.out.printf("%-8s%-10s%-18s%-20s%-7s%.2f%-15s%.2f\n",corCust.getCustID(),corCust.getContractName(),corCust.getCustPhone(),
                corCust.getCustAddress(),"",corCust.getCurrentCreditLimit(),"",corCust.getSpentCreditLimit());
            }
        }else{System.out.println(CC.getMessage());}//end if else
    }
   
}
