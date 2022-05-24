/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;
import ObserverNT.ObserverNT;
/**
 *
 * @author Fahid Shehzad
 */
public class Party {
    public static void main(String[] args) {
        ObserverNT achim    = new JokeListener( "Achim" ); 
        ObserverNT michael  = new JokeListener( "Michael" ); 
        JokeTeller chris  = new JokeTeller(); 

        chris.addObserver( achim );
        //achim.Observe(chris);

        chris.tellJoke();
        chris.tellJoke();

        chris.addObserver( michael );
        //michael.Observe(chris);

        chris.tellJoke();

        chris.deleteObserver( achim );

        chris.tellJoke();
    }
}