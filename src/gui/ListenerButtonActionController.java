/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Fahid Shehzad
 */
public class ListenerButtonActionController implements ActionListener{
    
    GuiMain gui = null;
    
    public ListenerButtonActionController(GuiMain gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gui == null){ return; };
        
        JButton pressedButton = (JButton) e.getSource();
        System.out.println(pressedButton.getName());
    }
    
}
