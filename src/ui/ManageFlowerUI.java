/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.FlowerControl;
import control.MasterControl;
import domain.Flower;

/**
 *
 * @author jiach
 */
public class ManageFlowerUI {
    private FlowerControl FC = new FlowerControl();
    private MasterControl MC;
    private Flower flower;
    
    public ManageFlowerUI(MasterControl MC){
        this.MC=MC;
        FC=MC.getfCtrl();
        showAll();
    }
    public MasterControl returnData(){
        MC.setfCtrl(FC);
        return MC;
    }
    public void showAll(){
        System.out.printf("%-8s%-10s%-10s%-5s%-15s%-10s%-8s\n", "ÏD","Name","color","qty","Type","","price");
        System.out.println("----------------------------------------------------------------------------------");
        for(int i=0;i<FC.getAll().size();i++){
            System.out.println(FC.getAll().getEntry(i).toFormatString());
        }
    }
    
    public void functionMenu(){
        
    }
    
    
}
