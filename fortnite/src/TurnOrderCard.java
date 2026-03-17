import java.util.ArrayList;

public abstract class TurnOrderCard {
    private ArrayList<Player> playerOrder;

    protected TurnOrderCard(int numPlayers) {
        this.playerOrder = new ArrayList<>(numPlayers);
    }

    protected ArrayList<Player> getPlayerOrder() {
        return playerOrder;
    }

    protected void setPlayerOrder(Board board){

    }

    protected void resolveBonusOrMalus(){
    }
}
