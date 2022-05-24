/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObserverNT;

import java.beans.PropertyChangeSupport;

/**
 *
 * Die Klasse ObservableNT (New Technology) lehnt sich an das Erscheinungs-
 * bild der seit Java 9 veralteten Klasse java.util.Observable an. Intern wird
 * ein Objekt der Klasse PropertyChangeSupport für die Funktionalität verwendet.
 * Wenige Methoden wurden gekapselt. Für weitergehende Unterstützung des 
 * ObserverPatterns benutzen Sie direkt die Klasse PropertyChangeSupport oder 
 * das Publisher-Subscriber Pattern
 * 
 * @author Vo
 * @see java.util.Observable
 * @see PropertyChangeSupport
 * @see Publisher
 */
public class ObservableNT {

    private PropertyChangeSupport changeSupport=null;
    
    public ObservableNT() {
        changeSupport=new PropertyChangeSupport(this);
    }
    
    /**
     * Fügt dem beobachtbaren Objekt den übergebenen Beobachter hinzu.
     * @param nObserver 
     */
    public void addObserver(ObserverNT nObserver){
        changeSupport.addPropertyChangeListener(nObserver);
    }
    
    /**
     * Entfernt den übergebenen Beobachter.
     * @param nObserver 
     */
    public void deleteObserver(ObserverNT nObserver){
        changeSupport.removePropertyChangeListener(nObserver);
    }
    
    /**
     * Informiert die Beobachter, dass sich der Wert einer Eigenschaft geändert
     * hat. Für den alten Wert kann "null" übergeben werden.
     * @param propertyName
     * @param oldValue
     * @param newValue 
     */
    public void notifyObservers(String propertyName, Object oldValue, Object newValue){
        changeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    /**
     * Diese Methode existiert aus Kombatilibitätsgründen zum veralteten
     * ObserverPattern und hat keine Funktion.
     */
    public void setChanged(){
        // Diese Methode hat keine Funktion
    }
    
}
