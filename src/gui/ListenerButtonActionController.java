/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import strings.Language;

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
        String listenerName = pressedButton.getActionCommand();
        int listenerId = Integer.parseInt(pressedButton.getName());
        
        String message = Language.getString("ListenerRemoveConfirmation")
                .replace("_Listener_", listenerName);
        
        int bestaetigung = JOptionPane.showConfirmDialog(
                gui, 
                message, 
                Language.getString("Confirmation"), 
                JOptionPane.YES_NO_OPTION);
        
        // Ja/Yes ist = 0
        if(bestaetigung == 0){
            gui.removeListener(listenerId);
        }
    }
    
}
