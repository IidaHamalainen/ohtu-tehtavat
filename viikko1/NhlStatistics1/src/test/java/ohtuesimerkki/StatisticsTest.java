
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class StatisticsTest {
    
   Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    @Test
    public void etsiPelaajaToimii() {              
        assertEquals("Semenko", stats.search("Semenko").getName());
    }
    @Test
    public void olematonPelaajaPalauttaaNull() {
        assertEquals(null, stats.search("Granlund"));
    }
    @Test
    public void pelaajaLista() {
        List<Player> pelaajat = stats.team("DET");
        Player pelaaja = pelaajat.get(0);
        
        assertEquals("Yzerman", pelaaja.getName());
    }
    
    @Test
    public void parhaatpelaajat() {
         List<Player> pelaajat = stats.topScorers(1);
         Player pelaaja = pelaajat.get(0);
         
         assertEquals("Gretzky", pelaaja.getName());
        
    }
}
