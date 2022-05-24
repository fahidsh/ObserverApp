/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;

import ObserverNT.ObservableNT;
import gui.GuiMain;
import java.beans.PropertyChangeEvent;
import strings.Language;

/**
 *
 * @author Fahid Shehzad
 */
public class JokeListener implements ObserverNT.ObserverNT{

    final private String name;
    public JokeListener(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    GuiMain gui;
    public void setGui(GuiMain gui) {
        this.gui = gui;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent arg) {
        String witz = (String) arg.getNewValue();
        System.out.println( name + " lacht über: \"" + witz + "\"" );
        
        if( gui!= null ){
            gui.protokolliere(name + Language.getString("LaughMessage"));
        }
    }

    @Override
    public void Observe(ObservableNT observableNT) {
        observableNT.addObserver(this);
    }
    
}
