import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TurnOrderCard {

    private int numPlayers;
    private ArrayList<Player> playerOrder;

    private static final Map<Integer, List<Integer>> foodTable = Map.of(
            2, List.of(1, -1),
            3, List.of(2, 0, -1),
            4, List.of(2, 1, 0, -1),
            5, List.of(3, 1, 0, 0, -1)
    );


    protected TurnOrderCard(int numPlayers, Game context) {
        this.numPlayers = numPlayers;
        this.playerOrder = new ArrayList<>(context.getPlayers());
        Collections.shuffle(playerOrder);
    }


    protected void resolveBonusOrMalus(){
        List<Integer> BonusPLayer = foodTable.get(numPlayers);
        Player lastPlayer = playerOrder.get(numPlayers - 1);

        for(int i=0 ; i< numPlayers - 1 ; i++){
            Player player= playerOrder.get(i);
            if(BonusPLayer.get(i)>0) {
                player.setNumFood(player.getNumFood() + BonusPLayer.get(i) + player.getAddFoodStartOfRound());
            }
        }
        if(lastPlayer.getNumFood() == 0)
            lastPlayer.setNumPrestigePoints(lastPlayer.getNumPrestigePoints() - 2);
        else
            lastPlayer.setNumFood(lastPlayer.getNumFood() + BonusPLayer.get(numPlayers - 1));
    }
    // GETTERS
     protected ArrayList<Player> getPlayerOrder() {
        return playerOrder;
    }

     protected int getNumPlayers() {
        return numPlayers;
    }

}
