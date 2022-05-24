/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;

import java.util.EventObject;

/**
 *
 * @author Fahid Shehzad
 */
public class AdEvent extends EventObject{
    private String joke;
    public AdEvent (Object source, String joke) {
        super(source);
        this.joke = joke;
    }
    
    public String getJoke() {
        return this.joke;
    }
}
