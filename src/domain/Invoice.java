/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import ADT.LList;
import ADT.ListInterface;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jiach
 */
public class Invoice {
    private String invoiceID;
    private String invoiceStatus="PENDING";//PENDING,PAID,OVERDUED
    private Date currentMonth;
    private Date invoiceDueDate;
    private String corCustID;
    private double price;
    private ListInterface<String> orderID = new LList<>();
    private LocalDate today = LocalDate.now();

    public Invoice() {
    }

    public Invoice(String invoiceID, String invoiceStatus, Date currentMonth, String corCustID,double price) {
        this.invoiceID = invoiceID;
        this.invoiceStatus = invoiceStatus;
        this.currentMonth = currentMonth;
        this.corCustID = corCustID;
        this.price = price;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getInvoiceStatus() {
        if(!"PAID".equals(invoiceStatus)){
            if(getInvoiceDueDate().getMonth()==today.getMonthValue()&&getInvoiceDueDate().getYear()==today.getYear()&&today.getDayOfMonth()>=7){
                invoiceStatus="OVERDUED";
            }
        }
        
        return invoiceStatus;
    }

    public Date getCurrentMonth() {
        return currentMonth;
    }

    public String getCorCustID() {
        return corCustID;
    }

    public ListInterface<String> getOrderID() {
        return orderID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public void setCurrentMonth(Date currentMonth) {
        this.currentMonth = currentMonth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

    public void setCorCustID(String corCustID) {
        this.corCustID = corCustID;
    }

    public void setOrderID(ListInterface<String> orderID) {
        this.orderID = orderID;
    }
    
    
    public Date getInvoiceDueDate() {
        invoiceDueDate=currentMonth;
        invoiceDueDate.setMonth(currentMonth.getMonth()+1);
        
        return invoiceDueDate;
    }
    
    
}
