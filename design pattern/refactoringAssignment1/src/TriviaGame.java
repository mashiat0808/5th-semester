import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

class Player{
    private String playerName;
    private int places;
    private int wins;
    private boolean inPenaltyBox;

    Player(String playerName){
        this.playerName=playerName;
        this.places=0;
        this.wins=0;
        this.inPenaltyBox=false;
    }
    public void increaseWins(){
        wins++;
    }
    public void newLocation(int dice){
        places = places + dice;
        if (places > 11)
        {
            places= places - 12;
        }

    }
    public String getCurrentCategory() {
        if (places%4 == 0) return "Pop";
        else if (places %4 == 1) return "Science";
        else if (places%4 == 2) return "Sports";
        else return "Rock";
    }
    public void setPositionInsidePenaltyBox(Boolean inPenaltyBox){
        this.inPenaltyBox=inPenaltyBox;
    }

    public String getPlayerName(){
        return playerName;
    }
    public int getPlace(){
        return places;
    }
    public int getNumberOfWins(){
        return wins;
    }
    public boolean isInPenaltyBox(){
        return inPenaltyBox;
    }


}
class Questions{
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public void addQuestions(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question "+ i);
        }
    }
    public Object askQuestion(Player player) {
        if (player.getCurrentCategory() == "Pop")
            return popQuestions.removeFirst();
        else if (player.getCurrentCategory() == "Science")
            return scienceQuestions.removeFirst();
        else if (player.getCurrentCategory() == "Sports")
            return sportsQuestions.removeFirst();
        else
            return rockQuestions.removeFirst();
    }
}
public class TriviaGame {
    ArrayList<Player> players = new ArrayList<Player>();
    Questions questions=new Questions();
    int currentPlayer = 0;
    private boolean isGettingOutOfPenaltyBox;

    public TriviaGame() {
        questions.addQuestions();
    }
    private boolean isPlayable() {
        return (players.size() >= 2);
    }

    private boolean addPlayer(String playerName) {
        Player player=new Player(playerName);
        players.add(player);
        return true;
    }

    private void rollDice(int dice) {
        announce(players.get(currentPlayer).getPlayerName() + " is the current player");
        announce("They have rolled a " + dice);
        if (players.get(currentPlayer).isInPenaltyBox()) {
            if (dice % 2 != 0) {
                isGettingOutOfPenaltyBox=true;
                changeLocationAndAskQuestion(dice);
            }else {
                announce(players.get(currentPlayer).getPlayerName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox=false;
            }
        } else {
            changeLocationAndAskQuestion(dice);
        }
    }
    public void changeLocationAndAskQuestion(int dice){
        players.get(currentPlayer).newLocation(dice);
        announce(players.get(currentPlayer).getPlayerName()
                + "'s new location is "
                + players.get(currentPlayer).getPlace());
        announce("The category is " + players.get(currentPlayer).getCurrentCategory());
        announce(questions.askQuestion(players.get(currentPlayer)));
    }
    public boolean rightAnswered() {
        if (players.get(currentPlayer).isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                return addPointsAndReturnWinner();
            } else {
                nextPlayerTurn();
                return true;
            }
        } else {
            return addPointsAndReturnWinner();
        }
    }
    public boolean addPointsAndReturnWinner(){
        announce("Answer was correct!!!!");
        players.get(currentPlayer).increaseWins();
        announce(players.get(currentPlayer)
                + " now has "
                + players.get(currentPlayer).getNumberOfWins()
                + " Gold Coins.");
        boolean winner = didPlayerWin();
        nextPlayerTurn();
        return winner;
    }
    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(players.get(currentPlayer) + " was sent to the penalty box");
        players.get(currentPlayer).setPositionInsidePenaltyBox(true);
        nextPlayerTurn();
        return true;
    }
    public void nextPlayerTurn(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    private boolean didPlayerWin() {
        return !(players.get(currentPlayer).getNumberOfWins()== 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}