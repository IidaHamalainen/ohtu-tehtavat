
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Erotus extends Komento {
    
    public Erotus(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {

        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    int edellinenSyote;
    
    @Override
    public void suorita()  {
        int syote = haeSyote();
        sovellus.miinus(syote);
        edellinenSyote = syote;
        asetaKentat();
    }
    @Override
    public void peru() {
        sovellus.plus(edellinenSyote);
        asetaKentat();
        
    }
}
