/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;

import ObserverNT.ObservableNT;
import java.beans.PropertyChangeEvent;

/**
 *
 * @author Fahid Shehzad
 */
public class JokeListener implements ObserverNT.ObserverNT{

    final private String name; 
    public JokeListener(String name) {
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg) {
        String witz = (String) arg.getNewValue();
        System.out.println( name + " lacht über: \"" + witz + "\"" );
    }

    @Override
    public void Observe(ObservableNT observableNT) {
        observableNT.addObserver(this);
    }
    
}
