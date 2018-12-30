/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.ConsumerControl;
import control.MasterControl;
import domain.Consumer;
import java.util.Scanner;
/**
 *
 * @author jiach
 */
public class ManageConsumerUI {
    private Consumer consumer;
    private Scanner sc = new Scanner(System.in);
    private ConsumerControl CC = new ConsumerControl();
    
    private MasterControl MC;
    
    public ManageConsumerUI(MasterControl MC){
        this.MC=MC;
        this.CC=MC.getConCtrl();
        functionMenu();
    }
    
    public MasterControl returnData(){
        MC.setConCtrl(CC);
        return MC;
    }
    
    public ManageConsumerUI() {
        
    }
    
    
    public void functionMenu(){
        String functionSelection="";
        System.out.println("##############################################################");
        System.out.println("--------------------Manage Consumer---------------------------");
        System.out.println("##############################################################");
        System.out.println("0 - main menu");
        System.out.println("1 - Add new consumer");
        //System.out.println("2 - Search consumer Info");
        //System.out.println("3 - Update consumer Info");
        //System.out.println("4 - Delete consumer Info\n");
        System.out.println("5 - Show all consumer details\n");
        System.out.println("##############################################################");
        System.out.println("Enter the number to proceed");//menu selection
        functionSelection = sc.next();
        System.out.println("--------------------------------------------------------------");
        switch(functionSelection){
            case "0": break;
            case "1": addConsumerUI();functionMenu();break;
            //case "2": searchConsumerUI();functionMenu();break;
            //case "3": updateConsumerUI();functionMenu();break;
            //case "4": deleteConsumerUI();functionMenu();break;
            case "5": showAll();functionMenu();break;
            default: System.out.println("Please enter valid number...");
        }//end switch
    }
    
    public void addConsumerUI(){
        consumer = new Consumer();
        String[] consumerAtt=new String[]{"Name:","IC: ","Gender: [1 - MALE] [2 - FEMALE]","Phone: ","Address: "};
        String[] getDetails= new String[consumerAtt.length];
        
        System.out.println();
        System.out.println("##############################################################");
        System.out.println("-----------------------Add Consumer---------------------------");
        System.out.println("##############################################################");
        System.out.println("u can use '0' to cancel this function");
        System.out.println("ID: "+CC.generateID());
        int Attl=0;
        do {
            do {
                System.out.println(consumerAtt[Attl]);
                getDetails[Attl]=sc.nextLine();
                
            } while (!CC.inputValidation(Attl, getDetails[Attl])&&!CC.stopLoop());
            Attl++;
        }while(Attl<consumerAtt.length&&!CC.stopLoop());
        if(!CC.stopLoop()){
            CC.add(new Consumer(CC.generateID(),getDetails[0],getDetails[1],getDetails[2],getDetails[3],getDetails[4],"EXISTING"));
            System.out.println("***************************");
            System.out.println(CC.getMessage());
            System.out.println("##############################################################");
        }   
    }
    public void searchConsumerUI(){
        
    }
    public void updateConsumerUI(){
        
    }
    public void deleteConsumerUI(){
        
    }
    public void showAll(){
//(generateID(),"CHUEN","981206145493","MALE","01127011502","kuala lumpur","EXISTING"))
        if(CC.getAll()!=null){
            System.out.printf("%-8s%-10s%-18s%-8s%-18s%-20s\n","ID","Name","IC","Gender","Phone",
                "Address");
                
            for(int i=0;i<CC.getAll().size();i++){
                consumer=CC.getAll().getEntry(i);
                System.out.printf("%-8s%-10s%-18s%-8s%-18s%-20s\n",consumer.getCustID(),consumer.getCustName(),
                        consumer.getCustIC(),consumer.getCustGender(),consumer.getCustPhone(),consumer.getCustAddress());
            }
        }else{System.out.println(CC.getMessage());}//end if else
    }
    
    
}
