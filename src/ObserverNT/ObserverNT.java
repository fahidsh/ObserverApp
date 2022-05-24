/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObserverNT;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Das Interface ObserverNT (New Technology) lehnt sich vom Namen an das
 * seit Java 9 veraltete Interface java.util.Observer an. Es verwendet jedoch
 * ohne Änderung das Interface PropertyChangeListener. 
 * @author Vo
 * @see java.util.Observer
 * @see PropertyChangeListener
 */
public interface ObserverNT extends PropertyChangeListener{

    /**
     * Ersetzt die Methode update(..) im veralteten ObserverPattern 
     * aus java.util
     * @param arg0 
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object) 
     */
    @Override
    public void propertyChange(PropertyChangeEvent arg0);
    
    public void Observe(ObservableNT observableNT);
    
}
