
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Summa extends Komento {
    
    public Summa(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {

        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    int edellinenSyote;
    
    @Override
    public void suorita()  {
        int syote = haeSyote();
        sovellus.plus(syote);
        edellinenSyote = syote;
        asetaKentat();
               
    }
    @Override
    public void peru() {
        sovellus.miinus(edellinenSyote);
        asetaKentat();

    }
}
