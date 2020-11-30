
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    Matcher m;
    
    
    public QueryBuilder() {   
        this.m = new All();
    }
    
    public Matcher build() {
        return this.m;
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(new PlaysIn(team), this.m);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int i, String s) {
        this.m = new And(new HasAtLeast(i, s), this.m);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int i, String s) {
        this.m = new And(new HasFewerThan(i, s), this.m);
        return this;
    }
    
    
}

