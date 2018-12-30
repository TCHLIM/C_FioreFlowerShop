/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jiach
 */
public class Flower {
    private String ID;
    private String Name;
    private int qty;
    private String Type;
    private double price;
    private boolean status;
    private String mode;
    private String color;
    
    public Flower() {
    }

    
    public Flower(String ID, String Name,String color, int qty, String Type, double price, boolean status,String mode) {
        this.ID = ID;
        this.Name = Name;
        this.color=color;
        this.qty = qty;
        this.Type = Type;
        this.price = price;
        this.status = status;
        this.mode=mode;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getQty() {
        return qty;
    }

    public String getType() {
        return Type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getStatus() {
        if(qty<=0){status=false;}else{status=true;}//end if
        return status;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
//    Flower(String ID, String Name,String color, int qty, String Type, double price, boolean status,String mode)
    public String toFormatString(){
        return String.format("%-8s%-10s%-10s%-5d%-15s%-10s%.2f", ID,Name,color,qty,Type,"",price);
        
    }
}
