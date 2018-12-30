/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class Order {
    private String orderID;
    private String itemName;
    private String color;
    private String itemType;
    private int itemQty;
    private double itemPrice;
    private Date dateAdded;
    private String flowerID;
    private String custID;
    private String mode;
    public Order() {
    }

    
    

    public Order(String orderID, String itemName,String color, String itemType, int itemQty, double itemPrice, Date dateAdded, String flowerID, String custID, String mode) {
        this.orderID = orderID;
        this.itemName = itemName;
        this.color=color;
        this.itemType = itemType;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.dateAdded = dateAdded;
        this.flowerID = flowerID;
        this.custID = custID;
        this.mode = mode;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

   

    public String getOrderID() {
        return orderID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemQty() {
        return itemQty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getMode() {
        return mode;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getCustID() {
        return custID;
    }

 
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
        
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
//Order(String orderID, String itemName,String color, String itemType, int itemQty, 
    //double itemPrice, Date dateAdded, String flowerID, String custID, String mode)
    public String toString(){
        return String.format("%-8s%-8s%-8s%-15s%-3d%-5s%.2f%-5s%-2s%-4s", orderID,itemName,color,itemType,itemQty,"",itemPrice,
                "",dateAdded.getMonth(),dateAdded.getYear());
    }
    
    
}
