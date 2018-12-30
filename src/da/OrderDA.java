/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import ADT.LList;
import domain.Order;
import ADT.ListInterface;

/**
 *
 * @author jiach
 */
public class OrderDA {
  private ListInterface<Order> orderList = new LList<>();
    private Order order;
    private boolean validation;
    private String message;
    
    public OrderDA(){
        
    }
    
    public void add(Order c){        
        orderList.add(c);
        message = "*Record Added...*";
    }
    public Order search(String id){
        order = new Order();int countPlace=0;
        if(!orderList.isEmpty()){
            while(countPlace<orderList.size()){
                order=orderList.getEntry(countPlace);
                if(!"DELETED".equals(order.getMode())&&order.getOrderID().equals(id)){
                    validation=true;countPlace=orderList.size();
                    
                }else{validation=false;}//end if
                countPlace++;
            }//end while
        }else{validation=false;message="*Record not found...*";}
        return order;
    }
    public void update(Order c){
        int countPlace=0;
        if(!orderList.isEmpty()){
            while(countPlace<orderList.size()){
                if(!"DELETED".equals(order.getMode())&&order.getOrderID().equals(c.getOrderID())){
                    orderList.replace(countPlace,c);validation=true;countPlace=orderList.size();}//end if
                countPlace++;
                message="*Record updated...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    public void delete(String id){
        order = new Order();int countPlace=0;
        if(!orderList.isEmpty()){
            while(countPlace<orderList.size()){
                if(!"DELETED".equals(order.getOrderID())&&order.getOrderID().equals(id)){
                    orderList.getEntry(countPlace).setMode("DELETED");validation=true;countPlace=orderList.size();}//end if
                countPlace++;
                message="*Record deleted...*";
            }//end while
        }else{validation=false;message="*Record not found...*";}
        
    }
    
    public ListInterface<Order> getAll(){
        if(!orderList.isEmpty()){
            return orderList;
        }else{message ="*No record, database is empty...*";return null;}
        
    }
    public boolean getValidation(){
        return validation;
    }
    public String getErrorMessage(){
        return message;
    }
        public String getLastID(){
        String custID="";
        validation=true;
        if(!orderList.isEmpty()){
           custID= orderList.getEntry(orderList.size()-1).getOrderID() ;
        }else{validation=false;}
        
        return custID;
    }

    
}
