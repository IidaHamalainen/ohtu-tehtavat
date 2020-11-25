package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    public Nollaa(TextField tuloskentta, TextField syotekentta,  Button nollaa, Button undo, Sovelluslogiikka sovellus) {

        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    int edellinenSyote;
    
    @Override
    public void suorita()  {
        int syote = Integer.parseInt(tuloskentta.getText());
        sovellus.nollaa();
        edellinenSyote = syote;
        asetaKentat();
    }
    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenSyote);
        asetaKentat();
        
    }
}
