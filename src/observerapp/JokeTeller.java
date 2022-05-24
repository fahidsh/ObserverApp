/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observerapp;
import ObserverNT.ObservableNT;
import gui.GuiMain;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import strings.Language;

/**
 *
 * @author Fahid Shehzad
 */
public class JokeTeller extends ObservableNT{
    
    private String name = "";
    
    public JokeTeller(){}
    public JokeTeller(String name) { this.name = name; }
    
    GuiMain gui;
    public void setGui(GuiMain gui) {
        this.gui = gui;
    }
    
    private static final List<String> jokes = Arrays.asList(
        "Sorry, aber du siehst so aus, wie ich mich fühle.",
        "Eine Null kann ein bestehendes Problem verzehnfachen.",
        "Wer zuletzt lacht, hat es nicht eher begriffen.",
        "Wer zuletzt lacht, stirbt wenigstens fröhlich.",
        "Unsere Luft hat einen Vorteil: Man sieht, was man einatmet.",
        "\"Das ist mein voller Ernst!\", sprach die Frau, die Lärm im Treppenhaus hörte.",
        "Die E-Mail-Adresse des Papstes: urbi@orbi",
        "Kommt ein Einarmiger in ein Second-hand Geschäft ...",
        "Geht ein Cowboy zum Friseur. Als er raus kommt, ist sein Pony weg.",
        "Die letzten Worte des Sportlehrers? \"Alle Speere zu mir!\"",
        "Was ist gelb und schießt? \"Eine Banone\"",
        "Ich bin wahrscheinlich so müde, weil so viele Talente in mir schlummern",
        "Eine Kuchenrolle unterscheidet sich nur in zwei Punkten von einer Küchenrolle."
    );
    
    public void tellJoke() {
        //setChanged();
        Collections.shuffle(jokes);
        
        if(gui != null) {
            String protokolAntrang = "";
            protokolAntrang += (name.equals("")) ? Language.getString("JokeTeller") : name;
            protokolAntrang += Language.getString("JokeTellMessage");
            protokolAntrang += "\n\t";
            protokolAntrang += jokes.get(0);
            gui.protokolliere(protokolAntrang);
        }
        
        notifyObservers("Witz", null, jokes.get(0));
    }
    
}
