package ohtu;

public class TennisGame {
    
    private int player1score = 0;
    private int player2score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1score += 1;
        else
            player2score += 1;
    }

    public String sameScore() {
        
        String score = "";
        switch (player1score)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                case 3:
                        score = "Forty-All";
                    break;
                default:
                        score = "Deuce";
                    break;  
            }
        return score;
    }

    public String leadingPlayer(int advantage) {
        String score = "";
        
        if (advantage == 1) score ="Advantage player1";
        else if (advantage == -1) score ="Advantage player2";
        else if (advantage >= 2) score = "Win for player1";
        else score ="Win for player2";

        return score;
    }

    public String getPlayerScore(int playerScore) {
        String playerPoints = "";

        switch(playerScore) {
            case 0:
                    playerPoints = "Love";
                    break;
                case 1:
                    playerPoints = "Fifteen";
                    break;
                case 2:
                    playerPoints = "Thirty";
                    break;
                case 3:
                    playerPoints = "Forty";
                    break;
        }
        return playerPoints;
    }
    

    public String getScore() {
        
        String score = "";
       
        if (player1score == player2score){
            score = sameScore();
        }
        else if (player1score >= 4 || player2score >= 4) {
            int advantage = player1score-player2score;
            score = leadingPlayer(advantage);
           
        }
        else {
            String playerOnesScore = getPlayerScore(player1score);
            String playerTwosScore = getPlayerScore(player2score);
            score = playerOnesScore + "-" + playerTwosScore;
        }
        return score;
    }
}