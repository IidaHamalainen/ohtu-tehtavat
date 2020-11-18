
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukutaulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;   // Tyhjässä joukossa alkioiden_määrä on nolla. 
    private int kapasiteetti;

    public IntJoukko() {
        this.kapasiteetti = KAPASITEETTI;
        this.kasvatuskoko = OLETUSKASVATUS;
        alustaTaulukko(kapasiteetti, kasvatuskoko);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        this.kasvatuskoko = OLETUSKASVATUS;
        alustaTaulukko(kapasiteetti, kasvatuskoko);

    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("uusi taulukko ei voi olla vanhaa pienempi");
        }
        alustaTaulukko(kapasiteetti, kasvatuskoko);

    }
    public void alustaTaulukko( int kapasiteetti, int kasvatuskoko) {
        lukutaulukko = new int[kapasiteetti];
        for (int i = 0; i < lukutaulukko.length; i++) {
            lukutaulukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public void lisaa(int luku) {
        
        if (alkioidenLkm == 0) {
            lukutaulukko[0] = luku;
            alkioidenLkm++;
        }
        if (!kuuluu(luku)) {
            lukutaulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukutaulukko.length == 0) {
                kasvataTaulukonKokoa();
            }
        }


    }

    public void kasvataTaulukonKokoa() {

        int[] aputaulukko = new int[lukutaulukko.length];
        kopioiTaulukko(lukutaulukko, aputaulukko);
        lukutaulukko = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(aputaulukko, lukutaulukko);
    }


    public boolean kuuluu(int luku) {
        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukutaulukko[i]) {
                return true;
            }
        } 
        return false;
        
    }

    public boolean poista(int luku) {
        int indeksi = -1;
        int apu;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukutaulukko[i]) {
                indeksi = i; 
                lukutaulukko[indeksi] = 0;
                break;
            }
        }
        if (indeksi != -1) {
            for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                apu = lukutaulukko[j];
                lukutaulukko[j] = lukutaulukko[j + 1];
                lukutaulukko[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int joukonKoko() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukutaulukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukutaulukko[i];
                tuotos += ", ";
            }
            tuotos += lukutaulukko[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukutaulukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
 
        return z;
    }
        
}
