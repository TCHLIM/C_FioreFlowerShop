/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import control.*;
import domain.*;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author jiach
 */
public class MainMenu {
    private MasterControl MC = new MasterControl();        
    private Scanner sc = new Scanner(System.in);
    
    public MainMenu(){
        welcome();
    }
    
    public void welcome(){
        
        System.out.println("+--------------------------------------------------------+");
        System.out.println("***************Welcome to Fiore Flower Shop***************");
        System.out.println("+--------------------------------------------------------+");
        String userReply;
        
        System.out.println("Function:\n0 - exit\n1 - Make Order\n2 - Check Flower\n"
                + "3 - Manage Corporate Customer\n4 - Generate Invoice ");
        
        System.out.println("Please Select which function u want to proceed");
        userReply=sc.nextLine();
        
        switch(userReply){
            case "0": exit(0);break;
            case "1": MC=new MakeOrderUI(MC).returnData();welcome();break;
            case "2": MC= new ManageFlowerUI(MC).returnData();welcome();break;
            //case "3": MC= new ManageConsumerUI(MC).returnData();welcome();break;
            case "3": MC= new ManageCorCustUI(MC).returnData();welcome();break;
            case "4": MC= new GenerateInvoiceUI(MC).returnData();welcome();break;
            default: System.out.println("Only enter number between '0' to '4");welcome();break;
        }
        
    }
    
    public static void main(String[] args){
        MainMenu MM = new MainMenu();
        
    }
}
