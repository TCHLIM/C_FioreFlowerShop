/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import ADT.LList;
import ADT.ListInterface;
import control.CorCustControl;
import control.InvoiceControl;
import control.MasterControl;
import control.OrderControl;
import domain.CorCust;
import domain.Invoice;
import domain.Order;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author jiach
 */

public class GenerateInvoiceUI {
    private MasterControl MC;
    private InvoiceControl IC = new InvoiceControl();
    private CorCustControl CC = new CorCustControl();
    private OrderControl OC = new OrderControl();
    private Invoice invoice;
    private CorCust corCust;
    private Order order;
    private SimpleDateFormat sf= new SimpleDateFormat("dd-MM-yyyy");
    //private Date date = new Date();
    private Scanner sc = new Scanner(System.in);
    
    public GenerateInvoiceUI(MasterControl MC){
        this.MC=MC;
        IC=MC.getiCtrl();
        OC=MC.getoCtrl();
        CC=MC.getCorCtrl();
        startInvoice();
    }
    public MasterControl returnData(){
        MC.setCorCtrl(CC);
        MC.setiCtrl(IC);
        MC.setoCtrl(OC);
        return MC;
    }
    private String invYear, invMonth;
    private Date selectedDate = new Date();
    public void startInvoice(){
        corCust = checkCustomer();ListInterface<Order> filteredList;
        if(corCust!=null){//if 1
            while(!selectMonth());
            selectedDate.setMonth(Integer.parseInt(invMonth));
            if(!IC.stopLoop()){//if 2
                while(!selectYear());
                selectedDate.setYear(Integer.parseInt(invYear));
        
                if(!IC.stopLoop()){//if 3
                    filteredList=getOrder(selectedDate,corCust.getCustID());
                    if(!filteredList.isEmpty()){//if 3
                        GenerateInvoice(corCust,filteredList,selectedDate);
                    }else System.out.println("******************\n No such record!!!\n******************");//end if 3
                }//end if 3
                
            }//end if 2
            
        }//end if 1
    }
    public void GenerateInvoice(CorCust c,ListInterface<Order> o,Date d){
        SimpleDateFormat sf = new SimpleDateFormat("MM");
        ListInterface<String> orderID = new LList();double totalPrice=0.00;
        System.out.println("#####################################################################################");
        System.out.printf("%-20s%-40s%-10s\n","Fiore Flower Shop","","INVOICE");
        System.out.printf("%55s%-15s\n","","INVOICE# | MONTH");
        System.out.printf("%58s%6s%-1s%-2s%-1s%-5s\n","",IC.generateID(),"|",sf.format(d),"/",d.getYear());
        System.out.println("BILL TO\n"+corCust.getContractName()+"\n"+corCust.getCustPhone() );
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-4s%-50s%-10s%-10s\n","NO","Item","QTY","Amount(RM)");
        
        for(int i=0;i<o.size();i++){
            order = o.getEntry(i);
            orderID.add(order.getOrderID());
            totalPrice+=(order.getItemPrice()*order.getItemQty());
            System.out.printf("%-4s(%-5s)%-45s%-10s%-10s\n",i+1,order.getOrderID(),order.getItemName()+"-"+order.getColor()
                    +" (RM "+order.getItemPrice()+"/unit)",
                    order.getItemQty(),order.getItemPrice()*order.getItemQty());
            
        }
//Invoice(String invoiceID, String invoiceStatus, Date currentMonth, String corCustID)
        IC.generate(new Invoice(IC.generateID(),"PENDING",d,c.getCustID(),orderID,totalPrice));
        
        System.out.println("--------------------------------------------------------------------------------");        
        System.out.println("                                    TOTAL RM"+totalPrice);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("#####################################################################################");
        
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
        return corCust;
    }
    public boolean selectMonth(){
        selectedDate=new Date();
        System.out.println("Enter 1 - 12 to select month of invoice, '0'to cancel");
        invMonth=sc.next();
        return IC.inputValidation("MONTH", invMonth);
    }
    public boolean selectYear(){
        invYear="";selectedDate.setYear(0);
        System.out.println("Enter the year of invoice in digit, '0' to exit");
        invYear=sc.next();
        return IC.inputValidation("YEAR", invYear);
        
    }
    
    public ListInterface<Order> getOrder(Date date,String custID){
        int countPlace=0;ListInterface<Order> returnList=new LList<>();
        while(countPlace<OC.getAll().size()){
            order = OC.getAll().getEntry(countPlace);
            //System.out.println("inout " + custID+"  item custid"+item.getCustID());
            if(custID.equals(order.getCustID())){
                if(order.getDateAdded().getMonth()==date.getMonth()){
                    if(order.getDateAdded().getYear()==date.getYear()){returnList.add(order);}//end if
                }//end if
            }//end if
            countPlace++;
        }
        return returnList;
    }
    
    
    
    
}
