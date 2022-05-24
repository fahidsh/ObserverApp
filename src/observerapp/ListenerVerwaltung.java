/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fahid Shehzad
 */
public class ListenerVerwaltung {
    private List<JokeListener> listeners = new ArrayList<>();
    
    public boolean addListener(String name){
        boolean istAngemeldet = false;
        if(!isListenerPresent(name)) {
            listeners.add(new JokeListener(name));
            istAngemeldet = true;
        }
        
        return istAngemeldet;
    }
    
    public boolean addListener(JokeListener listener) {
        boolean istAngemeldet = false;
        if( !isListenerPresent(listener.getName())){
            listeners.add(listener);
            istAngemeldet = true;
        }
        return istAngemeldet;
    }
    
    
    public boolean isListenerPresent(String name) {
        boolean isListenerPresent = false;
        for(JokeListener listener : listeners) {
            if(listener.getName().equals(name)){
                isListenerPresent = true;
                break;
            }
        }
        return isListenerPresent;
    }
    
    public List<JokeListener> getAllListeners() {
        return this.listeners;
    }
    
    public void removeListener(int id) {
        if(id >= 0 && id < listeners.size()){
            listeners.remove(id);
        }
    }
    
    public JokeListener get(int id) {
        JokeListener listener = null;
        if(id >= 0 && id < listeners.size()){
            listener = listeners.get(id);
        }
        return listener;
    }
    
}
