/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import Control.*;
/**
 *
 * @author jiach
 */
public class MasterControl {
    private ConsumerControl conCtrl = new ConsumerControl();
    private CorCustControl corCtrl= new CorCustControl();
    private FlowerControl fCtrl=new FlowerControl();
    private InvoiceControl iCtrl=new InvoiceControl();
    private OrderControl oCtrl=new OrderControl();
    
    public MasterControl(){
        conCtrl.init();
        corCtrl.init();
        fCtrl.init();
        iCtrl.init();
        oCtrl.init();
    }
    
    
    public ConsumerControl getConCtrl() {
        return conCtrl;
    }

    public CorCustControl getCorCtrl() {
        return corCtrl;
    }

    public FlowerControl getfCtrl() {
        return fCtrl;
    }

    public InvoiceControl getiCtrl() {
        return iCtrl;
    }

    public OrderControl getoCtrl() {
        return oCtrl;
    }

    public void setConCtrl(ConsumerControl conCtrl) {
        this.conCtrl = conCtrl;
    }

    public void setCorCtrl(CorCustControl corCtrl) {
        this.corCtrl = corCtrl;
    }

    public void setfCtrl(FlowerControl fCtrl) {
        this.fCtrl = fCtrl;
    }

    public void setiCtrl(InvoiceControl iCtrl) {
        this.iCtrl = iCtrl;
    }

    public void setoCtrl(OrderControl oCtrl) {
        this.oCtrl = oCtrl;
    }
    
}
