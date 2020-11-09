
package ohtu;

public class Player implements Comparable <Player> {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return goals;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public int getPoints() {
        int points = goals + assists;
        return points;
    }
    
    
    @Override
    public String toString() {
        return String.format("%-20s",name) + " " + team + " " + String.format("%2d",goals) + " + " 
                + String.format("%2d",assists) + " = " + getPoints();
    }
    @Override
    public int compareTo(Player t) {
        return t.getPoints()-this.getPoints();
    }
      
}
